import java.util.Scanner;  //import Scanner

public class helloWorld{
    public static void main(String[] args) {

        //create a new scanner
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the color: ");
        int r = keyboard.nextInt();
        int g = keyboard.nextInt();
        int b = keyboard.nextInt();


        int cmp_r,cmp_g,cmp_b;
        if (r>111&&r<144&&g>111&&g<144&&b>111&&b<144){
            cmp_r=(r<128)?r+128:r-128;
            cmp_g=(g<128)?g+128:g-128;
            cmp_b=(b<128)?b+128:b-128;

        }
        else{
            cmp_r=255-r;
            cmp_g=255-g;
            cmp_b=255-b;
        }

        System.out.println("The complement: "+cmp_r+" "+cmp_g+" "+cmp_b);
        keyboard.close();
    }
}
