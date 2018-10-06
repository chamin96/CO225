import java.util.Scanner;  //import Scanner

public class Task02{
    public static void main(String[] args) {
        //create a new scanner
        Scanner keyboard = new Scanner(System.in);

        String[] input = new String[2]; 
        int a; 
        int b;

        System.out.print("Please enter two integers: "); 
        input = keyboard.nextLine();

        a = Integer.parseInt(input[0]); 
        b = Integer.parseInt(input[1]);

        System.out.println("You input: " + a + " and " + b);
        keyboard.close();
    }
}