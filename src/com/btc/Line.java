package com.btc;

import java.awt.*;

/**
 * 抓取用的线
 */
public class Line {
    // 起点坐标
    int x = 380;
    int y = 180;

    // 终点坐标
    int endX = 500;
    int endY = 500;

    // 线长
    double length = 100;
    int MAX_LEN = 800;
    int MIN_LEN = 100;

    // 角度变量
    double n = 0;
    int dir = 1;

    // 0=摇摆，1=释放，2=收回，3=碰撞返回
    int state = 0;


    BTCMiner btc;

    Line(BTCMiner btc) {
        this.btc = btc;
    }


    void paintSelf(Graphics g) throws InterruptedException {
        logic();
        switch (state) {
            case 0:
                if (n < 0.1) {
                    dir = 1;
                } else if (n > 0.9) {
                    dir = -1;
                }
                n = n + 0.05 * dir;
                drawLine(g);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
                if (length < MAX_LEN) {
                    length += 5;
                    drawLine(g);
                } else {
                    state = 2;
                }
                break;
            case 2:
                if (length > MIN_LEN) {
                    length -= 5;
                    drawLine(g);
                } else {
                    state = 0;
                }
                break;
            case 3:
                int weight = 1;
                if (length > MIN_LEN) {
                    length -= 10;
                    drawLine(g);
                    for (Object object : btc.objectList) {
                        if (!object.flag) {
                            continue;
                        }
                        object.x = endX - object.width / 2;
                        object.y = endY;
                        weight = object.weight;
                        if (length <= MIN_LEN) {
                            object.x = - 200;
                            object.y = -200;
                            state = 0;
                            object.flag = false;
                        }
                    }
                }
                Thread.sleep(weight);
                break;
        }

    }

    // 碰撞检测，检测物体是否被抓取
    void logic() {
        for (Object obj : btc.objectList) {
            if (endX > obj.x && endX < obj.x + obj.width && endY > obj.y && endY < obj.y + obj.height) {
                System.out.println(1);
                state = 3;
                obj.flag = true;
            }
        }
    }

    private void drawLine(Graphics g) {
        endX = (int) (x + length * Math.cos(n * Math.PI));
        endY = (int) (y + length * Math.sin(n * Math.PI));
        g.setColor(Color.RED);
        g.drawLine(x - 1, y, endX - 1, endY);
        g.drawLine(x, y, endX, endY);
        g.drawLine(x + 1, y, endX + 1, endY);
    }

}
