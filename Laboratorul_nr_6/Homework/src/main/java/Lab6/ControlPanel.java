package Lab6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    private JButton exitBtn = new JButton("Exit");
    private JButton loadBtn = new JButton("Load");
    private JButton saveBtn = new JButton("Save");
    private JButton exportBtn = new JButton("Export");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * I add my buttons and their actions
     */
    private void init() {
        setLayout(new FlowLayout());

        add(exitBtn);
        add(saveBtn);
        add(loadBtn);
        add(exportBtn);

        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        exportBtn.addActionListener(this::exportPNG);
    }

    /**
     * exits the game
     *
     * @param e
     */
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    /**
     * Saves the current state of the game in an external json file
     *
     * @param e
     */
    private void saveGame(ActionEvent e) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(
                    new File("saves/board.json"),
                    this.frame.logic);
            mapper.writeValue(
                    new File("saves/tokens.json"),
                    this.frame.logic.tokenTable);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * I call a method from DrawingPanel that helps me export the canvas as a png
     *
     * @param e
     */
    private void exportPNG(ActionEvent e) {
        this.frame.canvas.saveImage("canvas", "png");
    }

    /**
     * Loading the game method. It's not working properly yet
     *
     * @param e
     */
    private void loadGame(ActionEvent e) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<Node, Node>> typeRef
                = new TypeReference<HashMap<Node, Node>>() {
        };

        try {
            String jsonInput = mapper.readValue("saves/tokens", String.class);
            java.util.Map<Node, Node> map = mapper.readValue(jsonInput, typeRef);
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();
        }
    }
}
