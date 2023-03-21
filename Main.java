import java.io.File;
import java.io.IOException;
import java.util.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.*;
import javafx.stage.Stage;
import javafx.scene.text.Text.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;

public class Main extends Application implements EventHandler<ActionEvent> {
	
	Stage window;
	Button button;
	
	
	public static void main(String args[]){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("Text Analyzer");
		button = new Button("Process");
		button.setOnAction(this);
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();
		}

	@Override
	public void handle(ActionEvent event) {	
		if(event.getSource()==button) {
			File poem = new File("src/Raven.txt");
			Scanner readMe = new Scanner(poem);
			
			Map<String,Integer> wordBank = new HashMap<String,Integer>();
			while(readMe.hasNext()) {
				String word = readMe.next();
				if(wordBank.containsKey(word)==false)
					wordBank.put(word,1);
				else{
					int count = (int)(wordBank.get(word));
					wordBank.remove(word);
					wordBank.put(word, count + 1);
			
			Set<Map.Entry<String, Integer>> set = wordBank.entrySet();
			List<Map.Entry<String,Integer>>sortedList = new ArrayList<Map.Entry<
					String,Integer>>(set);
			Collections.sort(sortedList,new Comparator<Map.Entry<String,Integer>>()
			{
		public int compare(Map.Entry<String,Integer>a,Map.Entry<String,Integer>b) {
			
			return (b.getValue()).compareTo(a.getValue());
				}
			});
		for(Map.Entry<String,Integer>i:sortedList) {
			System.out.println(i.getKey()+"->"+i.getValue());
	
	}
}
