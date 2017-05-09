import javax.swing.*;
import java.awt.*;

/**
 * Created by home on 5/5/17.
 */
public class GamePanel extends JPanel {

    Graphics g;
    Melee a;

    public GamePanel(int w, int h) {
        this.setPreferredSize(new Dimension(w, h));
        this.setBackground(Color.GREEN);
        initialize();
        repaint();
    }

    public void initialize(){
        a = new Melee("Clubman", 15);
    }

    public void paintComponent(Graphics g){

        a.draw(g);
        System.out.println("sdjf");
    }

}
