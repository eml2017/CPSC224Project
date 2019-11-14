import javax.swing.*;
import java.awt.*;

public class PianoView extends JFrame {
    private PianoController pianoController;
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

        cKey = new JButton("This will be the C key");
        contentPanel.add(cKey);

        dKey = new JButton("This will be the D key");
        contentPanel.add(dKey);

        getContentPane().add(contentPanel);
    }
}