package day3_Selenium_03102019;

public class methods{

static int resultc;
    public static void main(String args[]){

        add(7,8);//add void method is called here

        resultc = addReturn(4,5);//store return method into a integer variable

        System.out.println("My new value is " + (resultc-5));

        //String helloVariable = stringReturn(2,4);

    }//end of main method

    //method below is a void additon method
    public static void add(int a, int b){
        int sum = a+b;
        System.out.println("My total result is " + sum);
    }//end of void add method

    //method below is a retun additon method
    public static int addReturn(int a, int b){
        int c = a+b;
        System.out.println("My result for c is " + c);
        return c;
    }//end of void add method

    //method below is a retun additon method
    public static String stringReturn(int a, int b){
        String sum = "hello";
        System.out.println("My result for c is " + sum);
        return sum;
    }//end of void add method


}//end of parent class
