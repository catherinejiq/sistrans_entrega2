CREATE OR REPLACE PROCEDURE registrarServicioSalud(
    p_fecha       IN DATE,
    p_descripcion IN VARCHAR2,
    p_idServicio  OUT NUMBER
) AS
BEGIN
    INSERT INTO ServiciosSalud (fecha, descripcion)
    VALUES (p_fecha, p_descripcion)
    RETURNING idServicio INTO p_idServicio;
    COMMIT;
    
    END;
/