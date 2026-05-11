import java.util.ArrayList;
import java.util.Scanner;

public class GestionPedidos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Producto p1 = new Producto("Laptop Gamer", 1500.0, 3);
        Producto p2 = new Producto("Mouse Pro", 50.0, 5);
        Pedido miPedido = new Pedido("PED-001");

        int opcion;
        do {
            System.out.println("\n--- TIENDA ONLINE ---");
            System.out.println("1. Agregar " + p1.nombre + " (Disponibles: " + p1.cantidadDisponible + ")");
            System.out.println("2. Agregar " + p2.nombre + " (Disponibles: " + p2.cantidadDisponible + ")");
            System.out.println("3. Finalizar y Procesar Pedido");
            System.out.print("Selecciona una opción: ");
            opcion = sc.nextInt();

            if (opcion == 1 || opcion == 2) {
                Producto seleccionado = (opcion == 1) ? p1 : p2;

                System.out.print("¿Cuántas unidades quieres?: ");
                int cantidad = sc.nextInt();

                while (cantidad > seleccionado.cantidadDisponible || cantidad < 0) {
                    System.out.println("Error: Stock insuficiente o cantidad inválida.");
                    System.out.println("Disponible actualmente: " + seleccionado.cantidadDisponible);
                    System.out.print("Ingresa una nueva cantidad (0 para cancelar): ");
                    cantidad = sc.nextInt();
                }

                if (cantidad > 0) {
                    miPedido.listaItems.add(new ItemPedido(seleccionado, cantidad));
                    seleccionado.cantidadDisponible -= cantidad;
                    System.out.println("¡Agregado con éxito!");
                }
            }
        } while (opcion != 3);

        if (!miPedido.listaItems.isEmpty()) {
            System.out.println("\nTotal a pagar: $" + miPedido.calcularTotal());
            miPedido.procesarPedido();
            System.out.println("\nEstado del pedido: " + miPedido.estado);
        } else {
            System.out.println("No se agregaron productos.");
        }
    }
}

class Producto {
    String nombre;
    double precio;
    int cantidadDisponible;

    public Producto(String nombre, double precio, int cantidadDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = cantidadDisponible;
    }
}

class ItemPedido {
    Producto producto;
    int cantidadSolicitada;

    public ItemPedido(Producto producto, int cantidadSolicitada) {
        this.producto = producto;
        this.cantidadSolicitada = cantidadSolicitada;
    }
}

class Pedido {
    ArrayList<ItemPedido> listaItems = new ArrayList<>();
    String idPedido;
    String estado;

    public Pedido(String idPedido) {
        this.idPedido = idPedido;
        this.estado = "Pendiente";
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : listaItems) {
            total += item.producto.precio * item.cantidadSolicitada;
        }
        return total;
    }

    public void procesarPedido() {
        System.out.println("\n--- Preparando Paquetes ---");
        for (ItemPedido item : listaItems) {
            int unidades = 0;
            do {
                unidades++;
                System.out.println("Empacando " + item.producto.nombre + " [" + unidades + "/" + item.cantidadSolicitada + "]");
            } while (unidades < item.cantidadSolicitada);
        }
        this.estado = "Completado";
    }
}