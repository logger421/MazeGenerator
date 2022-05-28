package MazeGenerator;

import javax.swing.*;

public class MazeGenerator {

    public MazeGenerator() {
        JButton generate = new JButton("Generate");
        generate.setSize(50,50);

        JFrame frame = new JFrame("Maze Generator");
        frame.setSize(650,600);

        Maze maze = new Maze();
        frame.add(maze);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MazeGenerator();
    }
}
