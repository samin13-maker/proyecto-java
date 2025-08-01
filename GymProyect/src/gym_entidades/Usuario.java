package gym_entidades;

public abstract class Usuario {
    protected int id;
    protected String nombre;
    protected String telefono;

    public Usuario(int id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public String getNombre() {
        return nombre;
    }
    

    public int getId() {
        return id;
    }

    public void actualizarDatos(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public abstract String getTipoUsuario();
}

