package project.gameState;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import project.Map;
import project.game;

import java.io.IOException;

public class WinnerState implements GameStateBase {
    private BufferedImage mn[] = new BufferedImage[10];
    private BufferedImage bg[] = new BufferedImage[2];

    // private boolean startButton = false, exitButton = false;
    GamePanel gamepanel;

    public WinnerState(GamePanel gamepanel) {
        this.gamepanel = gamepanel;
        init();

    }

    public WinnerState() {

    }

    public void init() {
        try {
            mn[0] = ImageIO.read(getClass().getResourceAsStream("/assets/start1.png"));
            mn[5] = ImageIO.read(getClass().getResourceAsStream("../../assets/name1.png"));
            mn[6] = ImageIO.read(getClass().getResourceAsStream("../../assets/endState/Star1.png"));
            mn[7] = ImageIO.read(getClass().getResourceAsStream("../../assets/endState/Star2.png"));
            mn[8] = ImageIO.read(getClass().getResourceAsStream("../../assets/endState/Star3.png"));

            bg[0] = ImageIO.read(getClass().getResourceAsStream("../../assets/background.png"));
            bg[1] = ImageIO.read(getClass().getResourceAsStream("../../assets/Background OOP1.png"));
        } catch (IOException e) {
            System.err.println("Error loading map from file: " + e.getMessage());
        }
    }

    public void draw(Graphics g) {
        
        g.drawImage(bg[0], 0, 0, null);
        g.drawImage(bg[1], 0, 0, null);
        
        g.drawImage(mn[5], (game.getScreenWidth() - mn[5].getWidth()) / 2, 50, null);

        if (Map.score == 1 || Map.score == 0) {
            g.drawImage(mn[8], (game.getScreenWidth() - mn[6].getWidth()) / 2, 200, null);
        } else if (Map.score == 2 || Map.score == 3) {
            g.drawImage(mn[7], (game.getScreenWidth() - mn[6].getWidth()) / 2, 200, null);
        } else if (Map.score == 4) {
            g.drawImage(mn[6], (game.getScreenWidth() - mn[6].getWidth()) / 2, 200, null);
        }

    }

    public int getButtonWidth() {
        return mn[0].getWidth();
    }

    public int getButtonHeight() {
        return mn[0].getHeight();
    }

    public void mouse_move(int mx, int my) {

    }

    public void mouse_click(int mx, int my) {
        if (Map.score == 1 || Map.score == 0) {
            create_rectangle(6, mx, my);
        } else if (Map.score == 2 || Map.score == 3) {
            create_rectangle(7, mx, my);
        } else if (Map.score == 4) {
            create_rectangle(8, mx, my);
        }
    }

    public void create_rectangle(int i, int mx, int my) {
        if (new Rectangle((game.getScreenWidth() - mn[i].getWidth()) / 2, 450, getButtonWidth(), getButtonHeight())
                .contains(mx, my)) {
            gamepanel.getGameStateManager().setState(0);

        } else if (new Rectangle((game.getScreenWidth() - mn[i].getWidth()) / 2 + +mn[i].getWidth() / 3, 480,
                getButtonWidth(), getButtonHeight()).contains(mx, my)) {
            gamepanel.getGameStateManager().setState(1);

        } else if (new Rectangle((game.getScreenWidth() - mn[i].getWidth()) / 2 + mn[i].getWidth() * 2 / 3, 450,
                getButtonWidth(), getButtonHeight()).contains(mx, my)) {
            gamepanel.getGameStateManager().setState(0);

        }
    }

    public void update() {

    }

}
