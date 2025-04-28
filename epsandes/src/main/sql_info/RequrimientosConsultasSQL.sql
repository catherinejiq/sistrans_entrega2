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
    s.idServicio    AS idServicio,
    s.descripcion,
    s.fecha,
    COUNT(c.idCita) AS total_citas
  FROM Citas c
  JOIN Disponibilidad d
    ON c.idDisponibilidad = d.idDisponibilidad
  JOIN ServiciosSalud s
    ON d.idServicio = s.idServicio
  WHERE c.fechaReserva BETWEEN TIMESTAMP '2023-10-23 09:00:00' AND TIMESTAMP '2023-11-04 16:00:00'
  GROUP BY
    s.idServicio,
    s.descripcion,
    s.fecha
  ORDER BY
    total_citas DESC
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
      BETWEEN TIMESTAMP '2023-10-25 09:00:00'
          AND TIMESTAMP '2023-11-08 17:00:00'
    GROUP BY d.idServicio
  ),
  usados AS (
    SELECT
      d.idServicio,
      COUNT(*) AS total_usados
    FROM Citas c
    JOIN Disponibilidad d
      ON c.idDisponibilidad = d.idDisponibilidad
    WHERE d.fechaHoraInicio
      BETWEEN TIMESTAMP '2023-10-25 09:00:00'
          AND TIMESTAMP '2023-11-08 17:00:00'
    GROUP BY d.idServicio
  )
SELECT
  s.idServicio,
  s.descripcion        AS nombre_servicio,
  NVL(o.total_ofertados, 0) AS ofertados,
  NVL(u.total_usados,    0) AS usados,
  CASE
    WHEN NVL(u.total_usados,0) = 0 THEN NULL
    ELSE ROUND(o.total_ofertados / u.total_usados, 4)
  END                   AS indice_uso
FROM ServiciosSalud s
LEFT JOIN ofertados o
  ON s.idServicio = o.idServicio
LEFT JOIN usados u
  ON s.idServicio = u.idServicio
ORDER BY indice_uso DESC;

--RFC4
SELECT
  s.descripcion       AS nombre_servicio,
  d.fechaHoraInicio   AS fecha_servicio,
  m.nombre            AS nombre_medico,
  i.nombre            AS nombre_ips
FROM Citas c
JOIN Disponibilidad d
  ON c.idDisponibilidad = d.idDisponibilidad
JOIN ServiciosSalud s
  ON d.idServicio = s.idServicio
JOIN Medicos m
  ON d.idMedico = m.idMedico
JOIN IPSs i
  ON d.nitIps = i.nit
WHERE c.idAfiliado = :idAfiliado
  AND d.fechaHoraInicio
      BETWEEN TIMESTAMP '2023-10-25 09:00:00' AND TIMESTAMP '2023-11-08 17:00:00'
ORDER BY d.fechaHoraInicio;

--RFC5
SELECT s.descripcion,
       d.fechaHoraInicio,
       m.nombre
  FROM disponibilidad d
  JOIN serviciosSalud s ON s.idServicio = d.idServicio
  JOIN medicos m       ON m.idMedico   = d.idMedico
 WHERE d.idServicio  = 4
   AND d.idMedico    = 3
   AND d.fechaHoraInicio BETWEEN 
       TIMESTAMP '2023-10-25 09:00:00'
       AND TIMESTAMP'2023-11-08 17:00:00'

