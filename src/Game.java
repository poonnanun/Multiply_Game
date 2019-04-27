import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame {
	
    private JPanel p = new JPanel();
    private JButton a = new JButton("go");
   
	
	public Game() {
		super("Multiply Game");
		setSize(480,640);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		p.setBounds(20, 10, 440, 100);
	    a.setSize(50,50);
	    a.setBounds(10,10,50,50);
	    p.add(new JLabel("1 multiplication"));
	    p.add(new JLabel("highscore: 100"));
	    p.add(a);
	    p.setBorder(BorderFactory.createLineBorder(Color.black,2,true));
	    
	    setResizable(false);
	    add(p);
	    setLayout(null);
	    a.setVisible(true);
	    setVisible(true);
	    
		
	}
	
	 public static void main(String[] args) {
	        Game g = new Game();
 	
	 }

}
