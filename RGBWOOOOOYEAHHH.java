/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Constants.RGBConstants;

public class RGBWOOOOOOYEAHHH extends SubsystemBase {
  // TODO: make more arguments to tailor how the rainbow looks and moves
  private AdressableLED m_led = new AddressableLED();// robot map led port here)
    
  private int m_rainbowFirstPixelHue = 0;
  private int m_rainbowLastPixelHue = 180;

  public RGBWOOOOOOYEAHHH() {

  }

    /**
    * rainbow that moves down the LED strand at a constant rate
    * sets the LED buffer to this info but does not change the LEDs
    * do setData after this to update a strand of LEDs
    */
  private class LEGDSeg {
    // constructer takes start and end index

    //find direction using that

    // make array of colors

    // make methods for doing stuff
  }
  private bufferCombine (int bufferLength1, int bufferLength2, int Bufferlength3) {
    m_ledbuffer1 = new AdressableLEDBuffer(bufferLength1);
    m_ledbuffer2 = new AdressableLEDBuffer(bufferLength2);
    m_ledbuffer3 = new AdressableLEDBuffer(bufferLength3);

    int dir1 = 0 - m_ledbuffer1.getLength;
    int dir2 = m_ledbuffer1.getLength - m_ledbuffer2.getLength;
    int dir3 = m_ledbuffer2.getLength - m_ledbuffer3.getLength;

    return dirs;
  } 

  private void movingRainbow(int rate) {
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {  // for every LED in the strand

      final var hue = (m_rainbowFirstPixelHue + (i * 180 / m_ledBuffer.getLength())) % 180; // set it's hue to one higher than the previous (make sure it's in bounds)

      m_ledBuffer.setHSV(i, hue, 255, 128); // set that LED's hue 
    }

    m_rainbowFirstPixelHue += rate; // change the first LED's hue for the next go around

    m_rainbowFirstPixelHue %= 180; // make sure the new hue is in bounds
  }
    
    /**
    * rainbow that changes the whole strand, whole strand is the same color
    * sets the LED buffer to this info but does not change the LEDs
    * do setData after this to update a strand of LEDs
    */
  private void rainbow(int rate) {
    
    final var hue = m_rainbowFirstPixelHue; // just use the first LED's hue 
    
    for (var i = 0; i < m_ledBuffer.getLength(); i++) { // for every LED in the strand

      m_ledBuffer.setHSV(i, hue, 255, 128); // set that LED's hue
    }

    m_rainbowFirstPixelHue += rate; // change the first LED's hue for the next go around

    m_rainbowFirstPixelHue %= 180; // make sure the new hue is in bounds
  }
    
    /**
    * rainbow that moves the rainbow colors along with the robot's speed
    * input the speed from the encoders
    * sets the LED buffer to this info but does not change the LEDs
    * do setData after this to update a strand of LEDs
    */
  private void rainbowMoveWithRobot(int speed) { 
    // the goal here is to make it so it almost apperes like the colors are not moving in space, staying in the same spot as the robot moves forwards or backwards
    // TODO: add a correction value to turn speed into a number for sliding the rainbow

    // this will have to use the same solution as peel but with speed times a constant for the rate
  }
    
    /**
    * rainbow that moves the rainbow colors along the sides of the robot
    * sets the LED buffer to this info but does not change the LEDs
    * do setData after this to update a strand of LEDs
    */
  private void rainbowPeel(int rate) { 
      // the idea here is to make a rainbow that moved down the sides of the robot in the same direction.
      // must find a scheme to split a single addressable LED strip into two segments so this effect can work properly
  }
    
    /**
    * rainbow that moves the rainbow colors along with the robot's speed
    * input the speed from the encoders
    * sets the LED buffer to this info but does not change the LEDs
    * do setData after this to update a strand of LEDs
    */
  private void solidColorToLEDs(int red, int green, int blue) { // pass through a color object or three ints? (3 ints for now)
    for (var i = 0; i < m_ledBuffer.getLength(); i++) {  // for every LED in the stand
      m_ledBuffer.setRGB(red,green,blue); // set the RGB value
    }
  }

  /* private void ledSegment(int break1, int break2, boolean dir1, boolean dir2, boolean dir3) { //Dirs are true if positive
    
    for (var i = 0; i < break1; i++) {
      if (dir1 = true) {
        final var hue = (m_rainbowFirstPixelHue + (i * 180 / break1)) % 180; // set it's hue to one higher than the previous (make sure it's in bounds)
      } else if (dir1 = false) {
        final var hue = (m_rainbowLastPixelHue + (i * 180 / break1)) % 180; // set it's hue to one higher in reverse
      }

        m_ledBuffer.setHSV(i, hue, 255, 128); // set that LED's hue 

    }
  }
*/

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // TODO: make a switch case and a public method for switching what color mode to use.
    solidColorToLEDs(50,50,255);
      
    m_led.setData(m_ledBuffer); // remember the methods above only make an LED buffer, here we send that to the physical light strand
  }
}

