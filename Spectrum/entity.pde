/*
  Spectrum by Harry Grubman
  A keyboard-controlled color selector which allows users to select and save colors.
*/
class entity
{
  void Render(int red, int green, int blue)
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
      fill(#ffffff);
    }
    else
    {
      fill(#000000);
    }
    textSize(50);
    textAlign(CENTER);
    text(rgb, width/2, height/4);
  }
  void Saved(int red, int green, int blue, int n)
  {
    String rgb = "(" + red + ", " + green + ", " + blue + ")";
    fill(red, green, blue);
    ellipse((n*(width/3)-(width/6)), 5*(height/7), (width)/6, (width)/6);
    if ( red < 122 && blue < 122 && green < 122)
    {
      fill(#ffffff);
    }
    else
    {
      fill(#000000);
    }
    textSize(width/50);
    text(rgb, (n*(width/3)-(width/6)), 5*(height/7));
  }
}
