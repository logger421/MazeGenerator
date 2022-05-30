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
    JTextField sizeNumber;
    Maze maze;

    public MazeGenerator() {
        frame = new JFrame("Maze Generator");
        frame.setSize(650,600);

        mazeFrame = new JPanel();
        maze = new Maze();
        mazeFrame.add(maze);

        buttons = new JPanel();
        buttons.setBackground(Color.LIGHT_GRAY);
        buttons.setLayout(new BoxLayout( buttons, BoxLayout.PAGE_AXIS));

        generateButton = new JButton("   Generate  ");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maze.generate();
            }
        });
        resetButton = new JButton("    RESET    ");
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
        JLabel setNewSizeLabel = new JLabel("Enter size: ");
        JTextField setMazeSize = new JTextField(2);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));

        textPanel.add(setNewSizeLabel);
        textPanel.add(setMazeSize);

        buttons.add(generateButton);
        buttons.add(resetButton);
        //buttons.add(textPanel);

        frame.add(mazeFrame, BorderLayout.CENTER);
        frame.add(buttons, BorderLayout.EAST);
        frame.add(textPanel, BorderLayout.PAGE_START);
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
