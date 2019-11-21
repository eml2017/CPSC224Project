import javax.swing.*;
import java.awt.*;

public class PianoView extends JFrame {
    private PianoController pianoController;
    // Octave chooser
    private JSlider octavePickingSlider;
    // Octave 1 (<note name><octave number>Key)
    // White keys
    protected JButton c1Key;
    protected JButton d1Key;
    protected JButton e1Key;
    protected JButton f1Key;
    protected JButton g1Key;
    protected JButton a1Key;
    protected JButton b1Key;
    protected JButton c2Key;
    // Black keys
    protected JButton c1SharpKey;
    protected JButton d1SharpKey;
    protected JButton f1SharpKey;
    protected JButton g1SharpKey;
    protected JButton a1SharpKey;
    // Octave 2
    // Octave 3
    // Octave 4
    // Octave 5
    // Octave 6
    // Octave 7
    protected JButton cKey;
    protected JButton dKey;

    public PianoView(PianoController pianoController) {
        super("JPiano");
        this.pianoController = pianoController;
        setVisible(true);
        setPreferredSize(new Dimension(700, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpPiano();
        pack();
    }

    public void setUpPiano() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        /*JPanel sliderPanel = new JPanel();
        octavePickingSlider = new JSlider();
        sliderPanel.add(octavePickingSlider);
        contentPanel.add(sliderPanel, BorderLayout.NORTH);*/

        //JPanel pianoKeys = new JPanel();
        JPanel blackPianoKeys = new JPanel();
        blackPianoKeys.setLayout(new GridLayout(1, 5));
        JPanel whitePianoKeys = new JPanel();
        whitePianoKeys.setLayout(new GridLayout(1, 8));

        // Set background found by playing around with IntelliJ's autocomplete
        c1SharpKey = new JButton("C1#");
        c1SharpKey.setBackground(Color.BLACK);
        blackPianoKeys.add(c1SharpKey);
        d1SharpKey = new JButton("D1#");
        d1SharpKey.setBackground(Color.BLACK);
        blackPianoKeys.add(d1SharpKey);
        f1SharpKey = new JButton("F1#");
        f1SharpKey.setBackground(Color.BLACK);
        blackPianoKeys.add(f1SharpKey);
        g1SharpKey = new JButton("G1#");
        g1SharpKey.setBackground(Color.BLACK);
        blackPianoKeys.add(g1SharpKey);
        a1SharpKey = new JButton("A1#");
        a1SharpKey.setBackground(Color.BLACK);
        blackPianoKeys.add(a1SharpKey);

        c1Key = new JButton("C1");
        c1Key.setBackground(Color.WHITE);
        whitePianoKeys.add(c1Key);
        d1Key = new JButton("D1");
        d1Key.setBackground(Color.WHITE);
        whitePianoKeys.add(d1Key);
        e1Key = new JButton("E1");
        e1Key.setBackground(Color.WHITE);
        whitePianoKeys.add(e1Key);
        f1Key = new JButton("F1");
        f1Key.setBackground(Color.WHITE);
        whitePianoKeys.add(f1Key);
        g1Key = new JButton("G1");
        g1Key.setBackground(Color.WHITE);
        whitePianoKeys.add(g1Key);
        a1Key = new JButton("A1");
        a1Key.setBackground(Color.WHITE);
        whitePianoKeys.add(a1Key);
        b1Key = new JButton("B1");
        b1Key.setBackground(Color.WHITE);
        whitePianoKeys.add(b1Key);
        c2Key = new JButton("C2");
        c2Key.setBackground(Color.WHITE);
        whitePianoKeys.add(c2Key);

        contentPanel.add(blackPianoKeys);
        contentPanel.add(whitePianoKeys);
        //contentPanel.add(pianoKeys, BorderLayout.CENTER);
        //contentPanel.add(pianoKeys);
        getContentPane().add(contentPanel);
    }
}