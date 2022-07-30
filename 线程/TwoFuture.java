package �߳�;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TwoFuture {

    public static void main(String[] args) {
        CallableTask task=new CallableTask();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(task);
        new Thread(integerFutureTask).start();

        try {
            System.out.println("task���н����"+integerFutureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }



    static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("���߳����ڼ���");
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
