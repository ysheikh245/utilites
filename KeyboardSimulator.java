package com.yusuf.learning.java8;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class KeyboardSimulator {

    static long lastExecutionTime = 0;

    public static void main(String[] args) throws Exception {
        boolean firstTime = true;
        long startTime = System.currentTimeMillis();

        while(firstTime || isXMinIntervalComplete(startTime)) {
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                //System.out.println("Key Pressed ");
            } catch(Exception e) {
                e.printStackTrace();
            }
            firstTime = false;
        }
    }

    private static boolean isXMinIntervalComplete(long startTime) throws Exception {
        long currentTime = System.currentTimeMillis();
        long timeInSeconds = 0;
        int waitTime = 1000 * 60;

        if(lastExecutionTime > 0) {
            timeInSeconds = TimeUnit.MILLISECONDS.toSeconds(currentTime - lastExecutionTime);
        } else {
            timeInSeconds = TimeUnit.MILLISECONDS.toSeconds(currentTime - startTime);
        }

        if(timeInSeconds < waitTime) {
            Thread.sleep(waitTime);
        }

        lastExecutionTime = currentTime;
        //System.out.println(new Date(lastExecutionTime));
        //return (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - lastExecutionTime)) >= 1;
        return true;
    }


}
