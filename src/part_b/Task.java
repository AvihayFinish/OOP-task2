package part_b;

import java.util.concurrent.Callable;

public class Task<T> implements Callable<T>, Comparable<Task<T>> {
    private final TaskType taskType;
    private final Callable<T> operation;

    private Task(TaskType taskType, Callable<T> operation) {
        this.taskType = taskType;
        this.operation = operation;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public T call() throws Exception {
        try {
            return operation.call();
        }
        catch (Exception e)
        {
            throw new Exception("error");
        }

    }

    public int compareTo(Task other) {
        return Integer.compare(this.taskType.getPriorityValue(), other.taskType.getPriorityValue());
    }

    public static <T> Task<T> createTask(Callable <T> operation) {
        return new Task<>(TaskType.OTHER, operation);
    }

    public  static <T> Task<T> createTask( Callable<T> operation,TaskType type) {
        return new Task<>(type, operation);
    }

    public int getPriority() {
        return taskType.getPriorityValue();
    }
}



