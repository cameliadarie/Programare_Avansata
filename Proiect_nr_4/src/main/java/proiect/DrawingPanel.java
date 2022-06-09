package proiect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class DrawingPanel extends JPanel implements MouseListener {
    final MainFrame frame;
    private final Color colors[] = {Color.red, Color.blue, Color.green, Color.orange, Color.cyan, Color.magenta, Color.darkGray, Color.yellow};
    private final int color_n = colors.length;
    private Dimension area; //indicates area taken up by graphics
    private Vector<Rectangle> circles; //coordinates used to draw graphics
    private JPanel drawingPane;

    public DrawingPanel(MainFrame frame) {
        super(new BorderLayout());
        this.frame = frame;

        area = new Dimension(0, 0);
        circles = new Vector<Rectangle>();

        drawingPane = new DrawingPane(frame);
        drawingPane.setBackground(Color.white);
        drawingPane.addMouseListener(this);

        JScrollPane scroller = new JScrollPane(drawingPane);
        scroller.setPreferredSize(new Dimension(500, 500));

        add(scroller, BorderLayout.CENTER);
    }

    private void init() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public class DrawingPane extends JPanel {
        private final MainFrame frame;
        private JPanel drawingPane;

        private int canvasWidth = 800, canvasHeight = 800;


        public DrawingPane(MainFrame frame) {
            this.frame = frame;
            init();
        }

        final void init() {
            JScrollPane scroller = new JScrollPane(drawingPane);
            scroller.setPreferredSize(new Dimension(300, 200));
            setPreferredSize(new Dimension(canvasWidth, canvasHeight));

        }

        @Override
        protected void paintComponent(Graphics graphics) {
            int a = 16;
            init();
            Graphics2D g = (Graphics2D) graphics;
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, canvasWidth, canvasHeight);
            g.setColor(Color.BLACK);
            if (this.frame.configPanel.myList != null) for (Rows i : this.frame.configPanel.myList) {
                g.drawString(i.toString(), 6, a);
                a += 20;
            }
            if (this.frame.controlPanel.repBtn != null) for (String i : frame.controlPanel.rez) {
                g.drawString(i.toString(), 6, a);
                a += 20;
            }

        }


    }
}
