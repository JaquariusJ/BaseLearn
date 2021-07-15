package com.wujian.设计模式.原型模式.浅拷贝;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Test1 {

    public static void main(String[] args) {
        Sheep s1 = new Sheep();
        s1.setName("小白");
        s1.setAge(2);
        s1.setFirend(new Sheep("小红",2,null));
        Sheep s2 = (Sheep) s1.clone();
        Sheep s3 = (Sheep) s1.clone();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("修改s1.friend小红的名字");
        s1.getFirend().setName("小明");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }


}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Sheep implements Cloneable{
    private String name;
    private int age;
    private Sheep firend;

    @Override
    protected Object clone() {
        Object sheep = null;
        try {
            sheep = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sheep;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", firend=" + firend.hashCode() +
                '}';
    }
}
