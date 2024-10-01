# Swing/GUI
### Before you start:
Download **SnowFlakeGui.java** and **SnowFlakeCanvas.java**.   
**SnowFlakeCanvas.java** is a modification of the SnowFlake applet that you have written a few weeks ago. 
It is a subclass of Canvas and can be used as a Swing component. 
Most significantly, it provides setter methods for various parameters. Compile and run **SnowFlakeGui.java**.

### Goal:
SnowFlakeGui.java should provide the opportunity for the user to set parameters such as minimum and maximum beam length, number of snowflakes, background and snowflake color. When the "paint"-Button is clicked, the canvas in the center should display the snowflakes according to the given parameters.

### Exercise:
Add the missing code to **SnowFlakeGui.java**.   
`//TODO` stubs mark the places where code needs to be inserted.

### 1. Adding Components to a Layout
   Complete the `setUpEast()` method: Add 3 JLabels and 3 JTextFields where the user can enter the red, green and blue values for the snow flake color. You can use `setUpWest()` as a template.   

   (Note: component variables you want to access from other methods must be global!)

### 2. Handling ActionEvents, en-/disabling Components
   Implement the `actionPerformed(ActionEvent e)` method of the private class **ColorListener** which implements the `ActionListener` interface. This method is called whenever one of the two `JRadioButtons` is selected. If the user selects "Random Colors" you should disable the `JLabels` and `JTextFields` for the rgb values from (1.). If the user selects "Set fixed Color" you should enable them. (See the documentation of `JTextField)`

### 3. Handling ActionEvents, retrieving Input
   Implement the `actionPerformed(ActionEvent e)` method of the private class **PaintButtonListener**. This method is called whenever the "paint"-Button is clicked.
   Retrieve the values from all the important input components: minimum and maximum beam length, number of flakes, background color and snow flake color. The components `JTextField`, `JComboBox` and `JColorChooser` provide intuitive methods for that.
   Use the setter methods of **SnowFlakeCanvas.java** to pass those values to the canvas. (Note: SnowFlakeCanvas.java inherits a `setBackground()` method for the background color.) The input from the text fields must be converted from String to int (the Integer class provides methods to do that), so check the input properly.
   For random colors, set the flake color to null. Once everything is set, use the `repaint()` method of the Canvas class to draw the snow flakes. That will clear the canvas before automatically calling the `paint()` method.

### Hint:
Use code completion in Netbeans or Eclipse. When you type a variable name and the `'.'`, you can pick from a list of methods that are available. You should be able to find the methods that you need quickly (i.e. boolean `isSelected()`, String getTe