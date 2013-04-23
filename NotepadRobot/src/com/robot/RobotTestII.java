package com.robot;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RobotTestII
{
  public RobotTestII()
  {
    int keyInput[] =
                     {
		    		KeyEvent.VK_1,
		            KeyEvent.VK_2,
		            KeyEvent.VK_3,
		            KeyEvent.VK_4,
		            KeyEvent.VK_5,
		            KeyEvent.VK_1,
		            KeyEvent.VK_2,
		            KeyEvent.VK_3,
		            KeyEvent.VK_4,
		            KeyEvent.VK_5,
		            KeyEvent.VK_1,
		            KeyEvent.VK_2,
		            KeyEvent.VK_3,
		            KeyEvent.VK_4,
		            KeyEvent.VK_5,
		            KeyEvent.VK_1,
		            KeyEvent.VK_2,
		            KeyEvent.VK_3,
		            KeyEvent.VK_4,
		            KeyEvent.VK_5,
		            KeyEvent.VK_1,
		            KeyEvent.VK_2,
		            KeyEvent.VK_3,
		            KeyEvent.VK_4,
		            KeyEvent.VK_5,
                     KeyEvent.VK_F10,
                     KeyEvent.VK_DOWN,
                     KeyEvent.VK_DOWN,
                     KeyEvent.VK_DOWN,
                     KeyEvent.VK_ENTER,
                     KeyEvent.VK_H,
                     KeyEvent.VK_H,
                     KeyEvent.VK_Y,
                     KeyEvent.VK_U,
                     KeyEvent.VK_N,
                     KeyEvent.VK_S,
                     KeyEvent.VK_U,
                     KeyEvent.VK_Z,
                     KeyEvent.VK_Z,
                     KeyEvent.VK_A,
                     KeyEvent.VK_N,
                     KeyEvent.VK_G,
                     KeyEvent.VK_ENTER
    };

    try
    {
      // notepad 프로그램 활성화
      Runtime.getRuntime().exec("notepad");
      Robot robot = new Robot();
      // Hello글자 입력
      for(int i=0; i<keyInput.length; i++)
      {
        robot.keyPress(keyInput[i]);
        robot.keyRelease(keyInput[i]);
        //현재 해당 쓰레드를 200ms 동안 sleep시킨다.
        robot.delay(200);
      }



    }
    catch (AWTException ae)
    {
      ae.printStackTrace();
    }
    catch (java.io.IOException ex)
    {
      ex.printStackTrace();
    }

  }

  public static void main(String[] args)
  {
    new RobotTestII();
    System.exit(0);
  }

}