package com.wujian.设计模式.迪米特法则.样例2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        SchoolManager schoolManager = new SchoolManager();
        CollectManager collectManager = new CollectManager();
        schoolManager.printAllEmployee(collectManager);
    }
}

@Data
class SchoolEmployee{
    private Integer id;
}

@Data
class CollectEmployee{
    private Integer id;
}

class SchoolManager{

    public List<SchoolEmployee> getAllSchoolEmployee(){
        List<SchoolEmployee> list = new ArrayList<SchoolEmployee>();
        for (int i = 0; i < 10 ; i++) {
            SchoolEmployee schoolEmployee = new SchoolEmployee();
            schoolEmployee.setId(i+1);
            list.add(schoolEmployee);
        }
        return list;
    };

    public void printAllEmployee(CollectManager collectManager){
        System.out.println("打印所有学校的员工--------");
        getAllSchoolEmployee().stream().forEach(n-> System.out.println(n.getId()));
        System.out.println("打印所有学员的员工--------");
        collectManager.printCollectEmployee();

    }
}

class CollectManager{

    public List<CollectEmployee> getAllCollectEmployee(){
        List<CollectEmployee> list = new ArrayList<CollectEmployee>();
        for (int i = 0; i < 5 ; i++) {
            CollectEmployee collectEmployee = new CollectEmployee();
            collectEmployee.setId(i+1);
            list.add(collectEmployee);
        }
        return list;
    };

    public void printCollectEmployee(){
        System.out.println("打印所有学员的员工--------");
        getAllCollectEmployee().stream().forEach(n-> System.out.println(n.getId()));

    }
}