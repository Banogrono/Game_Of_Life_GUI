/*
Basically a single method that organises everything

 */

import java.util.Random;

public class Main {

    public static void startGameOfLife() throws InterruptedException {

        UniverseGeneration.getInput();

        boolean[][] previousMap = UniverseGeneration.generateMap();
        boolean[][] currentMap = new boolean[UniverseGeneration.NUMBER_OF_COLUMNS][UniverseGeneration.NUMBER_OF_ROWS];
        UniverseGeneration.copyArray(currentMap, previousMap);
        Window window = new Window();

        for (int i = 0; i < UniverseGeneration.GENERATIONS; i++) {

            if (window.resetFlag) {
                break;
            }

            if (window.pauseFlag) {
                i--;
                window.repaint();
                continue;
            }

            int aliveCellsCounter = GenerationAlgorithm.countAlive(currentMap);
            window.repaintInfo(currentMap, (1 + i), aliveCellsCounter);


            Thread.sleep(600);
            GenerationAlgorithm.generateNewLifeALT(previousMap, currentMap);
            UniverseGeneration.copyArray(previousMap, currentMap);
        }

        if (window.resetFlag) {
            window.resetFlag = false;
            UniverseGeneration.SEED = new Random().nextInt(1024);
            startGameOfLife();
        }

    }


    public static void main(String[] args) throws InterruptedException {

        startGameOfLife();

    }
}
