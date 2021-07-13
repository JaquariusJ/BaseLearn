package com.wujian.设计模式.依赖倒转原则.样例2;

public class Test1 {
    public static void main(String[] args) {
        Message email = new Email();
        Message weChat = new WeChat();
        Person person = new Person();
        person.getInfo(email);
        person.getInfo(weChat);

    }
}

interface Message{

    String printInfo();
}

class Email implements Message {

    public String printInfo() {
        return "电子邮件：hello ";
    }
}

class WeChat implements Message{
    public String printInfo() {
        return "微信：hello ";
    }
}

class Person {


    public void getInfo(Message message) {
        System.out.println(message.printInfo());
    }
}

