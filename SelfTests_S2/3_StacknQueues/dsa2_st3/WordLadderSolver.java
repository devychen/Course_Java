package dsa2_st3;

/**
 * Description:
 *  A program to find a word ladder between 2 words, where each word in the
 *  ladder is a word found in a dictionary.
 * 
 *  Reads a file with words and their neighbors into Word objects and
 *  creates an ArrayList<Word> dictionary.
 *
 * @author mkz
 * TASK: Based on starter codes given, complete the todos.
 */
import java.util.*;
import java.io.*;

public class WordLadderSolver {
    
    ArrayList<Word> dict;  // Word is an inner class
    
    /**
     * Construct a WordLadderSolver using the dictionary contained in filename
     * @param filename the name of the dictionary file
     */
    public WordLadderSolver(String filename) throws FileNotFoundException {
        readFile(filename);
    }
    
    /** note 读取词典文件，存入dict
     * Read in the dictionary from filename.
     * Each line in the dictionary contains a word followed by its neighbors
     */
    private void readFile(String filename) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filename));
        String line, wrd;
        ArrayList<String> wordsNeighbors;
        String[] wordsOnLine;
        
        // initialize dict to empty list
        ArrayList<Word> dict = new ArrayList<Word>();
        
        // fill the dictionary with all the words and their neighbors
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            wordsOnLine = line.split("\\s");
            
            // the word is the first thing on the line
            wrd = wordsOnLine[0];
            wordsNeighbors = new ArrayList<String>();
            
            // then come the words that differ by only one character
            for (int i=1; i < wordsOnLine.length; i++) {
                wordsNeighbors.add(wordsOnLine[i]);
            }
            
            // create a Word object and add it to the dictionary
            dict.add(new Word(wrd, wordsNeighbors));
        }
        scan.close();
        
        // sort the dictionary for fast lookup with binary search
        Collections.sort(dict);
    }
    
    /** note 寻找单词阶梯word-ladder
     * Find the word ladder between from and to if possible
     * @param from the starting word
     * @param to the resulting word
     * @return an ArrayList<String> containing the words in the ladder, or
     * null if no ladder could be found
     */
    public Stack<String> solve(String from, String to) {
        
        Stack<String> aStack; // to reference stacks removed from the queue
        Stack<String> solution = null; // return value
        boolean done;         // control for main loop
        Word aWord;           // to reference a Word in the dictionary
        String topWord;       // top word as a String
        int topIndex;         // index of top word in the dictionary array
        Stack<String> stackCopy;  // to store a copy of the current stack
        
        // use java's linked list as a queue:
        // add to end with offer method
        // remove from front with poll method
        LinkedList<Stack<String>> queue = new LinkedList<Stack<String>>();
        
        // get indexes of from and to in the dictionary using binary search
        int fromIndex = Collections.binarySearch(dict, new Word(from)); // note 二分查找
        int toIndex = Collections.binarySearch(dict, new Word(to));
        
        // if from and to are not both in the dictionary return null
        // it means no ladder is possible
        // todo
        if ((fromIndex < 0) || (toIndex < 0))  {
            return null;
        }
        
        /*
         * Initialize the queue of stacks. Each stack contains <from> on the
         * bottom and one of from's neighbor words on top.
         */
        
        // todo
        
        
        /*
         * Loop until we are done (a ladder was found) or
         * the queue is empty (no ladder exists)
         * Make sure no word is contained twice in the same stack.
         */        
        done = false;
        while (!queue.isEmpty() && !done) {
            
            // remove a stack from the queue
            /**********    To Do    **********/
            
            // peek at the top word
            /**********    To Do    **********/
            
            
            // find the top Word in the dictionary (use binary search)
            /**********    To Do    **********/
            
            /* 
             * Create stacks for top word's neighbors and add them to the queue,
             * but first make sure that the neighbor is not already on the stack.
             * We are done if the neighbor is the ending word in the ladder
             */
            /**********    To Do    **********/
            
        }
        return solution;
    }
    
    /*
     * Inner class to store a word in the dictionary and its neighbors
     *  implements interface `Comparable` for sorting and comparing
     */
    private class Word implements Comparable<Word> {  // NOTE- `Comparable`, predefined interface in pkg `java.lang`
                                                    //      only one method for the class to implement: `compareTo(T o)`
                                                    //      word这里，比较的是顺序，如c<d（rval<0）, c+c(0), c>b(>0)
        private String word;
        private ArrayList<String> neighbors;
        
        public Word(String aWord) {
            word = aWord;
            neighbors = null;
        }
        
        public Word(String aWord, ArrayList<String> theNeighbors) {
            word = aWord;
            neighbors = theNeighbors;
        }

        // note 判断两个Word对象是否相等
        public boolean equals(Object otherObj) {
            if (otherObj == null) {
                return false;
            }
            if (otherObj.getClass() != getClass()) {
                return false;
            }
            
            Word otherWord = (Word) otherObj;
            return (this.word.equals(otherWord.word));
        }

        // note 用于按字典序排序
        public int compareTo(Word otherWord) {
            return this.word.compareTo(otherWord.word);
        }

        // note 返回字符串表示
        public String toString() {
            String rval = word + " ";
            for (String s : neighbors) {
                rval += s + " ";
            }
            return rval;
        }
    }
    
    
    /*
     * Demo program that takes 2 words of length 4 as arguments
     * and finds the ladder between them.
     * note main用于运行程序，它接收两个长度为4的单词作为参数并查找它们之间的阶梯。
     */
    public static void main(String[] args) {  

        // note 如果输入不符合要求，提示用户并退出
        if (args.length != 2) {
            System.out.println("usage: java WordLadderSolver <word> <word>");
            System.out.println("each word should be of length 4");
            System.exit(0);
        }
        if ((args[0].length() != 4) || (args[1].length() != 4)) {
            System.out.println("Words must both be 4 letters long!");
            System.exit(0);
        }

        // note 使用词典文件进行单词查找
        //  调用solver方法寻找ladder，根据结果输出找到的ladder或未找到
        try {
            WordLadderSolver ladderSolver = 
                new WordLadderSolver("wordlistWithNeighbors4.txt");
            Stack<String> ladder = ladderSolver.solve(args[0], args[1]);
            
            if (ladder == null) {
                System.out.println("no ladder found :-(");
            } else {
                System.out.println(ladder);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}


/** NOTE




 */