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
                                         "║ You have selected Option 1.  ║\n"+
                                         "╚══════════════════════════════╝\n");
                    addTaskReminder();
                    break;
                case 2:
                    System.out.println("\n╔══════════════════════════════╗\n"+
                                         "║ You have selected Option 2.  ║\n"+
                                         "╚══════════════════════════════╝\n");
                    modifyTaskReminder();                     
                    break;
                case 3:
                    System.out.println("\n╔══════════════════════════════╗\n"+
                                         "║ You have selected Option 3.  ║\n"+
                                         "╚══════════════════════════════╝\n");
                    deleteTaskReminder();                     
                    break;
                case 4:
                    System.out.println("\n╔══════════════════════════════╗\n"+
                                         "║ You have selected Option 4.  ║\n"+
                                         "╚══════════════════════════════╝\n");
                    showListTaskReminder();                     
                    break;
                case 5:
                    System.out.println("\n╔══════════════════════════════╗\n"+
                                         "║ You have selected Option 5.  ║\n"+
                                         "╚══════════════════════════════╝\n");
                    undoLastAction();                 
                    break;
                case 0:
                    System.out.println("\n╔══════════════════════════════╗\n"+
                                         "║ Exiting the program...       ║\n"+
                                         "╚══════════════════════════════╝\n");
                    break;
                default:
                    System.out.println("Not valid option. Please, try again.");
            }


    }

    public int showMenuAndGetOption() {
        int input;

        System.out.println("\n╔══════════════════════════════╗\n" +
                             "║            ( ( (             ║\n" +         
                             "║             ) ) )            ║\n" +       
                             "║            ( ( (             ║\n" +
                             "║          '. ___ .'           ║\n" +
                             "║         '  (> <) '           ║\n" +
                             "║ --------ooO-(_)-Ooo--------- ║\n" +
                             "║                              ║\n" +
                             "║        | App Menu |          ║\n" +
                             "║                              ║\n" + 
                             "║  1. Add a task               ║\n" +
                             "║  2. Modify a task            ║\n" +
                             "║  3. Delete a task            ║\n" +
                             "║  4. Show task list           ║\n" +
                             "║  5. Undo last action         ║\n" + 
                             "║  0. Exit                     ║\n" + 
                             "╚══════════════════════════════╝\n");

        System.out.print("-> Select an option: ");


        input = sc.nextInt();
        sc.nextLine();
        return input;
    }


    private void addTaskReminder(){

        System.out.println("Enter a recognition id for the task (Only make use of numbers))");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.println("Enter the task title:");
        String title = sc.nextLine();

        System.out.println("Enter the task description:");
        String description = sc.nextLine();

        int day, month, year;
        System.out.println("Enter the day:");
        day = sc.nextInt();

        System.out.println("Enter the month:");
        month = sc.nextInt();

        System.out.println("Enter the year:");
        year = sc.nextInt();

        System.out.println("Enter the priority of the task (1 for priority, 0 for non-priority):");
        int priority = sc.nextInt();

        if(taskM.addTaskReminder(id, title, description, day, month-1, year, priority)){
            
            System.out.println("Task successfully entered");

        }else{

            System.out.println("Could not enter the task");

        }  
        

    }

    private void modifyTaskReminder(){

        String listado = taskM.showListTaskReminder();

        if(listado.equals("")){

            System.out.println("No tasks entered");

        }else{

            System.out.println(listado);

            System.out.println("Type the id of the task you want to modify");

            int selection = sc.nextInt();

            System.out.println("What data do you want to change in the task?\n" +
                               "1. Title\n" +
                               "2. Description\n" +
                               "3. Deadline\n" +
                               "4. Priority (1 for priority, 0 for non-priority)" );

            int cambio = sc.nextInt();
            
            int day = 0;
            int month = 0;
            int year = 0;
            String modification = "";

            sc.nextLine();

            if(cambio == 3){

                System.out.println("Enter date by day, month and year");

                System.out.println("Enter the day:");
                day = sc.nextInt();

                System.out.println("Enter the month:");
                month = sc.nextInt();

                System.out.println("Enter the year:");
                year = sc.nextInt();
                


            }else{

                System.out.println("Type the new value");
			    modification = sc.nextLine();

            }

            if(taskM.modifyTaskReminder(selection, cambio, day, month, year, modification)){

                System.out.println("Successful modification");

            }else{

                System.out.println("The task could not be modified");

            }  
            

			
            
        }   

    }

    private void deleteTaskReminder(){

        String listado = taskM.showListTaskReminder();

        if(listado.equals("")){

            System.out.println("No tasks entered");

        }else{

            System.out.println(listado);

            System.out.println("Enter the ID of the task to be deleted");

            int selection = sc.nextInt();

            taskM.deleteTaskReminder(selection);

        }


    }

    private void showListTaskReminder(){

        String listado = taskM.showListTaskReminder();

        if(listado.equals("")){

            System.out.println("No tasks entered");

        }else{

            System.out.println(listado);

        }

    }

    private void undoLastAction(){

        if(taskM.stackEmpty()){

            System.out.println("You have not performed actions");

        }else{

            System.out.println("The last action performed will be undone");

            if(taskM.undoLastAction()){

                System.out.println("Action successfully undone");

            }else{

                System.out.println("The action could not be undone");

            }  
            

        }


    }

}