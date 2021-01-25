package ch15;

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.animation.*;
import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.*;
import javafx.scene.shape.*;
import javafx.util.*;
import javafx.event.*;
import javafx.scene.input.*;


public class Exercise15_Animation extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		//make pane
		Pane pane = new Pane();
		
		//make shapes
		Rectangle r1 = new Rectangle(100, 100, 50, 100);
		r1.setFill(Color.GREEN);

		Polygon x = new Polygon(400, 100, 100, 400, 200, 700, 600, 700, 700, 400);
		x.setFill(Color.WHITE);
		x.setStroke(Color.RED);
		
		//put shapes in pan
		pane.getChildren().add(x);
		pane.getChildren().add(r1);
		
		//set up path
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(3000));
		pt.setPath(x);
		pt.setNode(r1);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setAutoReverse(false);
		
		//set up fade
		FadeTransition ft = new FadeTransition(Duration.millis(3000), r1);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		
		
		 // Start animation
		ft.play();
		pt.play();
		
		
		//event handler
		x.setOnMouseClicked( e -> {
			if (e.getButton() == MouseButton.SECONDARY) {
				pt.pause();
				ft.pause();
			}
			else {
				pt.play();
				ft.play();
			}
		});
		
		
		Scene scene = new Scene(pane, 800, 800);
		primaryStage.setTitle("ShowPolygon"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	public static void main(String[] args) {
		launch(args);
	}
}

