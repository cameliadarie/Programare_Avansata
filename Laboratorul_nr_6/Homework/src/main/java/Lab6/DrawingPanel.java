package Lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    private boolean[][] table;
    private int rows, cols;
    private int canvasWidth = 400, canvasHeight = 400;
    private int boardWidth, boardHeight;
    private int cellWidth, cellHeight;
    private int padX, padY;
    private int stoneSize = 20;
    private int[][] player;
    private boolean currentPlayer = true;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setStone(e.getX(), e.getY());

            }
        });
    }

    /**
     * I initialise the table of pressed elements and the matrix where I keep which player pressed what button.
     * I initialise the nr of rows, cols etc
     *
     * @param rows nr of rows
     * @param cols nr of cols
     */
    final void init(int rows, int cols) {
        table = new boolean[rows][cols];
        player = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
        paintSticks(g);
        paintStones(g);
    }

    /**
     * I draw the rows, the cols and the circles
     *
     * @param g
     */
    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int x2 = x1;
            int y1 = padY;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.setStroke(new BasicStroke(1));
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }


    /**
     * I paint the coloured circles depending on which player chose them
     *
     * @param g
     */
    private void paintStones(Graphics2D g) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + row * cellWidth;
                int y = padY + col * cellHeight;
                g.setStroke(new BasicStroke(1));
                if (table[row][col] && player[row][col] == 1) {
                    g.setColor(Color.RED);
                    g.fillOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);


                } else if (table[row][col] && player[row][col] == 2) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
                }

            }
        }
    }


    /**
     * I paint the sticks
     *
     * @param g
     */
    private void paintSticks(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(4));
        this.frame.logic.tokenTable.forEach((key, value) -> {
            g.drawLine(value.getRow() * cellWidth + padX, value.getCol() * cellHeight + padY, key.getRow() * cellWidth + padX, key.getCol() * cellHeight + padY);
        });
    }

    /**
     * This method exports the current canvas into an external file
     *
     * @param name
     * @param type
     */
    public void saveImage(String name, String type) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        paint(g2);
        try {
            ImageIO.write(image, type, new File(name + "." + type));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * I verify that the circle hasn't been chosen already. If it was, I print that and ask the player to choose
     * another circle. If it wasn't I mark it as chosen and change the turn
     *
     * @param x
     * @param y
     */
    private void setStone(int x, int y) {
        int row = (x - padX / 2) / cellWidth;
        int col = (y - padY / 2) / cellHeight;
        System.out.println("Mouse pressed at: " + row + " " + col);
        if (!table[row][col]) {
            table[(x - padX / 2) / cellWidth][(y - padY / 2) / cellHeight] = true;
            if (currentPlayer) player[row][col] = 2;
            else player[row][col] = 1;
            currentPlayer = !currentPlayer;
        } else System.out.println("There is already a stone here. Please choose another spot");
        this.frame.repaint();
    }
}
