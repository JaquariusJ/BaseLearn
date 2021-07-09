package com.wujian.common.tree;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class TreeUtils {

    private static Node root = new Node(1);

    static{
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }

    private static int[] pre_array = {1,2,4,5,3,6,7};
    private static int[] in_array = {4,2,5,1,6,3,7};
    private static int[] post_array = {4,5,2,6,7,3,1};


    public static void checkPre(Class clazz){
        checkForEach(clazz,"pre",pre_array);
    }

    public static void checkIn(Class clazz){
        checkForEach(clazz,"in",in_array);
    }

    public static void checkPost(Class clazz){
        checkForEach(clazz,"post",post_array);
    }

    public static void checkForEach(Class clazz,String methodName,int[] compareArray){
        boolean compare = true;
        try {
            Object o = clazz.newInstance();
            Method method = clazz.getDeclaredMethod(methodName,Node.class);
            List<Integer> each_array = (List<Integer>) method.invoke(o,root);
            if(each_array.size() != compareArray.length){
                System.out.println("length no same");
                compare = false;
            }
            for (int i = 0; i < compareArray.length; i++) {
                if(each_array.get(i) != compareArray[i]){
                    compare = false;
                    break;
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(compare);


    }
}
