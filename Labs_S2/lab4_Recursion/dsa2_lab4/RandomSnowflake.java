package dsa2_lab4;

/**
 * @author mkz
 * TASK: EX2 - Create a program RandomSnowflake.java that
 *      draws a random number of snowflakes, with random sizes, at random positions, with random colors.
 *      Your program should display up to 20 snowflakes,
 *      which should be clearly visible and should fit inside of the window
 *      (at least the center of the snowflake must be inside of the applets display area).
 *      It is alright if the snowflakes overlap, so long as the center of every snowflake is within the display area
 */

import java.applet.Applet;
import java.awt.*;
import javax.swing.*;
import java.lang.Math;
import java.util.Random;

public class RandomSnowflake extends Applet {

    public void drawStar(Graphics canvas, int x, int y, int beamLen) {
        int endX, endY;

        if (beamLen <= 0){
            return;
        }

        for (int i = 0; i < 6; i++){
            endX = x + (int) (beamLen * Math.cos(((2 * Math.PI) / 6) * i)); // note:
            endY = y - (int) (beamLen * Math.sin(((2 * Math.PI) / 6) * i));

            canvas.drawLine(x, y, endX, endY);
            drawStar(canvas, endX, endY, beamLen / 3);
        }
    }

    public void paint(Graphics gr) {
        int width = getSize().width;
        int height = getSize().height;
        int min = Math.min(width, height);

        // set bg color
        setBackground(Color.white);

        // calculate the max length of snowflakes
        int maxLen = min / 3;

        // get random number between 1-10
        Random randomiser = new Random();
        int randomNumSnow = randomiser.nextInt(10) + 1;

        // draw a star
        for (int i = 0; i < randomNumSnow; i++) {
            // random position
            int x = randomiser.nextInt(width); // 传递的参数是范围。生成一个介于 0 到 width-1 之间的随机整数，并将其赋值给变量 x
            int y = randomiser.nextInt(height);
            // random size
            int beamLen = randomiser.nextInt(maxLen);
            // random pen colour
            int r = randomiser.nextInt(255);
            int g = randomiser.nextInt(255);
            int b = randomiser.nextInt(255);
            Color c = new Color(r, g, b);
            gr.setColor(c);
            // draw
            drawStar(gr, x, y, beamLen);
        }
    }

    // for light testing
    public static void main(String[] args) {
        JFrame frame = new JFrame("RandomSnowflake");
        RandomSnowflake snowflake = new RandomSnowflake();
        frame.add(snowflake);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
