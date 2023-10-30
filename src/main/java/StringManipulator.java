import java.util.Scanner;

public class StringManipulator {
    public static char inputAnalyzer(String input){
        char userOption = input.charAt(0);
        if (userOption == '0' || userOption == '1' || userOption == '2' || userOption == '3') {
            return userOption;
        } else {
            return 'N';
        }
    }
    public static void substringChecker(){
        Scanner scan = new Scanner(System.in);
        String userString,userSubstring;

        System.out.println("Input a string:");
        userString = scan.nextLine();
        System.out.println("Input a substring:");
        userSubstring = scan.nextLine();

        if (userString.contains(userSubstring)){
            System.out.println("The string contains the substring.");
        } else {
            System.out.println("The string does not contains the substring.");
        }
    }

    public static void strictCompareStrings(){
        Scanner scan = new Scanner(System.in);
        String firstString,secondString;


        System.out.println("Input the first string to compare:");
        firstString = scan.nextLine();
        System.out.println("Input the second string to compare:");
        secondString = scan.nextLine();


        if (firstString.compareTo(secondString) == 0){
            System.out.println("The strings are equals.");
        } else {
            System.out.println("The strings are not equals.");
        }
    }

    public static void compareStrings(){
        Scanner scan = new Scanner(System.in);
        String firstString,secondString;

        System.out.println("Input the first string to compare:");
        firstString = scan.nextLine();

        System.out.println("Input the second string to compare:");
        secondString = scan.nextLine();


        if (firstString.equalsIgnoreCase(secondString)){
            System.out.println("The strings are equals.");
        } else {
            System.out.println("The strings are not equals.");
        }
    }

    public void charUnicode() {
        Scanner scan = new Scanner(System.in);
        String userString, indexS;
        int index, prevUnicode, nextUnicode,currentUnicode;

        System.out.println("Input a string:");
        userString = scan.nextLine();

        System.out.println("Your string: ["+userString + "] has a length of " + userString.length() + " characters.\n" +
                "Input the index of a character to get its Unicode:");
        indexS = scan.nextLine();
        try {
            index = Integer.parseInt(indexS);
        } catch (NumberFormatException e) {
            System.out.println("Input is not a valid integer.");
            return;
        }



        if (index < 0 || index >= userString.length()) {
            System.out.println("index not valid");
        } else if (index == 0 && userString.length() == 1) {
            currentUnicode = userString.codePointAt(index);
            System.out.println("Unicode before the index: not available"
                    + "\nUnicode in the index: " + currentUnicode
                    + "\nUnicode after the index: not available");
        } else if (index == 0) {
            currentUnicode = userString.codePointAt(index);
            index++;
            nextUnicode = userString.codePointAt(index);
            System.out.println("Unicode before the index: not available"
                    + "\nUnicode in the index: " + currentUnicode
                    + "\nUnicode after the index: " + nextUnicode
            );
        } else if (index == userString.length()-1){
            currentUnicode = userString.codePointAt(index);
            prevUnicode = userString.codePointBefore(index);
            System.out.println("Unicode before the index: " + prevUnicode
                    + "\nUnicode in the index: " + currentUnicode
                    + "\nUnicode after the index: not available"
            );
        } else {
            prevUnicode = userString.codePointBefore(index);
            currentUnicode = userString.codePointAt(index);
            index++;
            nextUnicode = userString.codePointAt(index);
            System.out.println("Unicode before the index: " + prevUnicode
                    + "\nUnicode in the index: " + currentUnicode
                    + "\nUnicode after the index: " + nextUnicode
            );
        }
    }

    public void stringManipulator() {
        System.out.println("""
                Hello, input a number to select an option:\s
                [0] substring in string
                [1] Compare strings (strict)
                [2] Compare strings (case insensitive)
                [3] Get Unicode from string
                """);

        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        char userInput = inputAnalyzer(input);
        if (userInput == '0') {
            substringChecker();
        } else if (userInput == '1') {
            strictCompareStrings();
        } else if (userInput == '2') {
            compareStrings();
        } else if (userInput == '3') {
            charUnicode();
        } else {
            System.out.println("Invalid input");
        }
    }
}
