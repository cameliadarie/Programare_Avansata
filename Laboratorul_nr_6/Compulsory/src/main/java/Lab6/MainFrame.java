package Lab6;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    protected ConfigPanel configPanel;
    protected ControlPanel controlPanel;
    protected DrawingPanel canvas;

    public MainFrame() {
        super("Camelia's Game™");
        init();
    }

    /**
     * This method initializes the components of the frame and adds them to the borderlayout
     * The BorderLayout is used to arrange the components in five regions: north, south, east, west, and center.
     * Each region (area) may contain one component only. It is the default layout of a frame or window.
     * The BorderLayout provides five constants for each region:
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);
        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
        pack();
    }
}
