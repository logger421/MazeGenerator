package MazeGenerator;

import javax.swing.*;
import java.awt.*;


public class MazeGenerator extends  JFrame{

    public MazeGenerator() {
        JFrame frame = new JFrame("Maze Generator");
        frame.setSize(650,600);

        JPanel buttons = new JPanel();
        JPanel mazeFrame = new JPanel();

        buttons.setBackground(Color.GRAY);
        JButton generate = new JButton("   Generate  ");
        JButton changeSize = new JButton("Change size");
        buttons.setLayout(new BoxLayout( buttons, BoxLayout.PAGE_AXIS));
        changeSize.setSize(120,70);
        generate.setSize(170,70);
        buttons.add(generate);
        buttons.add(changeSize);

        Maze maze = new Maze();
        mazeFrame.add(maze);

        frame.add(mazeFrame, BorderLayout.CENTER);
        frame.add(buttons, BorderLayout.EAST);
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
