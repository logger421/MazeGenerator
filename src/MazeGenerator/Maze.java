package MazeGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
    This class extend Canvas to simply
    add it later to JFrame object in main class
    MazeGenerator.java, this gives me ability
    to treat Maze as separate object so I can use
    different layouts and add buttons.
 */
public class Maze extends Canvas {
    /*
        Our maze will contain WIDTHxHEIGHT cells,
        each of them 10 points in length and height.
        What's important is that every cell is a path,
        and we build or destroy wall between them
     */
    private final static int WIDTH = 30;
    private final static int HEIGHT = 30;
    private final static Random rand = new Random();
    private int step = 0;
    private List<Edge> maze = new ArrayList<>();


    public Maze() {
        this.setSize(600, 600);
        generate();
    }

    /*
        We will store our paths in 1 dimention array,
        which means if we chave 10x10 cells our vector
        look like below:
        0   1  2  3  4  5  6  7  8  9
        10 11 12 13 14 15 16 17 18 19 etc

        IMPORTANT: to convert from 2D to 1D array we
        use equation
            current = ( y * WIDTH ) + x;
     */
    public void generate() {
        List<Integer> visited = new ArrayList<>();
        List<Edge> toVisit = new ArrayList<Edge>();

        visited.add(0); // start in left upper corner
        /*
            As prim's algorithm state we should
            add all not visited neighbours of current
            cell to list to go to them. We do it manually
            to initialise whole process.
            Here we add right neighbour of current cell, and below:
         */
        toVisit.add(new Edge(0, 1));
        toVisit.add(new Edge(0, WIDTH));

        while(toVisit.size() > 0) {
            int nextIndex = rand.nextInt(toVisit.size());
            Edge nextCell = toVisit.remove(nextIndex);

            if(visited.contains(nextCell.end))
                continue;

            visited.add(nextCell.end);
            addToMaze(nextCell);

            int above = nextCell.end - WIDTH;
            if( above > 0 && !visited.contains(above))
                toVisit.add(new Edge(nextCell.end, above));

            int below = nextCell.end + WIDTH;
            if( below < WIDTH*HEIGHT && !visited.contains(below))
                toVisit.add(new Edge(nextCell.end, below));

            int right = nextCell.end + 1;
            if( right % WIDTH != 0 && !visited.contains(right))
                toVisit.add(new Edge(nextCell.end, right));

            int left = nextCell.end - 1;
            if( left % WIDTH != WIDTH -1 && !visited.contains(left))
                toVisit.add(new Edge(nextCell.end, left));
        }

        // delay
//        Timer timer = new Timer(150, (e) ->
//        {
//            step();
//            Maze.this.repaint();
//        });
//        timer.setRepeats(true);
//        timer.start();
    }

    public void step()
    {
        step++;
        if(step >= maze.size())
            step = maze.size() - 1;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(0, 0, WIDTH*Cell.WIDTH, 0);
        g.drawLine(0,0, 0, HEIGHT*Cell.HEIGHT);
        g.drawLine(0, HEIGHT*Cell.HEIGHT, WIDTH*Cell.WIDTH, HEIGHT*Cell.HEIGHT);
        g.drawLine(WIDTH*Cell.WIDTH, 0, WIDTH*Cell.WIDTH, HEIGHT*Cell.HEIGHT);

        // drawing the maze:
        for(int y = 0; y < HEIGHT; y++)
            for (int x = 0; x < WIDTH; x++) {
                // horizontal lines drawing:
                int current = (y * WIDTH) + x;
                int below = ((y + 1) * WIDTH) + x;
                if (!maze.contains(new Edge(current, below)))
                    g.drawLine(x * Cell.WIDTH, (y + 1) * Cell.HEIGHT, (x + 1) * Cell.WIDTH, (y + 1) * Cell.HEIGHT);

                //vertical lines drawing:
                int right = current + 1;
                if (!maze.contains(new Edge(current, right)))
                    g.drawLine((x + 1) * Cell.WIDTH, y * Cell.HEIGHT, (x + 1) * Cell.WIDTH, (y + 1) * Cell.HEIGHT);
            }

    }

    /*
        it doesn't matter if our path is going
        from (left to right or right to left) or
        (bottom to up, up to bottom) so we do
        a flip of path coordinates.
     */
    private void addToMaze(Edge e) {
        if(e.start > e.end)
            maze.add(new Edge(e.end, e.start));
        else
            maze.add(e);
    }
}
