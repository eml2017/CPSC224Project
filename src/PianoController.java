/**
 * This program connects the piano GUI (view) to the database (model). It handles the logic
 *      for a change in the octave slider, updating the value in the database. It also plays
 *      the corresponding sound file in the src folder when a key button is pushed.
 *
 * @author John Hyde and Elizabeth Larson
 * @see https://alvinalexander.com/java/java-audio-example-java-au-play-sound, Alvin Alexander, how to play sound files
 * @see https://freesound.org/people/Goup_1/packs/10684/?page=13#sound, Uncle Dave's Sound's by Goup_1, downloaded piano sound files
 */

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

public class PianoController {
    /** octave - integer value that stores the octave the piano is set to */
    public int octave;
    /** pianoView - PianoView object that allows access to GUI components */
    private PianoView pianoView;
    /** openHelper - PianoOpenHelper that allows access to database logic */
    private PianoOpenHelper openHelper = new PianoOpenHelper();

    /**
     * Instantiates the program, connecting the controller program (which has access to the model... the database helper) to the view program
     *
     * @param args parameter arguments
     * @see "No Borrowed Code"
     */
    public static void main (String[] args) {
        PianoController controller = new PianoController();
    }

    /**
     * Play the sound of a white key
     * Opens an InputStream to read a .wav sound file from the src folder
     * Uses this to create an AudioStream and play the file
     *
     * @param octave current octave chosen by the user
     * @param note the note that was pushed, represented as a lowercase char
     * @param e ActionEvent passed-in from the ActionListener
     * @see "https://alvinalexander.com/java/java-audio-example-java-au-play-sound, Alvin Alexander, how to play sound files"
     */
    public void playSound(int octave, String note, ActionEvent e) {
        // Attempt to create read a sound file and play it using an AudioStream
        try {
            // White key sounds are stored in the src folder as <note><octave>.wav (example: c5.wav)
             InputStream inputStream = getClass().getResourceAsStream(note + octave + ".wav");
             AudioStream audioStream = new AudioStream(inputStream);
             AudioPlayer.player.start(audioStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Play the sound of a black key
     * Opens an InputStream to read a .wav sound file from the src folder
     * Uses this to create an AudioStream and play the file
     *
     * @param octave current octave chosen by the user
     * @param note the note that was pushed, represented as a lowercase char
     * @param e ActionEvent passed-in from the ActionListener
     * @see "https://alvinalexander.com/java/java-audio-example-java-au-play-sound, Alvin Alexander, how to play sound files"
     */
    public void playSharpSound(int octave, String note, ActionEvent e) {
        // Attempt to create read a sound file and play it using an AudioStream
        try {
            // Black key sounds are stored in the src folder as <note>#<octave>.wav (example: c#5.wav)
            InputStream inputStream = getClass().getResourceAsStream(note + "#" + octave + ".wav");
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Updates the label based on the current octave (example: D4 or F#1)
     *
     * @see "No Borrowed Code"
     */
    public void updateKeyLabels() {
        // White keys
        pianoView.cKey.setText("C" + octave);
        pianoView.dKey.setText("D" + octave);
        pianoView.eKey.setText("E" + octave);
        pianoView.fKey.setText("F" + octave);
        pianoView.gKey.setText("G" + octave);
        pianoView.aKey.setText("A" + octave);
        pianoView.bKey.setText("B" + octave);
        pianoView.cNextOctaveKey.setText("C" + (octave + 1));
        // Black keys
        pianoView.cSharpKey.setText("C#" + octave);
        pianoView.dSharpKey.setText("D#" + octave);
        pianoView.fSharpKey.setText("F#" + octave);
        pianoView.gSharpKey.setText("G#" + octave);
        pianoView.aSharpKey.setText("A#" + octave);
    }

    /**
     * Constructor for the PianoController class
     * Utilizes ActionListeners defined in anonymous classes to respond to a key (button) being pushed
     * Responds by playing a sound that corresponds with the key
     *
     * @see "No Borrowed Code"
     */
    public PianoController() {
        // Set the octave slider to the value stored in the database
        octave = openHelper.getOctave();
        this.pianoView = new PianoView(this);
        // Update the view based on this (slider value and key/button labels)
        pianoView.octavePickingSlider.setValue(octave);
        updateKeyLabels();

        // Updates the octavePickingSlider as it changes (the user moves the slider)
        pianoView.octavePickingSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                // Update the database to reflect the new slider value
                openHelper.updateOctave(source.getValue());
                // Set the octave slider to the value stored in the database
                octave = openHelper.getOctave();
                // Update the view based on this (slider value and key/button labels)
                updateKeyLabels();
            }
        });

        // Plays a sound when the C key is pushed
        pianoView.cKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "c", e);
            }
        });

        // Plays a sound when the D key is pushed
        pianoView.dKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "d", e);
            }
        });

        // Plays a sound when the E key is pushed
        pianoView.eKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "e", e);
            }
        });

        // Plays a sound when the F key is pushed
        pianoView.fKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "f", e);
            }
        });

        // Plays a sound when the G key is pushed
        pianoView.gKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "g", e);
            }
        });

        // Plays a sound when the A key is pushed
        pianoView.aKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "a", e);
            }
        });

        // Plays a sound when the B key is pushed
        pianoView.bKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave, "b", e);
            }
        });

        // Plays a sound when the C key (of the next octave) is pushed
        pianoView.cNextOctaveKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound(octave + 1, "c", e);
            }
        });

        // Plays a sound when the C# key is pushed
        pianoView.cSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSharpSound(octave, "c", e);
            }
        });

        // Plays a sound when the D# key is pushed
        pianoView.dSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSharpSound(octave, "d", e);
            }
        });

        // Plays a sound when the F# key is pushed
        pianoView.fSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSharpSound(octave, "f", e);
            }
        });

        // Plays a sound when the G# key is pushed
        pianoView.gSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSharpSound(octave, "g", e);
            }
        });

        // Plays a sound when the A# key is pushed
        pianoView.aSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSharpSound(octave, "a", e);
            }
        });
    }
}