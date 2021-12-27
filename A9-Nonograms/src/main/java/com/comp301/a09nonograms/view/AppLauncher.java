package com.comp301.a09nonograms.view;

import com.comp301.a09nonograms.PuzzleLibrary;
import com.comp301.a09nonograms.controller.Controller;
import com.comp301.a09nonograms.controller.ControllerImpl;
import com.comp301.a09nonograms.model.Clues;
import com.comp301.a09nonograms.model.Model;
import com.comp301.a09nonograms.model.ModelImpl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

public class AppLauncher extends Application {

  @Override
  public void start(Stage stage) {
    // TODO: Launch your GUI here

    List<Clues> clues = PuzzleLibrary.create();
    ModelImpl model = new ModelImpl(clues);
    Controller controller = new ControllerImpl(model);
    MainScreen ms = new MainScreen(controller);

    stage.setTitle("NONOGRAMS");
    StackPane pane = new StackPane();
    Button btn = new Button();
    btn.setText("PLAY NONOGRAMS");
    btn.setOnAction(
        new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {
            System.out.println("BUTTON CLICKED");
            stage.setScene(new Scene(ms.render()));
            model.addObserver(
                (Model m) -> {
                  stage.setScene(new Scene(ms.render()));
                });

            stage.show();
          }
        });
    pane.getChildren().add(btn);
    Scene scene = new Scene(pane, 400, 100);

    stage.setScene(scene);
    stage.show();
  }
}
