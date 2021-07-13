package com.wujian.设计模式.开闭原则.样例2;

public class Test1 {

    public static void main(String[] args) {
        DrawPen drawPen = new DrawPen();
        Shape cycle = new Clycle();
        Shape square = new Square();
        Shape delta = new Delta();
        drawPen.draw(square);
        drawPen.draw(cycle);
        drawPen.draw(delta);
    }

}


abstract  class Shape{

    abstract void draw();
}


class Clycle extends Shape {


    @Override
    void draw() {
        System.out.println("画圆");
    }
}

class Square extends Shape {


    @Override
    void draw() {
        System.out.println("画方形");
    }
}

class Delta extends Shape{

    @Override
    void draw() {
        System.out.println("画三角形");
    }
}

class DrawPen{
    public void draw(Shape shape){
        shape.draw();
    }
}

