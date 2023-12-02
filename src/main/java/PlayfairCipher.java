import java.util.*;
import java.util.stream.Collectors;

public class PlayfairCipher {

    /*
     * This method manages the main logic of the program itself
     * You call this method to start the program
     * @param void
     * @return void
     */
    public void playfairCipher (){
        char userInput;
        boolean flag=true;
        char[][] matrix;

        System.out.println("Hello, input a key:");
        // call newKey() method and receive a 5x5 key matrix to be used to cipher
        matrix = newKey();

        // the while loop is used to never stop the program until the user input the option to exit
        while(flag){
            System.out.println("""
                Input a number to select an option:\s
                [0] Change key
                [1] Encrypt
                [2] Decrypt
                [3] Exit
                """);
            // call to menuInput() and receive a valid input for the switch case
            userInput = menuInput();

            switch (userInput) { //switch used to do what the printed menu says
                case '0' -> {
                    System.out.println("Input a new key:");
                    matrix = newKey();
                }
                case '1' -> System.out.println("Encrypted text: "+encrypt(matrix)+"\n"); // call to encrypt() method and receives a text encrypted
                case '2' -> System.out.println("Decrypted text: "+decrypt(matrix)+"\n"); // call to decrypt() method and receives a text decrypted
                default ->  flag = false;
            }
        }
        // if the flag is false, the while loop and program finishes
        System.out.println("Bye bye...");
    }

    /*
     * This method ensure that the user inputs a valid menu option.
     * @param void
     * @return char, a valid option for the menu switch case
     */
    private static char menuInput() {
        while (true){ // while loop to never stop until the user input a valid input
            Scanner scan = new Scanner(System.in);
            String userInput = scan.nextLine(); // scan a user input and save it as a String userInput
            if (!userInput.isEmpty()){ // if the user input is not empty the condition will be true
                char input = userInput.charAt(0);
                // Checks if the first char in the userInput is one of the valid options
                // if the userInput is valid, it will return a char of the option selected
                if (input == '0' || input == '1' || input == '2' || input == '3') {
                    return input;
                }
            }
            //the loop will continue if the input is not a valid option
            System.out.println("""
                Not a valid option, try again:\s
                [0] Change key
                [1] Encrypt
                [2] Decrypt
                [3] Exit
                """);
        }
    }

    /*
     * Method used to encrypt text
     *
     * @param char[][] matrix, the 5x5 key matrix to be used when ciphering.
     * @return String, the text ciphered.
     */
    private static String encrypt(char[][] matrix) {
        // get the plainText ready to encrypt
        String plainText = textToCipher(0);
        System.out.println("Curated text ready to encrypt: "+plainText+"\n");

        int length = plainText.length();
        StringBuilder cipherText = new StringBuilder();

        // Iterate through the plainText in pairs
        for (int i = 0; i < length; i +=2) {
            char current, next;
            // first char of the pair
            current = plainText.charAt(i);
            // second char of the pair
            next = plainText.charAt(i+1);
            int currentRow=-1, currentCol=-1, nextRow=-1, nextCol=-1;

            // Search for the coordinates of current and next characters in the key matrix
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (matrix[row][col] == current) {
                        currentRow = row;
                        currentCol = col;
                    }
                    if (matrix[row][col] == next) {
                        nextRow = row;
                        nextCol = col;
                    }
                }
            }

