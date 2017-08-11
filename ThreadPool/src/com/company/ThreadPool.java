package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;

class ThreadPool implements Executor {
    private int PoolSize;

    //创建任务列表
    public static List<Runnable> tasks = new LinkedList<>();

    //创建工作线程列表
    public static final List<Thread> works = new ArrayList<>();

    public ThreadPool(int PoolSize) {
        this.PoolSize = PoolSize;
    }

    public synchronized void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }

        if (PoolSize >= works.size()) {
            MyThread work = new MyThread();
            Thread t = new Thread(work);
            works.add(t);
            t.start();
        } else {
            tasks.add(command);
            //super.notifyAll();
        }
    }
}


