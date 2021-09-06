package Thread;

public class Singleton {

    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public synchronized static Singleton getUniqueInstance() {

        // 判断对象是否实例化过，没实例化再进入加锁代码

        if (uniqueInstance == null) {

            // 类对象加锁

            synchronized (Singleton.class) {

                if (uniqueInstance == null) {

                    uniqueInstance = new Singleton();
                }
            }
        }

        return uniqueInstance;
    }
}