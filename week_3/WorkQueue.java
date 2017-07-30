
import java.util.*;


public class WorkQueue  {
    private final  int nThreads;            //线程数目
    private final PoolWorker[] threads;      //建立数组存放线程
    private final LinkedList queue;

    public WorkQueue(int nThreads) {
        this.nThreads = nThreads;
         queue = new LinkedList();
        threads = new PoolWorker[nThreads];

        for(int i = 0;i<nThreads;i++)
        {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void ex(Runnable r)
    {
        synchronized (queue)
        {

            queue.addLast(r);
            queue.notify();
        }
    }

    private class PoolWorker extends Thread {
        public void run() {
            Runnable r;
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                r = (Runnable) queue.removeFirst();
            }
        }
    }
}

//工作列表这块不太懂，所以是去百度了，看了别人的代码，又敲了一遍的。。。
