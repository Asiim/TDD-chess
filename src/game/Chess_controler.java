package game;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import enums.Color;
import figures.Bishop;
import figures.Figure;
import figures.King;
import figures.Knight;
import figures.Pawn;
import figures.Queen;
import figures.Rook;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;
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
    private int width = 0;
    private int length = 0;
    private GridPane root;
    private Table table;
    private Color player;
    private Figure selected;
    private Boolean draw = false;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
            switchScene();
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
        player = Color.WHITE;
        
        for(int x = 0; x < width; x++){
        	for(int y = 0; y < length; y++){
                ImageView iView = new ImageView();
                iView.setFitHeight(SCENE_HEIGHT / length);
                iView.setFitWidth(SCENE_WIDTH / width);
                iView.setPreserveRatio(true);
                iView.setId(new String("" + (x * length + y)));
                grid.add(iView);

                root.setRowIndex(iView,width - x - 1);
                root.setColumnIndex(iView,y);    
                root.getChildren().add(iView);
            }
        }
        
        drawTable();
        for (ImageView img : grid) {
        	img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	    		int x = Integer.parseInt(img.getId()) / length;
	    		int y = Integer.parseInt(img.getId()) % length;
        	     @Override
        	     public void handle(MouseEvent event) {
        	    	 if(selected == null) {
        	    		 System.out.println("IF1");
        	    		 if(table.has_figure(x, y)) {
            	    		 System.out.println("IF2");
            	    		 if(table.get_square_at_position(x, y).get_figure().get_color() == player) {
                	    		 System.out.println("IF3");
            	    			 selected = table.get_square_at_position(x, y).get_figure();
                	    		 System.out.println(selected.getClass());
            	    		 }
        	    		 }
        	    	 }
        	    	 else {
        	    		 System.out.println("ELSE1");
        	    		 if(table.has_figure(x, y)) {
            	    		 System.out.println("IF4");
            	    		 if(table.get_square_at_position(x, y).get_figure().get_color() == player) {
                	    		 System.out.println("IF5");
            	    			 selected = table.get_square_at_position(x, y).get_figure();
                	    		 System.out.println(selected.getClass());
            	    		 }
            	    		 else {
            	    			 if(selected.can_move(x, y, table)) {
                    	    		 System.out.println("IF6");
            	    				 table.get_square_at_position(selected.get_position_x(), selected.get_position_y()).set_figure(null);
            	    				 selected.move(x, y);
            	    				 table.get_square_at_position(x, y).set_figure(selected);
            	    				 selected = null;
            	    				 if(player.equals(Color.WHITE)) {
            	        	    		 System.out.println("IF7");
            	    					 player = Color.BLACK;
            	    				 }
            	    				 else {
            	        	    		 System.out.println("ELSE3");
            	    					 player = Color.WHITE;
            	    				 }
                    	    		 System.out.println("IF8");
            	    				 drawTable();
            	    				 try {
                	    				 drawTable();
    									Thread.sleep(2000);
    								} catch (InterruptedException e) {
    									e.printStackTrace();
    								}
            	    				 table.rotate();
            	    				 drawTable();
            	    			 }
            	    		 }
        	    		 }
        	    		 else {
            	    		 System.out.println("ELSE2");
        	    			 if(selected.can_move(x, y, table)) {
                	    		 System.out.println("IF6");
        	    				 table.get_square_at_position(selected.get_position_x(), selected.get_position_y()).set_figure(null);
        	    				 selected.move(x, y);
        	    				 table.get_square_at_position(x, y).set_figure(selected);
        	    				 selected = null;
        	    				 if(player.equals(Color.WHITE)) {
        	        	    		 System.out.println("IF7");
        	    					 player = Color.BLACK;
        	    				 }
        	    				 else {
        	        	    		 System.out.println("ELSE3");
        	    					 player = Color.WHITE;
        	    				 }
                	    		 System.out.println("IF8");
                	    		 draw = true;
                	    		 System.out.println("IF9");
        	    				 try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
        	    				 table.rotate();
        	    				 //drawTable();
                	    		 System.out.println("IF9");
        	    			 }
        	    		 }
        	    	 }
        	    	 System.out.println("FIGRUE: " + selected.get_position_x() + "\t" + selected.get_position_y());
        	         System.out.println("Tile pressed " + x + "\t" + y);
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
    
    Task tableDraw = new Task<Void>() {
        @Override
        public Void call() throws Exception {
       	 	while (true) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
	                    	if(draw) {
	                    		drawTable();
	                    		draw = false;
	                    	}
                    	}
       	 		});
				Thread.sleep(100);
        	}
    	 }
    };
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      Thread thread = new Thread(tableDraw);
      thread.setDaemon(true);
      thread.start();   
        prepareResources();
    	initGUI();
    }   
    
    public Color get_player() {
    	return player;
    }
}
