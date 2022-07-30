package �߳�;

/**
 * 1����������:����Դ����һ��ʱ��ֻ��һ���߳�ռ�á�
 * 2�������뱣������:һ��������������Դ������ʱ�����ѻ�õ���Դ���ֲ��š�
 * 3������������:�߳��ѻ�õ���Դ��ĩʹ����֮ǰ���ܱ������߳�ǿ�а��ᣬֻ���Լ�ʹ����Ϻ���ͷ���Դ��
 * 4��ѭ���ȴ�����:���ɽ���֮���γɡ���ͷβ��ӵ�ѭ���ȴ���Դ��ϵ��
 * */

public class DeadLockDemo {

    private static Object resource1 = new Object();//��Դ 1

    private static Object resource2 = new Object();//��Դ 2

    public static void main(String[] args) {

        new Thread(() -> {

        synchronized (resource1) {

            System.out.println(Thread.currentThread() + "get resource1");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread() + "waiting get resource2");

            synchronized (resource2) {

                System.out.println(Thread.currentThread() + "get resource2");
            }
        }
        }, "�߳� 1").start();

        new Thread(() -> {

        synchronized (resource2) {

            System.out.println(Thread.currentThread() + "get resource2");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread() + "waiting get resource1");

            synchronized (resource1) {

                System.out.println(Thread.currentThread() + "get resource1");
            }
        }
        }, "�߳� 2").start();
    }
}

