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
        prioritizedTasks = new PriorityQueue<>(new PriorityComparator());
        nonPrioritizedTasks = new PriorityQueue<>(new PriorityComparator());
        actionStack = new Stack<>();
        testCases();

    }

    
    public void sortTasks() {
        Task[] taskArray = tasks.values().toArray(new Task[0]);
        int n = taskArray.length;
    
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(taskArray, n, i);
    
        for (int i = n - 1; i >= 0; i--) {

            Task temp = taskArray[0];
            taskArray[0] = taskArray[i];
            taskArray[i] = temp;
    
            heapify(taskArray, i, 0);
        }

        tasks.clear();
        for (int i = 0; i < taskArray.length; i++) {
            tasks.put(i + 1, taskArray[i]);
        }
    }
    
    private void heapify(Task[] arr, int n, int i) {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
    

        if (l < n && arr[l].compareTo(arr[largest]) > 0)
            largest = l;
    
        if (r < n && arr[r].compareTo(arr[largest]) > 0)
            largest = r;
    

        if (largest != i) {
            Task swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
    
            heapify(arr, n, largest);
        }
    }



    public void testCases(){

        Task newTask = new Task("Additions and Subtractions","Everything you need to know about addition and subtraction","17/10/2023", Priority.PRIORITY);
        tasks.put(1, newTask);
        Task newTask1 = new Task("Shoes","Buy costume shoes","30/10/2023", Priority.PRIORITY);
        tasks.put(2, newTask1);
    }

    public boolean addTaskReminder(int id, String title, String description, int day, int month, int year, int priority) {


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

        return true;


    }

    public boolean verifyId(int id){

        if (tasks.containsKey(id)){

            return true;

        }

        return false;

    }

    public void addTaskReminder(int id, Task task) {
        tasks.put(id , task);
        actionStack.push(new Action("Add task", task, id));
    }


    public boolean modifyTaskReminder(int id, int cambio, int day, int month, int year, String modification) {
        
        if (tasks.containsKey(id)) {
            Task task = tasks.get(id);
            Task originalTask = new Task(task.getTitle(), task.getDescription(), task.getDatelimit(), task.getPriority());
            switch(cambio){

                case 1:
                    task.setTitle(modification);
                    actionStack.push(new Action("Modify task", originalTask, id));
                    return true;
                    
                case 2:
                    task.setDescription(modification);
                    actionStack.push(new Action("Modify task", originalTask, id));
                    return true;
                case 3:

                    Calendar fechaProvisional = new GregorianCalendar(day, month-1, year);

                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                    
                    String fechaChange = formatoFecha.format(fechaProvisional.getTime());

                    task.setDatelimit(fechaChange);
                    actionStack.push(new Action("Modify task", originalTask, id));
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
                    actionStack.push(new Action("Modify task", originalTask, id));
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
            Task originalTask = new Task(task.getTitle(), task.getDescription(), task.getDatelimit(), task.getPriority());
            
            tasks.remove(id);
    
            if (task.getPriority() == Priority.PRIORITY) {
                prioritizedTasks.remove(task);
            } else {
                nonPrioritizedTasks.remove(task);
            }

            actionStack.push(new Action("Delete task", originalTask, id));
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
                   "║ -> Title: " + task.getTitle() + "\n" +
                   "║\n" +
                   "║ -> Description: " + task.getDescription() + "\n" +
                   "║\n" +
                   "║ -> Deadline: " + task.getDatelimit() + "\n" +
                   "║\n" +
                   "║ -> Priority: " + task.getPriority() + "\n" +
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
    
            if (actionType.equals("Add task")) {
                tasks.remove(id);

                if (taskDetails.getPriority() == Priority.PRIORITY) {
                    prioritizedTasks.remove(taskDetails);
                } else {
                    nonPrioritizedTasks.remove(taskDetails);
                }

                return true;
            } else if (actionType.equals("Modify task")) {
                tasks.put(id, taskDetails);
                return true;
            } else if (actionType.equals("Delete task")) {
                tasks.put(id, taskDetails);

                if (taskDetails.getPriority() == Priority.PRIORITY) {
                    prioritizedTasks.add(taskDetails);
                } else {
                    nonPrioritizedTasks.add(taskDetails);
                }
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
