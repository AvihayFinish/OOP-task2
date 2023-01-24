package part_b;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;
import static java.lang.ref.Reference.reachabilityFence;

class CustomExecutor {
    private final ThreadPoolExecutor executor;
    private PriorityBlockingQueue workerQueue = new PriorityBlockingQueue<Task>();
    private int arr [] = {0,0,0,0};

    public CustomExecutor() {
        int corePoolSize = Runtime.getRuntime().availableProcessors() / 2;
        int maximumPoolSize = Runtime.getRuntime().availableProcessors() - 1;
        long keepAliveTime = 300;
        TimeUnit unit = TimeUnit.MILLISECONDS;
        executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,workerQueue);
    }

    public <T> Future<T> submit(Task  <T> task) {
        if (executor.getQueue().isEmpty()) {
            arr[1] = 0;
            arr[2] = 0;
            arr[3] = 0;
        }
        arr[task.getPriority()]++;
        return executor.submit(task);
    }
    public <T> Future<T> submit(Callable<T> operation) {
        return  submit(Task.createTask(operation));
    }

    public <T> Future<T> submit(Callable<T> operation,TaskType type) {
        return submit(Task.createTask(operation,type));
    }

    public int getCurrentMax() {
        int size = executor.getQueue().size();
        int counterSubmit = arr[1] + arr[2] + arr[3];
        if (size > counterSubmit - arr[1]){
            return 1;
        }
        else if (size > counterSubmit - (arr[1] + arr[2])) {
            return 2;
        }
        else if (size > 0) {
            return 3;
        }
        return -1;
    }

    public void gracefullyTerminate()
    {
        while(true)
        {
            if(executor.getQueue().isEmpty())
            {
                break;
            }
        }
        executor.shutdown();
    }

}
