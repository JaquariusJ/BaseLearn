package com.wujian.designpattern.decorator;

public class ConcreteDecorator1 extends Decorator {

    public ConcreteDecorator1(Component component) {
        super(component);
    }

    public void operation() {
        component.operation();
        System.out.println("加上红色");
    }
}
