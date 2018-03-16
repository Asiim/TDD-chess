package game;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private Stage stage = null;
    private ArrayList<ImageView> grid = new ArrayList<>();
    private int width = 0;
    private int length = 0;
    private GridPane root;
    private Table table;
    private Color player;
    private Figure selected;
    private Boolean ready = true;
    HashMap<Color, King> kings = new HashMap<Color, King>();
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private static Socket sock;
	private ServerSocket ss;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException{
    	int TCP_PORT = 9000;
		try {
			ss = new ServerSocket(TCP_PORT);
            sock = ss.accept();
            sock.setSoTimeout(10);
            oos = new ObjectOutputStream(sock.getOutputStream());
            ois = new ObjectInputStream(sock.getInputStream());
            ready = true;
            player = Color.WHITE;
            switchScene(50, 60);
            drawTable();
      		Thread thread = new Thread(tableDraw);
      		thread.setDaemon(true);
      		thread.start();  
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
  
    @FXML
    private void handleButtonAction2(ActionEvent event) throws IOException{
    	int TCP_PORT = 9000;
		try {
            InetAddress addr = InetAddress.getByName("127.0.0.1");
            sock = new Socket(addr,TCP_PORT);
            sock.setSoTimeout(10);
            oos = new ObjectOutputStream(sock.getOutputStream());
            ois = new ObjectInputStream(sock.getInputStream());
            ready = false;
            player = Color.BLACK;
            switchScene(1000, 60);
            table.rotate();
            drawTable();
      		Thread thread = new Thread(tableDraw);
      		thread.setDaemon(true);
      		thread.start();  
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private void switchScene(int x, int y){
        prepareResources();
        Scene oldScene = startBtn.getScene();
        Window window = oldScene.getWindow();
        stage = (Stage) window;
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setScene(scene);
        stage.setX(x);
        stage.setY(y);
    	initGUI();
    }

    private void prepareResources(){
        root = new GridPane();
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
        kings.put(Color.WHITE, (King)table.get_square_at_position(0, 4).get_figure());
        kings.put(Color.BLACK, (King)table.get_square_at_position(7, 4).get_figure());
        width = table.get_width();
        length = table.get_length();
        
        for(int x = 0; x < width; x++){
        	for(int y = 0; y < length; y++){
                ImageView iView = new ImageView();
                iView.setFitHeight(SCENE_HEIGHT / length);
                iView.setFitWidth(SCENE_WIDTH / width);
                iView.setPreserveRatio(true);
                iView.setId(new String("" + (x * length + y)));
                grid.add(iView);

                GridPane.setRowIndex(iView,width - x - 1);
                GridPane.setColumnIndex(iView,y);    
                root.getChildren().add(iView);
            }
        }
        
        for (ImageView img : grid) {
        	img.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
	    		int x = Integer.parseInt(img.getId()) / length;
	    		int y = Integer.parseInt(img.getId()) % length;

        	     @Override
        	     public void handle(MouseEvent event) {
        	    	 if(ready) {
	        	    	 if(selected == null) {
	        	    		 if(table.has_figure(x, y)) {
	            	    		 if(table.get_square_at_position(x, y).get_figure().get_color() == player) {
	            	    			 selected = table.get_square_at_position(x, y).get_figure();
	            	    		 }
	        	    		 }
	        	    	 }
	        	    	 else {
	        	    		 if(table.has_figure(x, y)) {
	            	    		 if(table.get_square_at_position(x, y).get_figure().get_color() == player) {
	            	    			 selected = table.get_square_at_position(x, y).get_figure();
	            	    		 }
	            	    		 else {
	                	    		 if(selected.can_move(x, y, table, kings.get(player))) {
		                	    		 selected.move(x, y, table);
	            	    				 selected = null;
	                    	    		 drawTable();
	                    	    		 ready = false;
	                    	    		 table.rotate();
	            	    				 try {
											oos.writeObject(table);
											oos.writeObject(kings);
										} catch (IOException e) {
											e.printStackTrace();
										}
	            	    			 }
	            	    		 }
	        	    		 }
	        	    		 else { 
	        	    			 drawTable();
	        	    			 if(selected.can_move(x, y, table, kings.get(player))) {
	        	    				 selected.move(x, y, table);
	        	    				 selected = null;
	                	    		 drawTable();
                    	    		 ready = false; 
            	    				 table.rotate();
            	    				 try {
										oos.writeObject(table);
										oos.writeObject(kings);
									} catch (IOException e) {
										e.printStackTrace();
									}
	        	    			 }
	        	    		 }
	        	    	 }
//	        	         event.consume(); 
	        	         if(promotePawn(table)) {
	 	         	        	System.out.println("PROMOTE PAWN");
	 	         	        }
	 	          	        if(draw(table, kings.get(player))) {
	 							Alert alert = new Alert(AlertType.INFORMATION);
	 							alert.setTitle("");
	 							alert.setHeaderText("Game over");
	 							alert.setContentText("Draw!");
	 							alert.showAndWait();
	 	    		       	 	initGUI();
	 	    		       	 	if (player.equals(Color.BLACK)) {
	 	    		       	 		table.rotate();
	 	    		       	 	}
	 	    		       	 	drawTable();
	 	        	        }
	 	        	        if(checkMate(table, kings.get(player))) {
	 		        	        Alert alert = new Alert(AlertType.INFORMATION);
	 							alert.setTitle("");
	 							alert.setHeaderText("Game over");
	 		    				 if(player.equals(Color.WHITE)) {
	 		 						alert.setContentText(Color.BLACK + " player wins!");
	 		    				 }
	 		    				 else {
	 		 						alert.setContentText(Color.WHITE + " player wins!");
	 		    				 }
	 							alert.showAndWait();
	 	    		       	 	initGUI();
 	    		       	 		table.rotate();
	 	    		       	 	drawTable();
	 	    		       	 	if (player.equals(Color.BLACK)) {
	 	    		       	 		table.rotate();
	 	    		       	 		ready = false; 
	 	    		       	 		try {
										oos.writeObject(table);
										oos.writeObject(kings);
									} catch (IOException e) {
										e.printStackTrace();
									}
	 	    		       	 	}
	 	        	        }
        	    	 }
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
    
    private Boolean draw(Table table, King king) {
    	if(table.square_occupied(king.get_position_x(), king.get_position_y(), player)) {
    		return false;
    	}
    	
    	for(int i = 0; i < table.get_width() * table.get_length(); i++) {
			if(table.get_square_at_position(i / table.get_width() ,i % table.get_length()).get_figure() != null && 
					!(table.get_square_at_position(i / table.get_width() ,i % table.get_length()).get_figure() instanceof King)) {
				break;
			}
			if(i == table.get_width() * table.get_length() - 1) {
				return true;
			}
		}
    	
    	for(int i = 0; i < table.get_width(); i++) {
    		for(int j = 0; j < table.get_length(); j++) {
    			Figure tmp = null;
    			try {
    				if(table.get_square_at_position(i, j).get_figure().get_color().equals(player)) {
    					tmp = table.get_square_at_position(i, j).get_figure();
    	    			for(int ii = 0; ii < table.get_width(); ii++) {
    	    	    		for(int jj = 0; jj < table.get_length(); jj++) {
    	    	    			if(tmp.can_move(ii, jj, table, king)) {
    	    	    				return false;
    	    	    			}
    	    	    		}
    	        		}
    				}
    			}
    			catch(Exception e) {
    			}
    		}
    	}
    	return true;
    }
    
    
    private Boolean checkMate(Table table, King king) {
    	if(!table.square_occupied(king.get_position_x(), king.get_position_y(), player)) {
    		return false;
    	}
    	
    	for(int i = 0; i < table.get_width(); i++) {
    		for(int j = 0; j < table.get_length(); j++) {
    			Figure tmp = null;
    			try {
    				if(table.get_square_at_position(i, j).get_figure().get_color().equals(player)) {
    					tmp = table.get_square_at_position(i, j).get_figure();
    	    			for(int ii = 0; ii < table.get_width(); ii++) {
    	    	    		for(int jj = 0; jj < table.get_length(); jj++) {
    	    	    			if(tmp.can_move(ii, jj, table, king)) {
    	    	    				return false;
    	    	    			}
    	    	    		}
    	        		}
    				}
    			}
    			catch(Exception e) {
    			}
    		}
    	}
    	return true;
    }
    
    private Boolean promotePawn(Table table) {
    	for(int i = 0; i < table.get_length(); i++) {
    		if(table.get_square_at_position(7, i).get_figure() instanceof Pawn) {
    			return true;
    		}
    	}
    	return false;
    }
    
    Task tableDraw = new Task<Void>() {
        @Override
        public Void call() throws Exception {
       	 	while (true) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                    	if(!ready) {
                    		try {
								table = (Table) ois.readObject();
								kings = (HashMap<Color, King>) ois.readObject();
								drawTable();
								ready = true;
							} catch (ClassNotFoundException | IOException e) {
								e.printStackTrace();
							}
                    	}
                    }
       	 		});
				Thread.sleep(350);
        	}
    	 }
    };    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        player = Color.WHITE;
    }   
    
    public Color get_player() {
    	return player;
    }
}
