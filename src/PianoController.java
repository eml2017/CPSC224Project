import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

// Sound files downloaded from:
// https://freesound.org/people/Tesabob2001/packs/12995/

// Sources used to play the sound file:
// https://alvinalexander.com/java/java-audio-example-java-au-play-sound

public class PianoController {
    private PianoModel pianoModel;
    private PianoView pianoView;

    public static void main (String[] args) {
        PianoModel pianoModel = new PianoModel();
        PianoController controller = new PianoController(pianoModel);
    }

    // C3 -> C4 working
    public PianoController(PianoModel pianoModel) {
        this.pianoModel = pianoModel;
        this.pianoView = new PianoView(this);

        pianoView.cKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InputStream inputStream = getClass().getResourceAsStream("c3.wav");
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
                try {
                    InputStream inputStream = getClass().getResourceAsStream("d3.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        pianoView.eKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InputStream inputStream = getClass().getResourceAsStream("e3.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        pianoView.fKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InputStream inputStream = getClass().getResourceAsStream("f3.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        pianoView.gKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InputStream inputStream = getClass().getResourceAsStream("g3.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        pianoView.aKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InputStream inputStream = getClass().getResourceAsStream("a3.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        pianoView.bKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InputStream inputStream = getClass().getResourceAsStream("b3.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        pianoView.cNextOctaveKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InputStream inputStream = getClass().getResourceAsStream("c4.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        pianoView.cSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InputStream inputStream = getClass().getResourceAsStream("c#3.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        pianoView.dSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InputStream inputStream = getClass().getResourceAsStream("d#3.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        pianoView.fSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InputStream inputStream = getClass().getResourceAsStream("f#3.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        pianoView.gSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InputStream inputStream = getClass().getResourceAsStream("g#3.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        pianoView.aSharpKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    InputStream inputStream = getClass().getResourceAsStream("a#3.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}