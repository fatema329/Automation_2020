package day3_01182020;

public class Reusable_Methods {

    //void method to add two variables and print the result
    public static void addVoid(int arg1, int arg2) {
        System.out.println("my result is " + (arg1 + arg2));
    }//end of addvoid 1

    //void method to add two variables and print the result
    public static void addVoid(int arg1, int arg2, int arg3){
        System.out.println("my result is " + (arg1+arg2+arg3));
    }//end of addvoid 2

    //void method to add two variables and print the result
    public static void addVoid(int arg1, int arg2, int arg3, int arg4){
        System.out.println("my result is " + (arg1+arg2+arg3+arg4));
    }//end of addvoid 3

    //return method to add two variables and return the result
    public static int addReturn(int a, int b){
        int result = a+b;
        System.out.println("My result is " + result);
        return result;
    }//end of return method

}//end of parent class
