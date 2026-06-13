import java.util.Scanner;

public class Funciones {

        // ===================================================
        //  --- Nivel 1 – Fundamentos de métodos (sin arrays)
        // ===================================================

        //1. Mostrar mensaje fijo. Crear un metodo llamado mostrarSaludo() que imprima “Hola, mundo”.
        public static void mostrarSaludo() {
            System.out.println("Hola mundo! :D");
        }

        //2. Saludo personalizo, Crear un metodo llamado saludar(String nombre) que reciba un nombre como
        //parámetro e imprima un saludo.
        public static void saludar(String nombre) {
            if (nombre == null || nombre.trim().isEmpty()) {
                System.out.println("¡Hola, anon!");
            } else {
                System.out.println("¡Buenas noches, " + nombre.trim() + "! ¿Cómo está? :]");
            }
        }

        //3. Área de un rectángulo. Crear un metodo que reciba dos argumentos (base, altura) y devuelva el área del
        //rectángulo.
        public static double calcularAreaRectangulo(double base, double altura) {
            if (base <= 0 || altura <= 0) {
                System.out.println("¡Error!: La base y la altura deben ser mayores a 0.");
                return 0.0;
            }
            return base * altura;
        }

        //4. Convertir a mayúsculas. Crear un metodo que reciba una cadena de texto y devuelva esa cadena en mayúsculas.
        public static String convertirAMayusculas(String texto) {
            if (texto == null) {
                return "";
            }
            return texto.trim().toUpperCase();
        }

        //5. Mostrar menú. Crear un metodo sin argumentos ni retorno que imprima un menú con varias opciones.
        public static void mostrarMenu() {
            System.out.println("\n========================================");
            System.out.println("        PANEL DE EJERCICIOS             ");
            System.out.println("========================================");
            System.out.println("  [1] Mostrar saludo fijo             ");
            System.out.println("  [2] Saludo personalizado            ");
            System.out.println("  [3] Calcular área rectángulo        ");
            System.out.println("  [4] Convertir texto a mayúsculas    ");
            System.out.println("  [5] Mostrar este menú otra vez      ");
            System.out.println("  [6] Comprobar si número es par      ");
            System.out.println("  [7] Calcular cuadrado de un número  ");
            System.out.println("  [8] Calcular factorial recursivo    ");
            System.out.println("  [9] Sumar múltiples números         ");
            System.out.println("  [10] Calcular promedio de un array  ");
            System.out.println("  [11] Buscar un valor en un array    ");
            System.out.println("  [12] Contar palabras repetidas      ");
            System.out.println("  [13] Imprimir un array formateado   ");
            System.out.println("  [14] Invertir un array de enteros   ");
            System.out.println("  [15] Buscar alumno con mejor nota   ");
            System.out.println("  [0] Salir del programa              ");
            System.out.println("========================================");
        }

        // ============================================
        // --- Nivel 2 – Métodos con retorno y lógica
        // ============================================

        //6. Número par o impar. Crear un metodo esPar(int numero) que devuelva true si el número es par, y
        //false si es impar.
        public static boolean esPar(int numero) {
            return numero % 2 == 0;
        }

        //7. Calcular el cuadrado de un número. Crear un metodo que reciba un entero y devuelva su cuadrado.
        public static int calcularCuadrado(int numero) {
            return numero * numero;
        }

        //8. Factorial recursivo. Crear un metodo recursivo que calcule el factorial de un número.
        public static int factorial(int numero) {
            if (numero < 0) {
                System.out.println("No existe el factorial de un número negativo.");
                return -1;
            }
            // Caso base
            if (numero <= 1) {
                return 1;
            }
            // Caso recursivo: el metodo se llama a sí mismo:[]
            return numero * factorial(numero - 1);
        }

        // ===========================================
        // --- Nivel 3 – Métodos con varargs y arrays
        // ===========================================

        //9. Sumar múltiples números (varargs). Crear un metodo sumarNumeros(int... numeros) que reciba una cantidad
        //indefinida de enteros y devuelva la suma.
        public static int sumarNumeros(int... numeros) {
            if (numeros.length == 0) return 0;

            int suma = 0;
            for (int num : numeros) {
                suma += num;
            }
            return suma;
        }

        //10. Promedio de un array. Crear un metodo que reciba un array de double y retorne el promedio.
        public static double calcularPromedio(double[] array) {
            if (array == null || array.length == 0) {
                return 0.0;
            }
            double suma = 0;
            for (double num : array) {
                suma += num;
            }
            return suma / array.length;
        }

        //11. Buscar valor en array. Crear un metodo que reciba un array de int y un número a buscar,
        // y devuelva true si el número está presente.
        public static boolean buscarValor(int[] array, int numeroBuscar) {
            if (array == null) return false;

            for (int num : array) {
                if (num == numeroBuscar) {
                    return true; // Termina el bucle apenas lo encuentra
                }
            }
            return false;
        }

