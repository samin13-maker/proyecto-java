package gym_servicios;

import gym_conexion.conexionDB;
import java.sql.*;

public class ServicioAmonestaciones {

    public void registrarAmonestacion(int subscriptorId, String comentario) {
        String sql = "INSERT INTO amonestaciones (subscriptor_id, comentario, fecha) VALUES (?, ?, CURDATE())";
        try (Connection con = conexionDB.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, subscriptorId);
            ps.setString(2, comentario);
            ps.executeUpdate();
            System.out.println("Amonestación registrada en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al registrar amonestación: " + e.getMessage());
        }
    }
}
