package com.btc;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BTC extends Object {

    BTC() {
        this.x = (int) (Math.random() * 700);
        this.y = (int) (Math.random() * 550 + 300);
        this.width = 80;
        this.height = 80;
        this.weight = 20;
        this.image = Toolkit.getDefaultToolkit().getImage("images/btc1.png");
    }
}

class BTCMini extends BTC {

    BTCMini() {
        this.x = (int) (Math.random() * 700);
        this.y = (int) (Math.random() * 550 + 300);
        this.width = 50;
        this.height = 50;
        this.weight = 5;
        this.image = Toolkit.getDefaultToolkit().getImage("images/btc0.png");
    }
}

class BTCPlus extends BTC {

    BTCPlus() {
        this.x = (int) (Math.random() * 700);
        this.y = (int) (Math.random() * 550 + 300);
        this.width = 150;
        this.height = 150;
        this.weight = 50;
        this.image = Toolkit.getDefaultToolkit().getImage("images/btc2.png");
    }
}

