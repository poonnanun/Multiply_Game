import javax.swing.*;
import java.awt.*;

public abstract class FrameController extends JFrame {

    protected Font font;

    public FrameController() {
        super("Multiply MainMenuController");
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.getAllFonts();
        font = new Font("Jokerman", Font.PLAIN, 19);
        setSize(480,640);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
    }

    public void visible(boolean bool){
        this.setVisible(bool);
    }
}
