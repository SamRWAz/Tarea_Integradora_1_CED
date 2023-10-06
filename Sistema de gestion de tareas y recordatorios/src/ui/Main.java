package ui;

import java.util.Scanner;

import model.TaskManager;

public class Main {

    private Scanner sc;
    private TaskManager taskM;

    public Main(){

        sc = new Scanner(System.in);
        taskM = new TaskManager();
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
                    System.out.println("\n╔══════════════════════════════╗\n"+
                                         "║ Ha seleccionado la Opción 1. ║\n"+
                                         "╚══════════════════════════════╝\n");

                    addTaskReminder();
                    break;
                case 2:
                    System.out.println("\n╔══════════════════════════════╗\n"+
                                         "║ Ha seleccionado la Opción 2. ║\n"+
                                         "╚══════════════════════════════╝\n");
                    modifyTaskReminder();                     
                    break;

                case 3:
                    System.out.println("\n╔══════════════════════════════╗\n"+
                                         "║ Ha seleccionado la Opción 3. ║\n"+
                                         "╚══════════════════════════════╝\n");
                    deleteTaskReminder();                     
                    break;

                case 4:
                    System.out.println("\n╔══════════════════════════════╗\n"+
                                         "║ Ha seleccionado la Opción 4. ║\n"+
                                         "╚══════════════════════════════╝\n");
                    showListTaskReminder();                     
                    break;
                case 5:
                    System.out.println("\n╔══════════════════════════════╗\n"+
                                         "║ Ha seleccionado la Opción 5. ║\n"+
                                         "╚══════════════════════════════╝\n");
                    break;
                case 0:
                    System.out.println("\n╔══════════════════════════════╗\n"+
                                         "║ Saliendo del programa...     ║\n"+
                                         "╚══════════════════════════════╝\n");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }


    }

    public int showMenuAndGetOption() {
        int input;

        System.out.println("\n╔══════════════════════════════╗\n" +
                             "║      | Menú de la App |      ║\n" +
                             "║                              ║\n" + 
                             "║  1. Agregar una tarea        ║\n" +
                             "║                              ║\n" +
                             "║  2. Modificar una tarea      ║\n" +
                             "║                              ║\n" + 
                             "║  3. Eliminar una tarea       ║\n" +
                             "║                              ║\n" + 
                             "║  4. Mostrar lista            ║\n" +
                             "║                              ║\n" + 
                             "║  5. Deshacer última acción   ║\n" + 
                             "║                              ║\n" +
                             "║  0. Salir                    ║\n" + 
                             "║                              ║\n" + 
                             "╚══════════════════════════════╝\n");

        System.out.print("Seleccione una opción: ");


        input = sc.nextInt();
        sc.nextLine();
        return input;
    }


    private void addTaskReminder(){

        System.out.println("Ingresa un id de reconocimiento para la tarea (Solo hacer uso de números)");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.println("Ingrese el título de la tarea:");
        String title = sc.nextLine();

        System.out.println("Ingrese la descripción de la tarea:");
        String description = sc.nextLine();

        int day, month, year;
        System.out.println("Ingrese el día:");
        day = sc.nextInt();

        System.out.println("Ingrese el mes:");
        month = sc.nextInt();

        System.out.println("Ingrese el año:");
        year = sc.nextInt();

        System.out.println("Ingrese la prioridad de la tarea (1 para prioritaria, 0 para no prioritaria):");
        int priority = sc.nextInt();

        taskM.addTaskReminder(id, title, description, day, month, year, priority);
        

    }

    private void modifyTaskReminder(){



    }

    private void deleteTaskReminder(){



    }

    private void showListTaskReminder(){

        String listado = taskM.showListTaskReminder();

        if(listado.equals("")){

            System.out.println("No hay tareas");

        }else{

            System.out.println(listado);

        }

    }

}