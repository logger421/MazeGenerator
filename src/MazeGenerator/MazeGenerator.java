package MazeGenerator;

import javax.swing.*;
import java.awt.*;


public class MazeGenerator extends  JFrame{

    public MazeGenerator() {
        JButton generate = new JButton("Generate");

        generate.setSize(50,50);
        JFrame frame = new JFrame("Maze Generator");
        Container pane = frame.getContentPane();
        frame.setSize(650,600);
        Maze maze = new Maze();
        frame.add(maze, BorderLayout.CENTER);
        frame.add(generate, BorderLayout.NORTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        /*
            I use another thread to run our GUI -
            good practise (at least that's what
            they said on my Java lectures ...)
         */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MazeGenerator();
            }
        });
    }
}
