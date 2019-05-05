import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionActionListener implements ActionListener {
    private int number;
    private JFrame frame;

    public QuestionActionListener(int number, JFrame frame){
        this.number = number;
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        frame.removeAll();
        FrameController f = new InGameController(number);
        f.setVisible(true);

    }
}
