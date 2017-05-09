import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by home on 5/5/17.
 */
public class Main {

    int w = 800;
    int h = 800;

    public static void main(String[] args){
        new Main().start();
    }

    private void start(){
        JFrame frame = new JFrame("Age of War");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GamePanel(w,h), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }



//    //Start game button (add difficulties? by changing a timer)
//    JButton start = new JButton();
//        panel.add(start);
//        start.setText("Start Game");
//        start.addActionListener(new ActionListener() {
//        @Override
////            public void actionPerformed(ActionEvent e) {
////                JOptionPane.showMessageDialog(null, "Start Game!");
////            }
//        public void actionPerformed(ActionEvent e) {
//            System.out.println("start");
//        }
//    });
}
