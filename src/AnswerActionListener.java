import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerActionListener implements ActionListener {

    private JLabel score;
    private int ans;
    private int corr;
    private InGameController frame;

    public AnswerActionListener(JLabel score, InGameController frame){
        this.score = score;
        this.frame = frame;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public void setCorr(int corr) {
        this.corr = corr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ans == corr){
            int tmp = Integer.parseInt(score.getText())+10;
            score.setText(""+tmp);
        }
        frame.createQuestion();
    }
}
