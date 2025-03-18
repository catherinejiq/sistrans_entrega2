CREATE OR REPLACE PROCEDURE asignarServicioIPS(
    p_idServicio IN NUMBER,
    p_nitIPS     IN NUMBER
) AS
BEGIN
    INSERT INTO Servicio_IPS (idServicio, nit)
    VALUES (p_idServicio, p_nitIPS);
    COMMIT;

    END;
/