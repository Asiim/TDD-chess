package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Game extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PortSelector.fxml"));
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);        
        Scene scene = new Scene(root);
        
        
        stage.setTitle("Chess Master");
        stage.setScene(scene);
        stage.show();
    }

	public static void main(String[] args) {
        launch(args);
	}

}
