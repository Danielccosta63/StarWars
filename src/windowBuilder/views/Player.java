package windowBuilder.views;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player extends Sprite implements Config {

    private final int START_Y = 280;
    private final int START_X = 270;

    private final String playerImg = "src/windowBuilder/resources/player.png";
    private int width;

    public Player() {

        initPlayer();
    }

    private void initPlayer() {
        
        ImageIcon ii = new ImageIcon(playerImg);

        width = ii.getImage().getWidth(null);

        setImage(ii.getImage());
        setX(START_X);
        setY(START_Y);
    }

    //x and y are instance vars inherited from Sprite.
    public void act() {
        
        x += dx;
        
        if (x <= 2) {
            x = 2;
        }
        
        if (x >= BOARD_WIDTH - 2 * width) {
            x = BOARD_WIDTH - 2 * width;
        }
    }

    //When I get a left or right arrow keys pressed
    public void keyPressed(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {        
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {        
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {        
            dx = 0;
        }
    }
}