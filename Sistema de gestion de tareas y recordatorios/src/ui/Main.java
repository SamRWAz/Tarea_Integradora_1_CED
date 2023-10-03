package ui;

import java.util.Scanner;

public class Main {

    private Scanner sc;

    public Main(){

        sc = new Scanner(System.in);
    }
    public static void main(String[] args) {

        Main lobby = new Main();
        int option = 0;


        do {
            option =lobby.showMenuAndGetOption();
            lobby.answerOption(option);
        }while (option !=0);

    
    }

    public void answerOption(int userOption) {

        switch (userOption) {
                case 1:
                    System.out.println("Ha seleccionado la Opción 1.");
                    addTaskReminder();
                    break;
                case 2:
                    System.out.println("Ha seleccionado la Opción 2.");
                    modifyTaskReminder();
                    break;
                case 3:
                    System.out.println("Ha seleccionado la Opción 3.");
                    deleteTaskReminder();
                    break;
                case 4:
                    System.out.println("Ha seleccionado la Opción 4.");
                    showListTaskReminder();
                    break;
                case 5:
                    System.out.println("Ha seleccionado la Opción 5.");
                    
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }


    }

    public int showMenuAndGetOption() {
        int input;

        System.out.println("\n╔══════════════════════════════╗\n" +
                             "║          Menú de la App      ║\n" +
                             "║                              ║\n" + 
                             "║  1. Agregar una tarea        ║\n" +
                             "║  2. Modificar una tarea      ║\n" + 
                             "║  3. Eliminar una tarea       ║\n" + 
                             "║  4. Mostrar lista            ║\n" + 
                             "║  5. Deshacer última acción   ║\n" + 
                             "║  0. Salir                    ║\n" + 
                             "║                              ║\n" + 
                             "╚══════════════════════════════╝\n");

        System.out.print("Seleccione una opción: ");


        input = sc.nextInt();
        sc.nextLine();
        return input;
    }


    private void addTaskReminder(){

        

    }

    private void modifyTaskReminder(){



    }

    private void deleteTaskReminder(){



    }

    private void showListTaskReminder(){



    }

}