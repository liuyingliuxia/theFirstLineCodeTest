package com.zeasn.thefirstlinecode;

import android.util.Log;

/**
 * Author:Miracle.Lin
 * Date:2020/10/9
 * Email:miracle.lin@zeasn.com
 * Descripe:
 */
public class DemoA {
    private static final String TAG = "Demo";

    public void fun1(int n) {
        if ((n & 1) == 1) {
            //  Log.e(TAG, n + " 是 奇数");
            System.out.println(n + " 是 奇数");
        } else {
            // Log.e(TAG, n + " 是 偶数");
            System.out.println(n + " 是 偶数");
        }
    }


    public void swag(int x, int y) {
        System.out.println("x:" + x + "\n" + "y:" + y);
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("交换后：");
        System.out.println("x:" + x + "\n" + "y:" + y);
    }

    public void find(int[] arr) {
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            tmp = tmp ^ arr[i];
        }

        System.out.println("没有重复的数：" + tmp);

    }

    public void pow(int n, int m) {
        int sum = 1;
        int tmp = m;
        while (n != 0) {
            if ((n & 1) == 1) {
                sum *= tmp;
            }
            tmp *= tmp;
            n = n >> 1;
        }
        System.out.println(m+"的"+n+"次方:" + sum);
    }

    public void funN(int n ) {
        n|= n >>1;
        n|= n >>2;
        n|= n >>4;
        n|= n >>8;
        n|= n >>16;
        System.out.println("找出不大于N的最大的2的幂指数:"+ ((n+1) >> 1) );
    }
    public static void main(String[] args) {
        DemoA demo = new DemoA();
        // demo.fun1(111);

        //demo.swag(7 , 5);

       // int[] arry = {1, 2, 3, 4, 4, 1, 3, 1, 2};
        //demo.find(arry);
//        demo.pow(3,10);
        demo.funN(512321321);
    }
}
