package �߳�;

public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public synchronized static Singleton getUniqueInstance() {

        // �ж϶����Ƿ�ʵ��������ûʵ�����ٽ����������

        if (uniqueInstance == null) {

            // ��������

            synchronized (Singleton.class) {

                if (uniqueInstance == null) {

                    uniqueInstance = new Singleton();
                }
            }
        }

        return uniqueInstance;
    }
}