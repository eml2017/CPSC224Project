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
    protected JButton c3Key;
    protected JButton d3Key;
    protected JButton e3Key;
    protected JButton f3Key;
    protected JButton g3Key;
    protected JButton a3Key;
    protected JButton b3Key;
    protected JButton c4Key;
    // Black keys
    protected JButton c3SharpKey;
    protected JButton d3SharpKey;
    protected JButton f3SharpKey;
    protected JButton g3SharpKey;
    protected JButton a3SharpKey;
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
        c3SharpKey = new JButton("C3#");
        c3SharpKey.setBackground(Color.BLACK);
        c3SharpKey.setForeground(Color.WHITE);
        blackPianoKeys.add(c3SharpKey);
        d3SharpKey = new JButton("D3#");
        d3SharpKey.setBackground(Color.BLACK);
        d3SharpKey.setForeground(Color.WHITE);
        blackPianoKeys.add(d3SharpKey);
        f3SharpKey = new JButton("F3#");
        f3SharpKey.setBackground(Color.BLACK);
        f3SharpKey.setForeground(Color.WHITE);
        blackPianoKeys.add(f3SharpKey);
        g3SharpKey = new JButton("G3#");
        g3SharpKey.setBackground(Color.BLACK);
        g3SharpKey.setForeground(Color.WHITE);
        blackPianoKeys.add(g3SharpKey);
        a3SharpKey = new JButton("A3#");
        a3SharpKey.setBackground(Color.BLACK);
        a3SharpKey.setForeground(Color.WHITE);
        blackPianoKeys.add(a3SharpKey);

        c3Key = new JButton("C3");
        c3Key.setBackground(Color.WHITE);
        whitePianoKeys.add(c3Key);
        d3Key = new JButton("D3");
        d3Key.setBackground(Color.WHITE);
        whitePianoKeys.add(d3Key);
        e3Key = new JButton("E3");
        e3Key.setBackground(Color.WHITE);
        whitePianoKeys.add(e3Key);
        f3Key = new JButton("F3");
        f3Key.setBackground(Color.WHITE);
        whitePianoKeys.add(f3Key);
        g3Key = new JButton("G3");
        g3Key.setBackground(Color.WHITE);
        whitePianoKeys.add(g3Key);
        a3Key = new JButton("A3");
        a3Key.setBackground(Color.WHITE);
        whitePianoKeys.add(a3Key);
        b3Key = new JButton("B3");
        b3Key.setBackground(Color.WHITE);
        whitePianoKeys.add(b3Key);
        c4Key = new JButton("C4");
        c4Key.setBackground(Color.WHITE);
        whitePianoKeys.add(c4Key);

        contentPanel.add(sliderPanel);
        contentPanel.add(blackPianoKeys);
        contentPanel.add(whitePianoKeys);
        getContentPane().add(contentPanel);
    }
}