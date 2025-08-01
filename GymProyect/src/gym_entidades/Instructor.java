package gym_entidades;

import java.util.*;

public class Instructor extends Usuario {
    private List<Curso> cursos = new ArrayList<>();

    public Instructor(int id, String nombre, String telefono) {
        super(id, nombre, telefono);
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void eliminarCurso(Curso curso) {
        cursos.remove(curso);
    }

    @Override
    public String getTipoUsuario() {
        return "Instructor";
    }
}


