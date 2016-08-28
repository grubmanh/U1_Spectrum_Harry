/*
  Spectrum by Harry Grubman
  A keyboard-controlled color selector which allows users to select and save colors.
*/
class entity
{
  void Render(int r, int g, int b)
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
  void Saved(int r, int g, int b, int n)
  {
    fill(r, g, b);
    String rgb = "(" + r + ", " + g + ", " + b + ")";
    ellipse((n*(width/3)-(width/6)), 5*(height/7), (width)/6, (width)/6);
    fill(#000000);
    textSize(width/50);
    text(rgb, (n*(width/3)-(width/6)), 5*(height/7));
  }
}
