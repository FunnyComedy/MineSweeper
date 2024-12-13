import javax.swing.*;
import javax.swing.border.LineBorder;

import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MineSweeper extends JFrame{
    // field
    private int rows = 16;
    private int cols = 30;
    private JPanel fieldPanel = new JPanel(new GridLayout(rows, cols));
    private ImageIcon emptyIcon, oneIcon, twoIcon, threeIcon, fourIcon, fiveIcon, sixIcon, sevenIcon, eightIcon;
    
    // emptyIcon = new ImageIcon(getClass().getResource("/empty.png"));


    // info
    private static int time = 0;
    private static int ticks = 0;

    private static int mine = 99;

    private JPanel infoPanel = new JPanel(new BorderLayout());
    private static JLabel timeLabel = new JLabel("Seconds: " + time);
    private static JLabel mineLabel = new JLabel("Mines: " + mine);



    
    // main constructor
    private MineSweeper() {
        setTitle("Minesweeper");
        setSize(cols * 32, (rows * 32) + 96);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // field
        for (int i = 0; i < rows * cols; i++) {
            Square square = new Square();
            square.addMouseListener(square);
            fieldPanel.add(square);
        }

        add(fieldPanel, BorderLayout.SOUTH);


        // info
        infoPanel.setBackground(Color.BLACK);

        mineLabel.setForeground(Color.RED);
        mineLabel.setFont(new Font("Consolas", Font.PLAIN, 32));

        timeLabel.setForeground(Color.RED);
        timeLabel.setFont(new Font("Consolas", Font.PLAIN, 32));

        infoPanel.add(mineLabel, BorderLayout.WEST);
        infoPanel.add(timeLabel, BorderLayout.EAST);

        add(infoPanel, BorderLayout.NORTH);
    }

    // makes grid
    public class Square extends JButton implements MouseListener {
        public Square() {
            setBackground(Color.lightGray);
            setPreferredSize(new Dimension(32, 32));
            setBorder(new LineBorder(Color.darkGray, 2));
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("Pressed!");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("Released!");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
    } 

    


    // main method
    public static void main(String[] args) {
        MineSweeper k = new MineSweeper();
        k.setVisible(true);

        // game loop
        while (true) {
            ticks++;

            if (ticks >= 20) {
                time++;
                ticks = 0;
            }
            
            timeLabel.setText("" + time);
            mineLabel.setText("" + mine);

            
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
