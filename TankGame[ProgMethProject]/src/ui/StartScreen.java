package ui;

import Main.Main;
import Model.IRenderableHolder;
import Utility.GameUtility;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class StartScreen extends StackPane{
	private Button startButton, body1, body2 ,body3 ,body4 , gun1, gun2, gun3, gun4;
	private Canvas canvas;
	private Image bg;
	private int currentX;
	private int imageWidth;
	private static String style = "-fx-text-fill: white; -fx-font: bold 20pt \"Time News Roman\";";
	private TextField player1TextField, player2TextField;
	public StartScreen(){
		super();
		this.setVisible(true);
		
		initializeGUI();
		addListener();
		
	}
	
	public void addListener(){
		startButton.setOnAction((ActionEvent e) -> {
			Main.instance.ChangeScene();
			Main.instance.startAnimation.stop();
		});
	}
	
	public void initializeGUI(){
		this.setPrefSize(GameUtility.GAMESCREEN_WIDTH, GameUtility.GAMESCREEN_HEIGHT);
		this.setAlignment(Pos.CENTER);
		this.bg = IRenderableHolder.bg;
		imageWidth = (int) bg.getWidth();
		
		startButton = new Button("Start");
		startButton.setAlignment(Pos.CENTER);
		startButton.setPrefSize(200, 20);
		startButton.setStyle(style+"-fx-background-color: gray");
		
		player1TextField = new TextField();
		player2TextField = new TextField();
		
		canvas = new Canvas(GameUtility.GAMESCREEN_WIDTH, GameUtility.GAMESCREEN_HEIGHT);
		
		body1 = new Button();
		body1.setPrefSize(75, 75);
		body1.setStyle("-fx-background-color: darkblue");
		body2 = new Button();
		body2.setPrefSize(75,75);
		body2.setStyle("-fx-background-color: green");
		body3 = new Button();
		body3.setPrefSize(75,75);
		body3.setStyle("-fx-background-color: orange");
		body4 = new Button();
		body4.setPrefSize(75,75);
		body4.setStyle("-fx-background-color: pink");
		gun1 = new Button();
		gun1.setPrefSize(75,75);
		gun1.setStyle("-fx-background-color: white");
		gun2 = new Button();
		gun2.setPrefSize(75,75);
		gun2.setStyle("-fx-background-color: brown");
		gun3 = new Button();
		gun3.setPrefSize(75,75);
		gun3.setStyle("-fx-background-color: purple");
		gun4 = new Button();
		gun4.setPrefSize(75,75);
		gun4.setStyle("-fx-background-color: aquamarine");

		Label bodyLabel1 = new Label("Body");
		bodyLabel1.setStyle(style);
		Label bodyLabel2 = new Label("Body");
		bodyLabel2.setStyle(style);
		Label gunLabel1 = new Label("Gun");
		gunLabel1.setStyle(style);
		Label gunLabel2 = new Label("Gun");
		gunLabel2.setStyle(style);
		Label player1Label = new Label("Player1 -->");
		player1Label.setStyle(style);
		Label player2Label = new Label("<-- Player2");
		player2Label.setStyle(style);
		Label vsLabel = new Label("VS");
		vsLabel.setStyle(style);
		Label titleLabel = new Label("Tank Game 1 vs 1");
		titleLabel.setStyle(style);
		
		
		GridPane leftPane = new GridPane();
		leftPane.setPrefSize(300, 300);
		leftPane.setVgap(10);
		leftPane.setHgap(50);
		leftPane.setAlignment(Pos.CENTER);
		leftPane.add(bodyLabel1, 0, 0);
		leftPane.add(body1, 0, 1);
		leftPane.add(body2, 1, 1);
		leftPane.add(gunLabel1, 0, 2);
		leftPane.add(gun1, 0, 3);
		leftPane.add(gun2, 1, 3);
		
		GridPane rightPane = new GridPane();
		rightPane.setPrefSize(300, 300);
		rightPane.setVgap(10);
		rightPane.setHgap(50);
		rightPane.setAlignment(Pos.CENTER);
		rightPane.add(bodyLabel2, 0, 0);
		rightPane.add(body3, 0, 1);
		rightPane.add(body4, 1, 1);
		rightPane.add(gunLabel2, 0, 2);
		rightPane.add(gun3, 0, 3);
		rightPane.add(gun4, 1, 3);
		
		GridPane centerPane = new GridPane();
		centerPane.setPrefSize(500, 500);
		centerPane.setVgap(30);
		centerPane.setHgap(30);
		centerPane.setAlignment(Pos.CENTER);
		centerPane.add(player2Label, 0, 0);
		centerPane.add(player2TextField, 1, 0);
		centerPane.add(player1Label, 1, 2);
		centerPane.add(player1TextField, 0, 2);
		
		
		BorderPane boderPane = new BorderPane();
		boderPane.setPrefSize(GameUtility.GAMESCREEN_WIDTH, GameUtility.GAMESCREEN_HEIGHT);
		boderPane.setPadding(new Insets(20,20,20,20));
		boderPane.setBottom(startButton);
		boderPane.setLeft(leftPane);
		boderPane.setRight(rightPane);
		boderPane.setCenter(centerPane);
		boderPane.setTop(titleLabel);
		boderPane.setAlignment(startButton, Pos.CENTER);
		boderPane.setAlignment(titleLabel, Pos.CENTER);
		
		this.getChildren().add(canvas);
		this.getChildren().add(boderPane);
		this.getChildren().add(vsLabel);
	}
	
	public void paintComponents(){
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setGlobalAlpha(0.8);
		gc.clearRect(0, 0, GameUtility.GAMESCREEN_WIDTH, GameUtility.GAMESCREEN_HEIGHT);
		WritableImage croppedImage = new WritableImage(bg.getPixelReader(), currentX, 0,
		GameUtility.GAMESCREEN_WIDTH, GameUtility.GAMESCREEN_HEIGHT);
		gc.drawImage(croppedImage, 0, 0);
		gc.setGlobalAlpha(1);
		
	}
	
	public void movementUpdate(){
		int newX = currentX + 1;
		if(newX + GameUtility.GAMESCREEN_WIDTH > imageWidth) newX = 0;
		currentX = newX;
	}
	
}
