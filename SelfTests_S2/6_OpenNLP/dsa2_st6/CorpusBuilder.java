package dsa2_st6;

/**
 * @author mkz
 * TASK: Based on source codes, write a class CorpusBuilder which 
 *  takes a String in the constructor and creates POS and Lemma annotations 
 *  for the text with OpenNLP.
 * 
 */

import opennlp.tools.*;
import java.io.*;
import java.util.*;

public class CorpusBuilder {

    // stub, instance variables
    private String text;
    private String[] sentences;
    private ArrayList<List<String>> lemmas, tokens, posTags;


    /**
     * Create a CorpusBuilder which generates POS tags and Lemmas for text.
     * 
     * @param text The text which should be annotated.
     */
    CorpusBuilder(String text) {
        // todo
        this.text = text;
        generateSentences(text);
        generateTokens();
        generateLemmas();
        generatePosTags();


    }

    public void generateSentences(String text){
        if(getSentences() == null){  // means the sentences is not initialised / segmented yet
            try (InputStream modelIn = new FileInputStream("de-sentence.bin")){ // read inputfile
                SentenceModel model = new SentenceModel(modelIn); // pre-traied model 模型
                SentenceDetectorMe sentenceDetector = new SentenceDetectorMe(model); // the detector 分割器
                this.sentences = sentenceDetector.sentDetect(text);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        /* 例：this.sentences = ["Hello world!", "This is a test sentence.", "How are you?"]; */
    }

    public void generateTokens(){
        tokens = new ArrayList<>();
        if (getSentences().length > 0){
            try(InputStream modelIn = new FileInputStream("de-tokens.bin")){
                TokenizerModel model = new TokenizerModel(modelIn);
                Tokenizer tokenizer = new Tokenizer(model);
                for (String s: getSentences()){
                    /* 转写
                     for (int i = 0; i < getSentences().length; i++) {
                     String s = getSentences()[i]; }
                     */
                    String[] tokens = tokenizer.tokenize(s);
                    ArrayList<String> tokenList = new ArrayList<>(); // create an arraylist to store tokens
                    /* 
                     make sure the double quotes are recognised as separate tokens
                     如果含"且长度大于1，说明是复合token，需要用将双引号分离出来，即"word"到" word "
                     使得“变为单独的token
                    */
                    for (String t: tokens){
                        if (t.contains("\"") && t.length() > 1){
                            t = t.replaceAll("\"", " \" ").trim();
                        } else {
                            tokenList.add(t);
                        }
                    }
                    getTokens().add(tokenList);
                }
            } catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    public void generateLemmas(){
        lemmas = new ArrayList<>();
        if(getTokens().size() > 0){
            try (InputStream modelIn = new FileInputStream("de-lemmatizer.bin")){
                LemmatizerModel model = new LemmatizerModel(modelIn);
                Lemmatizer lemmatizer = new Lemmatizer(model);

                for (int i = 0; i < token.size(); i++){
                    List<String> st = tokens.get(i);
                    List<String> tmpPos = posTags.get(i);
                    String[] tmpLemmas = lemmatizer.lemmatize
                            (st.toArray(new String[0], tmpPos.toArray((new String[0]))));
                    lemmas.add(Array.asList(tmpLemmas));
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        /*
        `lemmatize(String[] tokens, String[] posTags)`作用：
                         String[] lemmas = lemmatizer.lemmatize(
                         new String[] {"The", "cats", "are", "running", "fast"},
                         new String[] {"DT", "NNS", "VBP", "VBG", "RB"}
         会返回lemmas = ["the", "cat", "be", "run", "fast"];
);

         */

    }

    public void generatePosTags(){
        posTags = new ArrayList<>();
        if (getTokens().size() > 0) {
            try (InputStream modelIn = new FileInputStream("de-pos.bin")) {
                POSModel model = new POSModel(modelIn);
                POSTaggerME tagger = new POSTaggerME(model);
                for (List<String> st : getTokens()) {
                    String[] tags = tagger.tag(st.toArray(new String[0]));
                    posTags.add(Arrays.asList(tags));

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    

    

    // no need to change the rest

    /**
     * Returns the text of this CorpusBuilder
     * 
     * @return The text of this CorpusBuilder
     */
    public String getText() {
        return text;
    }

    /**
     * Return an array with the sentences of the CorpusBuilder
     * 
     * @return An array with the sentences of the CorpusBuildr
     */
    public String[] getSentences() {
        return sentences;
    }

    /**
     * Return a List of List with the tokens/words of the text of CorpusBuilder. The
     * first list holds the words of the
     * first sentence, the second list holds the words of the second sentence and so
     * on.
     * 
     * @return A List of List the tokens/words of the text of the CorpusBuilder.
     */
    public List<List<String>> getTokens() {
        return tokens;
    }

    /**
     * Return a List of List with the POS tags of the text of CorpusBuilder. The
     * first list holds the POS tags of the
     * first sentence, the second list holds the POS tags of the second sentence and
     * so on.
     * 
     * @return A List of List with the POS tags of the text of CorpusBuilder.
     */
    public List<List<String>> getPosTags() {
        return posTags;
    }

    /**
     * Return a List of List with the Lemmas of the text of CorpusBuilder. The first
     * list holds the lemmas of the
     * first sentence, the second list holds the Lemmas of the second sentence and
     * so on.
     * 
     * @return A List of List with the Lemmas of the text of CorpusBuilder.
     * @return
     */
    public List<List<String>> getLemmas() {
        return lemmas;
    }

}
