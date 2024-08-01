<html>
<h1>Lab 5</h1>
<body>
<h2>Exercise 1</h2>
<h3><u>Part 1</u></h3>

We have provided the starter code in <code>Person.java</code>. Add the following methods to class <code>Person</code>:
<ul>
	<li>
		<tt><strong>public</strong> boolean equals(Person anotherPerson)</tt>
		<p>This method must test whether two persons are equal.</p>
		<p>We consider two persons to be equal if they have the same name and they are of the same age.</p>
	</li>
	<li>
		<tt><strong>public</strong> boolean isSameName(Person anotherPerson)</tt>
		<p>This method must test whether two persons have the same name. <u>Note that the case of the names does not matter</u>.</p>
	</li>
	<li>
		<tt><strong>public</strong> boolean isSameAge(Person anotherPerson)</tt>
		<p>This method must test whether two persons are of the same age.</p>
	</li>
	<li>
		<tt><strong>public</strong> boolean isOlderThan(Person anotherPerson)</tt>
		<p>This method must test whether the instance is older than <tt>anotherPerson</tt>.</p>
	</li>
	<li>
		<tt><strong>public</strong> boolean isYoungerThan(Person anotherPerson)</tt>
		<p>This method must test whether the instance is younger than <tt>anotherPerson</tt>.</p>
	</li>
</ul>

<p>
<u>Notes</u>:
<ul>
	<li>Your class, method, and variable names should be <i>exactly</i> as provided above. </li>
	<li>Do <b>not</b> change any of the code that is provided for you.</li>
	<li>Don't forget to add javadoc comments to document your new methods and ensure that you are conforming to the java style guidelines.</li>
	<li>Points will be deducted for code that is not spaced, capitalized or indented properly. (Shift + Alt + F is your friend.)</li>
	<li>And of course, don't forget to put the (correctly filled!) honor code in <i>all</i> the files that you submit </li>
</ul>


<h3><u>Part 2</u></h3>

<p>
While you are writing your methods in <tt>Person</tt> class, you should immediately develop test methods in <tt>PersonTest</tt> for those methods. Every method (except of the setter/getter methods) in <tt>Person</tt> <b>must</b> 
be tested by at least 2 methods in <tt>PersonTest</tt>. To get you going, we uploaded the starter JUnit test cases in the file <code>PersonTest.java</code>, which you can find in your repo. 
</p>


Again, remember adding javadoc comments to describe your test methods!


<p><b>(10 points)</b></p>




</body>
</html>