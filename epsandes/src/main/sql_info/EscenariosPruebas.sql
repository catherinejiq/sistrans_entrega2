-----------------------------------------------------
-- Escenario 1: Prueba de unicidad de tuplas en IPSs
-----------------------------------------------------

INSERT INTO IPSs (nit, nombre, direccion, telefono, horario)
VALUES (100, 'IPS 1', 'D', '123456789', 'L-V 8am-6pm');
DBMS_OUTPUT.PUT_LINE('Escenario 1: Primera insercion de IPS con nit=100 exitosa.');


BEGIN
    INSERT INTO IPSs (nit, nombre, direccion, telefono, horario)
    VALUES (100, 'IPS 1-1', 'DD', '987654321', 'L-V 9am-5pm');
    DBMS_OUTPUT.PUT_LINE('Escenario 1: Segunda insercion con nit=100 exitosa (esto no deberia ocurrir).');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Escenario 1: Error de unicidad: ' || SQLERRM);
END;
/
-----------------------------------------------------
-- Escenario 2: Prueba de integridad referencial con FK en Afiliado_IPS
-----------------------------------------------------

BEGIN
    INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (1, 1);
    DBMS_OUTPUT.PUT_LINE('Escenario 2: Insercion con FK válida en Afiliado_IPS (idAfiliado=1, nit=1) exitosa.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Escenario 2: Error en inserción FK valida en Afiliado_IPS: ' || SQLERRM);
END;
/


BEGIN
    INSERT INTO Afiliado_IPS (idAfiliado, nit) VALUES (999999999, 1);
    DBMS_OUTPUT.PUT_LINE('Escenario 2: Insercion con FK invalida (idAfiliado=999, nit=1) exitosa (esto no deberia ocurrir).');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Escenario 2: Error de integridad referencial capturado (idAfiliado=999, nit=1): ' || SQLERRM);
END;
/
-----------------------------------------------------
-- Escenario 3: Prueba de integridad de restricciones de chequeo en Afiliados
-----------------------------------------------------

BEGIN
    INSERT INTO Afiliados (idAfiliado, tipoDocumento, nombre, fechaNacimiento, direccion, telefono, parentesco, tipoAfiliado)
    VALUES (999, 'CC', 'Pepito Perez', DATE '2000-01-01', 'D', '3000000000', 'Prueba', 'INVALIDO');
    DBMS_OUTPUT.PUT_LINE('Escenario 3: Insercion en Afiliados con tipoAfiliado invalido exitosa (esto no debería ocurrir).');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Escenario 3: Error de restriccion de chequeo capturado: ' || SQLERRM);
END;
/

