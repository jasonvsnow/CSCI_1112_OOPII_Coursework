package chapter15;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.event.*;

/*
 * Author: Jason Snow
 * Date: 01/21/2021
 * 
 * This program launches a stage with a circle and four buttons "left", "right", "up", and "down" that
 * 	move the circle in those directions until it would move off the screen, at which point it instead stops. 
 * 
 * 
 */


public class Exercise15_Listeners extends Application {
	private MyCircle c1 = new MyCircle();
	
	@Override
	public void start (Stage primaryStage) {
		//make buttons
		Button left = new Button ("left");
		Button right = new Button ("right");
		Button up = new Button ("up");
		Button down = new Button ("down");
		//set boxes in row
		HBox row = new HBox();
		row.setSpacing(15);
		row.setAlignment(Pos.CENTER);
		//put buttons in row
		row.getChildren().addAll(left, right, up, down);
		
		//create and register handlers
		left.setOnAction(new Lefthandler());
		right.setOnAction(new RightHandler());
		up.setOnAction(new UpHandler());
		down.setOnAction(new DownHandler());
		
		
		//make holder pane
		BorderPane pane = new BorderPane();
		//set row in bigger pane
		pane.setBottom(row);
		//test pane
		pane.setCenter(c1);
		Scene scene = new Scene(pane, 250, 200);
		primaryStage.setTitle("Moving Circle");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}

class Lefthandler implements EventHandler<ActionEvent> {
	@Override
	public void handle (ActionEvent e) {
		MyCircle.left();
	}
}

class RightHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle (ActionEvent e) {
		MyCircle.right();
	}
}
class UpHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle (ActionEvent e) {
		MyCircle.up();
	}
}
class DownHandler implements EventHandler<ActionEvent> {
	@Override
	public void handle (ActionEvent e) {
		MyCircle.down();
	}
}

class MyCircle extends Pane {
	private static Circle c1 = new Circle(125, 100, 25);
	
	public MyCircle() {
		c1.setStroke(Color.BLACK);
		c1.setFill(Color.WHITE);
		getChildren().add(c1);
		
	}
	
	public static void left() {
		double check = c1.getCenterX();
		if (check > 40) c1.setCenterX(check-25);
	}
	
	public static void right() {
		double check = c1.getCenterX();
		if (check < 210) c1.setCenterX(check+25);
	}
	
	public static void up() {
		double check = c1.getCenterY();
		if (check > 40) c1.setCenterY(check-25);
	}
	
	public static void down() {
		double check = c1.getCenterY();
		if (check < 140) c1.setCenterY(check+25);
	}
}

