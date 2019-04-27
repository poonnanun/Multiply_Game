

public class Score implements Comparable<Score>{
	
	private int score;
	private String name;
	private int multiplication;
	
	public Score(String name, int score, int multiplication) {
		this.score = score;
		this.name = name;
		this.multiplication = multiplication;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getMultiplication() {
		return this.multiplication;
	}


	@Override
	public int compareTo(Score s0) {
		return Integer.compare(this.getScore(), s0.getScore());
	}
	
	public String toString() {
		return String.format("Name: %s Score: %d Multiplication: %d", name, score, multiplication);
	}

}
