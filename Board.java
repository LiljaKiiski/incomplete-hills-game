public class Board {
	public Hills hills;
	public GraphPanel graphPanel;

	public int index;

	public Board(Hills hills){
		this.hills = hills;
	}

	public void move(){
		index += 1;

		if (index > hills.points.size()){
			index -= 1;
		}
	}
}
