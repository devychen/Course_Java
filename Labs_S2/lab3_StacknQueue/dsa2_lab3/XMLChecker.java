package dsa2_lab3;

import java.util.Stack;
import java.util.*;

/**
 * @author mkz
 * TASK: ex2. write the method to implement the algorithm which
 *      could handle the XMLs in example.txt.
 *      Don't use regex or xml parsing library
 */

public class XMLChecker {

    public static boolean wellformedXML(String xml){

        // case 1: null or empty input
        if (xml == null || xml.isEmpty()){
            return false;
        }

        // declare the template
        String begin = "<tag>";
        int beginLen = begin.length();
        String end = "</tag>";
        int endLen = end.length();

        // declare the stack
        Stack<String> stack = new Stack<>();

        // read the begin-tag
        for (int i = 0; i < xml.length(); i++){
            // false if b-tag is malformed
            if (!xml.substring(i, i + beginLen).equals(begin)){
                return false;
            } else {
                // push begin-tag onto the stack
                stack.push(begin);
                // skip past the begin-tag, proceed to later chars
                i += beginLen - 1;
            }
        }





        // if all matched, should have an empty stack in the end
        return stack.isEmpty();
    }

    // light testing
    public static void main(String[] args) {
        String xml =  "abc";
        if(wellformedXML(xml)){
            System.out.println("Well-formed XML");
        } else{
            System.out.println("Malformed XML");
        }
    }

}
