CREATE OR REPLACE PROCEDURE SP_AGENDAR_SERVICIO(
  p_idServicio       IN NUMBER,
  p_nitIps           IN NUMBER,
  p_idMedico         IN NUMBER,
  p_fechaHoraInicio  IN TIMESTAMP,
  p_idAfiliado       IN NUMBER,
  p_receta           IN VARCHAR2
) IS
  v_estado  Disponibilidad.estado%TYPE;
  v_idOrden OrdenServicios.idOrden%TYPE;
BEGIN
  SELECT estado
    INTO v_estado
    FROM Disponibilidad
   WHERE idServicio     = p_idServicio
     AND nitIps          = p_nitIps
     AND idMedico        = p_idMedico
     AND fechaHoraInicio = p_fechaHoraInicio
   FOR UPDATE;

  IF v_estado = 'LIBRE' THEN
    INSERT INTO OrdenServicios(tipoOrden, receta, estado, fecha, idMedico, idAfiliado)
    VALUES('Agendamiento Servicio', p_receta, 'VIGENTE', TRUNC(SYSDATE), p_idMedico, p_idAfiliado)
    RETURNING idOrden INTO v_idOrden;

    INSERT INTO Orden_Servicio(idOrden, idServicio)
    VALUES(v_idOrden, p_idServicio);

    UPDATE Disponibilidad
       SET estado = 'OCUPADO'
     WHERE idServicio     = p_idServicio
       AND nitIps          = p_nitIps
       AND idMedico        = p_idMedico
       AND fechaHoraInicio = p_fechaHoraInicio;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Cita agendada. Orden #'||v_idOrden);
  ELSE
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('No hay disponibilidad en esta franja horaria');
    RETURN;
  END IF;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Franja horaria no encontrada');
END SP_AGENDAR_SERVICIO;
/