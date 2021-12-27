package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.model.Clues;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CluesView implements FXComponent {

  private Controller controller;

  public CluesView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    Clues clues = controller.getClues();
    HBox hbox = new HBox();
    Text space = new Text(" ");
    hbox.getChildren().add(space);
    hbox.setSpacing(72);
    for (int i = 0; i < clues.getWidth(); i++) {
      String clueV = "";
      for (int j = 0; j < clues.getColCluesLength(); j++) {
        clueV += clues.getColClues(i)[j] + "\n";
      }
      Text space2 = new Text(clueV);
      hbox.getChildren().add(space2);
    }
    return hbox;
  }
}
