package gym_servicios;

import gym_entidades.*;
import java.util.*;

public class ServicioCurso {
    private List<Curso> cursos = new ArrayList<>();

    public void registrarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void eliminarCurso(int id) {
        cursos.removeIf(c -> c.getId() == id);
    }

    public List<Curso> listarCursos() {
        return cursos;
    }

    public Curso buscarCursoPorId(int id) {
        for (Curso c : cursos) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public boolean inscribirSubscriptor(int cursoId, Subscriptor sub) {
        Curso curso = buscarCursoPorId(cursoId);
        if (curso != null) return curso.inscribir(sub);
        return false;
    }

    public List<Subscriptor> listarInscritos(int cursoId) {
        Curso curso = buscarCursoPorId(cursoId);
        return curso != null ? curso.getInscritos() : new ArrayList<>();
    }
}
