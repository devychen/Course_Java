package de.uni.tuebingen.sfs.java2.Corpus;

import opennlp.tools.lemmatizer.LemmatizerME;
import opennlp.tools.lemmatizer.LemmatizerModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CorpusBuilder {
    private String text;
    private String[] sentences;
    private ArrayList<List<String>> tokens;
    private ArrayList<List<String>> posTags;
    private ArrayList<List<String>> lemmas;

    /**
     * Create a CorpusBuilder which generates POS tags and Lemmas for text.
     * @param text The text which should be annotated.
     */
    CorpusBuilder(String text) {
        this.text = text;
        extractSentences(text);
        extractTokens();
        extractPosTags();
        extractLemma();
    }

    private void extractPosTags() {
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

    private void extractLemma()  {
       lemmas = new ArrayList<>();
       if (getTokens().size()>0)  {
           try (InputStream modelIn = new FileInputStream("de-lemmatizer.bin")) {
               LemmatizerModel model = new LemmatizerModel(modelIn);
               LemmatizerME lemmatizer = new LemmatizerME(model);

               for (int i = 0; i<tokens.size(); i++ )   {
                   List<String> st = tokens.get(i);
                   List<String> tmpPos = posTags.get(i);
                   String[] tmpLemmas = lemmatizer.lemmatize(st.toArray(new String[0]),tmpPos.toArray((new String[0])));
                   lemmas.add(Arrays.asList(tmpLemmas));
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }

    private void extractTokens() {
        tokens = new ArrayList<>();
        if (getSentences().length > 0) {
            try (InputStream modelIn = new FileInputStream("de-tokens.bin")) {
                TokenizerModel model = new TokenizerModel(modelIn);
                Tokenizer tokenizer = new TokenizerME(model);
                for (String s : getSentences()) {
                    String[] sTokens = tokenizer.tokenize(s);

                    /*
                    The OpenNLP tokenizer has problems with double quotes. 
                    Sometimes the quotes are not recognized as
                    separate tokens.
                     */
                    ArrayList<String> tokenList = new ArrayList<>();
                    for (String t : sTokens) {
                        if (t.contains("\"") && t.length() > 1) {
                            t = t.replaceAll("\"", " \" ").trim();
                            Collections.addAll(tokenList, t.split("\\s+"));
                        } else {
                            tokenList.add(t);
                        }
                    }
                    getTokens().add(tokenList);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void extractSentences(String text) {
        if (getSentences() == null) {
            try (InputStream modelIn = new FileInputStream("de-sentence.bin")) {
                SentenceModel model = new SentenceModel(modelIn);
                SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);
                this.sentences = sentenceDetector.sentDetect(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns the text of this CorpusBuilder
     * @return The text of this CorpusBuilder
     */
    public String getText() {
        return text;
    }

    /**
     * Return an array with the sentences of the CorpusBuildr
     * @return An array with the sentences of the CorpusBuildr
     */
    public String[] getSentences() {
        return sentences;
    }

    /**
     * Return a List of List with the tokens/words of the text of CorpusBuilder. The first list holds the words of the
     * first sentence, the second list holds the words of the second sentence and so on.
     * @return A List of List the tokens/words of the text of the CorpusBuilder.
     */
    public List<List<String>> getTokens() {
        return tokens;
    }

    /**
     * Return a List of List with the POS tags of the text of CorpusBuilder. The first list holds the POS tags of the
     * first sentence, the second list holds the POS tags of the second sentence and so on.
     * @return A List of List with the POS tags of the text of CorpusBuilder.
     */
    public List<List<String>> getPosTags() {
        return posTags;
    }

    /**
     * Return a List of List with the Lemmas of the text of CorpusBuilder. The first list holds the lemmas of the
     * first sentence, the second list holds the Lemmas of the second sentence and so on.
     * @return A List of List with the Lemmas of the text of CorpusBuilder.
     * @return
     */
    public List<List<String>> getLemmas() {
        return lemmas;
    }
}
