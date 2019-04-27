import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Choice {
	
	private Question q;
	
	private List<Integer> list = new ArrayList<>();
	
	public Choice(Question q) {
		this.q = q;
	}
	
	public void generateChoices() {
		
		int ans = q.getMultiplication() * q.getRandNum();
		list.add(ans);
		while(list.size() < 4) {
			int x = q.getMultiplication() * (int) (Math.random() * 13 + 1);
			if (!list.contains(x)) list.add(x);
		}
		
	}
	
	public boolean isCorrect() {

		return false;
	}
	
	public void printList() {
		for (Integer i : list) {
			System.out.println(i);
		}
	}
	
	public void shuffleChoice() {
		Collections.shuffle(list);
		for (Integer i : list) {
			System.out.println(i);
		}
	}

	
}
