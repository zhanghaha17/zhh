package com.example.zhh.controller;

import java.util.Arrays;

public class InsertSort_01 {
    public static void main(String[] args) {
        int a[]={3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
/*        for(int i = 0;i<a.length;i++){
            int insertValue = a[i];
            int insertIndex = i-1;
            while (insertIndex>=0&&insertValue<a[insertIndex]){
                a[insertIndex+1]=a[insertIndex];
                insertIndex--;
            }
            a[insertIndex+1] = insertValue;
        }*/
        cr1(a);
        System.out.println(Arrays.toString(a));
    }


    public static void  insertSort(int a[]){

        for(int i = 0;i<a.length;i++){
            int isValue = a[i];
            int isIndex = i - 1;
            while (isIndex>=0&&isValue<a[isIndex]){
                a[isIndex+1] = a[isIndex];
                isIndex--;
            }
            a[isIndex+1] = isValue;
        }

    }






    public static void insertSort_01(int a[]){
        for(int i = 0;i<a.length;i++){
            int isValue = a[i];
            int isIndex = i-1;
            while(isIndex>=0&&isValue<a[isIndex]){
                a[isIndex+1] = a[isIndex];
                isIndex--;
            }
            a[isIndex+1] = isValue;
        }
    }




















    public static void insert(int []a){
        for(int i = 0;i<a.length;i++){
            int isValue = a[i];
            int isIndex = i-1;
            while (isIndex>=0&&a[isIndex]>isValue){
                a[isIndex+1] = a[isIndex];
                isIndex--;
            }
            a[isIndex+1] = isValue;
        }
    }



















    public static void charu(int a[]){
        for(int i = 0;i<a.length;i++){
            int isIndex = i-1;
            int isValue = a[i];
            while (isIndex>=0&&isValue<a[isIndex]){
                a[isIndex+1] = a[isIndex];
                isIndex--;
            }
            a[isIndex+1] = isValue;
        }
    }


























    public static void cr1(int [] a){
        for(int i = 0;i<a.length;i++){
            int inIndex = i-1;
            int inValue = a[i];
            while(inIndex>=0&&inValue<a[inIndex]){
                a[inIndex+1] = a[inIndex];
                inIndex--;
            }
            a[inIndex+1] = inValue;
        }
    }


}
