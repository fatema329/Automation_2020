package day3_01182020;

public class multiple_conditions {

    public static void main(String[] args){


        //declare integer variables
        int a,b,c;
        a=2;
        b=3;
        c=4;
        //a+b is either can be equal, greater or less than c
        if(a+b == c){
            System.out.println("a & b is equal to c");
        } else if(a+b > c) {
            System.out.println("a & b is greater than c");
        } else {
            System.out.println("a & b is less than c");
        }//end of conditional statements

    }//end of main class

}//end of parent class
