import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by home on 5/9/17.
 */
public class Melee extends GameObject {

    private Image image;

    public Melee(String n, int h){
        setName(n);
        setHealth(h);

        //make it so that by name you can get the respective pic
        getImage();
    }

    private void getImage() {
        URL url = Melee.class.getResource("Images/ClubMan.png");
        try {
            image = ImageIO.read(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw (Graphics g){
        g.drawImage(image, 10,10,100,100, null);
    }

}
