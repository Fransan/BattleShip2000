import javafx.application.Application;
import javafx.stage.Stage; 
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 

public class Main extends Application {

	private static final int HEIGHT = 500;
	private static final int WIDTH = 500;
	
	@Override
	public void start(Stage mainStage) {
		
		GridPane root = new GridPane();
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		TextField inputField = new TextField();
		Button submit = new Button("Fire!");
		
		// Get the graphics context of the canvas
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		BattleShip game = new BattleShip();
		Painter painter = new Painter(gc);
		
		root.setPadding(new Insets(10,10,10,10));
		root.setAlignment(Pos.CENTER);
		root.add(canvas, 0, 0);
		root.add(inputField, 0, 1);
		root.add(submit, 0, 2);
		
		submit.setOnAction(e -> {
            String input = inputField.getText();
            String strikeResult = game.nextMove(input);
            String[] coordinates = { input.substring(0,1), input.substring(1) };
           System.out.println(coordinates[0] + "," + coordinates[1]);
            
            painter.paintStrike(coordinates[0].toUpperCase(), Integer.parseInt(coordinates[1]), strikeResult );
        });

		
		
		Scene scene = new Scene(root);
		
		mainStage.setTitle("Battle Ship!");
		mainStage.setScene(scene);
		mainStage.show();
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
