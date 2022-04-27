final float SPRING_CONSTANT = 0.999;
final float SPRING_LENGTH = 100;
final float SPRING_DAMPEN = 0.005;
ArrayList<Orb>orbList;
Orb firstOrb = new Orb(500, 400, 0, 0, 20);
int mode;
boolean backgroundMode;
boolean lineMode;
boolean gravityMode;
void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  mode = 0;
  gravityMode = true;
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
    if (mode != 2){
      mode++;
    }
    else{
      mode = 0;
    }
  }
  else if (keyCode = 71){
    
  println(keyCode);
}
  
void draw() {
  strokeWeight(0);
  background(255);
  firstOrb.display();
  for (Orb o : orbList) {
    if (mode == 0){
      o.gravity();
    }
    else if (mode == 1){
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
