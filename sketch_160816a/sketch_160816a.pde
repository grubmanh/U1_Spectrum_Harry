entity dude;

int red = 255;
int green = 255;
int blue = 255;
String rgb = "";

void setup()
{
  fullScreen();
  dude = new entity();
  background(#FFFFFF);
  dude.Render(255, 255, 255);
}

void draw()
{
  background(#FFFFFF);
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
