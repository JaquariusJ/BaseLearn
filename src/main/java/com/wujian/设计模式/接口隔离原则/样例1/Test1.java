package com.wujian.设计模式.接口隔离原则.样例1;

public class Test1{
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.use1(b);
        a.use2(b);
        a.use3(b);

        C c = new C();
        D d = new D();
        c.use1(d);
        c.use4(d);
        c.use5(d);
    }
}


interface interface1 {

    void method1();
    void method2();
    void method3();
    void method4();
    void method5();

}


class B implements interface1{

    public void method1() {
        System.out.println("B 调用了 method1");
    }

    public void method2() {
        System.out.println("B 调用了 method2");
    }

    public void method3() {
        System.out.println("B 调用了 method3");
    }

    public void method4() {
        System.out.println("B 调用了 method4");
    }

    public void method5() {
        System.out.println("B 调用了 method5");
    }
}

class D implements interface1{

    public void method1() {
        System.out.println("D 调用了 method1");
    }

    public void method2() {
        System.out.println("D 调用了 method2");
    }

    public void method3() {
        System.out.println("D 调用了 method3");
    }

    public void method4() {
        System.out.println("D 调用了 method4");
    }

    public void method5() {
        System.out.println("D 调用了 method5");
    }
}

class A{

    public void use1(interface1 interface1){
        interface1.method1();
    }

    public void use2(interface1 interface1){
        interface1.method2();
    }

    public void use3(interface1 interface1){
        interface1.method3();
    }
}




class C{
    public void use1(interface1 interface1){
        interface1.method1();
    }

    public void use5(interface1 interface1){
        interface1.method5();
    }

    public void use4(interface1 interface1){
        interface1.method4();
    }
}


