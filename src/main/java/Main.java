import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        //set variables
        double baseRate = 29.99;
        double tollTag = 3.95;
        double gps = 2.95;
        double roadside = 3.95;

        //questions
        String pickUpDate = readLine(myScanner,"Please enter the desired pick up date:");
        int days = readInt(myScanner, "Please enter the number of rental days:");
        boolean wantTollTag = readBoolean(myScanner, "Add electronic toll tag for $3.95/day? (yes/no):");
        boolean wantGps = readBoolean(myScanner, "Add GPS for $2.95/day? (yes/no):");
        boolean wantRoadside = readBoolean(myScanner, "Add roadside assistance for for $3.95/day? (yes/no):");
        int age = readInt(myScanner, "Please enter your age:");

        double basicRental = baseRate * days;

        double optionsAdd = 0.00;
        if (wantTollTag) {
            optionsAdd += tollTag;
        }
        if (wantGps) {
            optionsAdd += gps;
        }
        if (wantRoadside) {
            optionsAdd += roadside;
        }

        double optionsCost = optionsAdd * days;

        double underageCharge = 0.00;
        if (age < 25) {
            underageCharge = basicRental * 0.30;
        }

        double total = basicRental + optionsCost + underageCharge;

        //output
        System.out.printf("Basic car rental price for %d days: $%.2f%n", days, basicRental);
        System.out.printf("Options charge: $%.2f%n", optionsCost);
        System.out.printf("Underage driver surcharge: $%.2f%n", underageCharge);
        System.out.printf("TOTAL: $%.2f%n", total);

    }

    //parameter
    public static String readLine(Scanner in, String condition) {
        System.out.println(condition);
        return in.nextLine();
    }

    public static int readInt(Scanner in, String condition) {
        System.out.println(condition);
        int number = in.nextInt();
        in.nextLine();
        return number;
    }
    public static boolean readBoolean(Scanner in, String condition) {
        while (true) {
            System.out.println(condition);
            String answer = in.nextLine();

            switch  (answer) {
                case "yes":
                    return true;
                case "no":
                    return false;
                default:
                    System.out.println("Please enter only 'yes' or 'no'.");
            }

        }

    }
}