package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class Status implements FXComponent {

  private Controller controller;

  public Status(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox hbox = new HBox();
    Text solvedText = new Text("PUZZLE IS CURRENTLY SOLVED");
    if (controller.isSolved()) {
      hbox.getChildren().addAll(solvedText);
    }
    return hbox;
  }
}
