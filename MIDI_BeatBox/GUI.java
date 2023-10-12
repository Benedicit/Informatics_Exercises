package MIDI_BeatBox;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.management.GarbageCollectorMXBean;
import java.util.concurrent.TimeUnit;

public class GUI {
    private JFrame frame;
    private JLabel label;
    private int x;
    private int y;

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
    public void animate() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Animation anim = new Animation();
        frame.getContentPane().add(anim);
        frame.setSize(300, 300);
        frame.setVisible(true);
        while(x<=100) {
            x++;
            y++;
            anim.repaint();
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (Exception e){
                e.printStackTrace();
            }

        }


    }

    class Animation extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0,0, this.getWidth(), this.getHeight());
            g.setColor(Color.green);
            g.fillOval(x,y,100,100);
        }
    }
}
