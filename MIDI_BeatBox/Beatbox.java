package MIDI_BeatBox;
import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Beatbox {
    private Random random = new Random();
    public static void main(String[] args) {
        Beatbox beatBox = new Beatbox();
        if (args.length < 2) {
            System.out.println("Don't forget the instrument and note args");
        }
        else {
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            beatBox.play(instrument, note);
        }
        GUI gui = new GUI();
        gui.go();

    }
    public void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            int[] eventsIWant = {127};
            player.addControllerEventListener(event -> System.out.println("la"), eventsIWant);
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //Events
            for (int i = 5; i<61; i += 4) {
                track.add(makeEvent(NOTE_ON, 1, i, 100, i));
                track.add(makeEvent(CONTROL_CHANGE,1,127,0,i));

                track.add(makeEvent(NOTE_OFF, 1,i,100,i+2));
            }
            player.setSequence(seq);
            player.setTempoInBPM(220);
            player.start();

        }
        catch(Exception e) {
            System.out.println("Me sad");
        }

    }
    public static MidiEvent makeEvent(int command, int channel, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(command, channel, one, two);
            event = new MidiEvent(msg, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
    class Panel extends JPanel implements ControllerEventListener {
        private boolean msg = false;
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }
        public void paintComponent(Graphics g) {
            if (msg) {
                int r = random.nextInt(250);
                int gr = random.nextInt(250);
                int b = random.nextInt(250);

                g.setColor(new Color(r,gr,b));

                int height = random.nextInt(120) + 10;
                int width = random.nextInt(120) + 10;

                int xPos = random.nextInt(40) + 10;
                int yPos = random.nextInt(40) + 10;
                g.fillRect(xPos,yPos,width, height);
                msg = false;
            }
        }
    }


}
