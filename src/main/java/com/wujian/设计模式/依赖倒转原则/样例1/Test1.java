package com.wujian.设计模式.依赖倒转原则.样例1;

public class Test1 {

    public static void main(String[] args) {
        Person person = new Person();
        person.getInfo(new Email());
    }

}


class Email {

    public String printInfo() {
        return "电子邮件：hello ";
    }
}

class Person {


    public void getInfo(Email email) {
        System.out.println(email.printInfo());
    }
}
