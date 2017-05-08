import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by home on 5/5/17.
 */
public class Main {

    public static void main(String[] args){
        System.out.println("works");

        GameFrame frame = new GameFrame();
        frame.setVisible(true);
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Age of War");

        GamePanel panel = new GamePanel();
        frame.add(panel);
        panel.add(label);


        //Start game button (add difficulties? by changing a timer)
        JButton start = new JButton();
        panel.add(start);
        start.setText("Start Game");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Start Game!");
            }
        });

    }



}
