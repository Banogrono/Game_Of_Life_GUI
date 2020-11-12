/*
GUI part

 */


import javax.swing.*;
import java.awt.*;


public class Window extends JFrame {

    boolean resetFlag = false;
    boolean pauseFlag = false;

    JLabel generationLabel1 = new JLabel();
    JLabel aliveLabel1 = new JLabel();

    JToggleButton PlayToggleButton = new JToggleButton();
    JButton ResetButton = new JButton();

    JPanel backgroundLabelPanel1 = new JPanel();
    JPanel backgroundGamePanel1 = new JPanel();

    JPanel[][] gameSquares = new JPanel[UniverseGeneration.getNumberOfColumns()][UniverseGeneration.getNumberOfRows()];

    public Window() {

        super("Game Of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 620);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);
        setBackground(Color.LIGHT_GRAY);

        initComponents();

    }


    void initComponents() {

        backgroundLabelPanel1.setBackground(Color.LIGHT_GRAY);
        backgroundLabelPanel1.setLayout(new GridLayout(2, 2, 3, 3));
        add(backgroundLabelPanel1, BorderLayout.NORTH);

        backgroundGamePanel1.setBackground(Color.BLACK);
        backgroundGamePanel1.setLayout(new GridLayout(UniverseGeneration.getNumberOfRows(), UniverseGeneration.getNumberOfColumns(), 1, 1));
        add(backgroundGamePanel1, BorderLayout.CENTER);

        // generationLabel1.setText(generationLabelString);
        backgroundLabelPanel1.add(generationLabel1);

        backgroundLabelPanel1.add(PlayToggleButton);
        PlayToggleButton.setName("PlayToggleButton");
        PlayToggleButton.setText("Start & Stop");
        PlayToggleButton.setBackground(Color.LIGHT_GRAY);
        PlayToggleButton.addActionListener(event ->
                pauseFlag = PlayToggleButton.isSelected()
        );

        backgroundLabelPanel1.add(aliveLabel1);

        backgroundLabelPanel1.add(ResetButton);
        ResetButton.setName("ResetButton");
        ResetButton.setText("ResetButton");
        ResetButton.setBackground(Color.LIGHT_GRAY);
        ResetButton.addActionListener(event ->
                resetFlag = true
        );

        for (int rows = 0; rows < UniverseGeneration.getNumberOfRows(); rows++) {
            for (int columns = 0; columns < UniverseGeneration.getNumberOfColumns(); columns++) {
                gameSquares[rows][columns] = new JPanel();
                gameSquares[rows][columns].setBackground(Color.LIGHT_GRAY);
                backgroundGamePanel1.add(gameSquares[rows][columns]);

            }
        }
    }

    public void repaintInfo(boolean[][] currentMap, int generationCounter, int aliveCounter) {
        generationLabel1.setText("Generation: " + generationCounter);
        generationLabel1.repaint();

        aliveLabel1.setText("Alive: " + aliveCounter);
        aliveLabel1.repaint();
        for (int rows = 0; rows < UniverseGeneration.getNumberOfRows(); rows++) {
            for (int columns = 0; columns < UniverseGeneration.getNumberOfColumns(); columns++) {
                if (currentMap[rows][columns])
                    gameSquares[rows][columns].setBackground(Color.BLACK);
                else
                    gameSquares[rows][columns].setBackground(Color.LIGHT_GRAY);

                gameSquares[rows][columns].repaint();
            }
        }
    }

}
