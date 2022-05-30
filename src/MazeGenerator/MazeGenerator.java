package MazeGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeGenerator extends  JFrame{
    JFrame frame;
    JPanel buttons;
    JPanel mazeFrame;
    JButton generateButton;
    JButton resetButton;
    Maze maze;

    public MazeGenerator() {
        frame = new JFrame("Maze Generator");
        frame.setSize(650,600);

        mazeFrame = new JPanel();
        maze = new Maze();
        mazeFrame.add(maze);

        buttons = new JPanel();
        buttons.setBackground(Color.LIGHT_GRAY);
        buttons.setLayout(new FlowLayout());

        generateButton = new JButton("Generate");

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maze.generate();
            }
        });
        resetButton = new JButton("Reset");

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mazeFrame);
                mazeFrame.remove(maze);
                maze = new Maze();
                mazeFrame.add(maze);
                frame.add(mazeFrame, BorderLayout.CENTER);
                frame.pack();
                repaint();
                revalidate();
            }
        });

        JLabel enterSize = new JLabel("Enter new size: ");
        JTextField enterNumber = new JTextField(5);
        enterNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = enterNumber.getText();
                Integer newSize = Integer.parseInt(text);
                frame.remove(mazeFrame);
                mazeFrame.remove(maze);
                maze = new Maze(newSize, newSize);
                mazeFrame.add(maze);
                frame.add(mazeFrame, BorderLayout.CENTER);
                frame.pack();
                repaint();
                revalidate();
            }
        });

        buttons.add(generateButton);
        buttons.add(resetButton);
        buttons.add(enterSize);
        buttons.add(enterNumber);
        frame.add(mazeFrame, BorderLayout.CENTER);
        frame.add(buttons, BorderLayout.NORTH);
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
