package com.comp301.a09nonograms.model;

public class BoardImpl implements Board {

  //    INT VALUES ARE BETWEEN 0-2
  //    0 = UNSHADED/SPACE
  //    1 = SHADED
  //    2 = ELIMINATED
  private int[][] cellStates;

  //  public BoardImpl(int width, int height) {
  //    //    MAY BE AN ISSUE HERE
  //    cellStates = new int[height][width];
  //    clear();
  //  }
  public BoardImpl(int[][] cellStates) {
    this.cellStates = cellStates;
  }

  //    /** Returns true if the cell at the given location is shaded */
  //    boolean isShaded(int row, int col);
  @Override
  public boolean isShaded(int row, int col) {
    if (cellStates[row][col] == 1) {
      return true;
    }
    return false;
  }

  //    /** Returns true if the cell at the given location is eliminated with an "x" */
  //    boolean isEliminated(int row, int col);
  @Override
  public boolean isEliminated(int row, int col) {
    if (cellStates[row][col] == 2) {
      return true;
    }
    return false;
  }

  //    /**
  //     * Returns true if the cell at the given location is blank (i.e. it is neither shaded nor
  //     * eliminated)
  //     */
  //    boolean isSpace(int row, int col);
  @Override
  public boolean isSpace(int row, int col) {
    if (cellStates[row][col] == 0) {
      return true;
    }
    return false;
  }

  //    /** Toggles whether the cell at the given location is shaded */
  //    void toggleCellShaded(int row, int col);
  @Override
  public void toggleCellShaded(int row, int col) {
    if (cellStates[row][col] == 1) {
      cellStates[row][col] = 0;
    } else {
      cellStates[row][col] = 1;
    }
  }

  //    /** Toggles whether the cell at the given location is eliminated with an "x" */
  //    void toggleCellEliminated(int row, int col);
  @Override
  public void toggleCellEliminated(int row, int col) {
    if (cellStates[row][col] == 2) {
      cellStates[row][col] = 0;
    } else {
      cellStates[row][col] = 2;
    }
  }

  //    /** Clears the board by marking all the cells blank */
  //    void clear();
  @Override
  public void clear() {
    for (int i = 0; i < cellStates.length; i++) {
      for (int j = 0; j < cellStates[i].length; j++) {
        cellStates[i][j] = 0;
      }
    }
  }
}
