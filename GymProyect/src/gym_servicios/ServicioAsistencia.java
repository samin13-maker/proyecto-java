package gym_servicios;

import gym_entidades.*;
import gym_conexion.conexionDB;
import java.sql.*;

public class ServicioAsistencia {

    public void registrarAsistencia(int subscriptorId, int cursoId, boolean presente) {
        String sql = "INSERT INTO asistencias (subscriptor_id, curso_id, fecha, presente) VALUES (?, ?, CURDATE(), ?)";
        try (Connection con = conexionDB.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, subscriptorId);
            ps.setInt(2, cursoId);
            ps.setBoolean(3, presente);
            ps.executeUpdate();
            System.out.println("Asistencia registrada en la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al registrar asistencia: " + e.getMessage());
        }
    }
}

