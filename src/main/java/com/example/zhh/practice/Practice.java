package com.example.zhh.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Practice {


    public static void main(String[] args) {

reverse();
//        int a[]={8,9,1,7,2,3,5,4,6,0,32,44,38,95,47,15,36,26,27,29,46,84,19,50,48};
//        //ShellSort(a);
//        InsertSort(a);
//        System.out.println(a.toString());
    }

    public static void ShellSort(int [] source){
        int count = 0;
        for(int i = source.length/2;i>0;i/=2){

            int j = 0;
            while ((j+i)<source.length){
                if(source[j]>source[j+i]){
                    int temp = source[j+i];
                    source[j+i] =  source[j];
                    source[j] = temp;
                    count++;
                }
                j++;
            }

        }
        System.out.println(Arrays.toString(source));
        System.out.println("xx"+count);

    }

    public static void InsertSort(int []a){
        int count = 0;
        for (int i = 0; i < a.length; i++) {  //长度不减1，是因为要留多一个位置方便插入数
            //定义待插入的数
            int insertValue=a[i];
            //找到待插入数的前一个数的下标
            int insertIndex=i-1;
            while (insertIndex>=0 && insertValue <a[insertIndex]) {//拿a[i]与a[i-1]的前面数组比较
                a[insertIndex+1]=a[insertIndex];
                insertIndex--;
                count++;
            }
            a[insertIndex+1]=insertValue;
        }
        System.out.println("yy"+count);

    }

    public static void reverse() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
/*        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }*/
        ArrayList<Integer> integers = new ArrayList<>();
        int length = in.nextInt();
        while (length>0) { // 注意 while 处理多个 case
            integers.add(Integer.valueOf(in.next()));
            length--;
/*            String[] s1 = s.split(" ");
            for(int i = s1.length-1;i>=0;i--){
                String aChar = s1[i];
                stringBuilder.append(aChar+" ");
            }
            System.out.println(stringBuilder.toString());*/
        }


        for(int i = 0;i<integers.size();i++){
            int count = 0;
            int temp = integers.get(i);
            for(int j = i+1;j<integers.size();j++){
                if(integers.get(j)>temp){
                    temp = integers.get(j);
                    count++;
                    continue;
                }
                if(integers.get(j)>integers.get(i)){
                    temp = integers.get(j);
                    count++;
                }

            }
            if(count==2){
                System.out.println(true);
                return;
            }

        }
        System.out.println(false);

    }
}





