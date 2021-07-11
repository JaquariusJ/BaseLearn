package com.wujian.designpattern.decorator;

public class Main {

    public static void main(String[] args) {

        Component component = new ConcreteComponent();
        component.operation();
        System.out.println("----------------");
        Component component1 = new ConcreteDecorator1(new ConcreteComponent());
        component1.operation();
        System.out.println("----------------");
        Component component2 = new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent()));
        component2.operation();

    }
}
