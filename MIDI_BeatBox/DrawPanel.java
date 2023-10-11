package MIDI_BeatBox;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.fillRect(0,0, this.getWidth(), this.getHeight());

        Random random = new Random() ;
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        Color startcolor = new Color (red, green, blue);
        red = random.nextInt(256);
        green = random.nextInt(256);
        blue = random.nextInt(256);
        Color endcolor = new Color (red, green, blue);

        GradientPaint gradient = new GradientPaint (70, 70, startcolor, 150, 150, endcolor);
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }
}
