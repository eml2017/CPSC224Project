import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

// Sound files downloaded from:
// https://freesound.org/people/Tesabob2001/packs/12995/

// Sources used to play the sound file:
// https://alvinalexander.com/java/java-audio-example-java-au-play-sound

public class PianoController {
    public int octave;
    private PianoView pianoView;
    private PianoOpenHelper openHelper = new PianoOpenHelper();

    public static void main (String[] args) {
        PianoController controller = new PianoController();
    }

    public void playSound(int octave, String note, ActionEvent e) {
        try {
             InputStream inputStream = getClass().getResourceAsStream(note + octave + ".wav");
             AudioStream audioStream = new AudioStream(inputStream);
             AudioPlayer.player.start(audioStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void playSharpSound(int octave, String note, ActionEvent e) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(note + "#" + octave + ".wav");
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // C3 -> C4 working
    public PianoController() {
        octave = openHelper.getOctave();
        this.pianoView = new PianoView(this);
        pianoView.octavePickingSlider.setValue(octave);

        pianoView.octavePickingSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                openHelper.updateOctave(source.getValue());
                octave = openHelper.getOctave();
                pianoView.cKey.setText("C" + octave);
                pianoView.dKey.setText("D" + octave);
                pianoView.eKey.setText("E" + octave);
                pianoView.fKey.setText("F" + octave);
                pianoView.gKey.setText("G" + octave);
                pianoView.aKey.setText("A" + octave);
                pianoView.bKey.setText("B" + octave);
                pianoView.cNextOctaveKey.setText("C" + octave + 1);
                pianoView.cSharpKey.setText("C#" + octave);
                pianoView.dSharpKey.setText("D#" + octave);
                pianoView.fSharpKey.setText("F#" + octave);
                pianoView.gSharpKey.setText("G#" + octave);
                pianoView.aSharpKey.setText("A#" + octave);
            }
        });

        pianoView.cKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "c", e);
            }
        });

        pianoView.dKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "d", e);
            }
        });

        pianoView.eKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "e", e);
            }
        });

        pianoView.fKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "f", e);
            }
        });

        pianoView.gKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "g", e);
            }
        });

        pianoView.aKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "a", e);
            }
        });

        pianoView.bKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "b", e);
            }
        });

        pianoView.cNextOctaveKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave + 1, "c", e);
            }
        });

        pianoView.cSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSharpSound(octave, "c", e);
            }
        });

        pianoView.dSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSharpSound(octave, "d", e);
            }
        });

        pianoView.fSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSharpSound(octave, "f", e);
            }
        });

        pianoView.gSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSharpSound(octave, "g", e);
            }
        });

        pianoView.aSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSharpSound(octave, "a", e);
            }
        });
    }
}