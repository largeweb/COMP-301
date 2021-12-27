package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class MainScreen implements FXComponent {

  private Controller controller;

  public MainScreen(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    VBox layout = new VBox();
    CluesView cv = new CluesView(controller);
    layout.getChildren().add(cv.render());
    Grid grid = new Grid(controller);
    layout.getChildren().add(grid.render());
    BottomButtons bb = new BottomButtons(controller);
    layout.getChildren().add(bb.render());
    Status st = new Status(controller);
    layout.getChildren().add(st.render());
    return layout;
  }
}
