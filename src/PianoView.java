/**
 * This program builds the piano GUI. It uses JButtons to represent the the piano keys and a
 *      JSlider represents the octave changer.
 *
 * @author John Hyde and Elizabeth Larson
 * @see https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html, Oracle, working with GridBagLayout
 * @see https://docs.oracle.com/javase/7/docs/api/javax/swing/SwingConstants.html, Oracle, working with JLabel allignment
 * @see https://www.youtube.com/watch?v=SUyh1GLQpM0, Java Swing Tutorial, changing JLabel font size
 */

import javax.swing.*;
import java.awt.*;

public class PianoView extends JFrame {
    /** pianoController - PianoController object that gives access to GUI functionality and database storage */
    private PianoController pianoController;
    /** octavePickingLabel - labels where the octave picking slider is */
    protected JLabel octavePickingLabel;
    /** octavePickingSlider - slider that allows the user to choose an octave */
    protected JSlider octavePickingSlider;
    /** cKey - white key representing C keys of any octave */
    protected JButton cKey;
    /** dKey - white key representing D keys of any octave */
    protected JButton dKey;
    /** eKey - white key representing E keys of any octave */
    protected JButton eKey;
    /** fKey - white key representing F keys of any octave */
    protected JButton fKey;
    /** gKey - white key representing G keys of any octave */
    protected JButton gKey;
    /** aKey - white key representing A keys of any octave */
    protected JButton aKey;
    /** bKey - white key representing B keys of any octave */
    protected JButton bKey;
    /** cNextOctaveKey - white key representing C keys of the consecutive octave */
    protected JButton cNextOctaveKey;
    /** cSharpKey - black key representing C# keys of any octave */
    protected JButton cSharpKey;
    /** dSharpKey - black key representing D# keys of any octave */
    protected JButton dSharpKey;
    /** fSharpKey - black key representing F# keys of any octave */
    protected JButton fSharpKey;
    /** gSharpKey - black key representing G# keys of any octave */
    protected JButton gSharpKey;
    /** aSharpKey - black key representing A# keys of any octave */
    protected JButton aSharpKey;

    /**
     * Constructor for the PianoView
     * Create a new GUI view and call a method to set up the components
     * Executes a graceful exit when the user closes the GUI
     *
     * @param pianoController PianoController object that connects this view to the controller class
     * @see "No Borrowed Code"
     */
    public PianoView(PianoController pianoController) {
        super("JPiano");
        this.pianoController = pianoController;
        setVisible(true);
        setPreferredSize(new Dimension(700, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpPiano();
        pack();
    }

    /**
     * Sets up the panels for the piano GUI
     * Adds black and white keys represented as JButtons
     * Adds a slider that allows the user to change the octave of the keys on the screen
     *
     * @see "https://docs.oracle.com/javase/7/docs/api/javax/swing/SwingConstants.html, Oracle, working with JLabel allignment"
     * @see "https://www.youtube.com/watch?v=SUyh1GLQpM0, Java Swing Tutorial, changing JLabel font size"
     */
    public void setUpPiano() {
        // Main panel - used to organize the other mini panels
        JPanel megaPane = new JPanel();

        // Octave slider starts in the middle of the piano (octave 4)
        // The highest octave is 7 and the lowest octave is 1
        JPanel sliderPanel = new JPanel();
        octavePickingSlider = new JSlider(JSlider.HORIZONTAL, 1, 7, 4);
        octavePickingSlider.setMajorTickSpacing(1);
        octavePickingSlider.setMinorTickSpacing(1);
        octavePickingSlider.setPaintTicks(true);
        octavePickingSlider.setPaintLabels(true);
        octavePickingLabel = new JLabel("Octave:   ", SwingConstants.RIGHT);
        octavePickingLabel.setFont(new Font("Dialog", Font.BOLD, 20));
        sliderPanel.add(octavePickingLabel);
        sliderPanel.add(octavePickingSlider);
        sliderPanel.setLayout(new GridLayout(1, 2));

        // Set up the panels that hold the black keys
        // gridPane1 represents the C# and D# keys
        // gridPane2 represents the F#, G#, and A# keys
        JPanel blackKeysPane = new JPanel();
        JPanel gridPane1 = new JPanel();
        JPanel gridPane2 = new JPanel();
        gridPane2.setSize(new Dimension(3000, 200));
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        cSharpKey = new JButton("C4#");
        dSharpKey = new JButton("D4#");
        fSharpKey = new JButton("F4#");
        gSharpKey = new JButton("G4#");
        aSharpKey = new JButton("A4#");

        // Set up the layout for the C# Key
        c.gridx=0;
        c.gridy=0;
        c.anchor =GridBagConstraints.PAGE_END;
        cSharpKey.setPreferredSize(new Dimension(70, 200));
        c.insets = new Insets(0,0,0,10);
        cSharpKey.setBackground(Color.BLACK);
        cSharpKey.setForeground(Color.WHITE);
        grid.setConstraints(cSharpKey,c);
        gridPane1.add(cSharpKey);

        // Set up the layout for the D# Key
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

        // Empty pane that separates the two black key panels
        JPanel emptyPane = new JPanel();
        emptyPane.setPreferredSize(new Dimension(35, 200));

        // Set up the layout for the F# Key
        c.gridx=0;
        c.gridy=0;
        c.anchor =GridBagConstraints.PAGE_END;
        fSharpKey.setBackground(Color.BLACK);
        fSharpKey.setForeground(Color.WHITE);
        fSharpKey.setPreferredSize(new Dimension(70, 200));
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0,0,0,10);
        grid.setConstraints(fSharpKey, c);
        gridPane2.add(fSharpKey);

        // Set up the layout for the G# Key
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

        // Set up the layout for the A# Key
        c.gridx=2;
        c.gridy=0;
        aSharpKey.setBackground(Color.BLACK);
        aSharpKey.setForeground(Color.WHITE);
        aSharpKey.setPreferredSize(new Dimension(70, 200));
        c.anchor =GridBagConstraints.PAGE_END;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.insets = new Insets(0,0,0,0);
        grid.setConstraints(aSharpKey, c);
        gridPane2.add(aSharpKey);

        // Empty pane that pushes the two black key panels over
        JPanel emptyPane2 = new JPanel();
        emptyPane2.setPreferredSize(new Dimension(70, 200));

        // Create a panel for all of the white, natural keys on the piano
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

        // Add all panels to the main panel in a way that looks like a physical piano
        megaPane.add(sliderPanel, BorderLayout.NORTH);
        blackKeysPane.add(gridPane1);
        blackKeysPane.add(emptyPane);
        blackKeysPane.add(gridPane2);
        blackKeysPane.add(emptyPane2);
        megaPane.add(blackKeysPane, BorderLayout.CENTER);
        megaPane.add(whitePianoKeys, BorderLayout.NORTH);
        getContentPane().add(megaPane);
    }
}