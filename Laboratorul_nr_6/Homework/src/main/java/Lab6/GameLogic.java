package Lab6;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class GameLogic {
    protected boolean[][] board;
    protected Map<Node, Node> tokenTable;
    private int rows;
    private int cols;

    public GameLogic(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        init();
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void init() {
        board = new boolean[rows][cols];
        tokenTable = new HashMap<Node, Node>();
        System.out.println("Board table generated successfully");
        generateTokens(rows, cols);

    }

    public void setTrue(int col, int row) {
        this.board[row][col] = true;
    }

    /**
     * this method generates a start node specific to my current board.It is marked as visited and print it.
     * Then, we try to expand in the all possible directions
     *
     * @param rows number of rows
     * @param cols number of columns
     * @return
     */
    private Map<Node, Node> generateTokens(int rows, int cols) {
        Random r = new Random();
        Node start = new Node();
        start.setCol(r.nextInt(cols));
        start.setRow(r.nextInt(rows));
        setTrue(start.getCol(), start.getRow());
        System.out.println("start node is: " + start.getCol() + " " + start.getRow());

        randomToken(r, start, "right");

        randomToken(r, start, "up");

        randomToken(r, start, "left");

        randomToken(r, start, "down");

        return tokenTable;
    }

    /**
     * I mark the n node as visited, and then I check the direction with a switch case. I verify that it is possible to go in that direction
     * and if we choose to go in that direction(with coinFlip).If that is the case, I verify that the node that we go to hasn't been visited already.
     * If it was, I set the nr of cols and rows, I put the pair in my tokenTable, I mark the m node as visited and recall the function again for the m node.
     * If it wasn't, I set the nr of cols and rows, put the pair in my table, mark the node as visited and call the function for the m node
     *
     * @param r         object of type Random
     * @param n         the node
     * @param direction the direction in which we try to go
     */
    private void randomToken(Random r, Node n, String direction) {
        setTrue(n.getCol(), n.getRow());
        switch (direction) {
            case "up": {
                if (n.getRow() - 1 >= 0 && coinFlip(r)) {
                    Node m = new Node();
                    if (this.board[n.getRow() - 1][n.getCol()]) {
                        m.setCol(n.getCol());
                        m.setRow(n.getRow() - 1);
                        this.tokenTable.put(n, m);
                        setTrue(m.getCol(), m.getRow());
                        randomToken(r, m, "down");
                    } else {
                        m.setCol(n.getCol());
                        m.setRow(n.getRow() - 1);
                        this.tokenTable.put(n, m);
                        setTrue(m.getCol(), m.getRow());
                        randomToken(r, m, "left");
                        randomToken(r, m, "up");
                        randomToken(r, m, "right");
                    }
                }
            }
            case "down": {
                if (n.getRow() + 1 < this.rows && coinFlip(r)) {
                    Node m = new Node();
                    if (this.board[n.getRow() + 1][n.getCol()]) {
                        m.setCol(n.getCol());
                        m.setRow(n.getRow() + 1);
                        this.tokenTable.put(n, m);
                        setTrue(m.getCol(), m.getRow());
                        randomToken(r, m, "up");
                    } else {
                        m.setCol(n.getCol());
                        m.setRow(n.getRow() + 1);
                        this.tokenTable.put(n, m);
                        setTrue(m.getCol(), m.getRow());
                        randomToken(r, m, "left");
                        randomToken(r, m, "down");
                        randomToken(r, m, "right");
                    }
                }
            }
            case "right": {

                if (n.getCol() + 1 < this.cols && coinFlip(r)) {
                    Node m = new Node();
                    if (this.board[n.getRow()][n.getCol() + 1]) {
                        m.setCol(n.getCol() + 1);
                        m.setRow(n.getRow());
                        this.tokenTable.put(n, m);
                        setTrue(m.getCol(), m.getRow());
                        randomToken(r, m, "left");
                    } else {
                        m.setCol(n.getCol() + 1);
                        m.setRow(n.getRow());
                        this.tokenTable.put(n, m);
                        setTrue(m.getCol(), m.getRow());
                        randomToken(r, m, "down");
                        randomToken(r, m, "up");
                        randomToken(r, m, "right");
                    }
                }
            }
            case "left": {
                if (n.getCol() - 1 >= 0 && coinFlip(r)) {
                    Node m = new Node();
                    if (this.board[n.getRow()][n.getCol() - 1]) {
                        m.setCol(n.getCol() - 1);
                        m.setRow(n.getRow());
                        this.tokenTable.put(n, m);
                        setTrue(m.getCol(), m.getRow());
                        randomToken(r, m, "right");
                    } else {
                        m.setCol(n.getCol() - 1);
                        m.setRow(n.getRow());
                        this.tokenTable.put(n, m);
                        setTrue(m.getCol(), m.getRow());
                        randomToken(r, m, "down");
                        randomToken(r, m, "left");
                        randomToken(r, m, "up");
                    }
                }
            }
        }
    }

    /**
     * @param r
     * @return true or false with a probability of 45% (I chose that value randomly)
     */
    private boolean coinFlip(Random r) {
        return r.nextInt(100) < 45;
    }
}
