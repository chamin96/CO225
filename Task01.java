//Task 01
//Friday, October 5, 2018 3:58:40 PM | Author: E/15/154

import java.util.Scanner;  //import Scanner

public class Task01{
    public static void main(String[] args){
        int num;

        //create a new scanner
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter a number: ");
        num = keyboard.nextInt();
        System.out.println(num+" is special but not scary.");

        System.out.print("Enter a number: ");
        num = keyboard.nextInt();
        System.out.println(num+" is special, weird and scary but not big.");

        keyboard.close();
    }
}