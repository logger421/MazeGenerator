package MazeGenerator;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Maze extends Canvas {
    private final int WIDTH = 50;
    private final int HEIGHT = 50;
    public Maze() {
        this.setSize(500, 500);
    }
    public void generate() {
        List<Integer> visited = new ArrayList<>();
        List<Edge> toVisit = new ArrayList<Edge>();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(0, 0, WIDTH*Cell.WIDTH, 0);
        g.drawLine(0,0, 0, HEIGHT*Cell.HEIGHT);
        g.drawLine(0, HEIGHT*Cell.HEIGHT, WIDTH*Cell.WIDTH, HEIGHT*Cell.HEIGHT);
        g.drawLine(WIDTH*Cell.WIDTH, 0, WIDTH*Cell.WIDTH, HEIGHT*Cell.HEIGHT);
    }
}