            // Apply Playfair Cipher rules based on the positions of current and next characters
            if (currentCol == nextCol){
                // Same column
                if (currentRow == 4){
                    currentRow = 0;
                    cipherText.append(matrix[currentRow][currentCol]);
                } else {
                    cipherText.append(matrix[currentRow+1][currentCol]);
                }

                if (nextRow == 4){
                    nextRow =0;
                    cipherText.append(matrix[nextRow][nextCol]);
                } else {
                    cipherText.append(matrix[nextRow+1][nextCol]);
                }
            } else if (currentRow == nextRow) {
                // Same row
                if (currentCol == 4){
                    currentCol = 0;
                    cipherText.append(matrix[currentRow][currentCol]);
                } else {
                    cipherText.append(matrix[currentRow][currentCol+1]);
                }

                if (nextCol == 4){
                    nextCol =0;
                    cipherText.append(matrix[nextRow][nextCol]);
                } else {
                    cipherText.append(matrix[nextRow][nextCol+1]);
                }

            } else {
                // Different row and column
                cipherText.append(matrix[currentRow][nextCol]); //current
                cipherText.append(matrix[nextRow][currentCol]); // next
            }
        }
        return cipherText.toString();
    }

    /*
     * Method used to decrypt text
     *
     * @param char[][] matrix, the 5x5 key matrix to be used when ciphering.
     * @return String, the text ciphered.
     */
    private static String decrypt(char[][] matrix) {
        // get the plainText ready to decrypt
        String plainText = textToCipher(1);
        System.out.println("Curated text ready to decrypt: "+plainText+"\n");

        int length = plainText.length();
        StringBuilder cipherText = new StringBuilder();

        // Iterate through the plainText in pairs
        for (int i = 0; i < length; i +=2) {
            char current, next;
            // first char of the pair
            current = plainText.charAt(i);
            // second char of the pair
            next = plainText.charAt(i+1);
            int currentRow=-1, currentCol=-1, nextRow=-1, nextCol=-1;

            // Search for the coordinates of current and next characters in the key matrix
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (matrix[row][col] == current) {
                        currentRow = row;
                        currentCol = col;
                    }
                    if (matrix[row][col] == next) {
                        nextRow = row;
                        nextCol = col;
                    }
                }
            }

            // Apply Playfair Cipher rules based on the positions of current and next characters
            if (currentCol == nextCol){
                // Same column
                if (currentRow == 0){
                    currentRow = 4;
                    cipherText.append(matrix[currentRow][currentCol]);
                } else {
                    cipherText.append(matrix[currentRow-1][currentCol]);
                }

                if (nextRow == 0){
                    nextRow =4;
                    cipherText.append(matrix[nextRow][nextCol]);
                } else {
                    cipherText.append(matrix[nextRow-1][nextCol]);
                }
            } else if (currentRow == nextRow) {
                // Same row
                if (currentCol == 0){
                    currentCol = 4;
                    cipherText.append(matrix[currentRow][currentCol]);
                } else {
                    cipherText.append(matrix[currentRow][currentCol-1]);
                }

                if (nextCol == 0){
                    nextCol =4;
                    cipherText.append(matrix[nextRow][nextCol]);
                } else {
                    cipherText.append(matrix[nextRow][nextCol-1]);
                }

            } else {
                // Different row and column
                cipherText.append(matrix[currentRow][nextCol]); //current
                cipherText.append(matrix[nextRow][currentCol]); // next
            }
        }
        return cipherText.toString();
    }

    /*
     * Method used to format a text for ciphering.
     *
     * @param int input, used to customize a message
     * @return String, used to cipher
     */
    private static String textToCipher(int input) {
        String option;

        switch (input) {
            case 0 -> option = "Input a text to encrypt: ";
            case 1 -> option = "Input a text to decrypt: ";
            default -> option = "Input a text: ";
        }

        System.out.println(option);

        // call to getValidInputText() method and receive a valid text to format
        String plainText = getValidInputText();

        // remove spaces to the plainText received
        plainText = plainText.replaceAll("\\s", "");

        // Convert the plainText to a char array
        char[] txtArray = plainText.toCharArray();

        // replace 'j' letters with 'i' letters
        for (int i = 0; i < plainText.length(); i++) {
            if (txtArray[i] == 'j') {
                txtArray[i] = 'i';
            }
        }

        // call to prepareDigramsForCipher() with the array formatted
        // Return the string ready to cipher
        return prepareDigramsForCipher(txtArray);
    }

    /*
     * Method used to prepare the "digrams" to be ciphered.
     *
     * @param char[] txtArray, the array of letters that will be ciphered
     * @return String, the text ready to be ciphered
     */
    private static String prepareDigramsForCipher(char[] txtArray) {
        StringBuilder curatedText = new StringBuilder();

        // travel through the txtArray and add an x between a pair of equal letters
        // each loop focuses in a pair of letters
        for (int i = 0; i < txtArray.length; i += 2) {
            char current, next;
            current = txtArray[i]; // first letter of the pair

            // if it's the final loop, it just adds the last letter
            // because next won't exist
            if (i == txtArray.length-1){
                curatedText.append(current);
                break; // finishes de for loop
            }

            next = txtArray[i+1]; // second letter of the pair

            // add the first letter of the pair
            curatedText.append(current);

            if (current == next) { // if the pair of letter are equal, add an x next to the first letter
                curatedText.append('x');
                // decreases 1 to the index to start the loop again,
                // but now starting in the last letter of the previous pair
                i--;
            } else { // if each letter of the pair is different, just add the second letter of the pair and continue
                curatedText.append(next);
            }
        }

        // if the length is odd, it adds an x at the end
        if (curatedText.length() %2 !=0){
            curatedText.append('x');
        }
        return curatedText.toString();
    }

    /*
     * Method used return a text with only abc english lowercase letters and spaces
     * It forces the user to input at least one letter, and then it accepts to input any letters or spaces
     *
     * @param void
     * @return String
     */
    private static String getValidInputText() {
        while (true){
            Scanner scan = new Scanner(System.in);
            String text = scan.nextLine();
            if (text.matches("^[a-z]+(?: [a-z]+)*$") && !text.isEmpty()){
                return text;
            } else {
                System.out.println("Invalid input. Please enter lowercase English alphabets and spaces only.");
            }
        }
    }

    /*
     * Method used to create 5x5 key matrix
     *
     * @param void
     * @return char[][] matrix, to be used to cipher.
     */
    private static char[][] newKey() {
        char[][] matrix = new char[5][5]; // create a 5x5 matrix

        // call to getValidInputText() and receive a string which only contains abc english lowercase letters and spaces
        String StringKey = getValidInputText();

        // remove spaces from the key
        StringKey = StringKey.replaceAll("\\s", "");

        // create an array with the english abc
        char[] abcArray = {'a','b','c','d','e','f','g','h','i','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        // converts the key string receive from the user to an array
        char[] keyArray = StringKey.toCharArray();

        // create an array with the final key
        char[] finalKey = new char[25];

        // replace 'j' letters with 'i' letters, cuz are the same in the playfair cipher
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] == 'j') {
                keyArray[i] = 'i';
            }
        }

        // Create a LinkedHashMap with keys of type String and values of type Integer
        Map<Character, Integer> map = new LinkedHashMap<>();

        // Use the hashmap to get unique characters of the keyArray, such as in the leetcode problem #387
        for (int i = 0; i < StringKey.length(); i++) {
            if (map.containsKey(keyArray[i])){ // if the letter is already in the hashmap, it adds 1 to its value
                int currentValue = map.get(keyArray[i]);
                int newValue = currentValue + 1;
                map.put(keyArray[i], newValue);
            } else {
                map.put(keyArray[i],0); // insert the current letter with value of 0
            }
        }
        System.out.println("Unique chars in your key: "+map); // just to see the map, it looks interesting


        // get the keys of the map in order
        char[] keysInOrder = map.keySet().stream().map(Object::toString).collect(Collectors.joining()).toCharArray();

        //  Enter up to 25 unique chars in the finalKey
        int index = 0;
        for (char c : keysInOrder) {
            if (index < 25) {
                finalKey[index++] = c;
            }
        }

        // If keysInOrder are less than 25, fill the rest finalKey array with letters of the abcArray,
        // without repeating any letter in the finalKey array
        if (keysInOrder.length < 25){
            for (char c : abcArray) {
                if (index < 25 && !map.containsKey(c)) {
                    finalKey[index++] = c;
                }
            }
        }


        // fill the matrix with the finalKey
        index = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = finalKey[index++];
            }
        }

        System.out.println("Here's your key matrix: ");
        printMatrix(matrix); // call the method printMatrix() just to see the matrix

        return matrix;
    }

    /*
     * Method used to print the matrix
     *
     * @param char[][] matrix
     * @return void
     */
    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar + "\t");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

}
/*
 * Some mistakes/challenges:
 * - In the playfair rules, switched row and col coordinates.
 * - Tricky cases when preparing digrams for cipher
 */

/*

public class Main {

    /*
     * This method is the entry point of the program. It creates an instance of
     * the PlayfairCipher class and calls the playfairCipher() method to start
     * the Playfair Cipher program.
     *
     * @param String[] args, array representing command-line arguments (not used in this program).
     * @return void
     */
/*
public static void main(String[] args) {
    // Create an object from the PlayfairCipher class
    PlayfairCipher objPFC = new PlayfairCipher();
    // Use the object to call the playfairCipher() method
    objPFC.playfairCipher();
}
}
*/
