package MIDI_BeatBox;
import javax.swing.*;
import java.awt.event.*;

public class GUI implements ActionListener {
    private JButton button;
    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");
        button.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event) {
        button.setText("I've been clicked");
    }
}
