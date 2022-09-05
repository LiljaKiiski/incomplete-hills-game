public class Board {
	public Hills hills;
	public GraphPanel graphPanel;

	public int index;

	public Board(Hills hills){
		this.hills = hills;
	}

	public void move(){
		//Move forward
		if (index < hills.points.size()-2){
			index += 1;
		
		}
	}
}
