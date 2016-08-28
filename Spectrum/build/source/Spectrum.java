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
entity spectrumize;
PrintWriter output;
int red = 255;
int green = 255;
int blue = 255;
String rgb = "";
String rgb1 = "";
String rgb2 = "";
String rgb3 = "";
int red1, green1, blue1, red2, green2, blue2, red3, green3, blue3;
int n = 1;

public void setup()
{
  
  spectrumize = new entity();
  output = createWriter("saved_colors.txt");
  output.println("Created with Spectrum by Harry Grubman");
  output.println("");
  output.println("This tool will only save the colors from the most recent session (max 3).");
  output.println("If you would like to save more than that, please copy the RGB values and paste them somewhere else.");
  output.println("");
  output.flush();
}

public void draw()
{
  background(0xffFFFFFF);
  spectrumize.Render(red, green, blue);
  rgb = "(" + red + ", " + green + ", " + blue + ")";
  if ( n > 1 )
  {
    spectrumize.Saved(red1, green1, blue1, 1);
  }
  if ( n > 2 )
  {
    spectrumize.Saved(red2, green2, blue2, 2);
  }
  if ( n > 3 )
  {
    spectrumize.Saved(red3, green3, blue3, 3);
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
          red1 = red;
          blue1 = blue;
          green1 = green;
          rgb1 = "(" + red1 + ", " + green1 + ", " + blue1 + ")";
          output.println(rgb1);
          output.flush();
          break;
          case 2:
          red2 = red;
          blue2 = blue;
          green2 = green;
          rgb2 = "(" + red2 + ", " + green2 + ", " + blue2 + ")";
          output.println(rgb2);
          output.flush();
          break;
          case 3:
          red3 = red;
          blue3 = blue;
          green3 = green;
          rgb3 = "(" + red3 + ", " + green3 + ", " + blue3 + ")";
          output.println(rgb3);
          output.flush();
          break;
        }
        delay(200);
        n++;
      }
      else if ((key == 'f' || key == 'F') && n == 4)
      {
        fill(0xffffffff);
        rect(width/4, height/4, width/2, height/2);
        fill(0xff000000);
        text("No Save Space", width/2, height/2);
      }
      else if (key == 'x' || key == 'X')
      {
        exit();
      }
    }
}
/*
  Spectrum by Harry Grubman
  A keyboard-controlled color selector which allows users to select and save colors.
*/
class entity
{
  public void Render(int red, int green, int blue)
  {
    fill(red, 0, 0);
    rect(0, 0, width/3, height);
    fill(0, green, 0);
    rect(width/3, 0, width/3, height);
    fill(0, 0, blue);
    rect((width*2)/3, 0, width/3, height);
    fill(red, green, blue);
    rect((width/6), 0, 4*(width/6), (height/2));
    if ( red < 122 && blue < 122 && green < 122)
    {
      fill(0xffffffff);
    }
    else
    {
      fill(0xff000000);
    }
    textSize(50);
    textAlign(CENTER);
    text(rgb, width/2, height/4);
  }
  public void Saved(int red, int green, int blue, int n)
  {
    String rgb = "(" + red + ", " + green + ", " + blue + ")";
    fill(red, green, blue);
    ellipse((n*(width/3)-(width/6)), 5*(height/7), (width)/6, (width)/6);
    if ( red < 122 && blue < 122 && green < 122)
    {
      fill(0xffffffff);
    }
    else
    {
      fill(0xff000000);
    }
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
