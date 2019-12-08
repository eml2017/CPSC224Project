import jdk.internal.dynalink.support.BottomGuardingDynamicLinker;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PianoView extends JFrame {
    private PianoController pianoController;
    // Octave chooser and label
    protected JLabel octavePickingLabel;
    protected JSlider octavePickingSlider;
    // White keys
    protected JButton cKey;
    protected JButton dKey;
    protected JButton eKey;
    protected JButton fKey;
    protected JButton gKey;
    protected JButton aKey;
    protected JButton bKey;
    protected JButton cNextOctaveKey;
    // Black keys
    protected JButton cSharpKey;
    protected JButton dSharpKey;
    protected JButton fSharpKey;
    protected JButton gSharpKey;
    protected JButton aSharpKey;

    public PianoView(PianoController pianoController) {
        super("JPiano");
        this.pianoController = pianoController;
        setVisible(true);
        setPreferredSize(new Dimension(700, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpPiano();
        pack();
    }

    public void setUpPiano() {
        JPanel megaPane = new JPanel();
        //megaPane.setLayout(new BoxLayout(megaPane, BoxLayout.Y_AXIS));

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


        JPanel blackKeysPane = new JPanel();
        JPanel gridPane1 = new JPanel();
        JPanel gridPane2 = new JPanel();
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        cSharpKey = new JButton("C4#");
        dSharpKey = new JButton("D4#");
        fSharpKey = new JButton("F4#");
        gSharpKey = new JButton("G4#");
        aSharpKey = new JButton("A4#");

        c.gridx=0;
        c.gridy=0;
        c.anchor =GridBagConstraints.PAGE_END;
        cSharpKey.setPreferredSize(new Dimension(70, 200));
        c.insets = new Insets(0,0,0,10);
        cSharpKey.setBackground(Color.BLACK);
        cSharpKey.setForeground(Color.WHITE);
        grid.setConstraints(cSharpKey,c);
        gridPane1.add(cSharpKey);

        c.gridx=1;
        c.gridy=0;
        c.anchor =GridBagConstraints.PAGE_END;
        c.anchor =GridBagConstraints.PAGE_END;
        dSharpKey.setBackground(Color.BLACK);
        dSharpKey.setForeground(Color.WHITE);
        dSharpKey.setPreferredSize(new Dimension(70, 200));
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0,0,0,0);
        grid.setConstraints(dSharpKey, c);
        gridPane1.add(dSharpKey);

        c.gridx=0;
        c.gridy=0;
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor =GridBagConstraints.PAGE_END;
        fSharpKey.setBackground(Color.BLACK);
        fSharpKey.setForeground(Color.WHITE);
        fSharpKey.setPreferredSize(new Dimension(70, 200));
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0,0,0,10);
        grid.setConstraints(fSharpKey, c);
        gridPane2.add(fSharpKey);

        c.gridx=1;
        c.gridy=0;
        c.anchor =GridBagConstraints.PAGE_END;
        gSharpKey.setBackground(Color.BLACK);
        gSharpKey.setForeground(Color.WHITE);
        gSharpKey.setPreferredSize(new Dimension(70, 200));
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0,0,0,10);
        grid.setConstraints(gSharpKey, c);
        gridPane2.add(gSharpKey);

        c.gridx=2;
        c.gridy=0;
        //c.fill = GridBagConstraints.HORIZONTAL;
        aSharpKey.setBackground(Color.BLACK);
        aSharpKey.setForeground(Color.WHITE);
        aSharpKey.setPreferredSize(new Dimension(70, 200));
        c.anchor =GridBagConstraints.PAGE_END;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0,0,0,0);
        grid.setConstraints(aSharpKey, c);
        gridPane2.add(aSharpKey);

        JPanel whitePianoKeys = new JPanel();
        whitePianoKeys.setLayout(new GridLayout(1, 8));
        cKey = new JButton("C4");
        cKey.setPreferredSize(new Dimension(70, 200));
        cKey.setBackground(Color.WHITE);
        whitePianoKeys.add(cKey);
        dKey = new JButton("D4");
        dKey.setBackground(Color.WHITE);
        whitePianoKeys.add(dKey);
        eKey = new JButton("E4");
        eKey.setBackground(Color.WHITE);
        whitePianoKeys.add(eKey);
        fKey = new JButton("F4");
        fKey.setBackground(Color.WHITE);
        whitePianoKeys.add(fKey);
        gKey = new JButton("G4");
        gKey.setBackground(Color.WHITE);
        whitePianoKeys.add(gKey);
        aKey = new JButton("A4");
        aKey.setBackground(Color.WHITE);
        whitePianoKeys.add(aKey);
        bKey = new JButton("B4");
        bKey.setBackground(Color.WHITE);
        whitePianoKeys.add(bKey);
        cNextOctaveKey = new JButton("C5");
        cNextOctaveKey.setBackground(Color.WHITE);
        whitePianoKeys.add(cNextOctaveKey);


        megaPane.add(sliderPanel, BorderLayout.NORTH);
        blackKeysPane.add(gridPane1);
        blackKeysPane.add(gridPane2);
        megaPane.add(blackKeysPane, BorderLayout.CENTER);
        megaPane.add(whitePianoKeys, BorderLayout.NORTH);
        getContentPane().add(megaPane);
    }
}