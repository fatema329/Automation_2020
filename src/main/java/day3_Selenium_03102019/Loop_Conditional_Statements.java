package day3_Selenium_03102019;

public class Loop_Conditional_Statements {

    public static void main(String args[]){

        String[] fruits = new String [5];
        fruits[0] = "apple";
        fruits[1] = "mango";
        fruits[2] = "strawberry";
        fruits[3] = "orange";
        fruits[4] = "banana";

        for(int i = 0; i < fruits.length; i++){

            //if fruit is equal to mango then only print
            if(fruits[i].equalsIgnoreCase("mango")){
                System.out.println("Fruit is Mango on array list " + i);
            } else if(fruits[i].equalsIgnoreCase("BaNana")) {
                System.out.println("Fruit is now Banana on array list " + i);
            } else if(i==2) {
                System.out.println("Array list 2 is " + fruits[i]);
            } else {
              //  System.out.println("Fruit is now " + fruits[i] + " on array list " + i);
            }

        }//end of for loop



    }//end of main method

}//end of parent class
