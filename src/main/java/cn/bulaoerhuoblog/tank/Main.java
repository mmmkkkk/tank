package cn.bulaoerhuoblog.tank;

import cn.bulaoerhuoblog.tank.vive.TankFrame;

/**
 * @author makun
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();



        while (true) {
            Thread.sleep(100);
            tf.repaint();
        }
    }
}
