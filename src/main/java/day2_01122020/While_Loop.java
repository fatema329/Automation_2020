package day2_01122020;

public class While_Loop {


    public static void main(String[] args){
        //declare zipcode
        String[] zipcode;
        //define string array and length
        zipcode = new String[7];
        //define the zipcode values on the array
        zipcode[0] = "11218";
        zipcode[1] = "11219";
        zipcode[2] = "10001";
        zipcode[3] = "10002";
        zipcode[4] = "11277";
        zipcode[5] = "11278";
        zipcode[6] = "11299";

        //using while loop to iterate through series of zip code
        int i=0;
        while (i<zipcode.length){
            System.out.println("My zipcode is " + zipcode[i]);
            i=i+1;//or you can use i++
        }//end of for loop
        int j=0;
        while (j<6){
            System.out.println("My zipcode is " + zipcode[j]);

            j=j+1;//or you can use i++
        }//end of for loop



    }//end of main method


}//end of parent class
