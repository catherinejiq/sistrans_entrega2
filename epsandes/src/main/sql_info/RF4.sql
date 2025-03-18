CREATE OR REPLACE PROCEDURE registrarMedico(
    p_identificacion IN VARCHAR2,
    p_nombre         IN VARCHAR2,
    p_numRegistro    IN VARCHAR2,
    p_especialidad   IN VARCHAR2,
    p_nitIPS         IN NUMBER,
    p_idMedico       OUT NUMBER
) AS
BEGIN
    INSERT INTO Medicos (identificacion, nombre, numRegistro, especialidad)
    VALUES (p_identificacion, p_nombre, p_numRegistro, p_especialidad)
    RETURNING idMedico INTO p_idMedico;
    
    INSERT INTO Medico_IPS (idMedico, nit)
    VALUES (p_idMedico, p_nitIPS);
    
    COMMIT;

    END;
/