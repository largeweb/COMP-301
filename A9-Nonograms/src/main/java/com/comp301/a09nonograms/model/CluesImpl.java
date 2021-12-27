package com.comp301.a09nonograms.model;

public final class CluesImpl implements Clues {

  private int height;
  private int width;
  private int[][] rowClues;
  private int[][] colClues;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    this.rowClues = rowClues;
    this.colClues = colClues;
    this.height = rowClues.length;
    this.width = colClues.length;
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int[] getRowClues(int index) {
    return rowClues[index];
  }

  @Override
  public int[] getColClues(int index) {
    return colClues[index];
  }

  @Override
  public int getRowCluesLength() {
    int returnVal = 0;
    for (int i = 0; i < rowClues.length; i++) {
      if (returnVal < rowClues[i].length) {
        returnVal = rowClues[i].length;
      }
    }
    return returnVal;
  }

  @Override
  public int getColCluesLength() {
    int returnVal = 0;
    for (int i = 0; i < colClues.length; i++) {
      if (returnVal < colClues[i].length) {
        returnVal = colClues[i].length;
      }
    }
    return returnVal;
  }
}
