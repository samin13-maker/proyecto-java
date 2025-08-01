package gym_conexion;

import java.util.Scanner;
import gym_servicios.*;
import gym_entidades.*;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private ServicioUsuario servicioUsuario = new ServicioUsuario();
    private ServicioCurso servicioCurso = new ServicioCurso();
    private ServicioAsistencia servicioAsistencia = new ServicioAsistencia();
    private ServicioAmonestaciones servicioAmonestacion = new ServicioAmonestaciones();

    public void mostrar() {
        while (true) {
            System.out.println("==== GIMNASIO ====");
            System.out.println("1. Registrar curso");
            System.out.println("2. Ver cursos");
            System.out.println("3. Registrar subscriptor");
            System.out.println("4. Registrar instructor");
            System.out.println("5. Ver todos los usuarios");
            System.out.println("6. Eliminar curso");
            System.out.println("7. Eliminar usuario");
            System.out.println("8. Registrar asistencia");
            System.out.println("9. Registrar amonestación");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            int op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> registrarCurso();
                case 2 -> verCursos();
                case 3 -> registrarSubscriptor();
                case 4 -> registrarInstructor();
                case 5 -> listarUsuarios();
                case 6 -> eliminarCurso();
                case 7 -> eliminarUsuario();
                case 8 -> registrarAsistencia();
                case 9 -> registrarAmonestacion();
                case 0 -> {
                    System.out.println("Hasta pronto!");
                    return;
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }
   

    private void registrarCurso() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Horario: ");
        String horario = sc.nextLine();
        System.out.print("Cupo: ");
        int cupo = sc.nextInt(); sc.nextLine();
        System.out.print("ID Instructor (solo número): ");
        int instructorId = sc.nextInt(); sc.nextLine();

        Instructor inst = new Instructor(instructorId, "TEMP", "");
        Curso curso = new Curso(id, nombre, horario, cupo, inst);
        servicioCurso.registrarCurso(curso);
    }
    
    private void verCursos() {
        for (Curso c : servicioCurso.listarCursos()) {
            System.out.println("ID: " + c.getId() + " | Curso: " + c.getNombre() + " - Cupo: " + c.getCupo());
        }
    }


    private void registrarSubscriptor() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Teléfono: ");
        String tel = sc.nextLine();
        System.out.print("¿Membresía activa? (true/false): ");
        boolean activa = sc.nextBoolean(); sc.nextLine();

        servicioUsuario.registrarSubscriptor(nombre, tel, activa);
        System.out.println("Subscriptor registrado.");
    }

    private void registrarInstructor() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Teléfono: ");
        String tel = sc.nextLine();

        servicioUsuario.registrarInstructor(nombre, tel);
        System.out.println("Instructor registrado.");
    }
    
    private void listarUsuarios() {
        for (Usuario u : servicioUsuario.listarUsuarios()) {
            System.out.println("ID: " + u.getId() + " | " + u.getTipoUsuario() + ": " + u.getNombre());
        }
    }

    
    
    private void eliminarCurso() {
        System.out.print("ID del curso a eliminar: ");
        int id = sc.nextInt(); sc.nextLine();
        servicioCurso.eliminarCurso(id);
        System.out.println("Curso eliminado.");
    }

    private void eliminarUsuario() {
        System.out.print("ID del usuario a eliminar: ");
        int id = sc.nextInt(); sc.nextLine();
        servicioUsuario.eliminarUsuario(id);
        System.out.println("Usuario eliminado.");
    }
    
    
    private void registrarAsistencia() {
        System.out.print("ID del curso: ");
        int cursoId = sc.nextInt(); sc.nextLine();
        System.out.print("ID del subscriptor: ");
        int subId = sc.nextInt(); sc.nextLine();
        System.out.print("¿Asistió? (true/false): ");
        boolean presente = sc.nextBoolean(); sc.nextLine();

        servicioAsistencia.registrarAsistencia(subId, cursoId, presente);
    }
    
    private void registrarAmonestacion() {
        System.out.print("ID del subscriptor: ");
        int subId = sc.nextInt(); sc.nextLine();
        System.out.print("Comentario: ");
        String comentario = sc.nextLine();

        servicioAmonestacion.registrarAmonestacion(subId, comentario);
    }


    
    private Subscriptor buscarSubscriptorPorId(int id) {
        for (Usuario u : servicioUsuario.listarUsuarios()) {
            if (u instanceof Subscriptor && u.getId() == id) {
                return (Subscriptor) u;
            }
        }
        return null;
    }



}
