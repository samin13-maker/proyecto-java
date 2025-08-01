package gym_entidades;

import java.time.LocalDate;

public class Amonestacion {
    private Subscriptor subscriptor;
    private String comentario;
    private LocalDate fecha;

    public Amonestacion(Subscriptor s, String comentario) {
        this.subscriptor = s;
        this.comentario = comentario;
        this.fecha = LocalDate.now();
    }
}
