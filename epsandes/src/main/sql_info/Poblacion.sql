---------------------------------------------------------
-- 1. Insertar IPSs
---------------------------------------------------------
INSERT INTO IPSs (nit, nombre, direccion, telefono, horario) 
VALUES (1, 'Clínica San Juan', 'Calle 123 #45-67', '6012345678', 'L-V 8am-6pm');

INSERT INTO IPSs (nit, nombre, direccion, telefono, horario) 
VALUES (2, 'Hospital Central', 'Av. Principal 789', '6019876543', 'L-D 24 horas');

INSERT INTO IPSs (nit, nombre, direccion, telefono, horario) 
VALUES (3, 'Centro Médico Los Andes', 'Carrera 5 #12-30', '6067891234', 'L-S 7am-7pm');

---------------------------------------------------------
-- 2. Insertar Médicos (sin especificar idMedico)
---------------------------------------------------------
INSERT INTO Medicos (identificacion, nombre, numRegistro, especialidad)
VALUES ('CC1001', 'Dr. Juan Pérez', 'MED123', 'Cardiología');

INSERT INTO Medicos (identificacion, nombre, numRegistro, especialidad)
VALUES ('CC1002', 'Dra. María Gómez', 'MED456', 'Pediatría');

INSERT INTO Medicos (identificacion, nombre, numRegistro, especialidad)
VALUES ('CC1003', 'Dra. Laura Castro', 'MED789', 'Dermatología');

INSERT INTO Medicos (identificacion, nombre, numRegistro, especialidad)
VALUES ('CC1004', 'Dr. Roberto Jiménez', 'MED101', 'Traumatología');

---------------------------------------------------------
-- 3. Insertar Afiliados (Contribuyentes y Beneficiarios)
---------------------------------------------------------
-- Contribuyentes
INSERT INTO Afiliado (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion) 
VALUES (1, 'CC', 'Carlos Gómez', DATE '1980-05-15', 'Carrera 45 #67-89');

INSERT INTO Afiliado (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion) 
VALUES (2, 'CC', 'Ana Torres', DATE '1975-08-22', 'Calle 70 #12-34');

INSERT INTO Afiliado (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion) 
VALUES (5, 'CE', 'Mónica Vélez', DATE '1990-09-25', 'Av. 68 #45-12');

-- Beneficiarios
INSERT INTO Afiliado (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion) 
VALUES (3, 'TI', 'Luis Gómez', DATE '2010-02-15', 'Carrera 45 #67-89');

INSERT INTO Afiliado (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion) 
VALUES (4, 'CC', 'Pedro Torres', DATE '2005-07-12', 'Calle 70 #12-34');

INSERT INTO Afiliado (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion) 
VALUES (6, 'TI', 'Camila Vélez', DATE '2015-03-18', 'Av. 68 #45-12');

---------------------------------------------------------
-- 4. Relacionar Contribuyentes y Beneficiarios
---------------------------------------------------------
INSERT INTO Contribuyente (afiliado) VALUES (1);
INSERT INTO Contribuyente (afiliado) VALUES (2);
INSERT INTO Contribuyente (afiliado) VALUES (5);

INSERT INTO Beneficiario (afiliado, contribuyente, parentesco) VALUES (3, 1, 'Hijo');
INSERT INTO Beneficiario (afiliado, contribuyente, parentesco) VALUES (4, 2, 'Hijo');
INSERT INTO Beneficiario (afiliado, contribuyente, parentesco) VALUES (6, 5, 'Hija');

---------------------------------------------------------
-- 5. Relacionar Afiliados con IPSs
---------------------------------------------------------
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (1, 1);
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (2, 2);
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (3, 1);
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (4, 2);
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (5, 3);
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (6, 3);

---------------------------------------------------------
-- 6. Relacionar Médicos con IPSs
---------------------------------------------------------
INSERT INTO Medico_IPS (idMedico, nit) VALUES (1, 1);
INSERT INTO Medico_IPS (idMedico, nit) VALUES (2, 2);
INSERT INTO Medico_IPS (idMedico, nit) VALUES (3, 3);
INSERT INTO Medico_IPS (idMedico, nit) VALUES (4, 1);

---------------------------------------------------------
-- 7. Insertar Servicios de Salud
---------------------------------------------------------
INSERT INTO ServiciosSalud (fecha, descripcion) VALUES (DATE '2023-01-10', 'Consulta general');
INSERT INTO ServiciosSalud (fecha, descripcion) VALUES (DATE '2023-02-15', 'Análisis de sangre');
INSERT INTO ServiciosSalud (fecha, descripcion) VALUES (DATE '2023-04-01', 'Terapia física');
INSERT INTO ServiciosSalud (fecha, descripcion) VALUES (DATE '2023-05-02', 'Consulta dermatológica');

