<h2>Exercise 1</h2>

Please write a class <tt>Word.java</tt> that encapsules a word and provides methods
to get the word, the stem of the word, and the number of syllables in the word. You will find a template for
your implementation in <tt><a href="Word.java">Word.java</a></tt>.

<p>
To test your code you may use <tt><a href="WordTest.java">WordTest.java</a></tt>
</p>

<h3>Methods of the <tt>Word</tt> class</h3>
<p>Your <tt>Word</tt> class must implement the following methods:</p>
<ul>
<li>
   <p>
   <p><code><strong>public</strong> Word()</code></p> 
    A default constructor that initializes the instance with an empty word.   
   </p>
</li>
<li>
   <p> 
      <p><code><strong>public</strong> Word(String aWord)</code></p> 
       A constructor that initializes the instance with String<code> aWord</code>.
   </p>    
</li>
<li>
	<code><strong>public</strong> void setWord(String newWord)</code>
	<p>
		Sets <tt>Word</tt> to <code><strong>String</strong> newWord</code>. 
		<p>
		<strong>Note:</strong> Whenever you change the word to a new value, you must 
		also recompute the stem and the syllable count of the <code>Word</code> instance.
		</p>
	</p>
</li>
<li>
	<code><strong>public</strong> String getWord()</code>
	<p>Returns the word.</p>
</li>
<li>
	<code><strong>public</strong> String getStem()</code>
	<p>Returns the stem of this <code>Word</code>.</p>     
</li>
<li>
	<code><strong>public</strong> int getSyllableCnt()</code>
	<p>Returns the number of syllables in this <code>Word</code>.</p>
</li>
<!--
<li>
	<code><strong>public</strong> String toString()</code>
	<p>Returns a <code>String</code> representation of this <code>Word</code>.</p>
</li>
-->

<!--
<li>
	<code><strong>private</strong> void setSyllableCnt()</code>
	<p>Sets the number of syllables in this word.</p>
</li>
<li>
	<code><strong>private</strong> void setStem()</code>
	<p>Sets the stem of this <code>Word</code>.</p>
</li>
-->
</ul>

<p>
Depending on your algorithm, it might be useful to define helper methods that 
create the syllable count and the stem of the word.   
</p>
<ul>
<li>
	<code><strong>private</strong> int createSyllableCnt(String aWord)</code>
	<p>
		Computes the number of syllables in this <code>Word</code> and return the number 
		to the caller.
	</p>
	<p>Those who don't
		find an own solution can use the code in 
		<tt><a href="SyllableCount.txt">SyllableCount.txt</a></tt>
If you want to use your own solution, it should give the same result as this one: A syllable is one or more consonants followed by one or more vowels(a, e, i, o, u, y). If the word ends in "e", the last consonant(s) + e do not count as a syllable.
	</p>
</li>
<li>
	<code><strong>private</strong> String createStem(String aWord)</code>
	<p>Creates the stem for this <code>Word</code> and returns a String
		with the stem. 
	</p>
	<p>
		You can use the same algorithm you have used in our lab session. Those who don't
		find their solution can use the code in 
		<tt><a href="CreateStem.txt">CreateStem.txt</a></tt>
	</p>
</li>
</ul>



<p>
	When you write the class, it is recommend that you compile your class after 
	<strong>every</strong> new method definition. Make sure that your class
	compiles properly before you write the next method. Do not go on and write new
	methods before the method you are currently working on is correct. 
</p>
<p><b>(10 points)</b></p>