import javax.swing.*;
import java.awt.*;

public class PianoView extends JFrame {
    private PianoController pianoController;
    // Octave chooser and label
    protected JLabel octavePickingLabel;
    protected JSlider octavePickingSlider;
    // Octave 0 (A0 and B0)
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
    // Octave 8 (C8)

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

        JPanel sliderPanel = new JPanel();
        // Start in the middle of the piano (octave 4)
        // Highest octave is 8 (only has C8)
        // Lowest octave is 0 (only has A0 and B0)
        octavePickingSlider = new JSlider(JSlider.HORIZONTAL, 0, 8, 4);
        octavePickingSlider.setMajorTickSpacing(1);
        octavePickingSlider.setMinorTickSpacing(1);
        octavePickingSlider.setPaintTicks(true);
        octavePickingSlider.setPaintLabels(true);
        // Find source for SwingConstants
        octavePickingLabel = new JLabel("Octave:   ", SwingConstants.RIGHT);
        // Find source for label size
        octavePickingLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        sliderPanel.add(octavePickingLabel);
        sliderPanel.add(octavePickingSlider);
        sliderPanel.setLayout(new GridLayout(1, 2));

        JPanel blackPianoKeys = new JPanel();
        blackPianoKeys.setLayout(new GridLayout(1, 5));

        JPanel whitePianoKeys = new JPanel();
        whitePianoKeys.setLayout(new GridLayout(1, 8));

        // Set background found by playing around with IntelliJ's autocomplete
        c1SharpKey = new JButton("C1#");
        c1SharpKey.setBackground(Color.BLACK);
        c1SharpKey.setForeground(Color.WHITE);
        blackPianoKeys.add(c1SharpKey);
        d1SharpKey = new JButton("D1#");
        d1SharpKey.setBackground(Color.BLACK);
        d1SharpKey.setForeground(Color.WHITE);
        blackPianoKeys.add(d1SharpKey);
        f1SharpKey = new JButton("F1#");
        f1SharpKey.setBackground(Color.BLACK);
        f1SharpKey.setForeground(Color.WHITE);
        blackPianoKeys.add(f1SharpKey);
        g1SharpKey = new JButton("G1#");
        g1SharpKey.setBackground(Color.BLACK);
        g1SharpKey.setForeground(Color.WHITE);
        blackPianoKeys.add(g1SharpKey);
        a1SharpKey = new JButton("A1#");
        a1SharpKey.setBackground(Color.BLACK);
        a1SharpKey.setForeground(Color.WHITE);
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

        contentPanel.add(sliderPanel);
        contentPanel.add(blackPianoKeys);
        contentPanel.add(whitePianoKeys);
        getContentPane().add(contentPanel);
    }
}