        //12. Contar ocurrencias. Crear un metodo que reciba un array de String y un string clave,
        // y devuelva cuántas veces aparece.
        public static int contarOcurrencias(String[] array, String clave) {
            if (array == null || clave == null) return 0;

            int contador = 0;
            for (String texto : array) {
                if (texto != null && texto.equalsIgnoreCase(clave)) {
                    contador++;
                }
            }
            return contador;
        }

        // ==========================================================
        // --- Nivel 4 – Métodos combinados y más complejos (ayuda-)
        // ==========================================================

        //13. Imprimir array de forma formateada. Crear un metodo que reciba un array de enteros y
        // los imprima entre corchetes, separados por comas.
        public static void imprimirArrayFormateado(int[] array) {
            if (array == null) {
                System.out.println("[]");
                return;
            }
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                // Si no es el último elemento, agrega una coma y un espacio
                if (i < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

        //14. Invertir array. Crear un metodo que reciba un array de enteros y devuelva otro array
        // con los valores en orden inverso.
        public static int[] invertirArray(int[] array) {
            if (array == null) return new int[0];

            int[] resultado = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                // El primer elemento del nuevo array toma el último del original
                resultado[i] = array[array.length - 1 - i];
            }
            return resultado;
        }

        //15. Estudiante con mejor nota. Crear un metodo que reciba dos arrays: uno con nombres de estudiantes
        // y otro con sus notas, y devuelva el nombre del estudiante con la mejor nota.
        public static String estudianteConMejorNota(String[] nombres, double[] notas) {
            // Validación de seguridad para que el programa no se rompa (que esperemos que ande la vdd-)
            if (nombres == null || notas == null || nombres.length == 0 || nombres.length != notas.length) {
                return "Error: Datos inconsistentes o vacíos.";
            }

            double maxNota = notas[0];
            int indiceMejor = 0;

            for (int i = 1; i < notas.length; i++) {
                if (notas[i] > maxNota) {
                    maxNota = notas[i];
                    indiceMejor = i; // Guardamos la posición del alumno con mejor nota
                }
            }
            return nombres[indiceMejor] + " (Nota: " + maxNota + ")";
        }

        // ==================================================================
        // --- Pruebas en consola que SÍ andan gracias a Dios- (Metodo Main)
        // ==================================================================
        public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);
            int opcion = -1;
            boolean imprimirMenucompletamente = true;

