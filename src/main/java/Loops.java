import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.Scanner;

public class Loops {
    public void loop (){
        int[] nums = new int[]{2,3,4};
        int target = 7;

        for (int i = 0; i<nums.length; i++){
            for (int j =0; j<nums.length; j++){
                if (nums[i]+nums[j] == target) {
                    System.out.println("[" + i + "," + j + "]");
                    return;
                }
            }
        }

        do{
            Scanner scan = new Scanner(System.in);

            System.out.println("Input a letter:");


        } while (true);


        /*
        for (int i = 10; i>0; i--){
            System.out.println(i);
        }
        */

    }
    public void numberFactorial (){
        int userNumber, factorial = 1;
        Scanner scan = new Scanner(System.in);

        System.out.println("Input a number:");
        userNumber = scan.nextInt();

        for (int i = 1; i<=userNumber; i++){
             factorial*= i;
        }
        System.out.println(factorial);
    }
}
