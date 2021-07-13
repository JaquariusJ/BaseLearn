package com.wujian.设计模式.开闭原则.样例1;

public class Test1 {

    public static void main(String[] args) {
        DrawPen drawPen = new DrawPen();
        drawPen.draw(new Clycle());
        drawPen.draw(new Square());
    }
}


class Shape{

    int code = 1;
}

class Clycle extends Shape{

    Clycle(){
        this.code = 2;
    }
}

class Square extends Shape{

    Square(){
        this.code = 3;
    }
}

class DrawPen{


    public void draw(Shape shape){
        if(shape.code == 2){
            drawClycle();
        }else if(shape.code ==3){
            drawSquare();
        }
    }

    public void drawClycle(){
        System.out.println("画圆");
    }

    public void drawSquare(){
        System.out.println("画方形");
    }
}