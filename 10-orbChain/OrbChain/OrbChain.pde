static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static float GRAVITY = 0.35;
static int MODE = SPRING;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
}

void keyPressed(){
  if (keyCode == 49){
    float newSpringConstant = SPRING_CONSTANT * 1.05;
    if (newSpringConstant > 1){
      SPRING_CONSTANT = 1;
    }
    else{
      SPRING_CONSTANT = newSpringConstant;
    }
  }
  if (keyCode == 50){
    float newSpringConstant = SPRING_CONSTANT * 0.95;
    SPRING_CONSTANT = newSpringConstant;
  }
  if (keyCode == 51){
    float newSpringDampen = SPRING_DAMPEN * 1.05;
    if (newSpringDampen > 1){
      SPRING_DAMPEN = 1;
    }
    else{
      SPRING_DAMPEN = newSpringDampen;
    }
  }
  if (keyCode == 52){
    float newSpringDampen = SPRING_DAMPEN * 0.95;
    SPRING_DAMPEN = newSpringDampen;
  }
  if (keyCode == 53){
    SPRING_LENGTH *= 1.05;
  }
  if (keyCode == 54){
    SPRING_LENGTH *= 0.95;
  }
  if (keyCode == 55){
    GRAVITY *= 1.05;
  }
  if (keyCode == 56){
    GRAVITY *= 0.95;
  }
  
}

void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
}
