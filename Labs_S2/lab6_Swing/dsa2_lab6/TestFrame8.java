import javax.swing.*;
import java.awt.event.*;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class TestFrame8
{
    private JFrame frame; // Our top level window

    /**
     * Constructor for TestFrame8
     * The window has a window listener that terminates the application
     * when the close window button is clicked. 5 Buttons are displayed
     * in a BoxLayout.
     */
    TestFrame8()  {
        frame = new JFrame("Test Frame 8");
        frame.setSize(300,200);

        //Override JFrames default layout manager.
        BoxLayout aBoxLayout = new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS);
        frame.getContentPane().setLayout(aBoxLayout);


        //This is the common size of the buttons
        Dimension size = new Dimension(80,30);

        //Add 5 Pixels rigid space
        frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));

        /*
         *	Create buttons, set their sizes and a rigid space, add an ActionListener
         *	then add them to the frame.
         */
        JButton firstButton = new JButton("first");
        firstButton.setMaximumSize(size);
        firstButton.addActionListener(new FirstButtonHandler());
        frame.getContentPane().add(firstButton);
        frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));

        JButton secondButton = new JButton("second");
        secondButton.setMaximumSize(size);
        secondButton.addActionListener(new SecondButtonHandler());
        frame.getContentPane().add(secondButton);
        frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));

        JButton thirdButton = new JButton("third");
        thirdButton.setMaximumSize(size);
        thirdButton.addActionListener(new ThirdButtonHandler());
        frame.getContentPane().add(thirdButton);
        frame.getContentPane().add(Box.createRigidArea(new Dimension(0,5)));

        JButton fourthButton = new JButton("fourth");
        fourthButton.setMaximumSize(size);
        fourthButton.addActionListener(new FourthButtonHandler());
        frame.getContentPane().add(fourthButton);

        //Add a stretchable space
        frame.getContentPane().add(Box.createVerticalGlue());

        JButton fifthButton = new JButton("new");
        fifthButton.setMaximumSize(size);
        fifthButton.addActionListener(new FifthButtonHandler());
        frame.getContentPane().add(fifthButton);


        frame.addWindowListener(new MyWindowListener());

        frame.setVisible( true );
    }

    /*
     * ActionListeners for the JButtons
     */

    private class FirstButtonHandler implements ActionListener  {
        public void actionPerformed(ActionEvent e)  {
            JOptionPane.showMessageDialog(frame,"First button was clicked");
        }
    }

    private class SecondButtonHandler implements ActionListener  {
        public void actionPerformed(ActionEvent e)  {
            JOptionPane.showMessageDialog(frame,"Second button was clicked");
        }
    }

    private class ThirdButtonHandler implements ActionListener  {
        public void actionPerformed(ActionEvent e)  {
            JOptionPane.showMessageDialog(frame,"Third button was clicked");
        }
    }

    private class FourthButtonHandler implements ActionListener  {
        public void actionPerformed(ActionEvent e)  {
            JOptionPane.showMessageDialog(frame,"Fourth button was clicked");
        }
    }

    private class FifthButtonHandler implements ActionListener  {
        public void actionPerformed(ActionEvent e)  {
            JOptionPane.showMessageDialog(frame,"New window!");
            new TestFrame8();
        }
    }




    /**
     * Our window listener terminates the program when the close window button
     * is clicked.
     */
    private class MyWindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    }

    /**
     * Opens a TestFrame4
     */
    public static void main ( String[] args )
    {
        new TestFrame8();
    }
}
