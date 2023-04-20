package utpl.edu.ec.TrabajoGrupal.CrearTabla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        try (Connection con =
                     DriverManager.getConnection("jdbc:h2:~/Gruopo", "Equipo2", "")) {

            //1. Crear tabla
            //createTable(con);

            //addData(con);

        }
    }

    private static void createTable(Connection con) throws SQLException {
        var createTable = """
                create table IF NOT EXISTS VEHICULO
                (
                ID INTEGER auto_increment,
                PLACA CHARACTER VARYING(9) not null,
                ANIO_FABRICACION INTEGER not null,
                NRO_CHASIS CHARACTER VARYING(32) not null,
                NRO_MOTOR CHARACTER VARYING(32) not null,
                COLOR1 CHARACTER VARYING(16) not null,
                COLOR2 CHARACTER VARYING(16) not null,
                AVALUO DOUBLE PRECISION default '0.0 ',
                PRENDADO BOOLEAN default 'FALSE',
                constraint VEHICULO_PKEY
                primary key (ID)
                );
                """;
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(createTable);
        }
    }

    private static void addData(Connection con) throws SQLException {
        var insertar = """
                INSERT INTO PUBLIC.VEHICULO (PLACA, ANIO_FABRICACION, NRO_CHASIS, NRO_MOTOR,
                    COLOR1, COLOR2, AVALUO, PRENDADO) 
                    VALUES ('LBA0001', 2011, 'ABC-123', 'XYZ-456-AC',
                    'Gris', 'Gris', 16499.99, false);
                INSERT INTO PUBLIC.VEHICULO (PLACA, ANIO_FABRICACION, NRO_CHASIS, NRO_MOTOR,
                    COLOR1, COLOR2, AVALUO, PRENDADO) 
                    VALUES ('LBA0002', 2020, 'DEF-456', 'A1B2-CD-89',
                    'Azul', 'Azul', 28500.01, true);
                """;
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(insertar);
        }
    }
}