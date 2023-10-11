package MIDI_BeatBox;
import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;
import javax.swing.*;

public class Beatbox {
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
        gui.animate();

    }
    public void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //          First Event
            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(PROGRAM_CHANGE, 1, instrument,0);
            MidiEvent changeInstrument = new MidiEvent(msg1, 1);
            track.add(changeInstrument);
//          Second Event
            ShortMessage msg2 = new ShortMessage();
            msg2.setMessage(NOTE_ON, 1, note,100);
            MidiEvent noteOn = new MidiEvent(msg2, 1);
            track.add(noteOn);
            // Third Event
            ShortMessage msg3 = new ShortMessage();
            msg3.setMessage(NOTE_OFF, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(msg3, 16);
            track.add(noteOff);


            player.setSequence(seq);

            player.start();


        }
        catch(Exception e) {
            System.out.println("Me sad");
        }

    }

}
