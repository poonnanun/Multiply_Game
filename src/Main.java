import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(480,640);
        JPanel p = new JPanel();
        p.setBounds(20,10,440,100);
        JLabel l = new JLabel("1 multiplication");
        JLabel l1 = new JLabel("highscore: 100");
        JButton a = new JButton("go");
        a.setSize(50,50);
        a.setBounds(10,10,50,50);
        p.add(l);
        p.add(l1);
        p.add(a);
        p.setBorder(BorderFactory.createLineBorder(Color.black,2,true));

        window.add(p);
        window.setLayout(null);
        a.setVisible(true);
        window.setVisible(true);
    }
}



