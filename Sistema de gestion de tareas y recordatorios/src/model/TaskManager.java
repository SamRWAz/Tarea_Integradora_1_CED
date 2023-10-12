package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Stack;


public class TaskManager {

    private Hashtable<Integer, Task> tasks;
    private PriorityQueue<Task> prioritizedTasks;
    private PriorityQueue<Task> nonPrioritizedTasks;
    private Stack<Action> actionStack;

    public TaskManager() {
        tasks = new Hashtable<>();
        prioritizedTasks = new PriorityQueue<>();
        nonPrioritizedTasks = new PriorityQueue<>();
        actionStack = new Stack<>();
        testCases();

    }

    public void testCases(){

        Task newTask = new Task("Sumas y Restas","Todo lo que necesitas saber sobre las sumas y restas","10/12/2023", Priority.PRIORITY);
        tasks.put(1, newTask);

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


        Task newTask = new Task(title, description, fechaChange, priority1);

        addTaskReminder(id, newTask);

        if (priority == 1) {
            prioritizedTasks.add(newTask);
        } else {
            nonPrioritizedTasks.add(newTask);
        }


    }

    public void addTaskReminder(int id, Task task) {
        tasks.put(id , task);
        actionStack.push(new Action("Agregar tarea", task, id));
    }


    public boolean modifyTaskReminder(int id, int cambio, int day, int month, int year, String modification) {
        
        if (tasks.containsKey(id)) {
            Task task = tasks.get(id);
            Task originalTask = new Task(task.getTitle(), task.getDescription(), task.getDatelimit(), task.getPriority());
            switch(cambio){

                case 1:
                    task.setTitle(modification);
                    actionStack.push(new Action("Modificar tarea", originalTask, id));
                    return true;
                    
                case 2:
                    task.setDescription(modification);
                    actionStack.push(new Action("Modificar tarea", originalTask, id));
                    return true;
                case 3:
                    Calendar fechaProvisional = new GregorianCalendar(day, month-1, year);
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");           
                    String fechaChange = formatoFecha.format(fechaProvisional.getTime());

                    task.setDatelimit(fechaChange);
                    actionStack.push(new Action("Modificar tarea", originalTask, id));
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
                    actionStack.push(new Action("Modificar tarea", originalTask, id));
                    return true;
            }
        } else {

           return false;

        }

        return false;
    }


    public void deleteTaskReminder(int id) {

        if (tasks.containsKey(id)) {
            Task task = tasks.get(id);
            tasks.remove(id);
    
            if (task.getPriority() == Priority.PRIORITY) {
                prioritizedTasks.remove(task);
            } else {
                nonPrioritizedTasks.remove(task);
            }
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

    public boolean undoLastAction() {

        if (!actionStack.isEmpty()) {

            Action lastAction = actionStack.pop();
            String actionType = lastAction.getActionType();
            Task taskDetails = lastAction.getTaskDetails();
            int id = lastAction.getId();
    
            if (actionType.equals("Agregar tarea")) {
                tasks.remove(id);
                return true;
            } else if (actionType.equals("Modificar tarea")) {
                tasks.put(id, taskDetails);
                return true;
            } else if (actionType.equals("Eliminar tarea")) {
                tasks.put(id, taskDetails);
                return true;
            }
        }
        return false; 
    }

    public boolean stackEmpty(){

        if(actionStack.isEmpty())
            return true;
        
        return false;

    }
    

    

}