            do {
                if (imprimirMenucompletamente) {
                    mostrarMenu();
                }

                System.out.print("Elige una opción (0-15): ");
                String entradaOpcion = teclado.nextLine();

                try {
                    opcion = Integer.parseInt(entradaOpcion.trim());
                } catch (NumberFormatException e) {
                    System.out.println("\n----------------------------------------");
                    System.out.println("Error: Debes ingresar un número válido, no letras.");
                    System.out.println("----------------------------------------");
                    imprimirMenucompletamente = false;
                    continue;
                }

                System.out.println("\n----------------------------------------");
                switch (opcion) {
                    case 1:
                        mostrarSaludo();
                        break;

                    case 2:
                        System.out.print("Introduce un nombre para el saludo: ");
                        String nom = teclado.nextLine();
                        saludar(nom);
                        break;

                    case 3:
                        try {
                            System.out.print("Introduce la base del rectángulo: ");
                            double b = Double.parseDouble(teclado.nextLine());
                            System.out.print("Introduce la altura del rectángulo: ");
                            double h = Double.parseDouble(teclado.nextLine());
                            System.out.println("Resultado -> Área: " + calcularAreaRectangulo(b, h));
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingresaste un carácter inválido en las medidas.");
                        }
                        break;

                    case 4:
                        System.out.print("Introduce el texto que quieres transformar: ");
                        String cadena = teclado.nextLine();
                        System.out.println("Resultado -> " + convertirAMayusculas(cadena));
                        break;

                    case 5:
                        System.out.println("Forzando despliegue del menú...");
                        imprimirMenucompletamente = true;
                        System.out.println("----------------------------------------");
                        continue;

                    case 6:
                        try {
                            System.out.print("Introduce un número entero: ");
                            int numPar = Integer.parseInt(teclado.nextLine());
                            System.out.println("Resultado -> ¿Es par?: " + esPar(numPar));
                        } catch (NumberFormatException e) {
                            System.out.println("Error: El dato ingresado no es un número entero.");
                        }
                        break;

                    case 7:
                        try {
                            System.out.print("Introduce un número entero: ");
                            int numCuad = Integer.parseInt(teclado.nextLine());
                            System.out.println("Resultado -> El cuadrado es: " + calcularCuadrado(numCuad));
                        } catch (NumberFormatException e) {
                            System.out.println("Error: El dato ingresado no es un número entero.");
                        }
                        break;

                    case 8:
                        try {
                            System.out.print("Introduce un número para calcular su factorial: ");
                            int numFact = Integer.parseInt(teclado.nextLine());
                            System.out.println("Resultado -> El factorial es: " + factorial(numFact));
                        } catch (NumberFormatException e) {
                            System.out.println("Error: El dato ingresado no es un número entero.");
                        }
                        break;

                    case 9:
                        System.out.println("Suma con Varargs (ejemplo dinámico interno):");
                        System.out.println("Enviando (10, 5, 25) -> Suma: " + sumarNumeros(10, 5, 25));
                        System.out.println("Enviando (1, 2, 3, 4, 5) -> Suma: " + sumarNumeros(1, 2, 3, 4, 5));
                        break;

                    case 10:
                        System.out.println("Calculando promedio de un array fijo de prueba {5.5, 7.0, 10.0, 8.5}...");
                        double[] notasPrueba = {5.5, 7.0, 10.0, 8.5};
                        System.out.println("Resultado -> Promedio: " + calcularPromedio(notasPrueba));
                        break;

                    case 11:
                        try {
                            int[] baseDatos = {10, 20, 30, 42, 50};
                            System.out.print("Array disponible: {10, 20, 30, 42, 50}. ¿Qué número deseas buscar?: ");
                            int buscar = Integer.parseInt(teclado.nextLine());
                            System.out.println("Resultado -> ¿Encontrado?: " + buscarValor(baseDatos, buscar));
                        } catch (NumberFormatException e) {
                            System.out.println("Error: El valor a buscar debe ser un número entero.");
                        }
                        break;

                    case 12:
                        String[] listaPalabras = {"Java", "GitHub", "java", "AIMP", "JAVA"};
                        System.out.print("Introduce la palabra a buscar en el array (ej: Java, AIMP): ");
                        String claveBuscar = teclado.nextLine();
                        System.out.println("Resultado -> Aparece " + contarOcurrencias(listaPalabras, claveBuscar) + " veces.");
                        break;

                    case 13:
                        System.out.println("Imprimiendo un array de prueba de forma formateada:");
                        int[] arrayFormato = {4, 8, 15, 16, 23, 42};
                        System.out.print("Resultado -> ");
                        imprimirArrayFormateado(arrayFormato);
                        break;

                    case 14:
                        try {
                            System.out.print("¿Cuántos números deseas ingresar en el array?: ");
                            int cantidad = Integer.parseInt(teclado.nextLine());

                            if (cantidad <= 0) {
                                System.out.println("Error: La cantidad debe ser mayor a 0.");
                            } else {
                                int[] usuarioArray = new int[cantidad];
                                for (int i = 0; i < cantidad; i++) {
                                    System.out.print("Ingresa el número para la posición [" + i + "]: ");
                                    usuarioArray[i] = Integer.parseInt(teclado.nextLine());
                                }

                                System.out.print("Array original: ");
                                imprimirArrayFormateado(usuarioArray);

                                int[] invertido = invertirArray(usuarioArray);
                                System.out.print("Resultado invertido -> ");
                                imprimirArrayFormateado(invertido);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Ingresaste un dato que no es un número entero válido.");
                        }
                        break;

                    case 15:
                        String[] alumnos = {"Ana", "Pedro", "Sofía", "Carlos"};
                        double[] calificaciones = {8.0, 6.5, 9.8, 7.2};
                        System.out.println("Lista: Ana(8.0), Pedro(6.5), Sofía(9.8), Carlos(7.2)");
                        System.out.println("Resultado de mejor nota -> " + estudianteConMejorNota(alumnos, calificaciones));
                        break;

                    case 0:
                        System.out.println("Cerrando el panel de ejercicios. ¡Hasta luego!");
                        break;

                    default:
                        System.out.println("Opción inválida. Intenta con un número del 0 al 15.");
                        break;
                }
                System.out.println("----------------------------------------");

                if (opcion != 0) {
                    String respuesta = "";
                    boolean respuestaValida = false;

                    while (!respuestaValida) {
                        System.out.print("¿Deseas volver a ver el menú principal? (S/N): ");
                        respuesta = teclado.nextLine().trim();

                        if (respuesta.equalsIgnoreCase("S") || respuesta.equalsIgnoreCase("N")) {
                            respuestaValida = true;
                        } else {
                            System.out.println("Error: Opción inválida. Por favor, escribe únicamente 'S' o 'N'.");
                        }
                    }

                    if (respuesta.equalsIgnoreCase("S")) {
                        imprimirMenucompletamente = true;
                    } else {
                        opcion = 0;
                        System.out.println("Cerrando el panel de ejercicios. ¡Hasta luego!");
                    }
                    System.out.println();
                }

            } while (opcion != 0);

            teclado.close();
        }
}