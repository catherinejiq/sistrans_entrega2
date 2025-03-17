
-- 1. Insertar IPSs
INSERT INTO IPSs (nit, nombre, direccion, telefono, horario) 
VALUES (1, 'Clínica San Juan', 'Calle 123 #45-67', '6012345678', 'L-V 8am-6pm');

INSERT INTO IPSs (nit, nombre, direccion, telefono, horario) 
VALUES (2, 'Hospital Central', 'Av. Principal 789', '6019876543', 'L-D 24 horas');

-- 2. Insertar Médicos
INSERT INTO Medicos (idMedico, identificacion, nombre, numRegistro, especialidad)
VALUES (1, 'CC1001', 'Dr. Juan Pérez', 'MED123', 'Cardiología');

INSERT INTO Medicos (idMedico, identificacion, nombre, numRegistro, especialidad)
VALUES (2, 'CC1002', 'Dra. María Gómez', 'MED456', 'Pediatría');

-- 3. Insertar Afiliados (2 contribuyentes y 2 beneficiarios)
-- Contribuyentes
INSERT INTO Afiliados (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion, telefono, parentesco, tipoAfiliado, idContribuyente) 
VALUES (1, 'CC', 'Carlos Gómez', DATE '1980-05-15', 'Carrera 45 #67-89', '3151234567', 'Titular', 'CONTRIBUYENTE', NULL);

INSERT INTO Afiliados (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion, telefono, parentesco, tipoAfiliado, idContribuyente) 
VALUES (2, 'CC', 'Ana Torres', DATE '1975-08-22', 'Calle 70 #12-34', '3102345678', 'Titular', 'CONTRIBUYENTE', NULL);

-- Beneficiarios
INSERT INTO Afiliados (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion, telefono, parentesco, tipoAfiliado, idContribuyente) 
VALUES (3, 'TI', 'Luis Gómez', DATE '2010-02-15', 'Carrera 45 #67-89', '3157654321', 'Hijo', 'BENEFICIARIO', 1);

INSERT INTO Afiliados (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion, telefono, parentesco, tipoAfiliado, idContribuyente) 
VALUES (4, 'CC', 'Pedro Torres', DATE '2005-07-12', 'Calle 70 #12-34', '3109876543', 'Hijo', 'BENEFICIARIO', 2);

-- 4. Relacionar Afiliados con IPSs
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (1, 1);
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (2, 2);
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (3, 1);
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (4, 2);

-- 5. Relacionar Médicos con IPSs
INSERT INTO Medico_IPS (idMedico, nit) VALUES (1, 1);
INSERT INTO Medico_IPS (idMedico, nit) VALUES (2, 2);

-- 6. Insertar Servicios de Salud
INSERT INTO ServiciosSalud (idServicio, fecha, descripcion) 
VALUES (1, DATE '2023-01-10', 'Consulta general');

INSERT INTO ServiciosSalud (idServicio, fecha, descripcion) 
VALUES (2, DATE '2023-02-15', 'Análisis de sangre');

-- 7. Insertar Consultas
INSERT INTO Consultas (idConsulta, tipoConsulta, idAfiliado, idMedico, idServicio)
VALUES (1, 'GENERAL', 1, 1, 1);

-- 8. Insertar Exámenes
INSERT INTO ExamenesDiagnosticos (idExamen, resultados, muestras, idServicio)
VALUES (1, 'Hemoglobina normal', 'Sangre venosa', 2);

-- 9. Relacionar Consulta con Examen
INSERT INTO Consulta_Examen (idConsulta, idExamen) VALUES (1, 1);

-- 10. Insertar Orden de Servicio
INSERT INTO OrdenServicios (idOrden, tipoOrden, receta, estado, fecha, idMedico, idAfiliado)
VALUES (1, 'Examen sangre', 'Ayuno 8 horas', 'COMPLETADA', DATE '2023-01-09', 1, 1);

-- 11. Relacionar Orden con Servicio
INSERT INTO Orden_Servicio (idOrden, idServicio) VALUES (1, 2);

-- 12. Insertar Hospitalización
INSERT INTO ServiciosSalud (idServicio, fecha, descripcion) 
VALUES (3, DATE '2023-03-01', 'Hospitalización por neumonía');

INSERT INTO Hospitalizaciones (idHospitalizacion, estado, tratamiento, idServicio)
VALUES (1, 'Estable', 'Antibióticos y reposo', 3);

-- 13. Relacionar Hospitalización con Médico y Afiliado
INSERT INTO Hospitalizacion_Medico (idHospitalizacion, idMedico) VALUES (1, 2);
INSERT INTO Hospitalizacion_Afiliado (idHospitalizacion, idAfiliado) VALUES (1, 3);

-- 14. Relacionar Servicio con IPS
INSERT INTO Servicio_IPS (idServicio, nit) VALUES (1, 1);
INSERT INTO Servicio_IPS (idServicio, nit) VALUES (2, 1);
INSERT INTO Servicio_IPS (idServicio, nit) VALUES (3, 2);

