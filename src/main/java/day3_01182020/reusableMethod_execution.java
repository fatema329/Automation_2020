package day3_01182020;

public class reusableMethod_execution {

    public static void main(String[] args){
        String [] cities = new String[]{"Brooklyn","Queens","Manhattan","Staten"};
        for(int i=0;i<cities.length;i++) {
            if (cities[i] == "Brooklyn") {
                System.out.println("My borough is " + cities[i]);
            } else if (cities[i] == "Queens") {
                System.out.println("My borough is " + cities[i]);
            }
        }//end of for loop

        int grade = 79;
        if(grade >= 90 && grade <= 100){
            System.out.println("Grade is A");
        }else if(grade >= 80 && grade < 90){
            System.out.println("Grade is B");
        } else if(grade >= 70 && grade < 80){
            System.out.println("Grade is C");
        }

        //execute voidAdd method
        Reusable_Methods.addVoid(0,3);
        Reusable_Methods.addVoid(0,3,4);

        //return method
        int newResult = Reusable_Methods.addReturn(6,4);
        System.out.println("My new result is " + (newResult-5));

    }//end of main class



}
