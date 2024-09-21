package dsa2_lab1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author mkz
 * TASK: Complete the class based on html file.
 *      First write the class `Word` then this one.
 *
 */

public class SentenceBuilder {

    // instance variables
    private BufferedReader br;
    private String line;

    // --- constructors ---

    /**
     * Create a SentenceBuilder for the TuBa export file filename.
     * Throws FileNotFoundException when filename does not refer to a file.
     *
     * @param fileName export filename
     * @throws FileNotFoundException
     */
    public SentenceBuilder(String fileName) throws FileNotFoundException {
        try {
            br = new BufferedReader(new FileReader(fileName));
            line = br.readLine();
        } catch (FileNotFoundException e) {  // NOTE: FileNotFoundException actually extends IOException
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --- helper methods ---

    /**
     * Return true if there is another sentence
     * to process in the file associated with this SentenceBuilder.
     *
     * @return
     */
    public boolean hasNext() throws IOException {

        if (line == null) {
            return false;
        }

        while (line != null) {
            if (line.startsWith("#BOS")) {
                return true;
            }
            line = br.readLine();
        }

        return false;
    }

    /**
     * Return the next sentence in the corpus as an ArrayList of Words.
     *
     * @return The next sentence in the corpus as an ArrayList of Words.
     */
    public ArrayList<Word> next() throws IOException {

        // first check if there is next sentence
        if (!hasNext()) throw new IOException("No next sentence.");

        // create an arraylist to store
        ArrayList<Word> words = new ArrayList<>();

        // detect the next sentences by checking the head #BOS
        while (line != null) {
            if (line.startsWith("#BOS")) { // if it's BOS
                line = br.readLine(); // store as a line, proceed content...
                while (!line.startsWith("#EOS")) {// keep reading whennot/until EOS
                    if (line.startsWith("#")) {
                        line = br.readLine(); // read current line but...
                        continue; // ...skip it
                    }
                    String[] tokens = line.split("\\s+"); // split tokens
                    words.add(new Word(tokens[0], tokens[1])); // word(wordform, token)
                    line = br.readLine(); // keep reading
                }


            }

            // continuing read lines, until reach the end #EOS
            if (line.startsWith("#EOS")) break;
            line = br.readLine();

        }
        return words;

    }

}

