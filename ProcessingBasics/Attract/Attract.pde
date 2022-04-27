ArrayList<Orb>orbList;
void setup() {
  size(1000, 700);
  orbList = new ArrayList<Orb>();
}
void mouseClicked() {
  float radiusRNG = random(20.0, 70.0);
  float xSpeedRNG = random(-3.0, 3.0);
  float ySpeedRNG = random(-3.0, 3.0);
  Orb newOrb = new Orb(mouseX, mouseY, xSpeedRNG, ySpeedRNG, radiusRNG);
  orbList.add(newOrb);
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the size should be between [20.0,70.0)
  //the dx and dy should be [-3.0,3.0)
}
void draw() {
  strokeWeight(0);
  background(255);
  Orb firstOrb = new Orb(100, 100, 0, 0, 10);
  firstOrb.display();
  for (Orb o : orbList) {
    o.attract(firstOrb);
    o.move();
    o.display();
  }
  fill(0);
  text(frameRate,20,20);
  text(orbList.size(),20,40);
}
