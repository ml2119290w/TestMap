package teat;

import org.junit.Test;

//双重检查
class Singleton{
    private Singleton(){
        System.out.println("我是单例模式的双重检查");
    }
    private static Singleton singleton;
    public static Singleton getInstance(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
//静态内部类
class Singleton2{
    private Singleton2(){
        System.out.println("我是单例模式的静态内部类");
    }
    private static class SingletonInstance{
        private static final Singleton2 INSTANCE = new Singleton2();
    }
    public static Singleton2 getInstance2(){
        return SingletonInstance.INSTANCE;
    }
}
//枚举  jdk1.5之后添加的
enum Singleton3{
    INSTANCE;
    public void whateverMethod(){
        System.out.println("我是单例模式的枚举");
    }
}
//懒汉式(线程安全,同步代码块)
class Singleton4{
    private Singleton4(){
        System.out.println("我是单例模式的懒汉式锁代码块");
    }
    private static Singleton4 singleton;
    public static Singleton4 getInstance4(){
        if (singleton==null){
            synchronized (Singleton4.class){
                singleton = new Singleton4();
            }
        }
        return singleton;
    }
}
//懒汉式(线程安全,同步方法)
class Singleton5{
    private Singleton5(){
        System.out.println("我是单例模式的懒汉式方法锁");
    }
    private static Singleton5 singleton;
    public static synchronized Singleton5 getInstance5(){
         if (singleton==null){
             singleton = new Singleton5();
         }
         return singleton;
    }
}
//懒汉式(线程不安全)
class Singleton6{
    private Singleton6(){
        System.out.println("我是单例模式的线程不安全懒汉式");
    }
    private static Singleton6 singleton;
    public static Singleton6 getInstance6(){
        if (singleton==null){
            singleton = new Singleton6();
        }
        return singleton;
    }
}
//饿汉式(静态代码块)
class Singleton7{
    private Singleton7(){
        System.out.println("我是单例模式的懒汉式静态代码块");
    }
    private static Singleton7 singleton;
    static {
        singleton = new Singleton7();
    }
    public static Singleton7 getInstance7(){
        return singleton;
    }
}
//饿汉式(静态常量)
class Singleton8{
    private Singleton8(){
        System.out.println("我是单例模式的饿汉式");
    }
    private static Singleton8 singleton = new Singleton8();
    public static Singleton8 getInstance8(){
        return singleton;
    }
}
public class SingletonTest {

    @Test
    public void Test(){
        class T implements Runnable{
            @Override
            public void run() {
                Singleton.getInstance();
                Singleton2.getInstance2();
                Singleton4.getInstance4();
                Singleton5.getInstance5();
                Singleton6.getInstance6();
                Singleton7.getInstance7();
                Singleton8.getInstance8();
            }
        }
        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        Thread t3 = new Thread(new T());
        Thread t4 = new Thread(new T());
        Thread t5 = new Thread(new T());
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
