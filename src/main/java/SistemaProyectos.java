import java.util.ArrayList;
import java.util.Scanner;

public class SistemaProyectos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Proyecto proyecto = new Proyecto("Desarrollo App Movil", "11/05/2026", "11/12/2026");

        proyecto.registrarMiembro(new MiembroEquipo("Ana", "Lider Tecnico"));
        proyecto.registrarMiembro(new MiembroEquipo("Pedro", "Desarrollador"));
        proyecto.registrarMiembro(new MiembroEquipo("Lucia", "Disenadora"));

        Tarea t1 = new Tarea("Diseno UI", "Crear prototipos en Figma", "20/05/2026");
        Tarea t2 = new Tarea("Base de Datos", "Modelado de tablas", "30/05/2026");

        proyecto.agregarTarea(t1);
        proyecto.agregarTarea(t2);

        int opcion;
        do {
            System.out.println("\n--- GESTION DE PROYECTO: " + proyecto.nombre + " ---");
            System.out.println("1. Mostrar progreso del proyecto");
            System.out.println("2. Asignar tarea a un miembro");
            System.out.println("3. Actualizar estado de una tarea");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    proyecto.mostrarProgreso();
                    System.out.println("\nPresiona ENTER para volver al menu...");
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("\n--- SELECCIONA UN MIEMBRO ---");
                    for (int i = 0; i < proyecto.equipo.size(); i++) {
                        System.out.println((i + 1) + ". " + proyecto.equipo.get(i).nombre + " (" + proyecto.equipo.get(i).rol + ")");
                    }
                    System.out.print("Elige el numero del miembro: ");
                    int numM = sc.nextInt();

                    System.out.println("\n--- SELECCIONA UNA TAREA ---");
                    for (int i = 0; i < proyecto.listaTareas.size(); i++) {
                        System.out.println((i + 1) + ". " + proyecto.listaTareas.get(i).nombre);
                    }
                    System.out.print("Elige el numero de la tarea: ");
                    int numT = sc.nextInt();
                    sc.nextLine();

                    if (numM > 0 && numM <= proyecto.equipo.size() && numT > 0 && numT <= proyecto.listaTareas.size()) {
                        MiembroEquipo m = proyecto.equipo.get(numM - 1);
                        Tarea t = proyecto.listaTareas.get(numT - 1);
                        proyecto.asignarTarea(t, m.nombre);
                    } else {
                        System.out.println("Seleccion invalida.");
                    }

                    System.out.println("\nTarea procesada. Presiona ENTER para continuar...");
                    sc.nextLine();

                    break;
                case 3:
                    System.out.println("\n--- ACTUALIZAR TAREA ---");
                    for (int i = 0; i < proyecto.listaTareas.size(); i++) {
                        System.out.println((i + 1) + ". " + proyecto.listaTareas.get(i).nombre + " [" + proyecto.listaTareas.get(i).estado + "]");
                    }
                    System.out.print("Selecciona el numero de tarea: ");
                    int sel = sc.nextInt();
                    sc.nextLine();
                    if (sel > 0 && sel <= proyecto.listaTareas.size()) {
                        proyecto.listaTareas.get(sel - 1).actualizarEstado();
                    }
                    System.out.println("\nCambio realizado. Presiona ENTER para continuar...");
                    sc.nextLine();
                    break;
            }
        } while (opcion != 4);
    }
}

class Tarea {
    String nombre;
    String descripcion;
    String estado;
    String fechaLimite;

    public Tarea(String nombre, String descripcion, String fechaLimite) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = "Pendiente";
        this.fechaLimite = fechaLimite;
    }

    public void actualizarEstado() {
        Scanner sc = new Scanner(System.in);
        String nuevoEstado;
        boolean valido;
        do {
            System.out.print("Nuevo estado (Pendiente / En Progreso / Completada): ");
            nuevoEstado = sc.nextLine();
            valido = nuevoEstado.equalsIgnoreCase("Pendiente") ||
                    nuevoEstado.equalsIgnoreCase("En Progreso") ||
                    nuevoEstado.equalsIgnoreCase("Completada");

            if (!valido) System.out.println("Error: Estado invalido.");
        } while (!valido);
        this.estado = nuevoEstado;
    }
}

class MiembroEquipo {
    String nombre;
    String rol;
    ArrayList<Tarea> tareasAsignadas = new ArrayList<>();

    public MiembroEquipo(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }
}

class Proyecto {
    String nombre;
    String fechaInicio;
    String fechaFinEstimada;
    ArrayList<Tarea> listaTareas = new ArrayList<>();
    ArrayList<MiembroEquipo> equipo = new ArrayList<>();

    public Proyecto(String nombre, String fechaInicio, String fechaFinEstimada) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinEstimada = fechaFinEstimada;
    }

    public void agregarTarea(Tarea t) {
        listaTareas.add(t);
    }

    public void registrarMiembro(MiembroEquipo m) {
        equipo.add(m);
    }

    public void asignarTarea(Tarea tarea, String nombreMiembro) {
        int i = 0;
        MiembroEquipo encontrado = null;
        while (i < equipo.size()) {
            if (equipo.get(i).nombre.equalsIgnoreCase(nombreMiembro)) {
                encontrado = equipo.get(i);
                break;
            }
            i++;
        }

        if (encontrado != null) {
            encontrado.tareasAsignadas.add(tarea);
            System.out.println("¡Exito! Tarea '" + tarea.nombre + "' asignada a " + encontrado.nombre);
        }
    }

    public void mostrarProgreso() {
        System.out.println("\n--- REPORTE DE TAREAS ---");
        for (Tarea t : listaTareas) {
            System.out.println("- " + t.nombre + ": [" + t.estado + "]");
        }
    }
}