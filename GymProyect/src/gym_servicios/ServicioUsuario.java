package gym_servicios;

import gym_entidades.*;
import gym_conexion.conexionDB;

import java.sql.*;
import java.util.*;

public class ServicioUsuario {

    public void registrarInstructor(String nombre, String telefono) {
        try (Connection con = conexionDB.conectar()) {
            String sql = "INSERT INTO usuarios (id, nombre, telefono, tipo, membresia_activa) VALUES (?, ?, ?, 'Instructor', NULL)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, generarNuevoId(con));
                ps.setString(2, nombre);
                ps.setString(3, telefono);
                ps.executeUpdate();
                System.out.println("Instructor registrado en base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar instructor: " + e.getMessage());
        }
    }

    public void registrarSubscriptor(String nombre, String telefono, boolean activa) {
        try (Connection con = conexionDB.conectar()) {
            String sql = "INSERT INTO usuarios (id, nombre, telefono, tipo, membresia_activa) VALUES (?, ?, ?, 'Subscriptor', ?)";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, generarNuevoId(con));
                ps.setString(2, nombre);
                ps.setString(3, telefono);
                ps.setBoolean(4, activa);
                ps.executeUpdate();
                System.out.println("Subscriptor registrado en base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar subscriptor: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int id) {
        try (Connection con = conexionDB.conectar()) {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Usuario eliminado.");
                } else {
                    System.out.println("No se encontró usuario con ese ID.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection con = conexionDB.conectar()) {
            String sql = "SELECT * FROM usuarios";
            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String tel = rs.getString("telefono");
                    String tipo = rs.getString("tipo");

                    if ("Instructor".equals(tipo)) {
                        usuarios.add(new Instructor(id, nombre, tel));
                    } else if ("Subscriptor".equals(tipo)) {
                        boolean activa = rs.getBoolean("membresia_activa");
                        usuarios.add(new Subscriptor(id, nombre, tel, activa));
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    public void editarDatosUsuario(int id, String nombre, String tel) {
        try (Connection con = conexionDB.conectar()) {
            String sql = "UPDATE usuarios SET nombre = ?, telefono = ? WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ps.setString(2, tel);
                ps.setInt(3, id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al editar usuario: " + e.getMessage());
        }
    }

    private int generarNuevoId(Connection con) throws SQLException {
        String sql = "SELECT IFNULL(MAX(id), 0) + 1 AS nuevo_id FROM usuarios";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("nuevo_id");
            }
        }
        return 1; 
    }
}