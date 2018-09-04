package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int [] numberList =  new int [1000];
    public static void main(String[] args) {
        addNumber();
        printNumber();
        sortNumber();
        printLine();
        printNumber();
        countUniqueNumber();
    }
    private static void addNumber(){
        for(int i = 0; i<numberList.length; i++){
            Random rand = new Random();
            numberList [i] = rand.nextInt(1000) + 1;
        }
    }
    private static void printNumber(){
        for(int i : numberList){
            System.out.println(i);
        }
    }
    private static void sortNumber(){
        for(int i = (numberList.length - 1); i>=0; i--){
            for(int j = 1; j<= i; j++){
                if(numberList[j-1] > numberList[j]){
                    int temp = numberList[j-1];
                    numberList[j-1] = numberList[j];
                    numberList[j] = temp;
                }
            }
        }
    }
    private static void printLine(){
        System.out.println("=========================");
    }
    private static void countUniqueNumber(){
        int count = 0;
        for(int i = 0; i<numberList.length - 1; i++){
            if(i+1 <= numberList.length - 1) {
                if (numberList[i] != numberList[i+1]) {
                    count++;
                } else{
                    do {
                        i += 1;
                    } while(numberList[i] == numberList[i+1] &&
                            i<numberList.length-2);
                }
            }
        }
        System.out.println("Unique number = " + count);
    }
    private static void mySort(){
        for(){

        }
    }
}
