package gym_conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/gymnasio";
    private static final String USUARIO = "root"; 
    private static final String CLAVE = "";       
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
    
    public static void main(String[] args) {
        try (Connection con = conectar()) {
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}
