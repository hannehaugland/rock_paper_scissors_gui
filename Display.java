import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Display {
    private JFrame window;
    private JPanel panel, header, grid, content;
    private JLabel welcomeMsg, title, score, resultMsg;
    private JButton exitBtn; 

    public Display (Controller c) {
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { System.exit(1); }

        // Wrapper panel containing all of the content in the window
        window = new JFrame("Rock Paper Scissors");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        // Head content of the window 
        header = new JPanel(); 
        header.setLayout(new BorderLayout(10, 10));
        title = new JLabel("Rock Paper Scissors"); 
        title.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        title.setHorizontalAlignment(JLabel.CENTER);
        score = new JLabel("You: 1 Computer: 2");
        score.setHorizontalAlignment(JLabel.CENTER);

        // Main content of the window 
        content = new JPanel();
        content.setLayout(new BorderLayout(10, 10));
        welcomeMsg = new JLabel("Make your choice using the buttons above to play");
        resultMsg = new JLabel("you lost");
        welcomeMsg.setHorizontalAlignment(JLabel.CENTER);
        resultMsg.setHorizontalAlignment(JLabel.CENTER);

        // Buttons for user options 
        grid = new JPanel();
        grid.setLayout(new GridLayout(1,3, 10, 10));
        grid.add(new JButton("Rock")); 
        grid.add(new JButton("Paper")); 
        grid.add(new JButton("Scissors")); 

        // Quit-button 
        exitBtn = new JButton("Finish"); 
        class Quitter implements ActionListener { @Override 
            public void actionPerformed (ActionEvent e) {
                c.quit();
            }
        }
        exitBtn.addActionListener(new Quitter());

        window.add(panel);
        panel.add(header, BorderLayout.NORTH);
        panel.add(content, BorderLayout.SOUTH);
        header.add(title, BorderLayout.NORTH);
        header.add(score, BorderLayout.SOUTH);
        header.add(new JPanel(), BorderLayout.WEST); 
        header.add(new JPanel(), BorderLayout.EAST); 
        content.add(welcomeMsg, BorderLayout.NORTH);
        content.add(exitBtn, BorderLayout.SOUTH);
        panel.add(grid);
        
        window.pack();  
        window.setVisible(true);
    }
}