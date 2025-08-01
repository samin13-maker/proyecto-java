package gym_entidades;

import java.util.*;

public class Subscriptor extends Usuario {
    private boolean membresiaActiva;
    private List<Curso> cursosInscritos = new ArrayList<>();
    private List<Amonestacion> amonestaciones = new ArrayList<>();

    public Subscriptor(int id, String nombre, String telefono, boolean activa) {
        super(id, nombre, telefono);
        this.membresiaActiva = activa;
    }

    public void inscribirseACurso(Curso curso) {
        if (membresiaActiva) cursosInscritos.add(curso);
    }

    public boolean tieneMembresiaActiva() {
        return membresiaActiva;
    }

    public void agregarAmonestacion(String comentario) {
        amonestaciones.add(new Amonestacion(this, comentario));
    }

    @Override
    public String getTipoUsuario() {
        return "Subscriptor";
    }
}

