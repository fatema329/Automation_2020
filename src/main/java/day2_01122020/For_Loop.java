package day2_01122020;

public class For_Loop {

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

        //using for loop to iterate through series of zip code
        for (int i=0;i<7;i++){
            System.out.println("My zipcode is " + zipcode[i]);
        } //end of for loop
        //for (int i=_ ;i><_ ;i++)

    }//end of main method


}//end of parent class
