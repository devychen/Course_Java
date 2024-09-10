# Self-Test 11

## Introduction:

The Flesch readability index is a tool for estimating the reading comprehension level necessary to understand a written document. For a given document, the Flesch readability index is an integer (usually between 0 and 100) indicating how difficult the document is to understand, with lower numbers indicating greater difficulty. For example, the table below shows typical Flesch readability index values for various reading material:

| Material            | Flesch Index |
|---------------------|--------------|
| Comics              | 95           |
| Consumer Ads        | 82           |
| Sports Illustrated  | 65           |
| Time                | 57           |
| New York Times      | 39           |
| Auto Insurance      | 10           |
| IRS Tax Code        | -6           |

Flesch does not require any linguistic analysis of the text.
In order to compute the index for a text corpus, you need:

1. the total number of sentences in the text (numSentences)
2. the total number of words in the text (numWords)
3. the total number of syllables in the text (numSyllables)

The Flesch readability index can then be computed with the following formula:

```
Flesch Index = 206.835
                - 84.6 * ((double) numSyllables / numWords)
                - 1.015 * ((double) numWords / numSentences)
```

With a simple method for computing the Flesch readability index it is possible for authors to write and revise documents until they are comprehensible to the target audience. 
For example, a newspaper reporter might continue to revise an article until the Flesch readability index is above 60.

At least one popular word processor is able to compute the Flesch readability index. 
If you ask Microsoft Word to display the readability statistics for a document, it will display a Flesch reading ease score, which is the same as the readability index.

## Exercise:

Fill in the missing `getFleschIndex()` method in **Corpus.java**.

- Note the instance variables, constructors, and helper methods provided. 
  - `inputFile` and `encoding` are initialized in the contructors
  - `getNumSyllables` is a method for counting syllables
  - `endOfSentence` determines if the input word is the last in a sentence (ie word ends with '.' , '?' , '!' , ':' , or ';' )
- Use `BufferedReader` and read the file line-by-line
  - Use String.split method to split each line on whitespace (use "\\s+")
  - Add to the total numbers of sentences, words, and syllables appropriately
- When the end of the file is reached, calculate and return the index using the formula above

You can use **CorpusDemo** to try out your code.

| Work                    | Flesch Index |
|-------------------------|--------------|
| Flesch1.txt             | 24           |
| Flesch2.txt             | 83           |
| RomeoAndJuliet.txt      | 82           |
| TomSawyerDetective.txt  | 80           |
| Beowulf.txt             | 73           |
| PlatosRepublic.txt      | 68           |

These texts are available at: **sampleTexts**

To find the Flesch index of Romeo & Juliet, use the following command:

```java CorpusDemo RomeoAndJuliet.txt```