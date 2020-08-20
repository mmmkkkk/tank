package cn.bulaoerhuoblog.tank.controller.keyresp;

import cn.bulaoerhuoblog.tank.common.Group;
import cn.bulaoerhuoblog.tank.controller.GameObjectManger;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author m_a_k
 */
public class PlayerKeyResp extends KeyAdapter {

    boolean bL = false;
    boolean bU = false;
    boolean bR = false;
    boolean bD = false;

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = true;
                break;
            case KeyEvent.VK_UP:
                bU = true;
                break;
            case KeyEvent.VK_RIGHT:
                bR = true;
                break;
            case KeyEvent.VK_DOWN:
                bD = true;
                break;

            default :
                break;
        }
            setMainTankDir();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_LEFT:
                bL = false;
                break;
            case KeyEvent.VK_UP:
                bU = false;
                break;
            case KeyEvent.VK_RIGHT:
                bR = false;
                break;
            case KeyEvent.VK_DOWN:
                bD = false;
                break;
            case KeyEvent.VK_CONTROL:
                GameObjectManger.getInstance().playerFire();
                break;
            default:
                break;
        }
            setMainTankDir();
    }

    private void setMainTankDir() {
        if (!bL && !bD && !bR && !bR) {
            GameObjectManger.getInstance().playerStop();
        }


    }
}
