entity dude;

int red = 255;
int green = 255;
int blue = 255;

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
  if (keyPressed) {
    if (key == 's' || key == 'S')
    {
      red--;
    }
    else if (key == 'w' || key == 'W')
    {
      red++;
    }
    else if (key == 'e' || key == 'E')
    {
      green++;
    }
    else if (key == 'd' || key == 'D')
    {
      green--;
    }
    else if (key == 'r' || key == 'R')
    {
      blue++;
    }
    else if (key == 'f' || key == 'F')
    {
      blue--;
    }
    else
    {
      background(#FFFFFF);
      dude.Render(red, green, blue);
    }
  }

}
