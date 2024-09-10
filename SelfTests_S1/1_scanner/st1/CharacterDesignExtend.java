package st1;

import java.util.Scanner;

/**
 * @author: mkz
 * St1, Ex3
 * Task: Notifies the user if:
 *      at least one of the variables is not in the admitted range,
 *      and assigns the default value 5 to each variable.
 */

public class CharacterDesignExtend {

    public static void main(String[] args) {

        // initialise
        String name;
        int strength, intelligence, luck;

        Scanner sc = new Scanner(System.in);

        // input name
        System.out.print("Enter the name of your character: ");
        name = sc.next();

        // input strength
        System.out.print("Enter strength (1-10): ");
        strength = sc.nextInt();
        if (strength > 10 || strength < 1) {
            System.out.println("Out of range, has reset to default value 5");
            strength = 5;
        }

        // input intelligence
        System.out.print("Enter intelligence (1-10): ");
        intelligence = sc.nextInt();
        if (intelligence > 10 || intelligence < 1){
            System.out.println("Out of range, has reset to default value 5");
            intelligence = 5;
        }

        // input luck
        System.out.print("Enter luck (1-10): ");
        luck = sc.nextInt();
        if (luck > 10 || luck < 1){
            System.out.println("Out of range, has reset to default value 5");
            luck = 5;
        }

        int total  = strength + intelligence + luck;
        if (total > 15){
            System.out.println("You have given your character too many points!"
                    + " Default values have been assigned:");

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
