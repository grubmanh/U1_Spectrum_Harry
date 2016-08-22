class entity
{
  entity()
  {

  }

  void Render(int r, int g, int b)
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
