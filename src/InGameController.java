import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Timer;

public class InGameController extends FrameController {

    private int number;
    private JLabel ques;
    private List<JButton> ans;
    private List<AnswerActionListener> action;

    public InGameController(int number){
        this.number = number;
        Timer timer = new Timer();
        JLabel time = new JLabel();
        time.setText("time: 60");
        time.setBounds(10,0,80,50);
        time.setVisible(true);

        ques = new JLabel("", SwingConstants.CENTER);
        ques.setBounds(50,60,380,70);
        ques.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        ques.setVisible(true);
        ques.setFont(font);

        ans = new ArrayList<>();
        action = new ArrayList<>();
        int y = 210;

        JLabel scoreTxt = new JLabel();
        scoreTxt.setText("score: ");
        scoreTxt.setBounds(80,0,50,50);
        scoreTxt.setVisible(true);

        JLabel score = new JLabel();
        score.setText(""+0);
        score.setBounds(120,0,50,50);
        score.setVisible(true);

        for(int i = 1; i<=4; i++){
            JButton a = new JButton();
            AnswerActionListener b = new AnswerActionListener(score, this);
            action.add(b);
            a.setFont(font);
            if(i % 2 == 0){
                a.setBounds(250, y, 180, 100);
                y += 150;
            }else{
                a.setBounds(50, y, 180, 100);
            }
            a.setVisible(true);
            a.addActionListener(b);
            add(a);
            ans.add(a);
        }
        add(ques);
        add(time);
        add(scoreTxt);
        add(score);
        createQuestion();
        timer.schedule(new TimerTask() {
            private int t = 60;
            @Override
            public void run() {
                time.setText("time: " + t);
                t--;
                if(t == 0){
                    timer.cancel();
                    gameFinish(Integer.parseInt(score.getText()));
                }
            }
        },0, 1000);
    }

    public void gameFinish(int score){
        try {
            Scanner sc = new Scanner(new File("src/Assets/score.txt"));
            String[] highScore = sc.nextLine().split("/");
            sc.close();
            if(Integer.parseInt(highScore[number-1]) < score){
                FileWriter fw = new FileWriter("src/Assets/score.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                String s = "";
                for(int j=0; j<12; j++){
                    if(j+1 == number){
                        int x = s.length();
                        s = s.substring(0, x) + score + "/";
                    }else{
                        int x = s.length();
                        s = s.substring(0, x) + highScore[j] + "/";
                    }
                }
                bw.write(s);
                bw.close();
                fw.close();
            }
            setVisible(false);
            removeAll();
            FrameController f = new MainMenuController();
            f.visible(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createQuestion(){
        Question q = new Question(number);
        Choice c = new Choice(q);
        q.generateQuestion();
        ques.setText(q.toString());
        c.generateChoices();
        c.shuffleChoice();
        List<Integer> list = c.getList();
        for(int i=0; i<4; i++){
            ans.get(i).setText(""+list.get(i));
            action.get(i).setCorr(q.getMultiplication()*q.getRandNum());
            action.get(i).setAns(list.get(i));
        }
    }
}
