package dsa2_lab4;

/**
 * @author mkz
 * TASK: EX1. Complete the code in Snowflake.java so that
 *      a single snowflake is drawn at the center of the window.
 *      Make sure that the snowflake fits inside of the window.
 */

import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import java.lang.Math;

public class Snowflake extends Applet {

    /**
     * Draw a snowflake like star at coordinate x, y on Canvas canvas
     * The beams of the star are beamLen pixels long
     */
    private void drawStar(Graphics canvas, int x, int y, int beamLen) {
        // the ending x- and y-coordinates of every beam
        int endX;
        int endY;

        if (beamLen <= 0) {
            return;
        }

        for (int i = 0; i < 6; i++) { // note: six lines per start
            // note: `((2 * Math.PI) / 6) * i`角度计算，60%
            //  `math.cos & math.sin` 用于坐标计算
            endX = x + (int) (beamLen * Math.cos(((2 * Math.PI) / 6) * i)); // note:
            endY = y - (int) (beamLen * Math.sin(((2 * Math.PI) / 6) * i));

            canvas.drawLine(x, y, endX, endY);

            // recursively draw the star
            // note: 每次递归时，线的长度 beamLen 会减少为原来的三分之一，直至<=0
            drawStar(canvas, endX, endY, beamLen / 3); // as least >= 3
            // note: 如果在循环结束后进行，在 for 循环结束后，只有最后一条线的终点 endX 和 endY 会被用作新调用的起点。
            //  这意味着只会在最后一条线的末端绘制细节，而不是在每条线的末端，
            //  你将只会看到一条线的细节，其他五条线不会有递归的细节添加，
            //  因此最终图形看起来可能像一条长线，而不是一个完整的雪花形状。
        }
    }

    /**
     * Paint method of the applet. Gets called whenever the applet needs a redraw
     *
     * @param gr - The canvas to draw the applets content on
     */
    public void paint(Graphics gr) {
        int width = getSize().width;
        int height = getSize().height;
        int min = Math.min(width, height); // 找到weight和height中更小的那个值

        // Set background and pen color
        setBackground(Color.white);
        gr.setColor(Color.blue);

        // todo： Calculate the maximal length in the window
        // note: 确保雪花的最大长度不会太大，能够合理地放置在窗口中心。
        //  每条雪花臂（或星形的一条线）的长度 maxLen 是整个窗口较短边长度的三分之一。
        //  这样可以保证雪花有足够的空间绘制递归细节，同时不会溢出窗口边界。
        int maxLen = min / 3; // at least >= 3

        // todo Draw a star
        // NOTE: `/2`确保从中点绘制
        drawStar(gr, width / 2, height / 2, maxLen);
    }

    // light testing
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snowflake");
        Snowflake snowflake = new Snowflake();
        frame.add(snowflake);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}
