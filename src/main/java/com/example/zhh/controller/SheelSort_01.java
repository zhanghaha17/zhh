package com.example.zhh.controller;

import java.util.Arrays;

public class SheelSort_01 {

    public static void main(String[] args) {
        int a[]={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
/*        for(int gap = a.length/2;gap>0;gap/=2){

            for(int i =0;i<gap;i++){

                for(int j = i;j<gap;j+=gap){
                    if(a[j]>a[j+gap]){
                        int temp = a[j];
                        a[j] = a[j+gap];
                        a[j+gap] = temp;
                    }
                }



            }*/

/*            for (int i = gap; i < a.length; i++) {
                //遍历各组的元素
                for (int j = i - gap; j>=0; j=j-gap) {
                    //交换元素
                    if (a[j]>a[j+gap]) {
                        int temp=a[j];
                        a[j]=a[j+gap];
                        a[j+gap]=temp;

                    }
                }
            }


        }*/
        xe1(a);
        System.out.println(Arrays.toString(a));
    }



    public static void SheelSort_01(int a[]){
        for(int gap = a.length/2;gap>0;gap/=2){
            for(int i = gap;i<a.length;i++){
                for(int j = i-gap;j>=0;j=j-gap){
                    if(a[j]>a[j+gap]){
                        int temp = a[j];
                        a[j] = a[j+gap];
                        a[j+gap] = temp;
                    }
                }
            }
        }
    }
















    public static void shell(int a[]){
        for (int gap = a.length/2;gap>0;gap/=2){
            for(int i = gap;i<a.length;i++){
                for (int j = i-gap;j>=0;j=j-gap){
                    if(a[j]>a[j+gap]){
                        int temp = a[j+gap];
                        a[j+gap] = a[j];
                        a[j] = temp;
                    }
                }
            }
        }
    }





















    public static void xier(int []a){
        for(int gap = a.length/2;gap>0;gap/=2){
            for(int i = gap;i<a.length;i++){
                for(int j = i-gap;j>=0;j=j-gap){
                    if(a[j+gap]<a[j]){
                        int temp = a[j+gap];
                        a[j+gap] = a[j];
                        a[j] = temp;
                    }
                }
            }
        }
    }



















    public static void xe1(int a[]){
        for(int gap = a.length/2; gap>0;gap/=2){
            for(int i = gap;i<a.length;i++){
                for(int j= i-gap;j>=0;j=j-gap){
                    if(a[j+gap]<a[j]){
                        int temp = a[j+gap];
                        a[j+gap] = a[j];
                        a[j] = temp;
                    }
                }
            }
        }
    }









}
