package test;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.beans.property.*;

public class Exercise16_01 extends Application {
	protected Text text = new Text(50, 50, "Programming is fun");
	
	protected BorderPane getPane() {
		//pane for left/right buttons
		HBox paneForButtons = new HBox(20);
		//buttons
		Button btLeft = new Button("<-");
		Button btRight = new Button("->");
		//add buttons, confirgure
		paneForButtons.getChildren().addAll(btLeft, btRight);
		paneForButtons.setAlignment(Pos.CENTER);
		paneForButtons.setStyle("-fx-border-color: black");
		//big pane, set buttons in
		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons);
		
		
		//add pane for text
		Pane paneForText = new Pane();
		//set text font
		text.setFont(Font.font("verdana", FontWeight.LIGHT, FontPosture.REGULAR, 20));
		paneForText.getChildren().add(text);
		//set text pane into border pane
		pane.setCenter(paneForText);
		
		
		//hbox for rbs
		HBox paneForRB = new HBox(20);
		//make radio buttons
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbYellow = new RadioButton("Yellow");
		RadioButton rbBlack = new RadioButton("Black");
		RadioButton rbOrange = new RadioButton("Orange");
		RadioButton rbGreen = new RadioButton("Green");
		//add toggle group
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbYellow.setToggleGroup(group);
		rbBlack.setToggleGroup(group);
		rbOrange.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		//set radio buttons in hbox 
		paneForRB.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
		paneForRB.setAlignment(Pos.CENTER);
		paneForRB.setStyle("-fx-border-color: black");
		//set radio button pane to border pane
		pane.setTop(paneForRB);
		
		
		//handlers
		btLeft.setOnAction(e -> {
			if (text.getX() > 0) {
				text.setX(text.getX() - 10);
				if (text.getX() < 0 ) text.setX(0);
			}
		});
		btRight.setOnAction(e -> {
			if (text.getX() < 200) text.setX(text.getX() + 10);
			else if (text.getX() < 205) text.setX(text.getX() + 5);
		});
		rbRed.setOnAction(e -> text.setStroke(Color.RED));
		rbYellow.setOnAction(e -> text.setStroke(Color.YELLOW));
		rbBlack.setOnAction(e -> text.setStroke(Color.BLACK));
		rbOrange.setOnAction(e -> text.setStroke(Color.ORANGE));
		rbGreen.setOnAction(e -> text.setStroke(Color.GREEN));
		
		
		return pane;	
	}
	
	
	@Override 
	public void start(Stage primaryStage) {
		Scene scene = new Scene(getPane(), 400, 200);
		primaryStage.setTitle("Exercise16_01");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
