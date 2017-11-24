package game;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import enums.Color;
import figures.Bishop;
import figures.Figure;
import figures.King;
import figures.Knight;
import figures.Pawn;
import figures.Queen;
import figures.Rook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import table.Table;

public class Chess_controler implements Initializable {
	
    @FXML
    private Button startBtn;
    
    private static final int NUM_OF_IMAGES = 26;
    private static final int SCENE_WIDTH = 880;
    private static final int SCENE_HEIGHT = 880;
    private Image [] images = new Image[NUM_OF_IMAGES];
    private Stage stage = null ;
    private ArrayList<ImageView> grid = new ArrayList<>();
    private static boolean initialized = false;
    private int width = 0;
    private int length = 0;
    private GridPane root;
    private Table table;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
            switchScene();
    }
    
    @FXML
    private void handleComboBoxAction(ActionEvent event) throws IOException{
        if (!initialized){
            Table table = new Table();                     
            width = table.get_width();
            length = table.get_length();
            
            //POCETAK 1
            for(int y = 0; y < length; y++){
                for(int x = 0; x < width; x++){
                    ImageView iView = new ImageView();
                    iView.setImage(images[0]);
                    iView.setFitHeight(SCENE_HEIGHT / length);
                    iView.setFitWidth(SCENE_WIDTH / width);
                    iView.setPreserveRatio(true);
                    grid.add(iView);

                    root.setRowIndex(iView,y);
                    root.setColumnIndex(iView,x);    
                    root.getChildren().add(iView);
                }
            }
        }
        
//        int imageToPick = 0;
//            // LOOP
//        for(int i = 0; i < length; i++) {
//            for(int j = 0; j < width; j++){
//                imageToPick = 0;
//                grid.get(i*width + j).setImage(images[imageToPick]);
//            }
//        }
    }
    
    private void switchScene(){
        Scene oldScene = startBtn.getScene();
        Window window = oldScene.getWindow();
        stage = (Stage) window;
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.setX(500);
        stage.setY(60);
        stage.show();
        initialized = true;
    }

    private void prepareResources(){
        root = new GridPane();
        System.out.println(System.getProperty("user.dir"));
        InputStream in = getClass().getResourceAsStream("resources/grpx/rook_black_1.png");
        images[0] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/knight_black_1.png");
        images[1] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/bishop_black_1.png");
        images[2] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/queen_black_1.png");
        images[3] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/king_black_1.png");
        images[4] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/pawn_black_1.png");
        images[5] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/rook_white_1.png");
        images[6] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/knight_white_1.png");
        images[7] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/bishop_white_1.png");
        images[8] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/queen_white_1.png");
        images[9] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/king_white_1.png");
        images[10] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/pawn_white_1.png");
        images[11] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/rook_black_0.png");
        images[12] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/knight_black_0.png");
        images[13] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/bishop_black_0.png");
        images[14] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/queen_black_0.png");
        images[15] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/king_black_0.png");
        images[16] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/pawn_black_0.png");
        images[17] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/rook_white_0.png");
        images[18] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/knight_white_0.png");
        images[19] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/bishop_white_0.png");
        images[20] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/queen_white_0.png");
        images[21] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/king_white_0.png");
        images[22] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/pawn_white_0.png");
        images[23] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/square_black.png");
        images[24] = new Image(in);
        in = getClass().getResourceAsStream("resources/grpx/square_white.png");
        images[25] = new Image(in);   
    }
            
    private void initGUI(){
        table = new Table();    
        table.set_figures_on_table();
        width = table.get_width();
        length = table.get_length();

        for(int x = 0; x < width; x++){
        	for(int y = 0; y < length; y++){
                ImageView iView = new ImageView();
                iView.setFitHeight(SCENE_HEIGHT / length);
                iView.setFitWidth(SCENE_WIDTH / width);
                iView.setPreserveRatio(true);
                iView.setId(new String("x = " + x + "\ny = " + y));
                grid.add(iView);

                root.setRowIndex(iView,width - x - 1);
                root.setColumnIndex(iView,y);    
                root.getChildren().add(iView);
            }
        }
        
        drawTable();
        for (ImageView img : grid) {
        	img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

        	     @Override
        	     public void handle(MouseEvent event) {
        	         System.out.println("Tile pressed " + img.getId());
        	         event.consume();
        	     }
        	});
        }
    }
    
    private void drawTable() {
        for(int i = width - 1; i >= 0; i--){
            for(int j = length - 1; j >= 0; j--){
	        	if(table.get_square_at_position(i, j).get_color().equals(Color.WHITE)) {
	        		grid.get(i*width + j).setImage(images[25]);
	        		if(table.get_square_at_position(i, j).get_figure() instanceof Rook) {
		        		if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.WHITE)) {
			        		grid.get(i*width + j).setImage(images[6]);
		        		}
		        		else if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.BLACK)) {
			        		grid.get(i*width + j).setImage(images[0]);	
		        		}
		        	}
		        	else if(table.get_square_at_position(i, j).get_figure() instanceof Bishop) {
		        		if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.WHITE)) {
			        		grid.get(i*width + j).setImage(images[8]);
		        		}
		        		else if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.BLACK)) {
			        		grid.get(i*width + j).setImage(images[2]);	
		        		}
		        	}
		        	else if(table.get_square_at_position(i, j).get_figure() instanceof King) {
		        		if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.WHITE)) {
			        		grid.get(i*width + j).setImage(images[10]);
		        		}
		        		else if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.BLACK)) {
			        		grid.get(i*width + j).setImage(images[4]);	
		        		}
		        	}
		        	else if(table.get_square_at_position(i, j).get_figure() instanceof Queen) {
		        		if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.WHITE)) {
			        		grid.get(i*width + j).setImage(images[9]);
		        		}
		        		else if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.BLACK)) {
			        		grid.get(i*width + j).setImage(images[3]);	
		        		}
		        	}
		        	else if(table.get_square_at_position(i, j).get_figure() instanceof Pawn) {
		        		if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.WHITE)) {
			        		grid.get(i*width + j).setImage(images[11]);
		        		}
		        		else if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.BLACK)) {
			        		grid.get(i*width + j).setImage(images[5]);	
		        		}
		        	}
		        	else if(table.get_square_at_position(i, j).get_figure() instanceof Knight) {
		        		if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.WHITE)) {
			        		grid.get(i*width + j).setImage(images[7]);
		        		}
		        		else if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.BLACK)) {
			        		grid.get(i*width + j).setImage(images[1]);	
		        		}
		        	}
	        	}
	        	else if(table.get_square_at_position(i, j).get_color().equals(Color.BLACK)) {
	        		grid.get(i*width + j).setImage(images[24]);
	        		if(table.get_square_at_position(i, j).get_figure() instanceof Rook) {
		        		if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.WHITE)) {
			        		grid.get(i*width + j).setImage(images[18]);
		        		}
		        		else if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.BLACK)) {
			        		grid.get(i*width + j).setImage(images[12]);	
		        		}
		        	}
		        	else if(table.get_square_at_position(i, j).get_figure() instanceof Bishop) {
		        		if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.WHITE)) {
			        		grid.get(i*width + j).setImage(images[20]);
		        		}
		        		else if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.BLACK)) {
			        		grid.get(i*width + j).setImage(images[14]);	
		        		}
		        	}
		        	else if(table.get_square_at_position(i, j).get_figure() instanceof King) {
		        		if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.WHITE)) {
			        		grid.get(i*width + j).setImage(images[22]);
		        		}
		        		else if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.BLACK)) {
			        		grid.get(i*width + j).setImage(images[16]);	
		        		}
		        	}
		        	else if(table.get_square_at_position(i, j).get_figure() instanceof Queen) {
		        		if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.WHITE)) {
			        		grid.get(i*width + j).setImage(images[21]);
		        		}
		        		else if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.BLACK)) {
			        		grid.get(i*width + j).setImage(images[15]);	
		        		}
		        	}
		        	else if(table.get_square_at_position(i, j).get_figure() instanceof Pawn) {
		        		if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.WHITE)) {
			        		grid.get(i*width + j).setImage(images[23]);
		        		}
		        		else if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.BLACK)) {
			        		grid.get(i*width + j).setImage(images[17]);	
		        		}
		        	}
		        	else if(table.get_square_at_position(i, j).get_figure() instanceof Knight) {
		        		if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.WHITE)) {
			        		grid.get(i*width + j).setImage(images[19]);
		        		}
		        		else if(table.get_square_at_position(i, j).get_figure().get_color().equals(Color.BLACK)) {
			        		grid.get(i*width + j).setImage(images[13]);	
		        		}
		        	}
	        	}
	        }
	    }
	    
	    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prepareResources();
    	initGUI();
    }    
}
