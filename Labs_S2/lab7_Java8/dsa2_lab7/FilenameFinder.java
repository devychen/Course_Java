package dsa2_lab7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate; // added

/**
 * @author mkz
 * Task: Instead of using `equals()` to decide when a file name matches the parameter {entryName},
 *      Please rewrite your FilenameFinder and use a Predicate as a criteria for file name selection. 
 *      You can use ur previous FilenameFinder or the codes provided.
 */

public class FilenameFinder {
    /**
     * Collect file or directory names equal to {@code entryName} and 
     * store the absolute pathname to the found entry in a List. 
     * Start the collection at path {@code path}. 
     * If {@code path} is a directory continue collection in its sub directories.
     * @param entryName Name to search for
     * @param path root of search
     * @return List with found items or empty list if nothing was found.
     */
    // todo: Change to Predicate interface
    public static List<String> findEntryAtPath(String path, Predicate<String> entryName) {
        List<String> entryList = new ArrayList<>();

        File fileOrDir = new File(path);

        // Collect all entries into entryList
        realFind(entryList, entryName, fileOrDir);

        return entryList;
    }

    // todo: replace `equals()` with Predicate
    private static void realFind(List<String> entryList, Predicate<String> entryName, File fileOrDir) {
        // If name matches add absolute path to list
        if (fileOrDir.isFile()){
            if (entryName.test(fileOrDir.getName())) {
             entryList.add(fileOrDir.getAbsolutePath());
            }
        }

        // if entry is a directory search all directory members for entryName
        if (fileOrDir.isDirectory()) {
            File[] directoryList = fileOrDir.listFiles();

            if (directoryList == null) {
                return;
            }

            for (File currentFile : directoryList) {
                realFind(entryList, entryName, currentFile);
            }
        }
    }

//     // light testing
//    public static void main(String[] args) {
//        String path = "resources/snook.moo";
//        List<String> entryList = FilenameFinder.findEntryAtPath(path, s -> s.equals("snook.moo"));
//        System.out.println(entryList);
//    }
}
