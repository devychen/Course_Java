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

        // declare the variables
        Stack<String> tags = new Stack<>();
        int begin = 0; // means the beginning index of a tag
        int end = 0; // the end index of a tag

        // case 1: false when null or empty input
        if (xml == null || xml.isEmpty()) return false;

        // case 2: false when malformed beginning
        if (!xml.startsWith("<") || xml.startsWith("</")) return false;

        // case 3: false when malformed ending
        if (!xml.endsWith(">") || xml.endsWith(">>") || xml.endsWith("/>")) return false;

        // case 4: false if "<>" or contains "<>", or no ending tags, or no any tags markers
        if (xml.contains("<>")||
                !xml.contains("/") ||
                !xml.contains("<") ||
                !xml.contains(">")) return false;

        // case 5: mismatch pairs of "<" and ">"
        int count = 0;
        for (int n = 0; n < xml.length(); n++) {
            if (xml.charAt(n) == '<') {
                count++;
            } else if (xml.charAt(n) == '>') {
                count--;
            }
        }
        if (count != 0) {
            return false;
        }

        // general case
        for (int i = 0; i< xml.length(); i++){
            if (xml.charAt(i) == '<'){
                begin = i + 1;
                end = xml.indexOf('>', i);

                // handle self-closing tags
                if (end > 1 && xml.charAt(end - 1) == '/') {
                    // It's a self-closing tag
                    String tag = xml.substring(begin, end - 1); // tag content
                    continue; // No need to push to stack
                }

                String tag = xml.substring(begin, end); // tag content

                // is it a begin-tag or end-tag?
                if (!tag.startsWith("/")) {
                    tags.push(tag); // it's begin-tag, push onto stack
                } else{
                    // it's end tag
                    if (tags.isEmpty() ||
                            !tags.pop().equals(tag.substring(1))) {
                        return false;
                    }
                }
                i = end;
            }
        }
        return tags.isEmpty();
    }

    // light testing
    public static void main(String[] args) {
        String xml =  "<tag></tag>";
        if(wellformedXML(xml)){
            System.out.println("\"" + xml + "\"" + " is WELL-formed");
        } else{
            System.out.println("\"" + xml + "\"" + " is MAL-formed");
        }
    }

}
