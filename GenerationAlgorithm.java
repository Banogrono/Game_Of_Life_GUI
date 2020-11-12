/*
Actual Game of Life Algorithm

 */

public class GenerationAlgorithm {

    static int countNeighbors(final boolean[][] matrix, final CellCoordinates cell) {
        int neighbors = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int x = (cell.getX() + i + UniverseGeneration.NUMBER_OF_COLUMNS) % UniverseGeneration.NUMBER_OF_COLUMNS;
                int y = (cell.getY() + j + UniverseGeneration.NUMBER_OF_ROWS) % UniverseGeneration.NUMBER_OF_ROWS;

                if (matrix[x][y]) {
                    neighbors++;
                }
            }
        }
        if (cell.value(matrix))
            neighbors--;
        return neighbors;
    } // alternative method using loop (both actually work)

    static void generateNewLifeALT(final boolean[][] matrix, boolean[][] newMatrix) { // new
        final int[][] neighbors = showMeYourFriends(matrix);

        for (int i = 0; i < UniverseGeneration.NUMBER_OF_COLUMNS; i++) {
            for (int j = 0; j < UniverseGeneration.NUMBER_OF_ROWS; j++) {

                if (matrix[i][j] && (neighbors[i][j] == 2 || neighbors[i][j] == 3)) {
                    newMatrix[i][j] = true;
                } else newMatrix[i][j] = !matrix[i][j] && neighbors[i][j] == 3;
            }
        }
    }

    static int[][] showMeYourFriends(final boolean[][] matrix) {
        int[][] friendsMatrix = new int[UniverseGeneration.NUMBER_OF_COLUMNS][UniverseGeneration.NUMBER_OF_ROWS];
        for (int i = 0; i < friendsMatrix.length; i++) {
            for (int j = 0; j < friendsMatrix[0].length; j++) {
                friendsMatrix[i][j] = countNeighbors(matrix, new CellCoordinates(i, j));
            }
        }
        return friendsMatrix;
    }

    static int countAlive(final boolean[][] matrix) {
        int alive = 0;
        for (int i = 0; i < UniverseGeneration.NUMBER_OF_COLUMNS; i++) {
            for (int j = 0; j < UniverseGeneration.NUMBER_OF_ROWS; j++) {
                if (matrix[i][j])
                    alive++;
            }
        }
        return alive;
    }


    /*static int neighboringCells(final boolean[][] matrix, final CellCoordinates cell) {
        int columns = UniverseGeneration.NUMBER_OF_COLUMNS - 1;
        int rows = UniverseGeneration.NUMBER_OF_ROWS - 1;
        int neighbors = 0;

             if (cell.getX() == 0 && matrix[columns][cell.getY()]) { // N
                neighbors++;
            }
            else if (cell.getX() > 0 && matrix[cell.getX() - 1][cell.getY()]) {
            neighbors++;
            }
            // ---------------------------------------------------------------------------------------------------------

            if (cell.getY() == 0 && matrix[cell.getX()][rows]) { // W
                neighbors++;
            }
            else if (cell.getY() > 0 && matrix[cell.getX()][cell.getY() - 1]) {
                neighbors++;
            }
            // ---------------------------------------------------------------------------------------------------------

             if (cell.getY() == rows && matrix[cell.getX()][0]) { // E
                neighbors++;
            }
            else if (cell.getY() < rows && matrix[cell.getX()][cell.getY() + 1]) {
                neighbors++;
            }
            // ---------------------------------------------------------------------------------------------------------

            if (cell.getX() == columns && matrix[0][cell.getY()]) { // S
                neighbors++;
            }
            else if (cell.getX() < columns && matrix[cell.getX() + 1][cell.getY()]) {
                neighbors++;
            }
            // ---------------------------------------------------------------------------------------------------------

            if (cell.getX() == 0 &&  cell.getY() == 0 && matrix[columns][rows]) { // NW
                neighbors++;
            }
            else if (cell.getX() == 0 &&  cell.getY() > 0 && matrix[columns][cell.getY() - 1]) {
                neighbors++;
            }
            else if (cell.getX() > 0 &&  cell.getY() == 0 && matrix[cell.getX() - 1][rows]) {
                neighbors++;
            }
            else if (cell.getX() > 0 && cell.getY() > 0 && matrix[cell.getX() - 1][cell.getY() - 1]) {
                neighbors++;
            }
            // ---------------------------------------------------------------------------------------------------------

            if (cell.getX() == 0 &&  cell.getY() == rows && matrix[columns][0]) { // NE
                neighbors++;
            }
            else if (cell.getX() == 0 &&  cell.getY() < rows && matrix[columns][cell.getY() + 1]) {
                neighbors++;
            }
            else if (cell.getX() > 0 &&  cell.getY() == rows && matrix[cell.getX() - 1][0]) {
                neighbors++;
            }
            else if (cell.getX() > 0 && cell.getY() < rows && matrix[cell.getX() - 1][cell.getY() + 1]) {
                neighbors++;
            }
            // ---------------------------------------------------------------------------------------------------------

            if (cell.getX() == columns && cell.getY() == rows && matrix[0][0]) { // SE
                neighbors++;
            }
            else if (cell.getX() == columns && cell.getY() < rows && matrix[0][cell.getY() + 1]) {
                neighbors++;
            }
            else if (cell.getX() < columns && cell.getY() == rows && matrix[cell.getX() + 1][0]) {
                neighbors++;
            }
            else if (cell.getX() < columns && cell.getY() < rows && matrix[cell.getX() + 1][cell.getY() + 1]) {
                neighbors++;
            }
            // ---------------------------------------------------------------------------------------------------------

            if (cell.getX() == columns && cell.getY() == 0 && matrix[0][rows]) { // SW
                neighbors++;
            }
            else if (cell.getX() == columns && cell.getY() > 0 && matrix[0][cell.getY() - 1]) {
                neighbors++;
            }
            else if (cell.getX() < columns && cell.getY() == 0 && matrix[cell.getX() + 1][rows]) {
                neighbors++;
            }
            else if (cell.getX() < columns && cell.getY() > 0 && matrix[cell.getX() + 1][cell.getY() - 1]) {
                neighbors++;
            }
            // ---------------------------------------------------------------------------------------------------------

        return neighbors;
    } // naive method using just if statements
*/

}
