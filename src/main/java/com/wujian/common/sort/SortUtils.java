package com.wujian.common.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

public class SortUtils {

    public static void swap(int[]arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void EORSwap(int[] arr,int a,int b){
        if(a == b){
            //位置相同的话，交换有bug
            return;
        }
        arr[a] = arr[a]^arr[b]; //异或值
        arr[b] = arr[a]^arr[b]; //arr[a]
        arr[a] = arr[a]^arr[b]; //arr[b]
    }

    public static void printarr(int[]arr){
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void checkSort(Class clzz){
        try {
            boolean right = true;
            //随机生成数组
            Random random = new Random();
            for (int i = 0; i < 5000 ; i++) {
                //生成数组
                int arr_length = Math.abs(random.nextInt(100)+1);
                int[] arr= new int[arr_length];
                for (int j = 0; j <arr_length ; j++) {
                    arr[j] = random.nextInt(100);
                }
                int[] copyarr = new int[arr_length];
                System.arraycopy(arr,0,copyarr,0,arr_length);
                //反射调用sort方法
                Object o = clzz.newInstance();
                Method sort = clzz.getDeclaredMethod("sort",int[].class);
                sort.invoke(o,arr);
                //Array.sort
                Arrays.sort(copyarr);
                //对比数组
                for (int j = 0; j <arr_length; j++) {
                    if(arr[j] != copyarr[j]){
                        right = false;
                        System.out.println("原数组为:");
                        printarr(copyarr);
                        System.out.println("排序错误错误为：");
                        printarr(arr);
                        break;
                    }
                }
                if(!right){
                    break;
                }
            }
            System.out.println(right);




        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
