import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import java.net.URL;
import java.util.Random;

/**
 * Created by home on 5/5/17.
 */
public class GamePanel extends JPanel implements MouseListener{
    Image bkgd;
    Graphics g;
    List<Melee> meleeList = new ArrayList<>();
    List<Archer> archerList = new ArrayList<>();
    Archer b;
    Timer t;
    JButton unit, melee, archer, back;
    boolean mainScreen = true;

    public GamePanel(int w, int h) {
        this.setPreferredSize(new Dimension(w, h));
        this.setBackground(Color.GREEN);

        initialize();
        getBkgd();
//        getInfo(a);
//        getInfo(b);

        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        // once you select difficulty
        t.start();
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
        initButtons();

        //making a new melee dude
//        Melee ma = new Melee("Clubman", 25);
//        ma.setPrice(20);
//        ma.setWeapon("Club", 5);
//
//        Archer aa = new Archer("Slingshot", 35);
//        aa.setPrice(20);
//        aa.setWeapon("Bow", 15);
//        archerList.add(aa);
    }

    public void initButtons(){
        setLayout(null);

        back = new JButton("back");
        back.setBounds(500, 100,70,20);
        add(back);
        back.setVisible(true);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainScreen = !mainScreen;
            }
        });

        // in unit menu
        melee = new JButton("Melee");
        melee.setBounds(500, 50,70, 20);
        add(melee);
        melee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //opens the unit menu
                //open panel to buy units
                //System.out.println("open units panel");

                // Make a new unit!
                //hashmap, with type and evoltion get info
                // get the name from the radio that is selected,
//                String t = "";
//                int hp = -1;// base this on the t from above and
//                int price = -1;// but based on the choices above
                Melee ma = new Melee("Clubman", 25);
                ma.setPrice(20);
                ma.setWeapon("Club", 5);
                meleeList.add(ma);

                /*
                If clicks archer icon
                String t = "";
                int hp = -1;
                int price = -1;
                Archer aa = new Archer (t,hp);
                aa.setPrice(price);
                aa.setWeapon("Bow", 15);
                archerList.add(aa);
                 */
            }
        });

        archer = new JButton("Archer");
        archer.setBounds(600, 50,70, 20);
        add(archer);
        archer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String t = "";
//                int hp = -1;
//                int price = -1;
                Archer aa = new Archer ("Slighshot", 35);
                aa.setPrice(40);
                aa.setWeapon("Bow", 15);
                archerList.add(aa);
            }
        });

        unit = new JButton("UnitMenu");
        unit.setBounds(500,50, 70, 20);
        add(unit);
        unit.setVisible(true);
        unit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainScreen = false;
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

        g.drawImage(bkgd, 0, 0, 1500, 800, null);

        //drawing menus
        g.fillRect(0, 0, 200, 100); // xp and gold
        g.fillRect(w - 300, 0, 300, 100); // main menu area
        g.fillRect(w - 200, 100, 200, 30); // evolution special

        // a boolean switch for if we are in the unit menu or main menu, boolean switches with back button

        if(mainScreen) {
            melee.setVisible(false);
            archer.setVisible(false);
            unit.setLocation(w - 300, 30);
            unit.setVisible(true);
        }
        else{
            unit.setVisible(false);
            melee.setLocation(w-300, 30);
            archer.setLocation(w-200, 30);
            melee.setVisible(true);
            archer.setVisible(true);
        }


        for(Melee m: this.meleeList){
            m.draw(g);
        }

        for(Archer a: this.archerList){
            a.draw(g);
        }
    }

    public void mouseClicked(MouseEvent arg0) {
//        System.out.println(arg0.getX() + " " + arg0.getY());
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



