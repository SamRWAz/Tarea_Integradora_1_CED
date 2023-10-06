package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;


public class TaskManager {
    private Hashtable<Integer, Task> tasks;

    public TaskManager() {
        tasks = new Hashtable<>();
        testCases();

    }

    public void testCases(){

        Task newTarea = new Task("Sumas y Restas","Todo lo que necesitas saber sobre las sumas y restas","10/12/2023", Priority.PRIORITY);
        tasks.put(1, newTarea);

    }


    public void addTaskReminder(int id, String title, String description, int day, int month, int year, int priority) {


        Calendar fechaProvisional = new GregorianCalendar(day, month-1, year);

		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		
		String fechaChange = formatoFecha.format(fechaProvisional.getTime());


		Priority Priority1 = Priority.NO_PRIORITY;

        if (priority == 1){

            Priority1 = Priority.PRIORITY;

        }else{

			Priority1 = Priority.NO_PRIORITY;

		}


        Task NewTarea = new Task(title, description, fechaChange, Priority1);

        addTaskReminder(id, NewTarea);


    }

    public void addTaskReminder(int id, Task task) {
        tasks.put(id , task);
    }


    public void modifyTaskReminder(int id, Task task) {
        if (tasks.containsKey(id)) {
            tasks.put(id, task);
        }
    }


    public void deleteTaskReminder(int id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        }
    }


    public Task obtenerTarea(int id) {
        return tasks.get(id);
    }

    public String showListTaskReminder() {
        
        String msg = "";

        for (Task task : tasks.values()) {


            msg +="\n╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\n" +
                   "║                                                                                                                            \n" + 
                   "║ -> Título: " + task.getDescription()+"                                                                                   "+"\n" + 
                   "║                                                                                                                            \n" +         
                   "║ -> Descripción: "  + task.getDescription()+"                                                                             "+"\n" + 
                   "║                                                                                                                            \n" +     
                   "║ -> Fecha Límite: " + task.getDatelimit() +"                                                                              "+"\n" +  
                   "║                                                                                                                            \n" + 
                   "║ -> Prioridad: " + task.getPriority()+"                                                                                   "+"\n" +                     
                   "║                                                                                                                            \n" + 
                   "╚════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════\n";

        }

        return msg;
    }

    

    

}
