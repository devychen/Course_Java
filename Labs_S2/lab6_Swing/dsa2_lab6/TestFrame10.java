package dsa2_lab6;

import javax.swing.*;
import java.awt.event.*;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.io.*;
import javax.swing.JOptionPane;
import javax.swing.event.*;

/**
 * TASK: Modify TestFrame10.java by
 *  adding an "Edit", "Load" and "Save" button above the "Quit" button.
 * @author mkz
 */

public class TestFrame10 {

    private JFrame frame;  	// Our top level window
    private JTextField aTextField;  // Text field to display selection

    JList<String> aList; // list component


    /**
     * Constructor for TestFrame10 The window has a window listener that
     * terminates the application when the close window button is clicked. 5
     * Buttons are displayed in a BoxLayout.
     */
    TestFrame10() {
        frame = new JFrame("Test Frame 10");
        frame.setSize(300, 300);   // Set window size

        //Text field to edit selection
        aTextField = new JTextField(60);
        /* Create a fixed size for the text field. Otherwise the text field
         * will stretch when the window is resized
         */
        aTextField.setMaximumSize(new Dimension(200, 40));

        // Data to display in the list
        String[] entries = {"Fuchs", "du", "hast", "die", "Gans", "gestohlen"};

        /*
         * Create a changeable ListModel for our List. We need this because
         * we later want to add or remove Strings from the list!
         */
        DefaultListModel<String> aListModel = new DefaultListModel<>();
        for (String entry : entries) {
            aListModel.addElement(entry);
        }
        //Create list and wrap it into a JScrollPane
        aList = new JList<>(aListModel);

        //Connect List and SelectionListener
        aList.addListSelectionListener(new ValueReporter());
        JScrollPane listPane = new JScrollPane(aList);
        JPanel panel1 = new JPanel();
        //Override JFrames default layout manager.
        BoxLayout aBoxLayout = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        panel1.setLayout(aBoxLayout);

        //Add 5 Pixels rigid space between components
        panel1.add(Box.createRigidArea(new Dimension(0, 5)));
        panel1.add(aTextField);
        panel1.add(Box.createRigidArea(new Dimension(0, 20)));
        panel1.add(listPane);

        //This is the common size of the buttons
        Dimension size = new Dimension(95, 30);

        JButton addButton = new JButton("Add");
        addButton.setMaximumSize(size);
        addButton.addActionListener(new AddButtonHandler());

        JButton rmButton = new JButton("Remove");
        rmButton.setMaximumSize(size);
        rmButton.addActionListener(new RMButtonHandler());

        JButton quitButton = new JButton("Quit");
        quitButton.setMaximumSize(size);
        quitButton.addActionListener(new QuitButtonHandler());

        // todo - set up the buttons
        JButton editButton = new JButton("Edit");
        editButton.setMaximumSize(size);
        editButton.addActionListener(new EditButtonHandler());

        JButton loadButton = new JButton("Load");
        loadButton.setMaximumSize(size);
        loadButton.addActionListener(new LoadButtonHandler());

        JButton saveButton = new JButton("Save");
        saveButton.setMaximumSize(size);
        saveButton.addActionListener(new SaveButtonHandler());


        JPanel panel2 = new JPanel();
        panel2.add(Box.createRigidArea(new Dimension(0, 5)));
        panel2.add(addButton);
        panel2.add(Box.createRigidArea(new Dimension(0, 15)));
        panel2.add(rmButton);
        panel2.add(Box.createRigidArea(new Dimension(0, 5)));
        // todo - add to panel, but before "quit" button
        panel2.add(editButton);
        panel2.add(Box.createRigidArea(new Dimension(0,5)));
        panel2.add(loadButton);
        panel2.add(Box.createRigidArea(new Dimension(0,5)));
        panel2.add(saveButton);
        panel2.add(Box.createRigidArea(new Dimension(0,5)));
        // todo ends.
        panel2.add(quitButton);
        panel2.add(Box.createVerticalGlue());
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));


        frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
        frame.getContentPane().add(panel1);
        frame.getContentPane().add(Box.createRigidArea(new Dimension(5, 0)));
        frame.getContentPane().add(panel2);

        frame.addWindowListener(new MyWindowListener());

        frame.setVisible(true);
    }

    /*
     * ActionListeners for the JButtons
     */
    private class AddButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String s = aTextField.getText();

            if (s.length() > 0) {
                int numItems = aList.getModel().getSize();
                for (int i = 0; i < numItems; i++) {
                    if (aList.getModel().getElementAt(i).equals(s)) {
                        JOptionPane.showMessageDialog(frame, "Word is already in list");
                        aTextField.setText("");
                        return;
                    }
                }
                DefaultListModel<String> aListModel = (DefaultListModel<String>) aList.getModel();
                aListModel.addElement(s);
                aTextField.setText("");
            }
        }
    }

    private class RMButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int elementIndex = aList.getSelectedIndex(); // NOTE: get the index of item selected
            if (elementIndex != -1) {
                if (JOptionPane.showConfirmDialog(frame, "Really delete element??")
                        == JOptionPane.YES_OPTION) {
                    DefaultListModel<String> aListModel = (DefaultListModel<String>) aList.getModel();
                    aListModel.remove(elementIndex);
                }
            } else return;                             //   NOTE: return if nothing selected
        }
    }

    private class QuitButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    // todo - add action listeners accordingly
    /**
     * When you click on the button, a JOptionPane.showInputDialog() must appear
     *  where you can edit the selected word.
     *  When you click OK, the edited word should replace the old word in the list.
     */
    private class EditButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int elementIndex = aList.getSelectedIndex();
            if (elementIndex != -1) {
                String currentValue = aList.getSelectedValue();
                String newValue = JOptionPane.showInputDialog(frame,
                        "Edit the word:", currentValue);
                if (newValue != null) {
                    DefaultListModel<String> aListModel = (DefaultListModel<String>) aList.getModel();
                    aListModel.set(elementIndex, newValue);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Please select an item to edit.");
            }
        }
    }

    /**
     * When you click on the button, a JOptionPane.showInputDialog() must appear
     *  where you can enter a filename.
     *  Then you must open the file and load the contents of the file into the JList.
     *  This should not replace the words currently in the list.
     *  Please check for errors, and inform the user if something went wrong.
     */
    private class LoadButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent e){
            String filename = JOptionPane.showInputDialog(frame, "Enter filename to load:");
            if (filename != null && !filename.trim().isEmpty()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    DefaultListModel<String> aListModel = (DefaultListModel<String>) aList.getModel();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        aListModel.addElement(line);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error loading file: " + ex.getMessage());
                }
            }
        }
    }

    /**
     * When you click on the button, a JOptionPane.showInputDialog() must appear
     *  where you can enter a filename.
     *  Then you must save the contents of the JList to the file.
     *  Please check for errors, and inform the user if something went wrong.
     */
    private class SaveButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String filename = JOptionPane.showInputDialog(frame, "Enter filename to save:");
            if (filename != null && !filename.trim().isEmpty()) {
                try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                    DefaultListModel<String> aListModel = (DefaultListModel<String>) aList.getModel();
                    for (int i = 0; i < aListModel.getSize(); i++) {
                        writer.println(aListModel.getElementAt(i));
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage());
                }
            }
        }
    }

    private class ValueReporter implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent event) { }
    }


    /**
     * Our window listener terminates the program when the close window button
     * is clicked.
     */
    private class MyWindowListener extends WindowAdapter {

        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    /**
     * Open a TestFrame10
     */
    public static void main(String[] args) {
        new TestFrame10();
    }
}