---------------------------------------------------------
-- 8. Relacionar Servicios con IPSs
---------------------------------------------------------
INSERT INTO Ips_Servicio (IPSs, idServicio) VALUES (1, 1);
INSERT INTO Ips_Servicio (IPSs, idServicio) VALUES (1, 2);
INSERT INTO Ips_Servicio (IPSs, idServicio) VALUES (3, 3);
INSERT INTO Ips_Servicio (IPSs, idServicio) VALUES (3, 4);

---------------------------------------------------------
-- 9. Insertar Consultas
---------------------------------------------------------
INSERT INTO Consultas (tipoConsulta, idAfiliado, idMedico, idServicio)
VALUES ('GENERAL', 1, 1, 1);

INSERT INTO Consultas (tipoConsulta, idAfiliado, idMedico, idServicio)
VALUES ('ESPECIALISTA', 6, 3, 4);

---------------------------------------------------------
-- 10. Insertar Exámenes
---------------------------------------------------------
INSERT INTO ExamenesDiagnosticos (resultados, muestras, idServicio)
VALUES ('Hemoglobina normal', 'Sangre venosa', 2);

INSERT INTO ExamenesDiagnosticos (resultados, muestras, idServicio)
VALUES ('Alergia al polen', 'Prueba cutánea', 4);

---------------------------------------------------------
-- 11. Relacionar Consultas con Exámenes
---------------------------------------------------------
INSERT INTO Consulta_Examen (idConsulta, idExamen) VALUES (1, 1);
INSERT INTO Consulta_Examen (idConsulta, idExamen) VALUES (2, 2);

---------------------------------------------------------
-- 12. Insertar Órdenes de Servicio
---------------------------------------------------------
INSERT INTO OrdenServicios (tipoOrden, receta, estado, fecha, idMedico, idAfiliado)
VALUES ('Examen sangre', 'Ayuno 8 horas', 'COMPLETADA', DATE '2023-01-09', 1, 1);

INSERT INTO OrdenServicios (tipoOrden, receta, estado, fecha, idMedico, idAfiliado)
VALUES ('Terapia respiratoria', 'Aplicar 3 veces al día', 'VIGENTE', DATE '2023-05-01', 3, 6);

---------------------------------------------------------
-- 13. Relacionar Órdenes con Servicios
---------------------------------------------------------
INSERT INTO Orden_Servicio (idOrden, idServicio) VALUES (1, 2);
INSERT INTO Orden_Servicio (idOrden, idServicio) VALUES (2, 4);
-- IPS 2 (Hospital Central) ofrece el servicio 2 (Análisis de sangre)
INSERT INTO Ips_Servicio (IPSs, idServicio) VALUES (2, 2);

-- IPS 1 (Clínica San Juan) ofrece el servicio 3 (Terapia física)
INSERT INTO Ips_Servicio (IPSs, idServicio) VALUES (1, 3);
---------------------------------------------------------
-- 14. Insertar Disponibilidad
---------------------------------------------------------
INSERT INTO Disponibilidad (idServicio, nitIps, idMedico, fechaHoraInicio, fechaHoraFin, estado)
VALUES (
    1, 
    1, 
    1, 
    TIMESTAMP '2023-10-25 09:00:00', 
    TIMESTAMP '2023-10-25 10:00:00', 
    'LIBRE'
);

INSERT INTO Disponibilidad (idServicio, nitIps, idMedico, fechaHoraInicio, fechaHoraFin, estado)
VALUES (
    4, 
    3, 
    3, 
    TIMESTAMP '2023-10-26 14:00:00', 
    TIMESTAMP '2023-10-26 15:00:00', 
    'LIBRE'
);
---------------------------------------------------------
-- Disponibilidad para Dr. Juan Pérez (Cardiólogo - IPS 1)
---------------------------------------------------------
INSERT INTO Disponibilidad (idServicio, nitIps, idMedico, fechaHoraInicio, fechaHoraFin, estado)
VALUES (
    1, -- Consulta general
    1, -- Clínica San Juan
    1, -- Dr. Juan Pérez
    TIMESTAMP '2023-10-26 08:00:00', 
    TIMESTAMP '2023-10-26 09:00:00', 
    'LIBRE'
);

INSERT INTO Disponibilidad (idServicio, nitIps, idMedico, fechaHoraInicio, fechaHoraFin, estado)
VALUES (
    1, 
    1, 
    1, 
    TIMESTAMP '2023-10-27 10:30:00', 
    TIMESTAMP '2023-10-27 11:30:00', 
    'OCUPADO'
);

---------------------------------------------------------
-- Disponibilidad Dra. María Gómez (Pediatría - IPS 2)
---------------------------------------------------------
INSERT INTO Disponibilidad (idServicio, nitIps, idMedico, fechaHoraInicio, fechaHoraFin, estado)
VALUES (
    2, -- Análisis de sangre
    2, -- Hospital Central
    2, -- Dra. María Gómez
    TIMESTAMP '2023-10-30 07:00:00', 
    TIMESTAMP '2023-10-30 08:00:00', 
    'LIBRE'
);

