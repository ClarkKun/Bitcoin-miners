package com.btc;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Object {

    int x;

    int y;

    int width;

    int height;

    int weight;

    Image image;

    int degree = 0;

    // 标识是否被碰撞
    boolean flag = false;

    void paintSelf(Graphics g) {
//        image = rotateImage(convertToBufferedImage(image), degree + 1);
        g.drawImage(image, x, y, null);
    }

    public  BufferedImage convertToBufferedImage(Image image) {
        BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, x, y, null);
        g.dispose();
        return newImage;
    }

    public Image rotateImage(final BufferedImage bufferedimage,
                                            final int degree) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        return img;
    }


}
