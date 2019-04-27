
public class Question {
	
	private int randNum;
	
	private int multiplication;
	
	public Question(int multiplication) {
		this.multiplication = multiplication;
	}
	
	public void generateQuestion() {
		this.randNum = (int) (Math.random() * 13);
	}
	
	public int getMultiplication() {
		return this.multiplication;
	}
	
	public int getRandNum() {
		return this.randNum;
	}
	
	public String toString() {
		return String.format("%d x %d", multiplication, randNum);
	}

}