INSERT INTO Disponibilidad (idServicio, nitIps, idMedico, fechaHoraInicio, fechaHoraFin, estado)
VALUES (
    2, 
    2, 
    2, 
    TIMESTAMP '2023-11-02 13:00:00', 
    TIMESTAMP '2023-11-02 14:00:00', 
    'LIBRE'
);

---------------------------------------------------------
-- Disponibilidad Dra. Laura Castro (Dermatología - IPS 3)
---------------------------------------------------------
INSERT INTO Disponibilidad (idServicio, nitIps, idMedico, fechaHoraInicio, fechaHoraFin, estado)
VALUES (
    4, -- Consulta dermatológica
    3, -- Centro Médico Los Andes
    3, -- Dra. Laura Castro
    TIMESTAMP '2023-11-03 15:00:00', 
    TIMESTAMP '2023-11-03 16:30:00', 
    'LIBRE'
);

INSERT INTO Disponibilidad (idServicio, nitIps, idMedico, fechaHoraInicio, fechaHoraFin, estado)
VALUES (
    4, 
    3, 
    3, 
    TIMESTAMP '2023-11-06 11:00:00', 
    TIMESTAMP '2023-11-06 12:00:00', 
    'OCUPADO'
);

---------------------------------------------------------
-- Disponibilidad Dr. Roberto Jiménez (Traumatología - IPS 1)
---------------------------------------------------------
INSERT INTO Disponibilidad (idServicio, nitIps, idMedico, fechaHoraInicio, fechaHoraFin, estado)
VALUES (
    3, -- Terapia física
    1, -- Clínica San Juan
    4, -- Dr. Roberto Jiménez
    TIMESTAMP '2023-11-07 09:00:00', 
    TIMESTAMP '2023-11-07 10:30:00', 
    'LIBRE'
);

INSERT INTO Disponibilidad (idServicio, nitIps, idMedico, fechaHoraInicio, fechaHoraFin, estado)
VALUES (
    3, 
    1, 
    4, 
    TIMESTAMP '2023-11-08 16:00:00', 
    TIMESTAMP '2023-11-08 17:00:00', 
    'LIBRE'
);
-- 1. Cita para Dr. Juan Pérez (Disponibilidad 1)
INSERT INTO Citas (idDisponibilidad, idAfiliado, fechaReserva)
VALUES (1, 1, TIMESTAMP '2023-10-23 09:00:00'); -- Carlos Gómez reserva 2 días antes

UPDATE Disponibilidad SET estado = 'OCUPADO' WHERE idDisponibilidad = 1;

-- 2. Cita para Dr. Juan Pérez (Disponibilidad 3)
INSERT INTO Citas (idDisponibilidad, idAfiliado, fechaReserva)
VALUES (3, 3, TIMESTAMP '2023-10-24 08:00:00'); -- Luis Gómez reserva 2 días antes

UPDATE Disponibilidad SET estado = 'OCUPADO' WHERE idDisponibilidad = 3;

-- 3. Cita para Dra. María Gómez (Disponibilidad 5)
INSERT INTO Citas (idDisponibilidad, idAfiliado, fechaReserva)
VALUES (5, 2, TIMESTAMP '2023-10-28 07:00:00'); -- Ana Torres reserva 2 días antes

UPDATE Disponibilidad SET estado = 'OCUPADO' WHERE idDisponibilidad = 5;

-- 4. Cita para Dra. María Gómez (Disponibilidad 6)
INSERT INTO Citas (idDisponibilidad, idAfiliado, fechaReserva)
VALUES (6, 4, TIMESTAMP '2023-10-30 13:00:00'); -- Pedro Torres reserva 3 días antes

UPDATE Disponibilidad SET estado = 'OCUPADO' WHERE idDisponibilidad = 6;

-- 5. Cita para Dra. Laura Castro (Disponibilidad 7)
INSERT INTO Citas (idDisponibilidad, idAfiliado, fechaReserva)
VALUES (7, 5, TIMESTAMP '2023-10-31 15:00:00'); -- Mónica Vélez reserva 3 días antes

UPDATE Disponibilidad SET estado = 'OCUPADO' WHERE idDisponibilidad = 7;

-- 6. Cita para Dr. Roberto Jiménez (Disponibilidad 9)
INSERT INTO Citas (idDisponibilidad, idAfiliado, fechaReserva)
VALUES (9, 1, TIMESTAMP '2023-11-03 09:00:00'); -- Carlos Gómez reserva 4 días antes

UPDATE Disponibilidad SET estado = 'OCUPADO' WHERE idDisponibilidad = 9;

-- 7. Cita para Dr. Roberto Jiménez (Disponibilidad 10)
INSERT INTO Citas (idDisponibilidad, idAfiliado, fechaReserva)
VALUES (10, 3, TIMESTAMP '2023-11-04 16:00:00'); -- Luis Gómez reserva 4 días antes

UPDATE Disponibilidad SET estado = 'OCUPADO' WHERE idDisponibilidad = 10;