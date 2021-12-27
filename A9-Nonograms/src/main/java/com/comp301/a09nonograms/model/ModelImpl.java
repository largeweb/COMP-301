package com.comp301.a09nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

  //  private PuzzleLibrary puzzleLibrary;
  private List<Clues> cluesList;
  private int currentlyActivePuzzleIndex;

  //    INT VALUES ARE BETWEEN 0-2
  //    0 = UNSHADED/SPACE
  //    1 = SHADED
  //    2 = ELIMINATED
  private int[][] cellStates;

  private Clues currentClues;
  //    private List<ModelObserver> (active model observers)
  private ArrayList<ModelObserver> modelObservers;

  public ModelImpl(List<Clues> clues) {
    //    this.puzzleLibrary = new PuzzleLibrary();
    this.cluesList = clues;
    this.currentlyActivePuzzleIndex = 0;
    this.currentClues = cluesList.get(1);
    //    THIS BELOW IS [HEIGHT][WIDTH], MAY HAVE TO REVERSE THIS, IDK RN
    //    cellStates = new int[currentClues.getHeight() + 1][currentClues.getWidth() + 1];
    //    this.cellStates = new int[currentClues.getHeight()][currentClues.getWidth()];
    //    clear();
    //    this.currentBoard = new BoardImpl(currentClues.getWidth(), currentClues.getHeight());
    this.modelObservers = new ArrayList<>();
    //    this.puzzleLibraryCount = cluesList.size();
    setPuzzleIndex(0);
    notifyObservers();
  }

  @Override
  public boolean isShaded(int row, int col) {
    //    if (row == getHeight() || col == getWidth()) {
    //      return false;
    //    }
    //    if (row >= getHeight() || col >= getWidth() || row < 0 || col < 0) {
    //      throw new RuntimeException();
    //    }
    if (cellStates[row][col] == 1) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isEliminated(int row, int col) {
    //    if (row == getHeight() || col == getWidth()) {
    //      return false;
    //    }
    //    if (row >= getHeight() || col >= getWidth() || row < 0 || col < 0) {
    //      throw new RuntimeException();
    //    }

    if (cellStates[row][col] == 2) {
      return true;
    }
    return false;
  }

  @Override
  public boolean isSpace(int row, int col) {
    //    if (row == getHeight() || col == getWidth()) {
    //      return false;
    //    }
    //    if (row >= getHeight() || col >= getWidth() || row < 0 || col < 0) {
    //      throw new RuntimeException();
    //    }
    if (cellStates[row][col] == 0) {
      return true;
    }
    return false;
  }

  //  ***
  @Override
  public void toggleCellShaded(int row, int col) {
    //    if (row == getHeight() || col == getWidth()) {
    //      return;
    //    }
    if (cellStates[row][col] == 1) {
      cellStates[row][col] = 0;
    } else {
      cellStates[row][col] = 1;
    }
    notifyObservers();
  }

  //  ***
  @Override
  public void toggleCellEliminated(int row, int col) {
    //    if (row == getHeight() || col == getWidth()) {
    //      return;
    //    }
    if (cellStates[row][col] == 2) {
      cellStates[row][col] = 0;
    } else {
      cellStates[row][col] = 2;
    }
    notifyObservers();
  }

  @Override
  public void clear() {
    for (int i = 0; i < cellStates.length; i++) {
      for (int j = 0; j < cellStates[i].length; j++) {
        cellStates[i][j] = 0;
      }
    }
    notifyObservers();
  }

  //  ***
  @Override
  public int getWidth() {
    return currentClues.getWidth();
  }

  //  ***
  @Override
  public int getHeight() {
    return currentClues.getHeight();
  }

  //  ***
  @Override
  public int[] getRowClues(int index) {
    return currentClues.getRowClues(index);
  }

  //  ***
  @Override
  public int[] getColClues(int index) {
    return currentClues.getColClues(index);
  }

  //  ***
  @Override
  public int getRowCluesLength() {
    return currentClues.getRowCluesLength();
  }

  //  ***
  @Override
  public int getColCluesLength() {
    return currentClues.getColCluesLength();
  }

  //    /** Getter method for the total number of puzzles in the puzzle list */
  //    int getPuzzleCount();
  //    ***
  @Override
  public int getPuzzleCount() {
    return cluesList.size();
  }

  //    /** Getter method for the index of the active puzzle in the puzzle list */
  //    int getPuzzleIndex();
  @Override
  public int getPuzzleIndex() {
    return currentlyActivePuzzleIndex;
  }

  //    /** Setter method for the the index of the active puzzle in the puzzle list */
  //    void setPuzzleIndex(int index);
  //    ***
  @Override
  public void setPuzzleIndex(int index) {
    currentlyActivePuzzleIndex = index;
    currentClues = cluesList.get(index);
    cellStates = new int[currentClues.getHeight()][currentClues.getWidth()];
    clear();
    notifyObservers();
  }

  //    /**
  //     * Adds an observer to the active observer list. An event is fired and all active observers
  // are
  //     * notified every time a Model field value changes
  //     */
  //    void addObserver(ModelObserver observer);
  //    ***
  @Override
  public void addObserver(ModelObserver observer) {
    modelObservers.add(observer);
  }

  //    /** Removes an observer from the active observer list */
  //    void removeObserver(ModelObserver observer);
  // ***
  @Override
  public void removeObserver(ModelObserver observer) {
    modelObservers.remove(observer);
    //    notifyObservers();
  }

  //    /** Returns true only if the active puzzle is solved */
  //    boolean isSolved();
  //    ***
  @Override
  public boolean isSolved() {
    //    boolean solved = false;
    //
    //    //    MAKE int[][] array for clues rows - - -
    //    //    ArrayList<ArrayList<Integer>> cluesRowsReal = new
    //    //
    // ArrayList<ArrayList<Integer>(currentClues.getRowCluesLength())>(currentClues.getHeight());
    //    //    for(int i=0; i<currentClues.getHeight(); i++) {
    //    //      for(int j=0; j<currentClues.getRowCluesLength(); j++) {
    //    //        if(currentClues.getRowClues(i)[j] != 0) {
    //    //          cluesRowsReal.add(null);
    //    //        }
    //    //      }
    //    ////      cluesRowsReal[i] = currentClues.getRowClues(i);
    //    //    }
    //    //   MAKE int[][] array for clues checking each rows
    //    int[][] cluesRowsCheck = new
    // int[currentClues.getHeight()][currentClues.getRowCluesLength()];
    //    for (int i = 0; i < currentClues.getHeight(); i++) {
    //      int[] currentRowArr = new int[currentClues.getWidth()];
    //      int count = 0;
    //      //      FOR EACH ROW, GO THROUGH EACH COLUMN OF cellStates at I and if shaded, count it
    // and
    //      // add save count to array when a 0 is read
    //      for (int j = 0; j < currentClues.getWidth(); j++) {
    //        if (cellStates[i][j] == 1) {
    //          count++;
    //        }
    //      }
    //      cluesRowsCheck[i] = currentRowArr;
    //    }
    //    //   CHECK ARRAYS, SET SOLVED TO TRUE IF EQUAL, RETURN FALSE IF NOT
    //
    //    return solved;
    //    return false;

    //    ROWS
    //    COUNT THE AMOUNT OF SHADED FROM CLUES
    for (int i = 0; i < currentClues.getHeight(); i++) {
      int[] rowClue = getRowClues(i);
      int realShaded = 0;
      for (int j = 0; j < rowClue.length; j++) {
        realShaded += rowClue[j];
      }
      int testShaded = 0;
      for (int j = 0; j < currentClues.getWidth(); j++) {
        if (isShaded(i, j)) {
          testShaded++;
        }
      }
      if (realShaded != testShaded) {
        return false;
      }
    }
    // REPEAT FOR COLS
    for (int i = 0; i < currentClues.getWidth(); i++) {
      int[] colClue = getColClues(i);
      int realShaded = 0;
      for (int j = 0; j < colClue.length; j++) {
        realShaded += colClue[j];
      }
      //      COUNT THE AMOUNT OF SHADED FROM COUNTING THE GRID
      int testShaded = 0;
      for (int j = 0; j < currentClues.getHeight(); j++) {
        if (isShaded(j, i)) {
          testShaded++;
        }
      }
      if (realShaded != testShaded) {
        return false;
      }
    }
    return true;
  }

  private void notifyObservers() {
    for (int i = 0; i < modelObservers.size(); i++) {
      modelObservers.get(i).update(this);
    }
  }
  //  private void loadBoard() {
  //  }
  public Clues getAllCurrentClues() {
    return currentClues;
  }
}
