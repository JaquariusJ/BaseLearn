package com.wujian.设计模式.单一职责原则;

public class Test3 {


    public static void main(String[] args) {
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.airRun("飞机");
        vehicle2.waterRun("轮船");
        vehicle2.roadRun("汽车");
    }
}


class Vehicle2{

    public void roadRun(String roadVehicle){
        System.out.println(roadVehicle+"在公路运行");
    }
    public void waterRun(String waterVehicle){
        System.out.println(waterVehicle+"在水中运行");
    }

    public void airRun(String airVehicle){
        System.out.println(airVehicle+"在空中运行");
    }


}