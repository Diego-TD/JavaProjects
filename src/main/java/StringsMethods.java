import java.util.Scanner;
import java.util.Stack;
public class StringsMethods {

    static int wordCounter(String phrase){
        if (phrase == null || phrase.trim().isEmpty()) {
            return 0;
        }

        String[] words = phrase.trim().split("\\s+");

        int count = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }

        return count;
    }
    static boolean isPalindrome(String phrase){
        if (phrase == null || phrase.trim().isEmpty()) {
            return false;
        }
        String[] words = phrase.trim().split("\\s+");

        String word = words[0];
        System.out.println("Your word: "+words[0]);
        Stack<Character> stack = new Stack<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }

        for (char c : word.toCharArray()) {
            if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return true;
    }

    public static char inputAnalyzer(String input){
        char userOption = input.charAt(0);
        if (userOption == '0' || userOption == '1' || userOption == '2') {
            return userOption;
        } else {
            return 'N';
        }
    }
    public void stringsMethods(){
        boolean flag = true;
        Scanner scan = new Scanner(System.in);
        String userInputMenu, sentence, palindrome;
        char charInputMenu;

        while (flag){
            System.out.println("""
                    Input a number to select an option:
                    0: Words counter
                    1: Palindrome
                    2: Exit
                    """
            );
            userInputMenu = scan.nextLine();
            charInputMenu = inputAnalyzer(userInputMenu);

            switch (charInputMenu) {
                case '0' -> {
                    System.out.println("Input your sentence:");
                    sentence = scan.nextLine();
                    System.out.println("Your sentence has "+wordCounter(sentence)+" words.\n");

                }

                case '1' -> {
                    System.out.println("Input your palindrome: ");
                    palindrome = scan.nextLine();
                    if (isPalindrome(palindrome)) {
                        System.out.println("Is a palindrome.\n");
                    } else {
                        System.out.println("Isn't a palindrome.\n");
                    }
                }
                case '2' -> {
                    System.out.println("Bye bye...");
                    flag = false;
                }
                default -> { System.out.println("ok\n");
                }
            }
        }
    }
}