-- 15. Relacionar Médico con Afiliado
INSERT INTO Medico_Afiliado (idMedico, idAfiliado) VALUES (1, 1);
INSERT INTO Medico_Afiliado (idMedico, idAfiliado) VALUES (2, 3);

-- 1. Más IPS
INSERT INTO IPSs (nit, nombre, direccion, telefono, horario) 
VALUES (3, 'Centro Médico Los Andes', 'Carrera 5 #12-30', '6067891234', 'L-S 7am-7pm');

-- 2. Más Médicos
INSERT INTO Medicos (idMedico, identificacion, nombre, numRegistro, especialidad)
VALUES (3, 'CC1003', 'Dra. Laura Castro', 'MED789', 'Dermatología');

INSERT INTO Medicos (idMedico, identificacion, nombre, numRegistro, especialidad)
VALUES (4, 'CC1004', 'Dr. Roberto Jiménez', 'MED101', 'Traumatología');

-- 3. Más Afiliados
-- Nuevo contribuyente
INSERT INTO Afiliados (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion, telefono, parentesco, tipoAfiliado, idContribuyente) 
VALUES (5, 'CE', 'Mónica Vélez', DATE '1990-09-25', 'Av. 68 #45-12', '3175554433', 'Titular', 'CONTRIBUYENTE', NULL);

-- Beneficiarios asociados al nuevo contribuyente
INSERT INTO Afiliados (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion, telefono, parentesco, tipoAfiliado, idContribuyente) 
VALUES (6, 'TI', 'Camila Vélez', DATE '2015-03-18', 'Av. 68 #45-12', '3175554433', 'Hija', 'BENEFICIARIO', 5);

INSERT INTO Afiliados (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion, telefono, parentesco, tipoAfiliado, idContribuyente) 
VALUES (7, 'CC', 'Alberto Vélez', DATE '1988-07-11', 'Av. 68 #45-12', '3175554433', 'Hermano', 'BENEFICIARIO', 5);

-- 4. Relacionar nuevos Afiliados con IPS
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (5, 3);
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (6, 3);
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (7, 1);  -- Este beneficiario en IPS diferente

-- 5. Relacionar nuevos Médicos con IPS
INSERT INTO Medico_IPS (idMedico, nit) VALUES (3, 3);
INSERT INTO Medico_IPS (idMedico, nit) VALUES (4, 1);

-- 6. Más Servicios de Salud
INSERT INTO ServiciosSalud (idServicio, fecha, descripcion) 
VALUES (4, DATE '2023-04-01', 'Terapia física');

INSERT INTO ServiciosSalud (idServicio, fecha, descripcion) 
VALUES (5, DATE '2023-04-05', 'Procedimiento menor');

INSERT INTO ServiciosSalud (idServicio, fecha, descripcion) 
VALUES (6, DATE '2023-04-10', 'Consulta de seguimiento');

-- 7. Más Consultas
INSERT INTO Consultas (idConsulta, tipoConsulta, idAfiliado, idMedico, idServicio)
VALUES (2, 'URGENCIA', 6, 4, 6);

-- 8. Más Exámenes
INSERT INTO ExamenesDiagnosticos (idExamen, resultados, muestras, idServicio)
VALUES (2, 'Colesterol elevado', 'Muestra de sangre en ayunas', 4);

-- 9. Nueva Orden de Servicio
INSERT INTO OrdenServicios (idOrden, tipoOrden, receta, estado, fecha, idMedico, idAfiliado)
VALUES (2, 'Radiografía', 'Aplicar contraste', 'VIGENTE', DATE '2023-04-03', 4, 7);

-- 10. Relacionar nueva Orden con Servicio
INSERT INTO Orden_Servicio (idOrden, idServicio) VALUES (2, 5);

-- 11. Terapia
INSERT INTO Terapias (idTerapia, tipo, cantidadSesiones, idServicio)
VALUES (1, 'Fisioterapia', 5, 4);

-- 12. Procedimiento Médico
INSERT INTO ProcedimientosMedicos (idProcedimiento, tipo, idServicio)
VALUES (1, 'Extracción de muestra', 5);

-- 13. Otra Hospitalización
INSERT INTO ServiciosSalud (idServicio, fecha, descripcion) 
VALUES (7, DATE '2023-04-15', 'Hospitalización por fractura');

INSERT INTO Hospitalizaciones (idHospitalizacion, estado, tratamiento, idServicio)
VALUES (2, 'En observación', 'Inmovilización y analgésicos', 7);

-- 14. Relaciones Hospitalización
INSERT INTO Hospitalizacion_Medico (idHospitalizacion, idMedico) VALUES (2, 4);
INSERT INTO Hospitalizacion_Afiliado (idHospitalizacion, idAfiliado) VALUES (2, 7);

-- 15. Más relaciones Servicio-IPS
INSERT INTO Servicio_IPS (idServicio, nit) VALUES (4, 3);
INSERT INTO Servicio_IPS (idServicio, nit) VALUES (5, 1);
INSERT INTO Servicio_IPS (idServicio, nit) VALUES (6, 3);
INSERT INTO Servicio_IPS (idServicio, nit) VALUES (7, 2);

