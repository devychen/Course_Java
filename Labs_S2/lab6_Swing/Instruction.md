# Lab 6

## Introduction to Swing
You can find the Swing introduction [here](http://www.sfs.uni-tuebingen.de/~saile/Java2/18-05-15/swing-intro/swing-intro.html).

## Exercise 1

Open `TestFrame8.java` and compile the program. When you click the button labeled "new", a new window appears. When you click the close window button, the program terminates no matter how many windows are on the screen. Please change the program so that it keeps running until the last window is closed.

#### (1 Point)

## Exercise 2

Modify `TestFrame10.java` by adding an "Edit", "Load" and "Save" button above the "Quit" button. 

The buttons should be able to do the following:

<table>
<tr><td width="10%" valign="top"><strong>Edit</strong></td>
<td>When you click on the button, a <code>JOptionPane.showInputDialog()</code> must appear where you can edit the selected word. When you click OK, the edited word should replace the 
old 
word in the list.</td></tr>
<tr><td width="10%" valign="top"><strong>Load</strong></td>
<td>When you click on the button, a <code>JOptionPane.showInputDialog()</code> must appear where you can enter a filename. Then you must open the file and load the contents of the 
file into the 
JList. This should not replace the words currently in the list. Please check for errors, and inform the user if something went wrong.</td></tr>
<tr><td width="10%" valign="top"><strong>Save</strong></td>
<td>When you click on the button, a <code>JOptionPane.showInputDialog()</code> must appear where you can enter a filename. Then you must save the contents of the JList to the file. 
Please check 
for errors, and inform the user if something went wrong.</td></tr>
</table>

**Additional requirement: words should not be able to appear in the list more than once!**

For this program you will need to test it without using JUnit. So we recommend running the program to try to find ways to cause errors, then go back and adapt your code to handle the errors. For example, try clicking the add button with a blank text window, or try adding a word that is currently in the list. 

#### (9 Points)
