package com.wujian.设计模式.原型模式;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Test1 {

    public static void main(String[] args) {
        Sheep s1 = new Sheep("小白",1);
        Sheep s2 = (Sheep) s1.clone();
        Sheep s3 = (Sheep) s1.clone();
        Sheep s4 = (Sheep) s1.clone();
        System.out.println(s1 == s2);
    }
}


@Data
@AllArgsConstructor
class Sheep implements Cloneable{

    private String name;
    private Integer age;

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
}
