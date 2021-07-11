package com.wujian.designpattern.decorator;

public class ConcreteDecorator2 extends Decorator {


    public ConcreteDecorator2(Component component) {
        super(component);
    }

    public void operation() {
        component.operation();
        System.out.println("加上蓝色");
    }
}
