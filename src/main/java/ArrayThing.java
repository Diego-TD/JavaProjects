import java.util.Arrays;
import java.util.Collections;

public class ArrayThing {
    public void arrayExercises(){
        // sort elements from an array
        int[] intArray = {23,1,344,5,1,2,4,5,6,7,8,88,4,99,12,23,15,76};
        System.out.println("intArray: "+Arrays.toString(intArray));
        Arrays.sort(intArray,0,intArray.length);
        System.out.println("intArray sorted: "+Arrays.toString(intArray)+"\n");

        // sort string elements from an array
        String[] stringArray = {"que","so","what","amigo","sopenco"};
        System.out.println("stringArray: "+ Arrays.toString(stringArray));
        Arrays.sort(stringArray);
        System.out.println("stringArray sorted: "+ Arrays.toString(stringArray)+"\n");

        // sort string elements from an array
        char[] charArray = {'z','a'};
        System.out.println("charArray: "+ Arrays.toString(charArray));
        Arrays.sort(charArray);
        System.out.println("charArray sorted: "+ Arrays.toString(charArray)+"\n");

        // sort integer elements in descendent order
        Integer[] integerArray = {23,1,344,5,1,2,4,5,6,7,8,88,4,99,12,23,15,76};
        System.out.println("integerArray: "+ Arrays.toString(integerArray));
        Arrays.sort(integerArray, Collections.reverseOrder());
        System.out.println("integerArray sorted: "+ Arrays.toString(integerArray)+"\n");

        // search in an array
        System.out.println("intArray: "+Arrays.toString(intArray));
        int element = 23;
        System.out.println("element to search: "+ element);
        int contains = arraySearch(intArray,element);
        if (contains == -1){
            System.out.println("The element isn't in the array");
        } else {
            System.out.println("Your element is in the array in the index: "+contains + "\n");
        }

        //
        System.out.println("Array: "+Arrays.toString(intArray));
        System.out.println("Array sorted: "+Arrays.toString(inverseArray(intArray)));
    }

    public static int arraySearch(int[] array, int element){
        for (int i = 0; i < array.length ; i++){
            if (array[i] == element){
                return i;
            }
        }
        return -1;
    }

    public static int[] inverseArray(int[] array){
        int j = 0;
        int[] newArray = new int[array.length];
        for (int i = array.length-1; i >= 0 ; i--){
            newArray[j] = array[i];
            j++;
        }
        return newArray;
    }

    public void arrayThing(){
        char[] charArray = {'2','2','2','2','2','2'};
        byte[] byteArray = {127,2,3,4,5};
        int[] intArray = {1,2,3,4,5};
        long[] longArray = {1,2,3,4,52222222211L};

        float[] floatArray = {1.2F,2.4F,3.4F,4.2F,5.2F};
        double[] doubleArray = {1.22222223222222222222D,2.4,3.4,4.2,5.2};

        String[] stringArray = {"hello","my","friend"};
        /*
        for (int i:intArray) {
            System.out.println(i);
        }

        int[][] multiIntArray = {{1, 2, 3, 4, 5}
                                ,{5, 4, 3, 2, 1}};

        System.out.println(multiIntArray[1][1]);
        */
        int sum =0;
        for (int i:intArray) {
            sum += i;
            System.out.println(sum);
        }

    }
}
