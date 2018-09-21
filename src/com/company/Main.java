package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static int [] numberList =  new int [1000];
    static double V0 = 5;
    static double Vf = 2;
    static final double DX = 215;
    static int[][] a = new int [0][9];
    static int[][] b = new int [0][2];
    static char[][] board = new char[3][3];
    public static void main(String[] args){
        //doSort();
        //System.out.println(rotateRight("cserfdas", 78));
        //System.out.println(arraySameSize(a, b));
        //System.out.println(convert(name));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int rit = ThreadLocalRandom.current().nextInt(0,3);
                char c;
                if(rit == 1) {
                    c = '0';
                } else if (rit == 2) {
                    c = 'X';
                } else {
                    c = '.';
                }
                board[i][j] = c;
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println(checkBoard(board));
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
        for(int i = 1; i<numberList.length-1; i++){
            if (numberList[i] < numberList[i-1]) {

            }
        }
    }
    private static void doMyProblem(){
        //System.out.println("Please enter V0");

        //System.out.println("Please enter Vf");
        double output = (Vf - V0)/((Vf * Vf - V0 * V0)/(2 * DX));
        System.out.println(output);

    }
    private static void doSort(){
        addNumber();
        printNumber();
        sortNumber();
        printLine();
        printNumber();
        countUniqueNumber();
    }
    public static String rotateRight(String input, int rotation) {
        char[] toChar = input.toCharArray();
        char[] resultArray = new char[toChar.length];
        int r = rotation;
        for (int i = 0; i < toChar.length; i++) {

                resultArray[(i + r) % toChar.length] = toChar[i];

        }
        return String.valueOf(resultArray);
    }
    static boolean arraySameSize(int[][] first, int[][] second) {
        boolean result = false;
        if (first != null && second != null) {
            if (first.length == second.length && first.length != 0) {
                for (int i = 0; i < first.length; i++) {
                    if (first[i].length != second[i].length) {
                        break;
                    } else {
                        if (i == first.length - 1) {
                            result = true;
                        }
                    }
                }
            } else if (first.length == second.length && first.length == 0) {
                result = true;
            }
        } else if (first == null && second == null) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
    static final String name = "Sun      ,    Yan";
    static String convert(String input) {
        String[] properInput = input.split(",");
        String output = "";
        for(int i = 0; i < properInput.length; i++){
            System.out.println(properInput[i]);
        }
        char[] lastNameStr = properInput[0].toCharArray();
        char[] firstNameStr = properInput[1].toCharArray();
        for(char c : firstNameStr){
            if(c != ' '){
                output += c;
            }
        }
        output += " ";
        for(char c : lastNameStr){
            if(c != ' '){
                output += c;
            }
        }
        return output;
    }
    static char checkBoard(char[][] input) {
        for (int i = 0; i < input.length; i++) {

            int count = 0;
            A: for (int j = 0; j < input[i].length; j++) {
                char firstCharH = input[i][0];
                char currentChar = input[i][j];
                if (currentChar == '.') {
                    break A;
                } else if (currentChar == firstCharH) {
                    count++;
                    System.out.println("is same" + currentChar + "," + firstCharH);
                    System.out.println(count);
                } else {
                    break A;
                }
                if (count == 3) {
                    System.out.println(count);
                    return firstCharH;
                }

            }
        }
        for (int j = 0; j < input[0].length; j++) {
            int count = 0;
            B: for (int i = 0; i < input.length; i++) {
                char firstCharV = input[0][j];
                char currentChar = input[i][j];
                if (currentChar == '.') {
                    break B;
                } else if (currentChar == firstCharV) {
                    count++;
                } else {
                    break B;
                }
                if (count == 3) {
                    return firstCharV;
                }
            }
        }
        return '.';
    }
}
