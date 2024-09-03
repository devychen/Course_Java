package st1;

import java.util.Scanner;

/**
 * @author: mkz
 * St1, Ex2
 * Task: Pick points for game character's 3 characteristics
 */

public class CharacterDesign {

    public static void main(String[] args) {

        // initialise
        String name;
        int strength = 0, intelligence = 0, luck = 0;
        int total  = strength + intelligence + luck;

        Scanner sc = new Scanner(System.in);

        // input name
        System.out.print("Enter the name of your character: ");
        name = sc.next();

        // input strength
        System.out.print("Enter strength (1-10): ");
        strength = sc.nextInt();

        // input intelligence
        System.out.print("Enter intelligence (1-10): ");
        intelligence = sc.nextInt();

        // input luck
        System.out.print("Enter luck (1-10): ");
        luck = sc.nextInt();

        // auto points assigned if total > 15
        if (total > 15) {
            System.out.println("You have given your character too many points! \n" +
                    "Default values have been assigned." );
            strength = intelligence = luck = 5;
        }

        // output
        System.out.println(name +
                " [strength: " + strength +
                ", intelligence: " + intelligence +
                ", luck: " + luck +
                "]");

        sc.close();

    }

}

