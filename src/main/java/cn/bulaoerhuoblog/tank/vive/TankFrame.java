package cn.bulaoerhuoblog.tank.vive;

import cn.bulaoerhuoblog.tank.controller.GameObjectManger;
import cn.bulaoerhuoblog.tank.controller.keyresp.PlayerKeyResp;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author makun
 */
public class TankFrame extends Frame {

    GameObjectManger gm = GameObjectManger.getInstance();

    public TankFrame() throws HeadlessException {
        this.setSize(GameObjectManger.GAME_WIDTH, GameObjectManger.GAME_HEIGHT);
        this.setResizable(false);
        this.setTitle("tank war");
        this.setVisible(true);

        this.addKeyListener(new PlayerKeyResp());
        // 窗口事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 解决闪烁问题
     */
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GameObjectManger.GAME_WIDTH, GameObjectManger.GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GameObjectManger.GAME_WIDTH, GameObjectManger.GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * 绘制图形
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        gm.paint(g);
    }

}
