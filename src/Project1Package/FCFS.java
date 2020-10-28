package Project1Package; /**
 * FCFS scheduling algorithm.
 */
 
import java.util.*;

public class FCFS implements Algorithm
{
    private List<Task> queue;
    private Task currentTask;

    private int tasksRun;

    public FCFS(List<Task> queue) {
        this.queue = queue;

        tasksRun = queue.size();
    }

    public void schedule() {
        System.out.println("First-Come, First-Served Scheduling \n");

        while (!queue.isEmpty()) {
            currentTask = pickNextTask();
            
            CPU.run(currentTask, currentTask.getBurst());

            System.out.println("Task " + currentTask.getName() + " finished at time "+CPU.getCurrentTime());

            // remove the task
            queue.remove(currentTask);
        }
    }

    public Task pickNextTask() {
        return queue.get(0);
    }
}
