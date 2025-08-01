package gym_entidades;

import java.time.LocalDate;

public class Asistencia {
    private Subscriptor subscriptor;
    private Curso curso;
    private LocalDate fecha;
    private boolean presente;

    public Asistencia(Subscriptor s, Curso c, LocalDate f, boolean p) {
        subscriptor = s;
        curso = c;
        fecha = f;
        presente = p;
    }
}
