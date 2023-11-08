import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
    public static char inputAnalyzer(String input){
        char userOption = input.charAt(0);
        if (userOption == '0' || userOption == '1' || userOption == '2' || userOption == '3' || userOption == '4') {
            return userOption;
        } else {
            return 'N';
        }
    }
    public static int pinGenerator(int textAdaptation){
        Scanner scan = new Scanner(System.in);
        String userPinInput,stringAdaptation;
        int pin;

        stringAdaptation = switch (textAdaptation) {
            case 1 -> "new";
            case 2 -> "current";
            default -> "";
        };

        while (true){
            System.out.println("Input your "+stringAdaptation+" PIN: ");
            userPinInput = scan.nextLine();
            pin = convertPinToInt(userPinInput);

            if (pin == -1) {
                System.out.println("Invalid PIN length. Please enter a 4-digit PIN.");
            } else if (pin == -2) {
                System.out.println("Invalid PIN format. Please enter a 4-digit numeric PIN.");
            } else {
                return pin;
            }
        }
    }
    public static int convertPinToInt(String pinInput) {
        int pinAsInt;

        if (pinInput.length() != 4) {
            return -1;
        }

        try {
            pinAsInt = Integer.parseInt(pinInput);
        } catch (NumberFormatException e) {
            return -2;
        }
        return pinAsInt;
    }
    public static boolean pinRequest (int userPin){
        int userPinChecker;
        for (int i = 1; i<4; i++) {
            userPinChecker = pinGenerator(2);
            if (userPin == userPinChecker) {
                return true;
            }
            System.out.println("Invalid pin, attempts: "+i+"/3");
        }
        System.out.println("Your account is now blocked :(");
        return false;
    }
    private static double moneyAmount(int textAdapter) {
        Scanner scan = new Scanner(System.in);
        double money=0;
        String stringAdaptation;
        boolean flag= true;

        switch (textAdapter) {
            case 0 -> stringAdaptation = "to deposit:";
            case 1 -> stringAdaptation = "to withdraw:";
            default -> stringAdaptation = "";
        }

        while (flag) {
            System.out.println("Input the amount of money " + stringAdaptation);
            try {
                money = scan.nextDouble();
                if (money > 0){
                    flag = false;
                } else {
                    System.out.println("Input a valid amount. \n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input a valid amount. \n");
            }
        }

        return money;
    }
    public void startATM(){
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        String input;
        char userInput;
        double balance = 1000;
        int pin;

        pin = pinGenerator(1);

        while(flag){
        System.out.println("""
                Input a number to select an option:\s
                [0] Change PIN
                [1] View account balance
                [2] Deposit money
                [3] Withdraw money
                [4] EXIT
                """);

        input = scan.next();
        userInput = inputAnalyzer(input);

        switch (userInput){
            case '0':
                System.out.println("Change PIN");
                if (pinRequest(pin)){
                    System.out.println("Continue to change your PIN");
                    pin = pinGenerator(1);
                    System.out.println("Your PIN has been changed successfully :)\n");
                } else {
                    return;
                }
                break;
            case '1':
                System.out.println("View account balance");
                if (pinRequest(pin)){
                    System.out.println("Your current balance is: "+"$" +balance+"\n");
                } else {
                    return;
                }
                break;
            case '2':
                System.out.println("Deposit money");
                if (pinRequest(pin)){
                    balance = balance + moneyAmount(0);
                    System.out.println("Money successfully deposited. \n");
                } else {
                    return;
                }
                break;
            case '3':
                System.out.println("Withdraw money");
                if (pinRequest(pin)){
                    double moneyAmount = moneyAmount(1);
                    if (moneyAmount > balance){
                        System.out.println("You haven't that amount of money. \n");
                    } else {
                        balance = balance - moneyAmount;
                        System.out.println("Money successfully withdrawn. \n");
                    }
                } else {
                    return;
                }
                break;
            case '4':
                System.out.println("Bye Bye..");
                flag = false;
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
        }
    }
}
