/*
Utility methods, constants and stuff

 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// mostly utility stuff
public class UniverseGeneration {
    final static int DEFAULT_VALUE = 48;
    static int NUMBER_OF_COLUMNS;
    static int NUMBER_OF_ROWS;
    static long SEED = 134;
    static int GENERATIONS;

    static void print2DMatrix(final boolean[][] matrix) {
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            for (int j = 0; j < NUMBER_OF_ROWS; j++) {

                if (matrix[i][j]) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static boolean[][] generateMap() {
        Random random = new Random(SEED);
        boolean[][] matrix = new boolean[NUMBER_OF_COLUMNS][NUMBER_OF_ROWS];
        for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
            for (int j = 0; j < NUMBER_OF_ROWS; j++) {
                matrix[i][j] = random.nextBoolean();
            }
        }
        return matrix;
    }

    static void copyArray(boolean[][] copyToMatrix, boolean[][] copyFromMatrix) {
        for (int i = 0; i < copyFromMatrix.length; i++) {
            copyToMatrix[i] = Arrays.copyOf(copyFromMatrix[i], copyFromMatrix[0].length);
        }
    }

    static void getInput() {
        Scanner s = new Scanner(System.in);
        try {
            NUMBER_OF_COLUMNS = DEFAULT_VALUE; //.nextInt();
            NUMBER_OF_ROWS = NUMBER_OF_COLUMNS;
            GENERATIONS = DEFAULT_VALUE;// s.nextInt();
        } catch (Exception ignored) {
            NUMBER_OF_COLUMNS = DEFAULT_VALUE;
            NUMBER_OF_ROWS = NUMBER_OF_COLUMNS;
            GENERATIONS = DEFAULT_VALUE;
        }
    }

    public static int getNumberOfColumns() {
        return NUMBER_OF_COLUMNS;
    }

    public static int getNumberOfRows() {
        return NUMBER_OF_ROWS;
    }
}
