package com.wujian.设计模式.单一职责原则;

public class Test2 {

    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("汽车");
        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("轮船");
        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }



}


class RoadVehicle{

    public void run(String vehicle){
        System.out.println(vehicle+"在公路上运行");
    }
}

class WaterVehicle{

    public void run(String vehicle){
        System.out.println(vehicle+"在水上运行");
    }
}

class AirVehicle{

    public void run(String vehicle){
        System.out.println(vehicle+"在空中运行");
    }
}
