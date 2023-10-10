import java.util.Scanner;

public class CharacterIdentifier {

    public void charIs() {
        Scanner scan = new Scanner(System.in);
        char character;
        int charValue = 0, end = 0;

        while (end == 0) {
            System.out.println("Introduce a character to identify:");

            character = scan.next().charAt(0);
            charValue = character;

            System.out.println("The decimal value of the character is: " + charValue);

            if ((charValue >= 32 && charValue <=47) || (charValue >= 58 && charValue <=64)
            || (charValue >= 91 && charValue <= 96) || (charValue >= 123 && charValue <=126))
            {
                System.out.println("It is a special character.");
            } else if (charValue >= 48 && charValue <=57){
                System.out.println("It is a number.");
            } else if (charValue >= 65 && charValue <=90) {
                System.out.println("It is a capital letter.");
            } else if (charValue >= 97 && charValue <=122) {
                System.out.println("It is a small letter.");
            } else {
                System.out.println("idk");
            }


            System.out.println("\nDid you finish? \n FINISH: 1 \n CONTINUE: 0 ");
            end = scan.nextInt(); // It crashes if you type a character :(
            if (end != 0 && end != 1){
                System.out.println("xd");
                end = 0;
            }
        }
    }
}
