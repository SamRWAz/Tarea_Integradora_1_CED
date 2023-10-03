package model;

import java.util.Hashtable;


public class TaskManager {
    private Hashtable<Integer, Task> tasks;

    public TaskManager() {
        tasks = new Hashtable<>();
    }

    public void addTaskReminder(Task task) {
        tasks.put(task.getId(), task);
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

    public void showListTaskReminder() {
        for (Task task : tasks.values()) {
            System.out.println("ID: " + task.getId());
            System.out.println("Título: " + task.getTitle());
            System.out.println("Descripción: " + task.getDescription());
            System.out.println("Fecha Límite: " + task.getDatelimit());
            System.out.println("Prioridad: " + task.getPriority());
            System.out.println("-------------------------");
        }
    }

}
