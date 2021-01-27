package chapter6;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.scene.text.*;
import javafx.util.Duration;
import javafx.animation.*;
import javafx.event.*;
import javafx.scene.media.*;
/*
 * Author: Jason Snow
 * Date: 01/27/21
 * 
 * This program displays a text field that a user can enter a number into. Entering anything except an
 * integer causes an exception to be caught and a message to be displayed telling the user to correct 
 * their error. The user has to click on the box again to enter a new number  
 */
public class Exercise16_21 extends Application {
	protected int value = 1;
	
	
	protected TextField getPane() {

		
		TextField tf = new TextField();
		tf.setFont(Font.font("Times", 50));
		tf.setAlignment(Pos.CENTER);
		
		EventHandler<ActionEvent> improper = e -> {
			tf.setAlignment(Pos.CENTER_LEFT);
			tf.setFont(Font.font(10));
			tf.setText("Enter an integer(click the field again)");
			tf.setEditable(false);
		};
		
		Timeline animation = new Timeline(
				new KeyFrame(Duration.millis(10), improper));
		animation.setCycleCount(1);
		
		Media media = new Media("https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3");
		MediaPlayer music = new MediaPlayer(media);
		music.setCycleCount(Timeline.INDEFINITE);
		
		EventHandler<ActionEvent> counting = e -> {
			value = Integer.parseInt(tf.getText());
			if (value > 0) {
				value -= 1;
				String string = value + "";
				tf.setText(string);
			}
			else if (value == 0) {
				music.play();
			}
		};
		
		Timeline countDown = new Timeline(
				new KeyFrame(Duration.millis(1000), counting));
		countDown.setCycleCount(Timeline.INDEFINITE);
		
		
		tf.setOnAction(e -> {
			String hold = tf.getText();
			try {
				value = Integer.parseInt(hold);
				tf.setEditable(false);
				countDown.play();
			}
			catch (IllegalArgumentException ex) {
				animation.play();		
			}
		});
		
		tf.setOnMouseClicked(e -> {
			if (tf.getText().equalsIgnoreCase("Enter an integer(click the field again)")) {
				tf.setText("");
				tf.setAlignment(Pos.CENTER);
				tf.setFont(Font.font(50));
				tf.setEditable(true);
			}	
		});
		
		
		
		
		
		return tf;
	}
	
	
	
	
	@Override 
	public void start(Stage primaryStage) {
		
		
		Scene scene = new Scene(getPane(), 200, 100);
		primaryStage.setTitle("Exercise16_21");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

