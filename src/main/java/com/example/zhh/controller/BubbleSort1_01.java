package com.example.zhh.controller;

import java.util.Arrays;
public class BubbleSort1_01 {
    public static void main(String[] args) {
        int a[]={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
/*        int count=0;
        for (int i = 0; i < a.length-1; i++) {
            boolean flag=true;
            for (int j = 0; j < a.length-1-i; j++) {
                if (a[j]>a[j+1]) {
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    flag=false;
                }
                count++;
            }
            if (flag) {
                break;
            }
        }*/

        BubbleSort1_01.mp1(a);
        System.out.println(Arrays.toString(a));// [2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50]
        //System.out.println("一共比较了："+count+"次");//一共比较了：95次
    }


    public static void BubbleSort(int a[]){

        for(int i =0;i<a.length-1;i++){
            for(int j = 0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }

        }

    }





    public static void BubbleSort01_1(int a[]){
        for(int i = 0;i<a.length-1;i++){
            for(int j = 0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }















    public static void bubbles(int a[]){
        for (int i = 0;i<a.length-1;i++){
            for(int j = 0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }











    public static void maopao(int []a){
        for(int i = 0;i<a.length-1;i++){
            for(int j = 0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }





















    public static void mp1(int [] a){
        for(int i = 0;i<a.length-1;i++){
            for(int j = 0;j<a.length-1-i;j++){
                if(a[j+1]<a[j]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }


    }







}
