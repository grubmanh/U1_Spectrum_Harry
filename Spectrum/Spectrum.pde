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

void setup()
{
  fullScreen();
  dude = new entity();
  background(#FFFFFF);
  rgb = "(" + red + ", " + green + ", " + blue + ")";
  dude.Render(255, 255, 255);
}

void draw()
{
  background(#FFFFFF);
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
        fill(#ffffff);
        rect(width/4, height/4, width/2, height/2);
        fill(#000000);
        text("No Save Space", width/2, height/2);
      }
    }
}
