--RFC1 CONSULTAR LA AGENDA DE DISPONIBILIDAD QUE TIENE UN SERVICIO DE SALUD INGRESADO POR EL USUARIO EN LAS SIGUIENTES 4 SEMANAS
SELECT
  s.descripcion       AS nombre_servicio,
  d.fechaHoraInicio   AS fecha_hora_inicio,
  i.nombre            AS nombre_ips,
  m.nombre            AS nombre_medico
FROM Disponibilidad d
JOIN ServiciosSalud s
  ON d.idServicio = s.idServicio
JOIN IPSs i
  ON d.nitIps = i.nit
JOIN Medicos m
  ON d.idMedico = m.idMedico
WHERE d.idServicio = :codigoServicio
  AND d.estado = 'LIBRE'
  AND d.fechaHoraInicio
      BETWEEN TIMESTAMP '2023-10-20 09:00:00'
          AND TIMESTAMP '2023-11-20 09:00:00'
ORDER BY d.fechaHoraInicio;




--RFC2
SELECT *
FROM (
  SELECT
    d.idServicio,
    s.descripcion           AS nombre_servicio,
    COUNT(*)                AS total_solicitudes
  FROM Disponibilidad d
  JOIN ServiciosSalud s
    ON d.idServicio = s.idServicio
  WHERE d.estado = 'OCUPADO'
    AND d.fechaHoraInicio BETWEEN TIMESTAMP '2023-10-20 09:00:00'
                              AND TIMESTAMP '2023-11-20 09:00:00'
  GROUP BY d.idServicio, s.descripcion
  ORDER BY COUNT(*) DESC
)
WHERE ROWNUM <= 20;

--RFC3
WITH
  ofertados AS (
    SELECT
      d.idServicio,
      COUNT(*) AS total_ofertados
    FROM Disponibilidad d
    WHERE d.fechaHoraInicio
      BETWEEN TIMESTAMP '2023-10-20 09:00:00'
          AND TIMESTAMP '2023-11-20 09:00:00'
    GROUP BY d.idServicio
  ),
  ocupados AS (
    SELECT
      d.idServicio,
      COUNT(*) AS total_usados
    FROM Disponibilidad d
    WHERE d.fechaHoraInicio
      BETWEEN TIMESTAMP '2023-10-20 09:00:00'
          AND TIMESTAMP '2023-11-20 09:00:00'
      AND d.estado = 'OCUPADO'
    GROUP BY d.idServicio
  )
SELECT
  s.idServicio,
  s.descripcion           AS nombre_servicio,
  NVL(o.total_ofertados,0) AS ofertados,
  NVL(u.total_usados,0)    AS usados,
  CASE
    WHEN NVL(u.total_usados,0) = 0 THEN NULL
    ELSE ROUND(o.total_ofertados / u.total_usados, 4)
  END                      AS indice_uso
FROM ServiciosSalud s
LEFT JOIN ofertados o
  ON s.idServicio = o.idServicio
LEFT JOIN ocupados u
  ON s.idServicio = u.idServicio
ORDER BY indice_uso DESC;

--RF4
