package dsa2_lab7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The class provides timer methods to compare the runtime of a Stream and a
 * loop search of a corpus.
 *
 * @author saile
 */
public class CorpusSearch {

    // The corpus
    private ArrayList<ArrayList<Word>> corpus;

    /**
     * Create a CorpusSearch from a Negra export file in the current directory
     *
     * @throws FileNotFoundException When export file is not found.
     */
    public CorpusSearch() throws FileNotFoundException {
        this("tuebadz_1-50-utf8.export");
    }

    /**
     * Create a CorpusSearch from a Negra export file in {@code filename}
     *
     * @param fileName Path to NEGRA export file
     * @throws FileNotFoundException When export file is not found.
     */
    public CorpusSearch(String fileName) throws FileNotFoundException {
        corpus = new ArrayList<ArrayList<Word>>();
        SentenceBuilder build = new SentenceBuilder(fileName);

        while (build.hasNext()) {
            ArrayList<Word> sentence = build.next();
            corpus.add(sentence);
        }

    }

    // todo: complete the method below, applying stream filter using predicates

    /**
     * Search for {@code Predicate needle} in corpus. 
     * Return a {@code List} of {@code Word} elements matching the {@code Predicate}
     *
     * @param needle {@code Predicate} to search for
     * @return Return a {@code List} of {@code Word} elements matching the {@code Predicate}
     */
    public  List<Word> search(Predicate<Word> needle) {
        
        return corpus.stream()
                .flatMap(ArrayList::stream) // 将 corpus 中所有 ArrayList<Word> 展平为一个单一的 Stream<Word>。
                .filter(needle) // 根据 needle 条件对 Stream<Word> 进行筛选，保留符合条件的 Word。
                .collect(Collectors.toList()); // 将筛选后的结果收集到一个 List<Word> 中并返回
                /*
                 * flatMap()：
                 * 首先将流中的每个元素映射到一个新的流（可以看成是子流），然后将所有这些子流“展平”（flatten）
                 * 成一个单独的流。flatMap() 可以将多个流合并为一个流。
                 * 这个操作通常用于处理嵌套结构，如 List<List<T>> 或 Stream<Stream<T>>。
                 */

    }
}
