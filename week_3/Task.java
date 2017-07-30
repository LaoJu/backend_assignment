
public class Task implements Runnable{
    private int tasknum;
    public Task(int num)
    {
        this.tasknum = num;
    }

    @Override
    public synchronized void run()
    {
        System.out.println("正在执行task "+tasknum);

        try
        {
            Thread.currentThread().sleep(200);
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("task "+tasknum+"执行完毕");
    }
}
