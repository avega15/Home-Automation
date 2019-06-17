package automation;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Verification extends Application {
	
	Boolean adminValid = false;
	ArrayList<Person> ArrPerson = new ArrayList<Person>();
	Person admin = new Person(1, 44127, "Admin", "Admin");

	DataBase data1 = new DataBase(ArrPerson);

	ArrayList<BlackList> ArrBlackList = new ArrayList<BlackList>();
	BlackList bl1 = new BlackList(28745);
	
	ArrayList<WhiteList> ArrWhiteList = new ArrayList<WhiteList>();
	WhiteList wl1 = new WhiteList(44127);
	WhiteList wl2 = new WhiteList(34844);

	DataBaseID dataBL = new DataBaseID(ArrBlackList);
	DataBaseWhiteList dataWL = new DataBaseWhiteList(ArrWhiteList);

	
	String IntPC;
	String GetFN;
	String GetLN;
	int foo;
	int idAdd = 1;

	String IntPC1;
	String GetFN1;
	String GetLN1;
	int foo1;
	String getID3;
	int ID3;
	
	String getID5;
	int ID5;
	public static void main(String[] args) {
		Application.launch(args);

	}

	public void start(Stage primaryStage) {
			Stage newStage = new Stage();
			newStage.setTitle("WhiteList Info Add");
			GridPane rootNode = new GridPane();
			rootNode.setPadding(new Insets(15));
			rootNode.setHgap(10);
			rootNode.setVgap(10);
			rootNode.setAlignment(Pos.TOP_CENTER);
			Text text = new Text();
			text.setText("Enter passcode to add   ");
			text.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

			rootNode.add(text, 0, 0);
			TextField PC3 = new TextField();
			rootNode.add(PC3, 1, 0);

			Button d1 = new Button("Add");
			rootNode.add(d1, 2, 0);
			
			d1.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent e) {								
			getID5 = PC3.getText();
			int ID5 = Integer.parseInt(getID5);
			
			
			WhiteList wl4 = new WhiteList(ID5);
			ArrWhiteList.add(wl4);
			
			final Text actiontarget1 = new Text();
			rootNode.add(actiontarget1, 1, 10);
			actiontarget1.setText("Added");				
				}
			});
			Scene stageScene = new Scene(rootNode, 500, 500);
			newStage.setScene(stageScene);
			newStage.show();
		

	}
}