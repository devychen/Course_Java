import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NestedMenus extends JFrame implements ActionListener
{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 300;
    public static final int LINES = 10;
    public static final int CHAR_PER_LINE = 40;

    private JTextArea theText;
    private String memo1 = "No Memo 1.";
    private String memo2 = "No Memo 2.";

    public NestedMenus()
    {
        setSize(WIDTH, HEIGHT);
        addWindowListener(new WindowDestroyer());
        setTitle("Memo Saver");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JMenu memoMenu = new JMenu("Memos");
        JMenuItem m;

        JMenu saveMenu = new JMenu("Save");

        m = new JMenuItem("Save Memo 1");
        m.addActionListener(this);
        saveMenu.add(m);

        m = new JMenuItem("Save Memo 2");
        m.addActionListener(this);
        saveMenu.add(m);

        memoMenu.add(saveMenu);

        JMenu getMenu = new JMenu("Get");

        m = new JMenuItem("Get Memo 1");
        m.addActionListener(this);
        getMenu.add(m);

        m = new JMenuItem("Get Memo 2");
        m.addActionListener(this);
        getMenu.add(m);

        memoMenu.add(getMenu);

        m = new JMenuItem("Clear");
        m.addActionListener(this);
        memoMenu.add(m);

        m = new JMenuItem("Exit");
        m.addActionListener(this);
        memoMenu.add(m);

        JMenuBar mBar = new JMenuBar();
        mBar.add(memoMenu);
        setJMenuBar(mBar);

        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.BLUE);
        theText = new JTextArea(LINES, CHAR_PER_LINE);
        theText.setBackground(Color.WHITE);
        textPanel.add(theText);
        contentPane.add(textPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("Save Memo 1"))
            memo1 = theText.getText();
        else if (actionCommand.equals("Save Memo 2"))
            memo2 = theText.getText();
        else if (actionCommand.equals("Clear"))
            theText.setText("");
        else if (actionCommand.equals("Get Memo 1"))
            theText.setText(memo1);
        else if (actionCommand.equals("Get Memo 2"))
            theText.setText(memo2);
        else if (actionCommand.equals("Exit"))
            System.exit(0);
        else
            theText.setText("Error in memo interface");
    }

    public static void main(String[] args)
    {
        NestedMenus gui = new NestedMenus();
        gui.setVisible(true);
    }
}
