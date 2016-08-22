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

int red = 255;
int green = 255;
int blue = 255;
String rgb = "";

public void setup()
{
  
  dude = new entity();
  background(0xffFFFFFF);
  dude.Render(255, 255, 255);
}

public void draw()
{
  background(0xffFFFFFF);
  dude.Render(red, green, blue);
  rgb = "(" + red + ", " + green + ", " + blue + ")";
  if (keyPressed) {
    if ( red > 0 && ( key == 's' || key == 'S' ))
    {
      red--;
    }
    else if ( red < 255 && (key == 'w' || key == 'W'))
    {
      red++;
    }
    else if ( green < 255 && (key == 'e' || key == 'E'))
    {
      green++;
    }
    else if ( green > 0 && ( key == 'd' || key == 'D' ))
    {
      green--;
    }
    else if ( blue < 255 && ( key == 'r' || key == 'R' ))
    {
      blue++;
    }
    else if ( blue > 0 && ( key == 'f' || key == 'F' ))
    {
      blue--;
    }
    else
    {

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
    fill(0, 0, 0);
    textSize(50);
    textAlign(CENTER);
    text(rgb, width/2, height/2);

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
