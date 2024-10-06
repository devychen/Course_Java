package examples;

import java.util.Arrays;

public class HashingTim {

    public static void main(String[] args) {
        // 创建一个大小为 26 的哈希表（数组），用于存放名字（对应A-Z的索引）
        String[] hashTable = new String[26];

        // 向哈希表中插入几个名字
        insert(hashTable, "Alice");
        insert(hashTable, "Bob");
        insert(hashTable, "Tim");

        // 显示哈希表的内容
        System.out.println("Hash Table: " + Arrays.toString(hashTable));

        // 查找名字 "Tim"
        String nameToFind = "Tim";
        boolean found = search(hashTable, nameToFind);

        if (found) {
            System.out.println(nameToFind + " is found in the hash table.");
        } else {
            System.out.println(nameToFind + " is not found in the hash table.");
        }
    }

    // 插入名字到哈希表中
    public static void insert(String[] hashTable, String name) {
        // 计算名字的哈希码：取名字的第一个字母
        int hashCode = name.charAt(0) - 'A';

        // 将名字存放到哈希表中对应的哈希码位置
        hashTable[hashCode] = name;
    }

    // 查找名字是否存在于哈希表中
    public static boolean search(String[] hashTable, String name) {
        // 计算名字的哈希码：取名字的第一个字母
        int hashCode = name.charAt(0) - 'A';

        // 查找哈希表中该哈希码位置的元素是否等于要查找的名字
        return hashTable[hashCode] != null && hashTable[hashCode].equals(name);
    }
}
