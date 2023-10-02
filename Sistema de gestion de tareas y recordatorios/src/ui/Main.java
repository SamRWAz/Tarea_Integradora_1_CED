package ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("3. Opción 3");
            System.out.println("0. Salir");
            System.out.print("Elija una opción (1-4): ");
            
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ha seleccionado la Opción 1.");
                    // Aquí puedes agregar el código para la Opción 1
                    break;
                case 2:
                    System.out.println("Ha seleccionado la Opción 2.");
                    // Aquí puedes agregar el código para la Opción 2
                    break;
                case 3:
                    System.out.println("Ha seleccionado la Opción 3.");
                    // Aquí puedes agregar el código para la Opción 3
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}