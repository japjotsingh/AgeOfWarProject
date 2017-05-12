import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

/**
 * Created by home on 5/5/17.
 */
public class GamePanel extends JPanel implements MouseListener{
    Image bkgd;
    Graphics g;
    Melee a;
    Archer b;
    Timer t;
    JButton unit;

    public GamePanel(int w, int h) {
        this.setPreferredSize(new Dimension(w, h));
        this.setBackground(Color.GREEN);
        initialize();
        getBkgd();
        getInfo(a);
        getInfo(b);
        initButtons();

        t = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
    }

    public void getInfo(GameObject o) {
        String[] info = new String[5];
        info[0] = "Name: " + o.getName();
        info[1] = "Health: " + String.valueOf(o.getHealth());
        info[2] = "Unit Cost: " + String.valueOf(o.getPrice());
        info[3] = "Weapon: " + o.getWeaponName();
        info[4] = "Weapon Dmg: " + String.valueOf(o.getWeaponDamage());

        for (String s : info) {
            System.out.println(s);
        }
    }

    // every time user clicks to get a new one, if the user has enough money they can buy a new one
    public void initialize() {

        addMouseListener(this);

        //making a new melee dude
        a = new Melee("Clubman", 25);
        a.setPrice(20);
        a.setWeapon("Club", 5);

        b = new Archer("archer", 35);
        b.setPrice(50);
        b.setWeapon("Bow", 15);


    }

    public void initButtons(){
        unit = new JButton("test");
        unit.setLocation(600, 50);
        add(unit);
        unit.setVisible(true);
        unit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //open panel to buy units
                //System.out.println("open units panel");

                // Make a new unit!
            }
        });
    }

    public void getBkgd() {
        // different depending on which evolution
        URL url = Melee.class.getResource("Images/prehistoric.png");
        try {
            bkgd = ImageIO.read(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {

        int w = this.getWidth();
        int h = this.getHeight();


        g.drawImage(bkgd, 0, 0, 1500, 800, null);

        //drawing menus
        g.fillRect(0, 0, 200, 100);
        g.fillRect(w - 300, 0, 300, 100);
        g.fillRect(w - 200, 100, 200, 30);

        unit.setLocation(this.getWidth()-300, 30);

        a.draw(g);
    }

    public void mouseClicked(MouseEvent arg0) {
        System.out.println(arg0.getX() + " " + arg0.getY());
    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {

    }

    public void mousePressed(MouseEvent arg0) {

    }

    public void mouseReleased(MouseEvent arg0) {

    }

    public void mouseDragged(MouseEvent arg0) {

    }

    public void mouseMoved(MouseEvent arg0) {

    }
}



