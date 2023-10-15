import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import static javax.sound.midi.ShortMessage.*;

public class BeatBox {
    private ArrayList<JCheckBox> checkboxlist;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;
    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat",
            "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
            "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
            "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
            "Open Hi Conga"};
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};
public static void main(String[] args) {
    new BeatBox().buildGUI();

}
public void buildgui(){
        Frame frame= new Frame("Cyber BeatBox");
        frame.setDefaultCloseoperation(Frame.EXIT_ON CLOSE);
        BorderLayout layout=new BorderLayout();
        JPanel background=new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        Box buttonBox=new Box(Boxlayout.Y_AXIS);
        Button start=new Button("Start");
        start.addActionListener(e->buildTrackAndstart());
        buttonBox.add(start);

        Button stop=new Button("Stop");
        stop.addActionlistener(e->sequencer.stop());
        buttonBox.add(stop);

        Button upTempo=new Button("Tempo Up");
        upTempo.addActionListener(e -> changeTempo(1.03f));
        buttonBox.add(upTempo);

        Button downTempo=new Button("Tempo Down");
        downTempo.addActionListener(e -> changeTempo(0.97f));
        buttonBox.add(downTempo);

        Box nameBox = new Box(BoxLayout. Y_AXIS);
        for (String instrumentName : instrumentNames) {
        JLabel instrumentLabel = new JLabel (instrumentName);
        instrumentLabel.setBorder(BorderFactory.createEmptyBorder (4, 1, 4, 1));
        nameBox.add(instrumentLabel);
        }

    background.add(BorderLayout.EAST, buttonBox);
    background.add(BorderLayout. WEST, nameBox);

    frame.getContentPane().add (background);
    Gridlayout grid = new Gridlayout(16, 16);
    grid.setvgap(1);
    grid.setHgap(2);
    JPanel mainPanel = new JPanel(grid);
    background.add(BorderLayout.CENTER, mainPanel);

    checkboxList = new Arraylist<>() ;
    for (int i = 0; i < 256; i++) {
        CheckBox c = new CheckBox();
        c.setselected(false);
        checkboxlist.add(c);
        mainPanel.add(c);
    }
    setUpMidi();
    frame.setBounds(50, 50, 300, 300);
    frame.pack();
    frame.setVisible(true);
    private void setUpMidi () {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void buildTrackAndStart() {
        int[] trackList;
        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {
            trackList = new int[16];
            int key = instruments[i];
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = checkboxlist.get(j + 16 * i);
                if (jc.isSelected()) {
                    trackList[] =key;
                } else {
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList);
            track.add(makeEvent(PROGRAM_CHANGE, 0,1,0,15));

        }

        track.add.()


        }
    }
    }




