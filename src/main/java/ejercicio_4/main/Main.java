package ejercicio_4.main;


import ejercicio_4.modelo.GestorParticipante;
import ejercicio_4.persistencia.ParticipanteDAO;
import ejercicio_4.vista.AgregarParticipante;

import java.awt.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String URL = "jdbc:derby:participantes;create=true";
    private static  Connection conn;

    public static void main(String[] args) throws SQLException {

        inizializar();
        crearTabla();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarParticipante(new GestorParticipante(new ParticipanteDAO(conn)));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    private static void inizializar(){
        try {
            conn = SetUpDatabase.obtenerConexion(URL);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void crearTabla() {
        try {
            Statement st = conn.createStatement();

            st.executeUpdate("""
            CREATE TABLE participantes (
                id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
                nombre VARCHAR(100),
                telefono VARCHAR(50),
                region VARCHAR(100),
                email VARCHAR(100),
                PRIMARY KEY (id)
            )
        """);

            st.close();
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
