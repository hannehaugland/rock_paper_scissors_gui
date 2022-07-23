import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Display {
    public static void main (String[] arg) {
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { System.exit(1); }

        JFrame window = new JFrame("Rock Paper Scissors");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        window.add(panel);

        String user = System.getProperty("user.name");
        JLabel welcomeMsg = new JLabel("Let's play rock paper scissors, " +  user + "!");
        panel.add(welcomeMsg);

        window.pack();  
        window.setVisible(true);
    }
}