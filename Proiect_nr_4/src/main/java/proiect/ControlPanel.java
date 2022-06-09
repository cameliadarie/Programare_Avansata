package proiect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton repBtn = new JButton("Repartizeaza");
    Repartizare rep = new Repartizare();
    List<String> rez = new ArrayList<String>();

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * Added my buttons and their functionality
     */
    private void init() {
        setLayout(new FlowLayout());

        add(repBtn);
        repBtn.addActionListener(this::reps);
    }

    private void reps(ActionEvent e) {

        rez = rep.afisare();
        this.frame.configPanel.myList = Collections.emptyList();
        this.frame.canvas.repaint();
    }


}
