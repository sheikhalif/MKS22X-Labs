public class Orb{
float x,y;
float xSpeed,ySpeed;
float radius;
color c;

public Orb(float x_,float y_,float xSpeed_, float ySpeed_, float radius_ ){
  x = x_;
  y = y_;
  xSpeed = xSpeed_;
  ySpeed = ySpeed_;
  radius = radius_;
  //random color... why not.
  c = color(random(255),random(255),random(255));
}
public float xLocation(Orb otherOrb){
  return x;
}

public float yLocation(Orb otherOrb){
  return y;
}
void display(){
  fill(c);
  ellipse(x, y, radius, radius);
}

void move(){
  //PART 2
  x+=xSpeed;
  y+=ySpeed;
  ellipse(x, y, radius, radius);
  //change the x based on the xSpeed
  //change the y based on the ySpeed

  //PART 3
  if (x > width-radius/2 || x < radius/2){
    xSpeed*=-1;
  }
  if (y > height-radius/2 || y < radius/2){
    ySpeed*=-1;
  }
}

void gravity(){
  ySpeed += 0.15;
}

void attract(Orb other){
  float distance = dist(this.x, this.y, xLocation(other), yLocation(other));
  xSpeed += ((xLocation(other) - xLocation(this))/(distance * distance)) * 20;
  ySpeed += ((yLocation(other) - yLocation(this))/(distance * distance)) * 20;    
}
  //Change the speed when you collide with the end of the screen (all 4 sides)

}
