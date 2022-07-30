package �߳�;

public class ThreadLocalDemo07 {

    public static void main(String[] args) {
        new Service1().service1();
    }
}

class Service1 {
    public void service1() {
        User user = new User("С��ͬѧ");
        UserContextHolder.holder.set(user);
        new Service2().service2();
    }
}

class Service2 {
    public void service2() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service2�õ��û�����" + user.name);
        new Service3().service3();
    }
}

class Service3 {
    public void service3() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3�õ��û�����" + user.name);
        UserContextHolder.holder.remove();
    }
}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();

}

class User {
    String name;
    public User(String n) {
        this.name = n;
    }
}
