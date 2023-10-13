package model;

import java.util.Comparator;

public class PriorityComparator implements Comparator<Task>{
    
        @Override
        public int compare(Task task1, Task task2) {
            return task1.getPriority().ordinal() - task2.getPriority().ordinal();
        }
}

