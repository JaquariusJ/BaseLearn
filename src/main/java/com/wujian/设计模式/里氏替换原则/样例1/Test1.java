package com.wujian.设计模式.里氏替换原则.样例1;

public class Test1 {

    public static void main(String[] args) {
        A a = new A();
        a.func1();
        B b = new B();
        b.func1();
    }
}

class A{
    public void func1(){
        System.out.println("方法一");
    }

    public void func2(){
        System.out.println("方法二");
    }
}

class B extends A{
    public void func1(){
        System.out.println("B方法一");
    }

}
