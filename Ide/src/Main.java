// Fri 10/05/2018 | Author: E/15/154


import java.util.Scanner;  //import Scanner

public class Main {
    public static void main(String[] args){
        int num;

        //create a new scanner
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a number: ");
        //getting the input
        num = keyboard.nextInt();

        /*check if num is BIG*/
        boolean isBig = num > 999;

        /*check if it is SPECIAL*/
        boolean isSpecial = num%15==0;

        /*check num is WEIRD*/
        boolean isWeird = num%5==0 && num%6==0 && num%18!=0;

        /*check num is SCARY*/
        boolean isScary = isBig||isWeird;

        /*OUTPUT*/
        System.out.print(num+" is");
        if (isSpecial){
            System.out.print(" special,");
            if (isScary){
                if (isBig && isWeird){
                    System.out.println(" big, weird, scary.");
                }
                else if (isBig){
                    System.out.println(" big, scary, but not weird.");
                }
                else {
                    System.out.println(" weird, scary, but not big.");
                }
            }
            else {
                System.out.println(" but not scary.");
            }

        }
        else{
            if (isScary){
                if (isBig && isWeird){
                    System.out.println(" big, weird, scary.");
                }
                else if (isBig){
                    System.out.println(" big, scary, but not weird.");
                }
                else {
                    System.out.println(" weird, scary, but not big.");
                }
            }
            else {
                System.out.println(" not scary.");
            }
        }



        keyboard.close();
    }
}
