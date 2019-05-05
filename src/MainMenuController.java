import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;

public class MainMenuController extends FrameController {

	private List<Integer> high = new ArrayList<>();
	
	public MainMenuController() {

		JLabel title = new JLabel();
		title.setIcon(new ImageIcon("src/Assets/title.png"));
		title.setBounds(120,10,240, 90);
		title.setVisible(true);
		getHighScore();


		int y = 120;
		for(int i = 1; i<=12; i++){
			JButton m = new JButton();
			m.setText(i + ")  High-score: " + high.get(i-1));
			if(i % 2 == 0){
				m.setBounds(250, y, 180, 70);
				y += 80;
			}else{
				m.setBounds(50, y, 180, 70);
			}
			m.setVisible(true);
			m.addActionListener(new QuestionActionListener(i,this));
			add(m);
		}
		add(title);
	}

	public void getHighScore(){
		try {
			Scanner sc = new Scanner(new File("src/Assets/score.txt"));
			String[] highScore = sc.nextLine().split("/");
			for(int i=0 ; i<12; i++){
				high.add(Integer.parseInt(highScore[i]));
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
