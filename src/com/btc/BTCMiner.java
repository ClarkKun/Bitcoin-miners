package com.btc;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class BTCMiner extends JFrame {

    // 缓存
    Image offScreenImage;
    BackGround backGround = new BackGround();
    Line line = new Line(this);
    List<Object> objectList = new ArrayList<>();
    int WIDTH = 768;
    int HEIGHT = 1024;

    int direction = 1;

    {
        objectList.add(new BTC());
        objectList.add(new BTCMini());
        objectList.add(new BTCPlus());
    }


    void launch() {
        setVisible(true);
        this.setSize(WIDTH, HEIGHT);
        // 窗口相对于屏幕的位置 null代表屏幕中央
        this.setLocationRelativeTo(null);
        this.setTitle("比特币矿工");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == 1) {
                    line.state = 1;
                }

            }
        });

        while (true) {
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        direction = (direction + 1) % 4;
        offScreenImage = this.createImage(WIDTH, HEIGHT);
        Graphics gImage = offScreenImage.getGraphics();
        backGround.paintSelf(gImage);
        for (Object object : objectList) {
            object.paintSelf(gImage);
        }

        try {
            line.paintSelf(gImage);
        } catch (Exception e) {

        }

        g.drawImage(offScreenImage, 0, 0, null);
    }

    public static void main(String[] args) {
        BTCMiner btcMiner = new BTCMiner();
        btcMiner.launch();
    }
}
