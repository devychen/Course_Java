package das2_lab9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author mkz
 *
 */

public class POSDict {

    private final HashMap<String, List<String>> dict;

    /**
     * Default constructor
     * Load a file {dict.dat} which is located in current dir
     * Should pass exceptions
     * @throws IOException
     */
    public POSDict() throws IOException {
        this.dict = new HashMap<>();
    }

    /**
     * Map file to dict. Read file and add each word & tag to the dict.
     * @param path
     * @throws IOException
     */
    public void map(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line, word, tag;
            while ((line = br.readLine()) != null) {
                String[] dictList = line.split("\\s+"); // 每一行变为 able jj -> dictList = ["able", "jj"]
                if (dictList.length == 2) {
                    word = dictList[0]; // 第一个元素是word, case-sensitive
                    tag = dictList[1].toLowerCase(); // 第二个元素是tag，case-insensitive

                    if(dict.containsKey(word)) { // 如果词典中已包含该单词，则将标签添加到对应的列表中
                        dict.get(word).add(tag);
                    } else { // 如果词典中不包含该单词，则创建一个新的列表，并将标签添加进去
                        dict.put(word, new ArrayList<>()); // 为该单词创建新的标签列表
                        dict.get(word).add(tag); // 将标签添加到该单词的标签列表中
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Whether {aWord} is of type posTag. Case-insensitive.
     * Case-sensitive for words.
     * @param aWord
     * @param posTag
     * @return
     */
    public boolean hasPOS(String aWord, String posTag){
        List<String> tags = dict.get(aWord); // 从词典中获取该单词对应的所有词性标签
        // 如果该单词存在，并且标签列表中包含指定的词性（转换为小写），则返回 true
        return tags != null && tags.contains(posTag.toLowerCase());
    }
}
