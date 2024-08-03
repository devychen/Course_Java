<h2>Exercise 1</h2>
<p>
Add the following new methods (Do not change the existing methods and instance variables):
</p>

<p>
<ul>
<li>
	<code>public void insertAt(int index, String item) </code> 
	<p>
	Insert String <code>item</code> at position <code>index</code>.
	</p>
</li>
<li>
	<code>public boolean remove(String item) </code> 
	<p>
	 Remove String <code>item</code> from the list. Returns <code>true</code>
     when <code>item</code> was successfully removed and <code>false</code>
     otherwise.
	</p>
</li>

<li>
	<code>public String[] toArray()</code> 
	<p>
	Returns the content as an array of Strings. (Copy every non-null element in list into an array)
	</p>
</li>
</ul>


<p>
We reccomend writing additional junit test cases. It is 
probably a good idea to test insert/remove at the first, the last and a middle position. To get
you going, you can use the test file in this repo. The tests will not be graded but are
  highly encouraged in order to confirm that your methods are working as intended.
</p>
<p>
To test if two arrays are equal you must compare each element of the arrays.
<h4>Example:</h4>
<pre>
String[] expected = {"AA","BB","CC"};
String[] res = testList.toArray();

assertTrue(expected.length == res.length);
for (int i=0;i&lt;res.length;i++)  {
assertEquals(res[i],expected[i]);
}
</pre>


<p>Needless to say: You must provide javadoc comments and comments describing the program flow. Please add javadoc comments to ALL methods, both the methods you write and the methods provided.</p>

<p><b>(10 points)</b></p>

<h2>Bonus exercise</h2>
<code>public String toString()</code>
<p>
Returns the content as a String representation without null elements.
</p>
Output must look like this:
<pre>[element1, element2, element3]</pre>
<p><b>(1 point)</b></p>