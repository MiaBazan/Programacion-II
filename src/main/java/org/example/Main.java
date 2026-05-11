package org.example;

@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {

//        //1. Imprimir N° del 1 al 10 :0
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(i);
//        }

//        //2.  Imprimir N° pares del 0 al 50 :]
//        for (int i = 0; i <= 50; i+= 2) {
//            System.out.println(i);
//        }

//        //3. Sumar N° del 1 al 100 e imprimir el resultado :]
//        int suma = 0;
//        for (int i = 1; i <= 100; i++)
//            suma += i;
//            System.out.println(suma);
//        }

//        //4. Cuenta Regresiva: Imprime una cuenta regresiva desde 5 hasta 1, y luego ¡Despegue! :D
//        int contador = 5;
//        while (contador > 0) {
//            System.out.println(contador);
//            contador--;
//        }
//        System.out.println("¡Despegue!");

//        //5. Adivina el número. Simula un juego donde tienes que adivinar un número fijo. :]
//        //El bucle continúa hasta que el número sea el adivinado. :0
//        Scanner sc = new Scanner(System.in);
//        int NumeroSecreto = 7;
//        int NumeroIntento = 0;
//        while (NumeroIntento != NumeroSecreto)
//        {
//            System.out.println("Introduce tu número");
//            NumeroIntento = sc.nextInt();
//          if (NumeroIntento != NumeroSecreto) {
//                System.out.println("Número incorrecto, pruebe nuevamente.");
//            }
//        }
//        System.out.println("Has adivinado el número, ¡Felicidades!");

//        //6. Validación de entrada. Pedir al usuario que ingrese una contraseña (simulada) hasta que sea la correcta. :]
//        Scanner sc = new Scanner(System.in);
//        String ContraseñaCorrecta = "Java2026";
//        String ContraseñaEntrada = "";
//        while (!ContraseñaEntrada.equals(ContraseñaCorrecta)) {
//            System.out.println("Usuario: Juan Perez");
//            System.out.println("Ingrese su contraseña: ");
//            ContraseñaEntrada = sc.nextLine();
//            if (!ContraseñaEntrada.equals(ContraseñaCorrecta)) {
//                System.out.println("Contraseña incorrecta, intente nuevamente.");
//                System.out.println("------------------------------------------");
//            }
//        }
//        System.out.print("Iniciando sesión...");

//        //7.  Imprime un menú de opciones al menos una vez, y luego pregunta si el usuario quiere verlo de nuevo. :]
//        //El bucle continúa si el usuario lo desea. :0
//        Scanner sc = new Scanner(System.in);
//        int Respuesta;
//        do {
//            System.out.println("\n------- MENÚ -------");
//            System.out.println("1. Ver perfil");
//            System.out.println("2. Configuración");
//            System.out.println("3. Salir");
//            System.out.println("Elige una opción: ");
//            Respuesta = sc.nextInt();
//            if (Respuesta == 1) {
//                System.out.println("Usuario: Juan Perez");
//                System.out.println("Contraseña: ********");
//            }
//            else if (Respuesta == 2) {
//                System.out.println("Cambiar nombre de usuario.");
//                System.out.println("Cambiar contraseña.");
//            }
//            else if (Respuesta == 3) {
//                System.out.println("Saliendo...");
//            }
//            else {
//                System.out.println("Opción inválida.");
//            }
//            if (Respuesta != 3) {
//                System.out.print("\n¿Deseas volver al menú principal? (Escribe cualquier número para SÍ, 3 para NO): ");
//                Respuesta = sc.nextInt();
//            }
//        } while (Respuesta != 3);
//        System.out.println("¡Hasta pronto!");

//        //8. Solicitar Número Positivo: Pide al usuario que ingrese un número, y sigue pidiéndolo hasta que ingrese un número positivo :D
//        Scanner sc = new Scanner(System.in);
//        long NumeroIngresado;
//        do
//        {
//            System.out.println("Por favor, ingrese un número de valor positivo: ");
//            NumeroIngresado = sc.nextLong();
//        }
//        while (NumeroIngresado <= 0);
//            System.out.println("Hasta pronto");

//        //9. Contador Mínimo: Imprime números del 1 al 3. :D
//        // Asegura que al menos el 1 se imprima, incluso si la condición del while se cumple desde el principio.
//        int i = 1;
//        do {
//            System.out.println("Número: " + i);
//            i++;
//        }
//        while (i <= 3);
//            System.out.println("¡Hasta pronto!");

        //10. Tablas de Multiplicar (del 1 al 5): Usa un bucle externo (for) para iterar por las tablas del 1 al 5,
        // y un bucle interno (for, while o do-while) para calcular e imprimir cada multiplicación (del 1 al 10)
        for (int TablaDelNumero = 1; TablaDelNumero <= 5; TablaDelNumero++)
        {
            System.out.println("\n--- TABLA DEL " + TablaDelNumero + " ---");
            int Multiplicador = 1;
            while (Multiplicador <= 10) {
                int Resultado = TablaDelNumero * Multiplicador;
                System.out.println(TablaDelNumero + " x " + Multiplicador + " = " + Resultado);
                Multiplicador++;
            }
        }
    }
}