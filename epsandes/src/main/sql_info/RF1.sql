CREATE OR REPLACE PROCEDURE registrarIPS(
    p_nombre     IN VARCHAR2,
    p_direccion  IN VARCHAR2,
    p_telefono   IN VARCHAR2,
    p_horario    IN VARCHAR2,
    p_nit        OUT NUMBER
) AS
BEGIN
    INSERT INTO IPSs (nombre, direccion, telefono, horario)
    VALUES (p_nombre, p_direccion, p_telefono, p_horario)
    RETURNING nit INTO p_nit;
    COMMIT;

    END;
/