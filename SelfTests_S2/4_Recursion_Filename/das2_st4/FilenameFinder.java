package das2_st4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mkz
 */

public class FilenameFinder {

    /**
     * Collects the absolute path names of all directory entries
     *      equal to {@code entryName} into a List of Strings.
     * Start the collection at path {@code path}, if
     *      {@code path} is a directory continue collection in its subdirectories.
     * Note: 在指定的 path 目录中查找所有文件或文件夹名等于 entryName 的条目，并返回它们的绝对路径列表
     * @param entryName Name to search for
     * @param path Root of search
     * @return List with found items or empty list if nothing was found.
     */
    public static List<String> findEntryAtPath(String entryName, String path){

        // create an empty to store results
        List<String> result = new ArrayList<>();

        // create a file object with the path
        File file = new File(path);

        // add all matched entries' path into the result list
        findEntry(file, entryName, result);

        return result;

    }

    /**
     * Recursively search for the {@code entryName}
     * @param filOrDir
     * @param entryName the name to be searched for
     * @param result the absolute path collection
     */
    public static void findEntry(File filOrDir, String entryName, List<String> result){

        // base case: if entryname matches, add absolute path to list
        if (filOrDir.getName().equals(entryName)){
            result.add(filOrDir.getAbsolutePath());
        }

        // if it's directory, recursively check and add
        if (filOrDir.isDirectory()){
            // get all the members
            File[] members = filOrDir.listFiles();
            // make sure it's not null, if null, return directly
            if (members == null){
                return;
            } else {
                for (File member : members){
                    findEntry(member, entryName, result);
                }
                /*
                for (int i = 0; i < members.length; i++) {
                    File member = members[i];
                    findEntry(member, entryName, result);
                }
                 */
            }
        }

    }

}
