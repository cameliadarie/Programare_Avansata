package Lab6;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    private JLabel label;
    private JSpinner spinnerRows;
    private JSpinner spinnerCols;
    private JButton refreshBtn;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * I add new components to the configpanel: a label, 2 spinners for the rows and columns and a refresh button
     */
    private void init() {
        label = new JLabel("Grid size:");
        spinnerRows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerCols = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        refreshBtn = new JButton("Refresh");
        add(label);
        add(spinnerRows);
        add(spinnerCols);
        add(refreshBtn);
        refreshBtn.addActionListener(this::refresh);
    }

    public int getRows() {
        return (int) spinnerRows.getValue();
    }

    public int getCols() {
        return (int) spinnerCols.getValue();
    }

    /**
     * It gets the new number of columns and rows and repaints the game
     *
     * @param e
     */
    private void refresh(ActionEvent e) {
        this.frame.canvas.init(getCols(), getRows());
        this.frame.repaint();
    }
}
