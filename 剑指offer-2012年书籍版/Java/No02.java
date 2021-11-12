/**
 * 设计一个类，我们只能生成该类的一个实例。
 */

public class No02 {

}

// 饿汉式  线程安全
class A {
    private static final A instance = new A();

    private A() {
    }

    public static A getInstance() {
        return instance;
    }
}

// 懒汉式 线程安全写法
class B {
    private static volatile B instance = null;

    private B() {
    }

    public static B getInstance() {
        if (instance == null) {
            synchronized (B.class) {
                if (instance == null)
                    instance = new B();
            }
        }
        return instance;
    }
}

// 静态内部类方式 线程安全
class C {
    private C() {

    }

    public static C getInstance() {
        return CHolder.INSTANCE;
    }

    private static class CHolder {
        private static final C INSTANCE = new C();
    }
}

