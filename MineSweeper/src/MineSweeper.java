import javax.swing.*;
import javax.swing.border.LineBorder;

import java.lang.*;
import java.util.*;
import java.awt.*;

public class MineSweeper extends JFrame{
    // field
    private int rows = 16;
    private int cols = 30;
    private JPanel fieldPanel = new JPanel(new GridLayout(rows, cols));
    GridBagConstraints nConstraints = new GridBagConstraints();
    

    // info
    private int time = 43210;
    

    private JPanel infoPanel = new JPanel(new BorderLayout());
    private JLabel timeLabel = new JLabel("56789" + time);
    private JLabel countLabel = new JLabel();



    
    // main constructor
    private MineSweeper() {
        setTitle("Minesweeper");
        setSize(cols * 32, (rows * 32) + 96);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // field
        for (int i = 0; i < rows * cols; i++) {
            fieldPanel.add(new Square());
        }

        add(fieldPanel, BorderLayout.SOUTH);


        // info
        infoPanel.setBackground(Color.BLACK);

        countLabel.setForeground(Color.RED);
        countLabel.setFont(new Font("Consolas", Font.PLAIN, 32));

        timeLabel.setForeground(Color.RED);
        timeLabel.setFont(new Font("Consolas", Font.PLAIN, 32));

        infoPanel.add(countLabel, BorderLayout.WEST);
        infoPanel.add(timeLabel, BorderLayout.EAST);

        add(infoPanel, BorderLayout.NORTH);
    }

    // makes grid
    public class Square extends JPanel {
        public Square() {
            setBackground(Color.lightGray);
            setPreferredSize(new Dimension(32, 32));
            setBorder(new LineBorder(Color.darkGray, 2));
        }
        
    } 


    


    // main method
    public static void main(String[] args) {
        MineSweeper k = new MineSweeper();
        k.setVisible(true);
    }
}
