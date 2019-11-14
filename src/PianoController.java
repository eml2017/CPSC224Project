import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

// Sources used to play the sound file
// I made the sound file in the program Audacity, so nothing to cite for that yet
// https://alvinalexander.com/java/java-audio-example-java-au-play-sound
//      ^ playing the .wav sound file found in src folder

public class PianoController {
    private PianoModel pianoModel;
    private PianoView pianoView;

    public static void main (String[] args) {
        PianoModel pianoModel = new PianoModel();
        PianoController controller = new PianoController(pianoModel);
    }

    public PianoController(PianoModel pianoModel) {
        this.pianoModel = pianoModel;
        this.pianoView = new PianoView(this);

        pianoView.cKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                try {
                    System.out.println("The C key was pushed");
                    InputStream inputStream = getClass().getResourceAsStream("tone.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        pianoView.dKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                try {
                    System.out.println("The D key was pushed");
                    InputStream inputStream = getClass().getResourceAsStream("tone.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}