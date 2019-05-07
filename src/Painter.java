import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.util.*;

public class Painter {
	GraphicsContext gc;
	Map <String, Integer> letterToX = new HashMap<String, Integer> ();
	Map <String, Integer> numberToY = new HashMap<String, Integer> ();
	
	Painter (GraphicsContext gc) {
		this.gc = gc;
		gc.setFill(Color.color(0.2,0.2,0.2));
        gc.fillRect(0, 0, 500, 500);
        paintScore(0);
        paintBoard();
        paintGrid();
	}
	
	public void paintScore (int score) {
		this.gc.setFill(Color.AQUAMARINE);
        this.gc.fillText("Score: 0", 10, 15);
	}
	
	public void paintBoard () {
		this.gc.setFill(Color.AQUAMARINE);
        //this.gc.fillText("A B C D E F G H I J", 10, 40);
	}
	
	public void paintGrid () {
		this.gc.setStroke(Color.AQUAMARINE);
		int columnWidth = 30;
		int gridHeight = 400;
		int gridTopOffset = 50;
		
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
		String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		
		for (int z = 3; z <= 12; z++) {			
			int x1 = z * columnWidth;
			this.gc.moveTo(x1, gridTopOffset);
            this.gc.lineTo(x1, gridHeight);
            this.gc.stroke();
            
            int xLetter = x1 + 11; // X coordinate from each letter
            this.gc.strokeText(Character.toString(letters[z-3]), xLetter, gridTopOffset + 23);
            
            letterToX.put(Character.toString(letters[z-3]), xLetter);
		}
		
		for (int a = 3; a <= 12; a++) {			
			int x1 = a * columnWidth; //Squares cells 
			this.gc.moveTo(gridTopOffset,x1);
            this.gc.lineTo(gridHeight, x1);
            this.gc.stroke();
            
            int yNumber = x1 + 19; // Y coordinate for each number
            this.gc.strokeText(numbers[a-3], gridTopOffset + 23, yNumber);
            
            numberToY.put(numbers[a-3], yNumber);
		}
	}
	
	public int[] toGridCoordinates (String letter, int number) {
		
		int[] coordinates = {
			letterToX.get(letter), numberToY.get(Integer.toString(number))
		};
		
		return coordinates;
		
	}
	
	public void paintStrike (String letter, int number, String type) {
		
		int[] gridCoordinates = toGridCoordinates(letter, number);
		
		if (type.equals("hit")) {
			this.gc.setStroke(Color.RED);
			this.gc.strokeText("O", gridCoordinates[0], gridCoordinates[1]);
		} else {
			this.gc.setStroke(Color.WHITE);
			this.gc.strokeText("X", gridCoordinates[0], gridCoordinates[1]);
		}
	}
}
