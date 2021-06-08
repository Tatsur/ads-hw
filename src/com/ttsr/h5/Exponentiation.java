package com.ttsr.h5;

public class Exponentiation {
    public static void main(String[] args) {
        try {
            System.out.println(pow(2, 5));
            System.out.println(pow(3, 3));
            System.out.println(pow(5, 0));
            System.out.println(pow(3002425,35));
            System.out.println(pow(5,-2));
            System.out.println(pow(0, 0));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    private static double pow(double number, double degree) throws IllegalArgumentException {
        if(number == 0){
            if(degree > 0)
                return 0;
            else {
                    throw new IllegalArgumentException(String.format("Wrong rank = %s for number = %s", degree, number));
            }
        }
        if(degree < 0)
            return 1 / (number * pow(number,-degree - 1));
        else if (degree > 0)
            return number * pow(number,degree - 1);
        else
            return 1;
    }
}
