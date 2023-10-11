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


		Priority priority1 = Priority.NO_PRIORITY;

        if (priority == 1){

            priority1 = Priority.PRIORITY;

        }else{

			priority1 = Priority.NO_PRIORITY;

		}


        Task NewTarea = new Task(title, description, fechaChange, priority1);

        addTaskReminder(id, NewTarea);


    }

    public void addTaskReminder(int id, Task task) {
        tasks.put(id , task);
    }


    public boolean modifyTaskReminder(int id, int cambio, int day, int month, int year, String modification) {
        
        if (tasks.containsKey(id)) {
            Task task = tasks.get(id);
            switch(cambio){

                case 1:
                    task.setTitle(modification);
                    return true;
                    
                case 2:
                    task.setDescription(modification);
                    return true;
                case 3:
                    Calendar fechaProvisional = new GregorianCalendar(day, month-1, year);

                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    
                    String fechaChange = formatoFecha.format(fechaProvisional.getTime());

                    task.setDatelimit(fechaChange);
                    return true;
                case 4:
                    Priority priority1 = Priority.NO_PRIORITY;
                    double priority = Integer.parseInt(modification);
                    if (priority == 1){

                        priority1 = Priority.PRIORITY;

                    }else{

                        priority1 = Priority.NO_PRIORITY;

                    }
                    task.setPriority(priority1);
                    return true;
            }
        } else {

           return false;

        }

        return false;
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

        for (Integer id : tasks.keySet()) {

            Task task = tasks.get(id);

            msg += "-> ID: " + id + "\n";
            msg += "╔════════════════════════════════════════════════════════════════════════════════════════════════════════\n" +
                   "║ -> Título: " + task.getDescription() + "\n" +
                   "║\n" +
                   "║ -> Descripción: " + task.getDescription() + "\n" +
                   "║\n" +
                   "║ -> Fecha Límite: " + task.getDatelimit() + "\n" +
                   "║\n" +
                   "║ -> Prioridad: " + task.getPriority() + "\n" +
                   "╚════════════════════════════════════════════════════════════════════════════════════════════════════════\n";

        }

        return msg;
    }

    

    

}
