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

public class Spectrum extends PApplet {

/*
  Spectrum by Harry Grubman
  A keyboard-controlled color selector which allows users to select and save colors.
*/
entity dude;

int red = 255;
int green = 255;
int blue = 255;
String rgb = "";
String rgb1 = "";
String rgb2 = "";
String rgb3 = "";
int r1, g1, b1, r2, g2, b2, r3, g3, b3;
int n = 1;

public void setup()
{
  
  dude = new entity();
  background(0xffFFFFFF);
  rgb = "(" + red + ", " + green + ", " + blue + ")";
  dude.Render(255, 255, 255);
}

public void draw()
{
  background(0xffFFFFFF);
  dude.Render(red, green, blue);
  rgb = "(" + red + ", " + green + ", " + blue + ")";
  if ( n > 1 )
  {
    dude.Saved(r1, g1, b1, 1);
  }
  if ( n > 2 )
  {
    dude.Saved(r2, g2, b2, 2);
  }
  if ( n > 3 )
  {
    dude.Saved(r2, g2, b2, 3);
  }
  if (keyPressed)
    {
      if ( red > 0 && ( key == 'a' || key == 'A' ))
      {
        red--;
      }
      else if ( red < 255 && (key == 'q' || key == 'Q'))
      {
        red++;
      }
      else if ( green < 255 && (key == 'w' || key == 'W'))
      {
        green++;
      }
      else if ( green > 0 && ( key == 's' || key == 'S' ))
      {
        green--;
      }
      else if ( blue < 255 && ( key == 'e' || key == 'E' ))
      {
        blue++;
      }
      else if ( blue > 0 && ( key == 'd' || key == 'D' ))
      {
        blue--;
      }
      else if (key == 'r' || key == 'R')
      {
        green = 255;
        blue = 255;
        red = 255;
        n = 0;
      }
      else if ((key == 'f' || key == 'F') && n < 4)
      {
        switch(n)
        {
          case 1:
          r1 = red;
          b1 = blue;
          g1 = green;
          rgb1 = "(" + r1 + ", " + g1 + ", " + b1 + ")";
          break;
          case 2:
          r2 = red;
          b2 = blue;
          g2 = green;
          rgb2 = "(" + r2 + ", " + g2 + ", " + b2 + ")";
          break;
          case 3:
          r3 = red;
          b3 = blue;
          g3 = green;
          rgb3 = "(" + r3 + ", " + g3 + ", " + b3 + ")";
          break;
        }
        delay(1000);
        n++;
      }
      else if ((key == 'f' || key == 'F') && n == 4)
      {
        fill(0xffffffff);
        rect(width/4, height/4, width/2, height/2);
        fill(0xff000000);
        text("No Save Space", width/2, height/2);
      }
    }
}
/*
  Spectrum by Harry Grubman
  A keyboard-controlled color selector which allows users to select and save colors.
*/
class entity
{
  // entity()
  // {
  //
  // }

  public void Render(int r, int g, int b)
  {
    fill(r, 0, 0);
    rect(0, 0, width/3, height);
    fill(0, g, 0);
    rect(width/3, 0, width/3, height);
    fill(0, 0, b);
    rect((width*2)/3, 0, width/3, height);
    fill(r, g, b);
    rect((width/6), 0, 4*(width/6), (height/2));
    fill(0, 0, 0);
    textSize(50);
    textAlign(CENTER);
    text(rgb, width/2, height/4);

  }
  public void Saved(int r, int g, int b, int n)
  {
    fill(r, g, b);
    String rgb = "(" + r + ", " + g + ", " + b + ")";
    ellipse((n*(width/3)-(width/6)), 5*(height/7), (width)/6, (width)/6);
    fill(0xff000000);
    textSize(width/50);
    text(rgb, (n*(width/3)-(width/6)), 5*(height/7));
  }
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Spectrum" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
