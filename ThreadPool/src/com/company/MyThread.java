package com.company;
class MyThread extends Thread{

    @Override
    public void run() {
        Runnable task=null;
        while(true){
            synchronized (ThreadPool.tasks) {//tasks锁
                while(ThreadPool.tasks.isEmpty()){//没有任务则等待
                    try {
                        ThreadPool.tasks.wait();
                    } catch (InterruptedException e) {

                        return;
                    }
                }
                task=ThreadPool.tasks.remove(0);//取出任务

            }
            task.run();//执行任务
        }
    }
}