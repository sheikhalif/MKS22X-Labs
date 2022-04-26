ArrayList<Orb>orbList;
Orb firstOrb = new Orb(500, 400, 0, 0, 20);
int mode;
void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  mode = 2;
}
void mouseClicked() {
  Orb newOrb = new Orb(mouseX, mouseY, 5, 0, 20);
  orbList.add(newOrb);
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the size should be between [20.0,70.0)
  //the dx and dy should be [-3.0,3.0)
}

void keyPressed(){
  if (keyCode == BACKSPACE){
    orbList.clear();
  }
  else if (keyCode == 32){
    println("Mode switch"); 
    if (mode == 1)mode = 2;
    else if (mode == 2)mode = 1;
  }
}
  
void draw() {
  strokeWeight(0);
  background(255);
  firstOrb.display();
  for (Orb o : orbList) {
    if (mode == 1){
      o.gravity();
    }
    else if (mode == 2){
      o.attract(firstOrb);
    }
    o.move();
    o.display();
  }
  fill(0);
  text(frameRate,20,20);
  text(orbList.size(),20,40);
  text(mode, 20, 60);
}
