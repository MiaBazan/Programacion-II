import java.util.ArrayList;
import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca miBiblioteca = new Biblioteca();
        Usuario usuarioActual = new Usuario("Juan", "U001");

        miBiblioteca.agregarLibro(new Libro("El Quijote", "Miguel de Cervantes", "111", 1605));
        miBiblioteca.agregarLibro(new Libro("Java para Todos", "James Gosling", "222", 1995));
        miBiblioteca.agregarLibro(new Libro("El Principito", "Antoine de Saint-Exupery", "333", 1943));
        miBiblioteca.agregarLibro(new Libro("Cien anos de soledad", "Gabriel Garcia Marquez", "444", 1967));
        miBiblioteca.agregarLibro(new Libro("Harry Potter", "J.K. Rowling", "555", 1997));

        int opcion;
        do {
            System.out.println("\n--- MENU BIBLIOTECA DIGITAL ---");
            System.out.println("1. Ver libros prestados");
            System.out.println("2. Buscar libro por Titulo o Autor");
            System.out.println("3. Pedir prestado un libro (ISBN)");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    usuarioActual.mostrarPrestados();
                    break;
                case 2:
                    System.out.print("¿Deseas buscar por 'titulo' o 'autor'?: ");
                    String criterio = sc.nextLine();
                    System.out.print("Ingresa el nombre a buscar: ");
                    String valor = sc.nextLine();

                    ArrayList<Libro> resultados = miBiblioteca.buscarLibro(criterio, valor);
                    System.out.println("\nResultados encontrados:");
                    for (Libro l : resultados) {
                        String estado = l.disponible ? "[Disponible]" : "[Prestado]";
                        System.out.println("- " + l.titulo + " de " + l.autor + " " + estado);
                    }
                    break;
                case 3:
                    miBiblioteca.prestarLibro(usuarioActual);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 4);
    }
}

class Libro {
    String titulo;
    String autor;
    String isbn;
    int anioPublicacion;
    boolean disponible;

    public Libro(String titulo, String autor, String isbn, int anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.disponible = true;
    }
}

class Usuario {
    String nombre;
    String idUsuario;
    ArrayList<Libro> librosPrestados = new ArrayList<>();

    public Usuario(String nombre, String idUsuario) {
        this.nombre = nombre;
        this.idUsuario = idUsuario;
    }

    public void mostrarPrestados() {
        System.out.println("\n--- MIS LIBROS PRESTADOS ---");
        if (librosPrestados.isEmpty()) {
            System.out.println("Tu lista esta vacia.");
        } else {
            for (int i = 0; i < librosPrestados.size(); i++) {
                Libro l = librosPrestados.get(i);
                System.out.println((i + 1) + ". " + l.titulo + " (" + l.autor + ")");
            }
        }
    }
}

class Biblioteca {
    ArrayList<Libro> catalogo = new ArrayList<>();

    public void agregarLibro(Libro l) {
        catalogo.add(l);
    }

    public ArrayList<Libro> buscarLibro(String criterio, String valor) {
        ArrayList<Libro> resultados = new ArrayList<>();
        int i = 0;
        while (i < catalogo.size()) {
            Libro actual = catalogo.get(i);
            boolean coincide = false;

            if (criterio.equalsIgnoreCase("titulo") && actual.titulo.toLowerCase().contains(valor.toLowerCase())) {
                coincide = true;
            } else if (criterio.equalsIgnoreCase("autor") && actual.autor.toLowerCase().contains(valor.toLowerCase())) {
                coincide = true;
            }

            if (coincide) {
                resultados.add(actual);
            }
            i++;
        }
        return resultados;
    }

    public void prestarLibro(Usuario usuario) {
        Scanner sc = new Scanner(System.in);
        String isbnBusqueda;
        Libro libroEncontrado = null;

        do {
            System.out.print("Ingrese el ISBN (o escriba 'cancelar'): ");
            isbnBusqueda = sc.nextLine();

            if (isbnBusqueda.equalsIgnoreCase("cancelar")) return;

            for (Libro l : catalogo) {
                if (l.isbn.equals(isbnBusqueda)) {
                    libroEncontrado = l;
                    break;
                }
            }

            if (libroEncontrado == null) {
                System.out.println("Error: ISBN no existe.");
            } else if (!libroEncontrado.disponible) {
                System.out.println("Error: El libro ya esta prestado.");
                libroEncontrado = null;
            }

        } while (libroEncontrado == null);

        libroEncontrado.disponible = false;
        usuario.librosPrestados.add(libroEncontrado);
        System.out.println("¡Has pedido prestado: " + libroEncontrado.titulo + "!");
    }
}