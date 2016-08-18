import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_160816a extends PApplet {

entity dude;

public void setup()
{
  
  dude = new entity();
}

public void draw()
{
  if (keyPressed) {
    if (key == 'b' || key == 'B')
    {
      background(0xffFFFFFF);
      dude.Render(255, 255, 255);
    }
    else
    {
      background(0xffFFFFFF);
      dude.Render(0, 0, 0);
    }
  }

}
class entity
{
  entity()
  {

  }

  public void Render(int r, int g, int b)
  {
    fill(r, 0, 0);
    rect(0, 0, width/3, height);
    fill(0, g, 0);
    rect(width/3, 0, width/3, height);
    fill(0, 0, b);
    rect((width*2)/3, 0, width/3, height);
    fill(r, g, b);
    rect((width/6), (height/4), 4*(width/6), 2*(height/4));
  }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_160816a" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
