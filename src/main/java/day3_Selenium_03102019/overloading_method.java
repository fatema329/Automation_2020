package day3_Selenium_03102019;

public class overloading_method {

    public static void addition(int a, int b) {
        System.out.println("My a & b result is " + (a+b));
    }

    public static void addition(int a, int b,int c){
        System.out.println("My a, b & c result is " + (a+b+c));
    }

    public static void main(String args[]){
        addition(10,20);
        addition(10,20,40);

    }


}
