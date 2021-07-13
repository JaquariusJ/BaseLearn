package com.wujian.设计模式.里氏替换原则.样例2;


public class Test1 {

    public static void main(String[] args) {
        A a = new A();
        a.func1();
        a.func2();
        B b = new B(a);
        b.func1();
        b.func2();
    }
}

interface i1{
    void func1();
}
class A implements i1{
    public void func1(){
        System.out.println("方法一");
    }

    public void func2(){
        System.out.println("方法二");
    }
}

class B implements i1{

    private A a;

    B(A a){
        this.a = a;
    }

    public void func1(){
        System.out.println("B的方法一");
    }

    public void func2(){
        a.func2();
    }
}