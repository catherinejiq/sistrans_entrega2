package uniandes.edu.co.demo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ServicioRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public ServicioRepositoryCustom(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    public List<Document> obtenerServiciosMasUsadosEntreFechas(Date fechaInicio, Date fechaFin) {
        List<Document> pipeline = List.of(
            new Document("$match", new Document("fechaReserva",
                new Document("$gte", fechaInicio).append("$lte", fechaFin)
            )),
            new Document("$lookup", new Document()
                .append("from", "disponibilidad_collection")
                .append("localField", "disponibilidadId")
                .append("foreignField", "_id")
                .append("as", "disponibilidad")
            ),
            new Document("$unwind", "$disponibilidad"),
            new Document("$addFields", new Document()
                .append("disponibilidad.idServicioStr",
                        new Document("$toString", "$disponibilidad.idServicio"))
            ),
            new Document("$match", new Document("disponibilidad.estado", "OCUPADO")),
            new Document("$lookup", new Document()
                .append("from", "servicios_collection")
                .append("localField", "disponibilidad.idServicioStr")
                .append("foreignField", "_id")
                .append("as", "servicioDetalle")
            ),
            new Document("$unwind", "$servicioDetalle"),
            new Document("$group", new Document()
                .append("_id", new Document()
                    .append("idServicio", "$servicioDetalle.idServicio")
                    .append("descripcion", "$servicioDetalle.descripcion")
                )
                .append("total", new Document("$sum", 1))
            ),
            new Document("$project", new Document()
                .append("_id", 0)
                .append("idServicio", "$_id.idServicio")
                .append("descripcion", "$_id.descripcion")
                .append("total", 1)
            ),
            new Document("$sort", new Document("total", -1)),
            new Document("$limit", 20)
        );

        return mongoTemplate.getCollection("citas_collection")
                             .aggregate(pipeline)
                             .into(new ArrayList<>());
    }
}
