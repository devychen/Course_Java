# SelfTest7

Text inside the `@literal` inline tag is interpreted literally and not as HTML markup.

Create a class `STArrays` which implements two helper methods for arrays. 
To display the Javadoc documentation of the class download the Javadoc folder and 
open the *index.html* file in the doc folder.

Please write a Junit test case. You should test each method under different aspects.


This is the javadoc comment of the toString() method:
```
/**
* Returns a string representation of the contents of the specified array.
* The string representation consists of a list of the array's elements,
* enclosed in square brackets ("[]"). Adjacent elements are separated by the characters ", "
* (a comma followed by a space).
*
* @param anIntArray Array whose string representation to return.
*
* @return A string representation of the contents of the specified array.
*/
```

There is nothing new here, while the comment for slice() has some new tags.

```
/**
* Copies the specified range of the specified array into a new array and returns the new array.
*
* @param anIntArray  the array from which a slice is to be copied.
* @param start the initial index of the range to be copied, inclusive.
* @param end  the final index of the range to be copied, exclusive. (This index may lie outside the array.)
*
* @return an array with  the specified range of the specified array or <b>null</b> when:<br>
* {@code anIntArray == null}<br>
* or<br>
* {@code start < 0 || end > anIntArray.length || start > anIntArray.length}<br>
* or<br>
* {@code end < start}<br>
* or<br>
* {@code start > end}
*/
```

This comment uses html `<b>` tags to format null as bold text and the <br> tag inserts a new line. 
The `{@code}` javadoc tag is interpreted literally and not as HTML markup. 

Everything in the @code braces is inserted directly and the font is set to a typewriter like font.