package application;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import javafx.scene.layout.HBox;


public class Main extends Application {
	@Override
	public void start(Stage applicationStage) {
		
		//adding Local Date ability
		LocalDate dayOfUse = LocalDate.now();
		String dayOfEntry = dayOfUse.toString();
		Label localDate = new Label("Today's date is: " + dayOfEntry);
		MenuBar mainMenu = new MenuBar();
		
		//setting outline of scene
		Menu menu = new Menu("Menu");
		mainMenu.getMenus().addAll(menu);
		BorderPane root = new BorderPane();
		root.setTop(mainMenu);
		root.setCenter(null);
		root.setStyle(null);
		localDate.setStyle(dayOfEntry);
		BorderPane.setMargin(localDate, new Insets(10,10,10,10));
		Scene scene = new Scene(root);

		//adding items to menu
		MenuItem menuItem1 = new MenuItem("1");
		MenuItem menuItem2 = new MenuItem("2");
		MenuItem menuItem3 = new MenuItem("3");
		MenuItem menuItem4 = new MenuItem("4");
		
		//mapping menu items
		menu.getItems().addAll(menuItem1, menuItem2, menuItem3, menuItem4);

		//adding actions to menuItem1 	
		menuItem1.setOnAction(event -> root.setCenter(localDate));

		
		//adding actions to menuitem2
		menuItem2.setOnAction(event-> {
			try {
				FileWriter myWriter = new FileWriter("dateText.txt");
				myWriter.write(dayOfEntry);
				myWriter.close();
				System.out.println("File Created");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.print("Log Text Error");
			}
		});
		
		//adding actions to menuItem3		WHY YOU NO TURN GREEN?!?
		menuItem3.setOnAction(event -> {
			try {
				root.setStyle("-fx-background-color: #33cc33");
			} catch (Exception e) {
				System.out.print("Error: cannot turn Green");
			}});
		
		//adding actions to menuItem4
		menuItem4.setOnAction(event -> System.out.print("Exiting"));
		menuItem4.setOnAction(event -> Platform.exit());
	
		
		//set scene
		applicationStage.setScene(scene);
		applicationStage.setWidth(500);
		applicationStage.setHeight(500);
		applicationStage.setTitle("Prog2 Ct3 Green");
		applicationStage.show();
		
			}
	
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		
	public static void main(String[] args) {
		launch(args);
	}}
