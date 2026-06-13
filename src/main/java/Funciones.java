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
            System.out.println("\n╔══════════════════════════════════════╗");
            System.out.println("║        MENÚ DE CONFIGURACIÓN         ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║  [1] Iniciar Aplicación              ║");
            System.out.println("║  [2] Ajustar Rendimiento             ║");
            System.out.println("║  [3] Ver Estadísticas de Uso         ║");
            System.out.println("║  [4] Salir del Programa              ║");
            System.out.println("╚══════════════════════════════════════╝\n");
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
                    return true; // Termina el bucle apenas lo encuentra (optimiza rendimiento)
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
            // Validación de seguridad para que el programa no se rompa
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
            System.out.println("=== INICIANDO PRUEBAS DE FUNCIONES ===");

            // Probando Nivel 1
            mostrarSaludo();
            saludar("   Agus   "); // Probando el recorte de espacios (.trim)
            System.out.println("Área de rectángulo (base 4.5, altura 10): " + calcularAreaRectangulo(4.5, 10));
            System.out.println("Texto en mayúsculas: " + convertirAMayusculas("subiendo tareas a github..."));
            mostrarMenu();

            // Probando Nivel 2
            System.out.println("¿El número 7 es par?: " + esPar(7));
            System.out.println("El cuadrado de 8 es: " + calcularCuadrado(8));
            System.out.println("Factorial de 5: " + factorial(5));

            // Probando Nivel 3
            System.out.println("+ Suma múltiple (Varargs): " + sumarNumeros(5, 10, 15, 20, 25));

            double[] notasClase = {8.5, 9.0, 7.5, 10.0};
            System.out.println("Promedio de notas: " + calcularPromedio(notasClase));

            int[] numerosAzar = {14, 25, 39, 42, 50};
            System.out.println("¿Está el número 42?: " + buscarValor(numerosAzar, 42));

            String[] palabras = {"Java", "Discord", "java", "AIMP", "JAVA"};
            System.out.println("Ocurrencias de la palabra 'Java': " + contarOcurrencias(palabras, "Java"));

            // Probando Nivel 4
            System.out.print("Array original formateado: ");
            imprimirArrayFormateado(numerosAzar);

            int[] arrayInvertido = invertirArray(numerosAzar);
            System.out.print("Array invertido formateado: ");
            imprimirArrayFormateado(arrayInvertido);

            String[] alumnos = {"Ana", "Pedro", "Sofía", "Carlos"};
            double[] calificaciones = {8.0, 6.5, 9.8, 7.2};
            System.out.println("Mejor estudiante: " + estudianteConMejorNota(alumnos, calificaciones));

            System.out.println("\n=== PRUEBAS FINALIZADAS CON ÉXITO ===");
        }
    }
