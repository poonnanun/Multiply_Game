import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreBoard {
	
	private List<Score> scoreList = new ArrayList<>();
	
	private static ScoreBoard instance = null;
	
	private ScoreBoard() {
		scoreList.add(new Score("A", 123, 5));
		scoreList.add(new Score("B", 321, 5));
		scoreList.add(new Score("C", 78, 5));
		scoreList.add(new Score("D", 1, 5));
		scoreList.add(new Score("E", 11, 5));
	}
	
	public static ScoreBoard getInstance() {
		if (instance == null) return new ScoreBoard();
		else return instance;
	}
	
	public void addScore(Score score) {
		scoreList.add(score);
		updateScoreList();
	}
	
	private void updateScoreList() {
		Collections.sort(scoreList);
	}
	
	public List<Score> getList() {
		return scoreList;
		
	}
	
	
	

}
