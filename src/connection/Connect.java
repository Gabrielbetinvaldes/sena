package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    public Connection connect() {
        // Ruta donde está al db creada
        String url = "jdbc:mysql://127.0.0.1:3306/mariachiDatabase";
        String usuario = "root";
        String clave = "";
        // EJEMPLO: String url =
        // "jdbc:sqlite:C:/Users/KRISTE~1/Documents/MINTIC/CICLO-II/CP_15/CP_15/db/almacen.db";
        Connection conn = null;

        try {
            // Creamos la conexión
            conn = DriverManager.getConnection(url , usuario, clave);
            System.out.println("¡Conexión OK!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void create(String sql, String mensajeExitoso) {
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println(mensajeExitoso);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

