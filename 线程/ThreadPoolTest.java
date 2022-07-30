package 线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    static class Task implements Runnable{

        @Override
        public void run() {
            System.out.println("当前线程名字："+Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10000; i++) {
            executorService.submit(new Task());
        }

        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            service.execute(new Task() {
            });
        }

        ScheduledExecutorService Service = Executors.newScheduledThreadPool(10);

        Service.schedule(new Task(), 10, TimeUnit.SECONDS);

        Service.scheduleAtFixedRate(new Task(), 10, 10, TimeUnit.SECONDS);

        Service.scheduleWithFixedDelay(new Task(), 10, 10, TimeUnit.SECONDS);

        System.out.println(Thread.currentThread().getName());
    }
}
