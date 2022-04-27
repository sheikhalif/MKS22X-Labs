final float SPRING_CONSTANT = 0.005;
final float SPRING_LENGTH = 100;
final float SPRING_DAMPEN = 0.995;
ArrayList<Orb>orbList;
Orb firstOrb = new Orb(500, 400, 0, 0, 20);
int mode;
boolean backgroundMode = false;
boolean lineMode = false;
boolean gravityMode = false;
void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  mode = 0;
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
  else if (keyCode == 71){
    if (gravityMode)gravityMode = false;
    else if (!(gravityMode))gravityMode = true;
  }
  else if (keyCode == 66){
    if (backgroundMode)backgroundMode = false;
    else if (!(backgroundMode))backgroundMode = true;
  }
  else if (keyCode == 76){
    if (lineMode)lineMode = false;
    else if (!(lineMode))lineMode = true;
  }
  
}
  
void draw() {
  strokeWeight(0);
  if (!(backgroundMode))background(255);
  firstOrb.display();
  for (Orb o : orbList) {
    if (gravityMode || mode == 0){
      o.gravity();
    }
    if (mode == 1){
      o.attract(firstOrb);
    }
    else if (mode == 2){
      o.attractSpring(firstOrb);
    }
    o.move();
    o.display();
  }
  fill(0);
  text(frameRate,20,20);
  text(orbList.size(),20,40);
  text(mode, 20, 60);
  if (gravityMode)text("Gravity mode on", 20, 80);
  else{
    text("Gravity mode off", 20, 80);
  }
  if (backgroundMode)text("Background mode on", 20, 100);
  else{
    text("Background mode off", 20,100);
  }
  if (lineMode)text("Line mode on", 20, 120);
  else{
    text("Line mode off", 20, 120);
  }
}
