package com.lmgy.color.utils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author lmgy
 * @date 2019/12/29
 */
public class ImageUtil {

    public static void gen(String color, int width, int height, HttpServletResponse resp) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics paint = bufferedImage.getGraphics();
        paint.setColor(toColorFromString(color));
        paint.fillRect(0,0,width,height);
        ImageIO.write(bufferedImage, "JPG", resp.getOutputStream());
    }

    /**
     * 字符串转换成Color对象
     * @param colorStr 16进制颜色字符串
     * @return Color对象
     * */
    public static Color toColorFromString(String colorStr){
        colorStr = colorStr.substring(4);
        return new Color(Integer.parseInt(colorStr, 16));
    }
}
