/*
  Spectrum by Harry Grubman
  A keyboard-controlled color selector which allows users to select and save colors.
*/
entity spectrumize;
int red = 255;
int green = 255;
int blue = 255;
String rgb = "";
String rgb1 = "";
String rgb2 = "";
String rgb3 = "";
int red1, green1, blue1, red2, green2, blue2, red3, green3, blue3;
int n = 1;

void setup()
{
  fullScreen();
  spectrumize = new entity();
}

void draw()
{
  background(#FFFFFF);
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
          break;
          case 2:
          red2 = red;
          blue2 = blue;
          green2 = green;
          rgb2 = "(" + red2 + ", " + green2 + ", " + blue2 + ")";
          break;
          case 3:
          red3 = red;
          blue3 = blue;
          green3 = green;
          rgb3 = "(" + red3 + ", " + green3 + ", " + blue3 + ")";
          break;
        }
        delay(300);
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
