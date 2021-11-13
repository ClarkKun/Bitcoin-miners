package com.btc;

import java.awt.*;

/**
 * 背景类
 */
public class BackGround {

    private Image background = Toolkit.getDefaultToolkit().getImage("images/bg.jpg");
    private Image sky = Toolkit.getDefaultToolkit().getImage("images/sky.jpg");
    private Image miner = Toolkit.getDefaultToolkit().getImage("images/miner.png");

    void paintSelf(Graphics g) {
        g.drawImage(sky, 0, 0, null);
        g.drawImage(background, 0, 200, null);
        miner.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        g.drawImage(miner, 334, 105, 100, 100, null);
    }
}
