entity dude;

void setup()
{
  fullScreen();
  dude = new entity();
  a = 255;
  b = 255;
  c = 255;
}

void draw()
{
  if (keyPressed) {
    if (key == 'b' || key == 'B')
    {
      background(#FFFFFF);
      dude.Render(a, b, c);
    }

    else
    {
      background(#FFFFFF);
      dude.Render(0, 0, 0);
    }
  }

}
