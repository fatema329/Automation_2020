package day2_01122020;

public class Dynamic_Array {

    public static void main(String[] args){

        //declaring array variable for String & int type
        String[] zipcode;
        int[] streetNumber;

        //define string array and length
        zipcode = new String[6];
        //define the zipcode values on the array
        zipcode[0] = "11218";
        zipcode[1] = "11219";
        zipcode[2] = "10001";
        zipcode[3] = "10002";
        zipcode[4] = "11277";
        zipcode[5] = "11278";

        //printing zipcode
        //System.out.println("My first zipcode is " + zipcode[0]);
        //System.out.println("My second zipcode is " + zipcode[1]);

        //int dynamic array
        streetNumber = new int[5];
        streetNumber[0] =  111;
        streetNumber[1] = 333;
        streetNumber[2] = 444;
        streetNumber[3] = 555;

       System.out.println("My first zipcode is " + zipcode[3] + " and my street number is " + streetNumber[0]);

    }//end of main method

}//end of parent class
