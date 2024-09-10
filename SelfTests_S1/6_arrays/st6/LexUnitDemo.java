package st6;

/**
 * @author mkz
 *
 * TASK: An implement of LexUnit.
 *      Ask for user prompt repeatly,
 *      print all lexunits in the array.
 */

import java.util.*;
import java.io.*;

public class LexUnitDemo {

    public static void main(String[] args) {

        // initialise
        String input, wf, syn;
        LexUnit rval = new LexUnit();

        // prompt
        System.out.println("Enter a word and its synonyms: ");

        // read the input line
        Scanner sc = new Scanner(System.in);
        Scanner lineScan;
        input = sc.nextLine();
        // If input not null, scan this input
        if (input.length() != 0){
            lineScan = new Scanner(input);
            // the first token is wordform
            wf = lineScan.next();
            rval = new LexUnit(wf);
            // read the rest of the input line, they are synonyms
            while (lineScan.hasNext()){
                syn = lineScan.next();
                rval.addSynonym(syn);
            }
        }

        String result1 = rval.toString();
        System.out.println("INPUTED: " + result1);

        rval.addSynonym("cheerful");
        rval.addSynonym("sunny");
        String result2 = rval.toString();
        System.out.println("NEW: " + result2);

        rval.setWordForm("sad");
        rval.addSynonym("tear");
        rval.addSynonym("sorrow");
        System.out.println(rval.getWordForm() + rval.getSynonyms());
        String result3 = rval.toString();
        System.out.println("UPDATED: " + result3);


    }



}
