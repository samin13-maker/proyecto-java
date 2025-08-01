package gym_entidades;

import java.util.*;

public class Curso {
    private int id;
    private String nombre;
    private String horario;
    private int cupo;
    private Instructor instructor;
    private List<Subscriptor> inscritos = new ArrayList<>();

    public Curso(int id, String nombre, String horario, int cupo, Instructor instructor) {
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
        this.cupo = cupo;
        this.instructor = instructor;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHorario() {
        return horario;
    }

    public int getCupo() {
        return cupo;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public List<Subscriptor> getInscritos() {
        return inscritos;
    }

    public boolean inscribir(Subscriptor s) {
        if (inscritos.size() < cupo && s.tieneMembresiaActiva()) {
            inscritos.add(s);
            return true;
        }
        return false;
    }
}
