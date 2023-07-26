package com.example.zhh.controller;

import java.util.Arrays;

public class ChooseSort_01 {

    public static void main(String[] args) {
        int a[]={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
/*        for(int i = 0;i<a.length-1;i++){
            int index = i;//最小元素的下标
            for(int j = i+1;j<a.length;j++){
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }*/
        xz1(a);
        System.out.println(Arrays.toString(a));
    }


    public static void chooseSort(int a[]){
        for(int i = 0;i<a.length-1;i++){
            int index = i;
            for(int j = i+1;j<a.length;j++){
                if(a[j]<a[index]){
                    index = j;
                }
            }
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    }




    public static void chooseSort_01(int a[]){
        for(int i = 0;i<a.length-1;i++){
            int index = i;
            for(int j = i+1;j<a.length;j++){
                if(a[j]<a[index])
                    index = j;
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;

        }
    }
















    public  static void choose(int []a){

        for(int i =0;i<a.length-1;i++){
            int index = i;
            for (int j = i+1;j<a.length;j++){
                if(a[j]<a[index]){
                    index = j;
                }
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }

    }



















    public static void xuanze(int []a){
        for(int i = 0;i<a.length-1;i++){
            int index = i;
            for(int j = i+1;j<a.length;j++){
                if(a[j]<a[i])
                    index = j;
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
    }




















    public static void xz1(int [] a){
        for(int i =0;i<a.length-1;i++){
            int index = i;
            for(int j = i+1;j<a.length;j++){
                if(a[j]<a[index]){
                    index = j;
                }
            }
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
    }







}