-- 16. Más relaciones Médico-Afiliado
INSERT INTO Medico_Afiliado (idMedico, idAfiliado) VALUES (3, 5);
INSERT INTO Medico_Afiliado (idMedico, idAfiliado) VALUES (4, 6);
-- 1. Nuevo Contribuyente y Beneficiarios
INSERT INTO Afiliados (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion, telefono, parentesco, tipoAfiliado, idContribuyente) 
VALUES (8, 'CC', 'Gabriel Morales', DATE '1982-12-08', 'Calle 80 #10-25', '3184445566', 'Titular', 'CONTRIBUYENTE', NULL);

INSERT INTO Afiliados (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion, telefono, parentesco, tipoAfiliado, idContribuyente) 
VALUES (9, 'TI', 'Valentina Morales', DATE '2018-06-20', 'Calle 80 #10-25', '3184445566', 'Hija', 'BENEFICIARIO', 8);

INSERT INTO Afiliados (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion, telefono, parentesco, tipoAfiliado, idContribuyente) 
VALUES (10, 'CE', 'Claudia Morales', DATE '1995-04-15', 'Calle 80 #10-25', '3184445577', 'Prima', 'BENEFICIARIO', 8);

-- 2. Relaciones IPS para nuevos afiliados
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (8, 2);
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (9, 2);
INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (10, 3);

-- 3. Nuevo Servicio de Salud con Consulta Especializada
INSERT INTO ServiciosSalud (idServicio, fecha, descripcion) 
VALUES (8, DATE '2023-05-02', 'Consulta dermatológica');

INSERT INTO Consultas (idConsulta, tipoConsulta, idAfiliado, idMedico, idServicio)
VALUES (3, 'ESPECIALISTA', 10, 3, 8);

-- 4. Examen de alergias relacionado
INSERT INTO ExamenesDiagnosticos (idExamen, resultados, muestras, idServicio)
VALUES (3, 'Alergia al polen', 'Prueba cutánea', 8);

INSERT INTO Consulta_Examen (idConsulta, idExamen) VALUES (3, 3);

-- 5. Orden de Servicio para terapia
INSERT INTO OrdenServicios (idOrden, tipoOrden, receta, estado, fecha, idMedico, idAfiliado)
VALUES (3, 'Terapia respiratoria', 'Aplicar 3 veces al día', 'VIGENTE', DATE '2023-05-01', 3, 10);

-- 6. Servicio de Terapia
INSERT INTO ServiciosSalud (idServicio, fecha, descripcion) 
VALUES (9, DATE '2023-05-05', 'Terapia pulmonar');

INSERT INTO Terapias (idTerapia, tipo, cantidadSesiones, idServicio)
VALUES (2, 'Respiratoria', 8, 9);

INSERT INTO Orden_Servicio (idOrden, idServicio) VALUES (3, 9);

-- 7. Procedimiento Quirúrgico
INSERT INTO ServiciosSalud (idServicio, fecha, descripcion) 
VALUES (10, DATE '2023-05-10', 'Cirugía menor ambulatoria');

INSERT INTO ProcedimientosMedicos (idProcedimiento, tipo, idServicio)
VALUES (2, 'Extracción de quiste', 10);

-- 8. Nueva Orden para Procedimiento
INSERT INTO OrdenServicios (idOrden, tipoOrden, receta, estado, fecha, idMedico, idAfiliado)
VALUES (4, 'Cirugía menor', 'Reposo 48 horas', 'COMPLETADA', DATE '2023-05-08', 4, 7);

INSERT INTO Orden_Servicio (idOrden, idServicio) VALUES (4, 10);

-- 9. Hospitalización Pediátrica
INSERT INTO ServiciosSalud (idServicio, fecha, descripcion) 
VALUES (11, DATE '2023-05-12', 'Hospitalización infantil');

INSERT INTO Hospitalizaciones (idHospitalizacion, estado, tratamiento, idServicio)
VALUES (3, 'Grave', 'Oxígeno y monitoreo constante', 11);

INSERT INTO Hospitalizacion_Medico (idHospitalizacion, idMedico) VALUES (3, 2);
INSERT INTO Hospitalizacion_Afiliado (idHospitalizacion, idAfiliado) VALUES (3, 9);

-- 10. Relaciones Médico-Afiliado adicionales
INSERT INTO Medico_Afiliado (idMedico, idAfiliado) VALUES (3, 10);
INSERT INTO Medico_Afiliado (idMedico, idAfiliado) VALUES (4, 8);

-- 11. Relaciones Servicio-IPS
INSERT INTO Servicio_IPS (idServicio, nit) VALUES (8, 3);
INSERT INTO Servicio_IPS (idServicio, nit) VALUES (9, 2);
INSERT INTO Servicio_IPS (idServicio, nit) VALUES (10, 1);
INSERT INTO Servicio_IPS (idServicio, nit) VALUES (11, 2);