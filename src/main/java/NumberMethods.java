import java.util.HashMap;
import java.util.Scanner;
import java.math.BigInteger;


public class NumberMethods {
    static char inputAnalyzer(String input){
        if (input.isEmpty()){
            return 'N';
        }

        char userOption = input.charAt(0);
        if (userOption == '0' || userOption == '1' || userOption == '2' || userOption == '3') {
            return userOption;
        } else {
            return 'N';
        }
    }
    public void numberMethods(){
        boolean flag = true;
        char charInputMenu;
        int userNumber;
        String userInputMenu, roman;
        Scanner scan = new Scanner(System.in);

        while (flag){
            System.out.println("""
            Input a number to select an option:
            0: Decimal to roman number converter (integers from 1 to 2000)
            1: Narcissistic number identifier
            2: Lucas numbers generator
            3: Exit
            """);

            userInputMenu = scan.nextLine();
            charInputMenu = inputAnalyzer(userInputMenu);

            switch (charInputMenu) {
                case '0' -> {
                    System.out.println("Decimal to roman number converter (integers from 1 to 2000)");
                    userNumber = positiveNumberCreator(0);
                    roman = convertToRoman(userNumber);
                    System.out.println("Your number in roman is: "+roman +"\n");

                }
                case '1' -> {
                    System.out.println("Narcissistic number identifier");
                    userNumber = positiveNumberCreator(1);
                    if (narcissisticChecker(userNumber)){
                        System.out.println("Your number: "+userNumber+" is narcissistic\n");
                    } else {
                        System.out.println("Your number: "+userNumber+" is not narcissistic\n");
                    }
                }
                case '2' -> {
                    System.out.println("Lucas numbers generator");
                    userNumber = positiveNumberCreator(2);
                    lucasSequence(userNumber);
                    System.out.println("Finished\n");
                }
                case '3' -> {
                    System.out.println("Bye bye...");
                    flag = false;
                }
                default -> System.out.println("ok\n");
            }
        }
    }
    static int positiveNumberCreator(int textAdaptation){
        Scanner scan = new Scanner(System.in);
        String userInput,stringAdaptation;
        int userNumber;

        stringAdaptation = switch (textAdaptation) {
            case 0 -> "Input a number to convert:";
            case 1 -> "Input a number:";
            case 2 -> "Input the number of how much numbers do you want:";
            default -> "";
        };

        while (true){
            System.out.println(stringAdaptation);

            userInput = scan.nextLine();

            userNumber = convertToInt(userInput);

            if (textAdaptation == 0 && (userNumber < 1 || userNumber > 2000)) {
                System.out.println("Invalid number. Please enter a positive number from 1 to 2000 (without spaces).");
            } else if (userNumber < 0) {
                System.out.println("Invalid number. Please enter a positive number from 0 to 2147483647 (without spaces).");
            } else {
                return userNumber;
            }
        }
    }
    static int convertToInt(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -2;
        }
        return number;
    }
    static boolean narcissisticChecker(int userNumber) {
        BigInteger userNumberBigInteger = BigInteger.valueOf(userNumber);
        BigInteger result = BigInteger.ZERO;

        String numString = Integer.toString(userNumber);
        int pow = numString.length();

        for (int i = 0; i < pow; i++) {
            int digit = Character.getNumericValue(numString.charAt(i));
            BigInteger digitBigInteger = BigInteger.valueOf(digit);
            result = result.add(digitBigInteger.pow(pow));
        }

        return result.equals(userNumberBigInteger);
    }
    static void lucasSequence(int userNumber) {
        System.out.println("Lucas sequence:");
        BigInteger lucasNumber, prev2 = BigInteger.valueOf(2), prev1 = BigInteger.valueOf(1);

        for (int c = 0; c < userNumber; c++) {
            switch (c) {
                case 0 -> {
                    System.out.println(c + ": " + prev2);
                    continue;
                }
                case 1 -> {
                    System.out.println(c + ": " + prev1);
                    continue;
                }
            }

            lucasNumber = prev1.add(prev2);
            System.out.println(c + ": " + lucasNumber);
            prev2 = prev1;
            prev1 = lucasNumber;
        }
    }
    static String convertToRoman(int num) {
        HashMap<Integer, String> romanMap = new HashMap<>();
        romanMap.put(1, "I");
        romanMap.put(4, "IV");
        romanMap.put(5, "V");
        romanMap.put(9, "IX");
        romanMap.put(10, "X");
        romanMap.put(40, "XL");
        romanMap.put(50, "L");
        romanMap.put(90, "XC");
        romanMap.put(100, "C");
        romanMap.put(400, "CD");
        romanMap.put(500, "D");
        romanMap.put(900, "CM");
        romanMap.put(1000, "M");

        StringBuilder result = new StringBuilder();

        int[] keys = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};


        for (int key : keys) {
            while (num >= key) {
                result.append(romanMap.get(key));
                num -= key;
            }
        }

        return result.toString();
    }
}
