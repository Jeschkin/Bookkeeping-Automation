import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new  Scanner(System.in);
        boolean exitFlag = false ;
        boolean isYearRepUp = false;
        boolean isMonthlyRepUp = false;


        while (!exitFlag){
            printMenu();
            String command = scanner.nextLine();

            if (command.equals("root")) {
                System.out.println("Exiting the program...");
                exitFlag = true;



               /* for (int i = 1; i <= 3; i++) {

                    String string = String.format("%02d", i);
                    Month month = new Month(string);
                    month.parsing("resources/m.2021" + string + ".csv");
                    isMonthlyRepUp = true;
                }*/



            } else if (command.equals('2')  ) {
                Year year = new Year();
                year.parsing();
                System.out.println(year.toString());
                isYearRepUp = true;

            } else if (command.equals('3') ) {

                if (isYearRepUp && isMonthlyRepUp ){

                    Integer result = 0 ;

                    if (result == 0) {
                        System.out.println("The expenses for month " +   " match in the annual and monthly reports.");
                    } else if (result > 0) {
                        System.out.println("The expenses for month " +   " are higher in the annual report than in the monthly report.");
                    } else {
                        System.out.println("The expenses for month " +   " are higher in the monthly report than in the annual report.");
                    }
                }
                else {
                    System.out.println("Unable to execute command. Read monthly and annual reports.");
                }

            }else if (command.equals('4')  ) {
                if ( isMonthlyRepUp ){

                }
                else {
                    System.out.println("Unable to perform command. Read monthly reports." );
                }

            }else if (command.equals('5')  ) {
                if (isYearRepUp  ){

                }
                else {
                    System.out.println("Unable to perform command. Read yearly report." );
                }

            }
            else {
                System.out.println("Invalid command.");
            }

        }
    }



    static void printMenu() {
        System.out.println("\n"+
                "What would you like to do?\n" +
                "\n" +
                "1- Read all monthly reports.\n" +
                "2- Read the annual report.\n" +
                "3- Compare reports.\n" +
                "4- Display information about all monthly reports.\n" +
                "5- Display information about the annual report.\n" +
                "\n");
    }


}