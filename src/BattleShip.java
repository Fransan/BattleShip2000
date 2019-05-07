public class BattleShip{
	private String[] patrol = new String[2];
	private String[] frigate = new String[3];
	private String[] carrier = new String[4];
	
	BattleShip (){
		initGame();
	}
	
	private void initGame() {
		patrol[0] = "a1";
		patrol[1] = "a2";
		
		frigate[0] = "c3";
		frigate[1] = "c4";
		frigate[2] = "c5";
		
		carrier[0] = "b6";
		carrier[1] = "c6";
		carrier[2] = "d6";
		carrier[3] = "e6";
	}
	
	public String nextMove(String coordinates) {
				
		boolean isAHit = checkCoordinates(coordinates);
		String result = "miss";
		
		if (isAHit) {
			result = "hit";
		} 
		
		return result;
		
	}
	
	private boolean checkCoordinates(String coordinates) {
		boolean impact = false;
		
		for (String x:patrol) {
			if (x.toLowerCase().equals(coordinates.toLowerCase())) {
				impact = true;
				return impact;
			}
		}

		for (String x:frigate) {
			if (x.toLowerCase().equals(coordinates.toLowerCase())) {
				impact = true;
				return impact;
			}
		}
		
		for (String x:carrier) {
			if (x.toLowerCase().equals(coordinates.toLowerCase())) {
				impact = true;
				return impact;
			}
		}
		
		return impact;
	}
	
	
	//public static void main(String[] args) {
		//BattleShip game = new BattleShip();
		
		//board.printBoard();
		//game.initGame();
		
		//boolean move = true;
		//while (move) {
		//	move = game.nextMove();
		//}
	//}

}