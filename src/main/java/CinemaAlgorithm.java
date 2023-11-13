import java.util.Scanner;

public class CinemaAlgorithm {
    public void CategoryChecker(){
        byte people, ageOne, studentOne, ageTwo, studentTwo, total, end = 0;
        String categories;
        Scanner scan = new Scanner(System.in);

        while (end == 0) {
            studentOne = 1;
            studentTwo = 1;
            // people filter
            System.out.println("Introduce the number of people (1 or 2 only):");
            people = scan.nextByte();

            if (people < 1 || people > 2) {
                System.out.println("Only 1 or 2 >:)");
                return;
            }

            if (people == 1) {
                System.out.println("Introduce the age of the person: (a number)");
                ageOne = scan.nextByte(); // duplicated, people can be a class? with a person as objects :0
                if (ageOne < 17) {
                    System.out.println("Does 'it' has a student credential? Type a number: \n True: 0 \n False: 1");
                    studentOne = scan.nextByte();
                    if (studentOne < 0 || studentOne > 1) {
                        System.out.println("That is not a valid option (student credential)");
                        return;
                    }
                }

                if (ageOne < 13) {
                    categories = "G";
                    if (studentOne == 0) {
                        total = 35;
                    } else {
                        total = 60;
                    }
                } else if (ageOne <= 16) {
                    categories = "G, PG";
                    if (studentOne == 0) {
                        total = 35;
                    } else {
                        total = 60;
                    }
                } else {
                    categories = "G, PG, R";
                    total = 60;
                }

            } else { // 2 people
                System.out.println("Introduce the information of the first person: \n Introduce the age of the person: (a number)");
                ageOne = scan.nextByte(); // duplicated, people can be a class? with a person as objects :0
                if (ageOne < 17) {
                    System.out.println("Does 'it' has a student credential? Type a number: \n True: 0 \n False: 1");
                    studentOne = scan.nextByte();
                    if (studentOne < 0 || studentOne > 1) {
                        System.out.println("That is not a valid option (student credential)");
                        return;
                    }
                }

                System.out.println("Introduce the information of the second person: \n Introduce the age of the person: (a number)");
                ageTwo = scan.nextByte(); // duplicated, people can be a class? with a person as objects :0
                if (ageTwo < 17) {
                    System.out.println("Does 'it' has a student credential? Type a number: \n True: 0 \n False: 1");
                    studentTwo = scan.nextByte();
                    if (studentTwo < 0 || studentTwo > 1) {
                        System.out.println("That is not a valid option (student credential)");
                        return;
                    }
                }

                if (ageOne >= 17 || ageTwo >= 17) {
                    if (ageOne < 13 || ageTwo < 13) {
                        categories = "G, PG";
                        if (studentOne == 0 || studentTwo == 0) {
                            total = 95;
                        } else {
                            total = 120;
                        }
                    } else {
                        categories = "G, PG, R";
                        if (ageOne >= 17 && ageTwo >= 17) {
                            total = 120;
                        } else {
                            if (studentOne == 0 || studentTwo == 0) {
                                total = 95;
                            } else {
                                total = 120;
                            }
                        }
                    }
                } else {
                    if (ageOne < 13 || ageTwo < 13) {
                        categories = "G";
                        if (studentOne == 0 && studentTwo == 0) {
                            total = 70;
                        } else if (studentOne == 0 || studentTwo == 0) {
                            total = 95;
                        } else {
                            total = 120;
                        }
                    } else {
                        categories = "G, PG";
                        if (studentOne == 0 && studentTwo == 0) {
                            total = 70;
                        } else if (studentOne == 0 || studentTwo == 0) {
                            total = 95;
                        } else {
                            total = 120;
                        }
                    }
                }
            }
            System.out.println("You can watch movies with these categories: " + categories + ". The total is: $" + total);
            System.out.println("\nDid you finish? \n FINISH: 1 \n CONTINUE: 0 ");
            end = scan.nextByte(); // It crashes if you type a character :(
            if (end != 0 && end != 1) {
                System.out.println("xd");
                end = 0;
            }
        }
    }
}
