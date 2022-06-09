package proiect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    List<Rows> myList;
    private JButton evenimenteBtn;
    private JButton saliBtn;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * I add new components to the configpanel: a label, 2 spinners for the rows and columns and a refresh button
     */
    private void init() {
        evenimenteBtn = new JButton("Evenimente");
        saliBtn = new JButton("Sali");
        add(evenimenteBtn);
        add(saliBtn);
        evenimenteBtn.addActionListener(this::evenimente);
        saliBtn.addActionListener(this::sali);
    }

    /**
     * It gets the new number of columns and rows and repaints the game
     *
     * @param e
     */
    private void evenimente(ActionEvent e) {
        try {
            this.frame.canvas.repaint();
            this.frame.controlPanel.rez = Collections.emptyList();
            Database.createConnection();

            AllClassesDAO allClassesDAO = new AllClassesDAO();
            allClassesDAO.setConnection(Database.getConnection());

            myList = allClassesDAO.findAll(InfoTable.EVENTS);

        } catch (SQLException ee) {
            ee.printStackTrace();
        }
        ;
    }

    private void sali(ActionEvent e) {
        try {
            Database.createConnection();

            AllClassesDAO allClassesDAO = new AllClassesDAO();
            allClassesDAO.setConnection(Database.getConnection());

            myList = allClassesDAO.findAll(InfoTable.ROOMS);

        } catch (SQLException ee) {
            ee.printStackTrace();
        }
        ;
        this.frame.controlPanel.rez = Collections.emptyList();
        this.frame.canvas.repaint();
    }
}
