package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class BottomButtons implements FXComponent {

  private Controller controller;

  public BottomButtons(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox hbox = new HBox();
    hbox.setSpacing(50);
    Text puzzleNumBtn = new Text("    PUZZLE    " + (controller.getPuzzleIndex() + 1) + "/5");
    Button prevBtn = new Button("\u00AB");
    prevBtn.setOnAction(
        (ActionEvent event) -> {
          controller.prevPuzzle();
        });
    Button nextBtn = new Button("\u00BB");
    nextBtn.setOnAction(
        (ActionEvent event) -> {
          controller.nextPuzzle();
        });
    Button randomBtn = new Button("  RANDOM  ");
    randomBtn.setOnAction(
        (ActionEvent event) -> {
          controller.randPuzzle();
        });
    Button resetBtn = new Button("  RESET  ");
    resetBtn.setOnAction(
        (ActionEvent event) -> {
          controller.clearBoard();
        });
    hbox.getChildren().addAll(puzzleNumBtn, prevBtn, nextBtn, randomBtn, resetBtn);
    return hbox;
  }
}
