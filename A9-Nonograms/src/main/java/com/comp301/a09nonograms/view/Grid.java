package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.model.Clues;
import javafx.scene.Parent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Grid implements FXComponent {

  private Controller controller;

  public Grid(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    Clues clues = controller.getClues();
    GridPane layout = new GridPane();
    layout.setVgap(10);
    layout.setHgap(30);
    for (int i = 0; i < clues.getHeight(); i++) {
      String clueString = "  ";
      for (int j = 0; j < clues.getRowCluesLength(); j++) {
        clueString += clues.getRowClues(i)[j] + " ";
      }
      Text clue = new Text(clueString);
      layout.add(clue, 0, i);
      for (int j = 0; j < clues.getWidth(); j++) {
        Rectangle cell = new Rectangle(30, 30, new Color(0, 0, 0, 1));
        if (controller.isEliminated(i, j)) {
          cell = new Rectangle(50, 50, new Color(1, 0, 0, 1));
        } else if (controller.isShaded(i, j)) {
          cell = new Rectangle(50, 50, new Color(0, 0, 0, 1));
        } else {
          cell = new Rectangle(50, 50, new Color(1, 1, 1, 1));
        }
        int cluei = i;
        int cluej = j;
        cell.setOnMousePressed(
            (MouseEvent event) -> {
              if (event.getButton() == MouseButton.PRIMARY) {
                controller.toggleShaded(cluei, cluej);
              } else if (event.getButton() == MouseButton.SECONDARY) {
                controller.toggleEliminated(cluei, cluej);
              }
            });

        layout.add(cell, j + 1, i);
      }
    }
    return layout;
  }
}
