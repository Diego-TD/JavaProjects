import java.util.Scanner;

public class CinemaAlgorithm {
    public void CategoryChecker(){
        byte people, ageOne, studentOne, ageTwo, studentTwo;
        String categories, ticketOne, ticketTwo;
        float money; // apparently it is unnecessary
        Scanner scan = new Scanner(System.in);

        // people filter
        System.out.println("Introduce the number of people (1 or 2 only):");
        people = scan.nextByte();

        if (people < 1 || people > 2) {
            System.out.println("Only 1 or 2 >:)");
            return;
        }

        // clean buffer?

        if (people == 1){
            System.out.println("Introduce the age of the person: (a number)");
            ageOne = scan.nextByte();

            if (ageOne < 16) {
                System.out.println("Does 'it' has a student credential? Type a number: \n True: 0 \n False: 1");
                studentOne = scan.nextByte();
                if (studentOne < 0 || studentOne > 1){
                    System.out.println("That is not a valid option (student credential)");
                    return ;
                }
            }

            switch (ageOne){
                ///
            }

            if (ageOne < 13) {
                categories = "G";
                if (studentOne == 0){
                    ticketOne = "$35";
                    System.out.println("You can watch movies with these categories: " + categories + ". Your ticket would cost: " + ticketOne);
                } else {
                    ticketOne = "$60";
                    System.out.println("You can watch movies with these categories: " + categories + ". Your ticket would cost: " + ticketOne);
                }
            } else if (ageOne >= 13 && ageOne <16) {
                categories = "G, PG";
                if (studentOne == 0){
                    ticketOne = "$35";
                    System.out.println("You can watch movies with these categories: " + categories + ". Your ticket would cost: " + ticketOne);
                } else {
                    ticketOne = "$60";
                    System.out.println("You can watch movies with these categories: " + categories + ". Your ticket would cost: " + ticketOne);
                }
            } else {
                categories = "G, PG, R";
                ticketOne = "$60";
                System.out.println("You can watch movies with these categories: " + categories + ". Your ticket would cost: " + ticketOne);
            }


        } else { // 2
            System.out.println("Introduce the information of the first person: \n Introduce the age of the person: (a number)");
            ageOne = scan.nextByte();
            System.out.println("Does 'it' has a student credential? Type a number: \n True: 0 \n False: 1");
            studentOne = scan.nextByte();

            System.out.println("Introduce the information of the second person: \n Introduce the age of the person: (a number)");
            ageTwo = scan.nextByte();
            System.out.println("Does 'it' has a student credential? Type a number: \n True: 0 \n False: 1");
            studentTwo = scan.nextByte();

            if (studentOne < 0 || studentOne > 1 && studentTwo < 0 || studentTwo > 1){
                System.out.println("That is not a valid option (student credential)");
                return;
            }


        }

        // clean buffer?


    }
}
