import java.util.concurrent.*;


public class Test {

        public static void main(String[] args) {

            WorkQueue wq = new WorkQueue(5);

           Executor e = new DirectExecutor();
            for (int i = 0; i < 10; i++) {

                Runnable task = new Task(i);
                wq.ex(task);
                e.execute(task);

            }

        }
}

