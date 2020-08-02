package com.simplibytes.leetcode.solutions;


import java.sql.SQLOutput;

/*Problem description: Given an integer, write a function to determine if it is a power of two.

        Example 1:
        Input: 1
        Output: true
        Explanation: 20 = 1

        Example 2:
        Input: 16
        Output: true
        Explanation: 24 = 16

        Example 3:
        Input: 218
        Output: false

 */
public class PowerOfTwo {

    public boolean isNumberPowerOfTwo(int number){
        int powerTwo =1;
        while(powerTwo<number){
            powerTwo*=2;
        }

        if(powerTwo==number)
            System.out.println("Number is power of two:"+number);
        else
            System.out.println("Number is not power of two:"+number);

        return powerTwo==number;
    }

    public static void main(String[] args) {
        PowerOfTwo powerOfTwo=new PowerOfTwo();
        powerOfTwo.isNumberPowerOfTwo(3345);
        powerOfTwo.isNumberPowerOfTwo(29202);
        powerOfTwo.isNumberPowerOfTwo(216);
        powerOfTwo.isNumberPowerOfTwo(64);


    }
}
