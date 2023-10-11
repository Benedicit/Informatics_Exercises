package MIDI_BeatBox;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI {
    private JFrame frame;
    private JLabel label;

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton labelbutton = new JButton("Change colors");
        labelbutton.addActionListener(event -> label.setText("Ouch!"));

        JButton colorbutton = new JButton("Change colors");
        colorbutton.addActionListener(event -> frame.repaint());

        label = new JLabel("I'm a label");
        DrawPanel panel = new DrawPanel();

        frame.getContentPane().add(BorderLayout.EAST, labelbutton);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, colorbutton);
        frame.getContentPane().add(BorderLayout.WEST, label);
        frame.setSize(300, 300);
        frame.setVisible(true);

    }
}
