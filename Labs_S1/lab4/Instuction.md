<h2>Instructions</h2>

<p>A <b>stemmer</b> is an algorithm that reduces a morphologically
complex word to its stem.  For instance, a stemmer for English should
reduce the word "relationally" to the stem "relate".<br>
</p>
<p>Here is a simple algorithm (based on M.F. Porter 1980 "An algorithm
for suffix stripping", <i>Program</i> 14, 130--137) for part of the
stemming problem: that it removes only inflectional endings (things
like "-ed" and "-ing" but not things like "-al" and "-tion") from
English words.
</p>
<ul>
<li>
If the word ends in "ing" and is longer than 4 letters, remove the 
"ing".</li>

<li>If the word ends in "sses", remove the final "es".</li>

<li>If the word ends in "ies", replace the "ies" with "y".</li>

<li>If the word ends in "s", but not in "sses", "ies", or "ss", then 
remove the final "s".</li>

<li>If the word ends in "eed" and is longer than 4 letters, remove the 
final "d".</li>

<li>If the word ends in "ed" but not in "eed" and is longer than 4 
letters, remove the final "ed".</li>
</ul>

<h2>Exercise 1</h2>
Write a program <tt>Stemmer.java</tt> which uses the above algorithm to
create
the stem of a word. The program must read all words on the
<i>System.in</i> stream,
create a stem for the word and print word and the stem.<br> Make sure to
consider the case in which the length of a input word is smaller than 4.
<br><br>
<b>Tip:</b> work with a line scanner<br>
<b>Tip:</b> three character words don't have suffixes
<h3> A few additonal notes </h3>
<ul>
<li>We want you to get familiar with the basics, therefore only use the 
stuff you have learnt in class so far. You are for example not allowed to 
use arrays, s.replace(string, string) or s.endsWith(s2)</li>
<li>Assume the input to be of the correct type.</li>
<li>Don't create an infinite loop. Your program should ask the user only 
once for input</li>
<li>Your implementation should follow the instructions exactly as 
outlined, even though the algorithm is not perfect and won't produce 
grammatically correct results for some words</li>
<li>Make sure your output looks exactly the same as the example output 
when entering the same words</li>
</ul>

<br> 
<b>Your output should look <i>exactly</i> like this:</b>
<pre>
Enter your words in the following line:
motoring sing caresses caress ponies cats feed agreed plastered bled<br>
motoring - motor
sing - sing
caresses - caress
caress - caress
ponies - pony
cats - cat
feed - feed
agreed - agree
plastered - plaster
bled - bled
</pre>
<br>
<b>(10 Points)</b>

<h2> Exercise 2 (OPTIONAL) </h2>
If you are done with Exercise 1 and you still have time, you can go on to
this small exercise. Assuming that you write this program correctly and
that you submit it before the deadline, you will earn 1 bonus point for
your lab grade.

<p>Here is what you have to do.</p>
<p>
Write a program <i>ComputeOddNumbers.java</i> that asks the user to enter 
a positive integer n, computes the sum of the first n positive odd 
integers and prints the sum. For example, if n is 5, you should compute 1 
+ 3 + 5 + 7 + 9.<br>
Don't forget to check whether n is a valid input before using it.  
</p>
<b>(1 Point)</b>

