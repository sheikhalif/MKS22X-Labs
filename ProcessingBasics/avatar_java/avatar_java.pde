  int x,y;
  int MODE;
  void setup(){
           size(800,800);
           MODE = 3;
           x = width/2;
           y = height/2;
  }
  void avatar(int x, int y){
  //your code here
  fill(0, 0, 0);
  triangle(x+10, y+60, x+40, y+60, x+25, y-70);
  triangle(x+40, y+60, x+70, y+60, x+55, y-70);
  triangle(x+70, y+60, x+100, y+60, x+85, y-70);
  triangle(x+100, y+60, x+130, y+60, x+115, y-70);
  triangle(x+130, y+60, x+160, y+60, x+145, y-70);
  triangle(x+160, y+60, x+190, y+60, x+175, y-70);
  fill(155, 103, 60);
  circle(x, y+100, 50);
  circle(x+200, y+100, 50);
  fill(242, 178, 178);
  circle(x, y+100, 30);
  circle(x+200, y+100, 30);
  fill(155, 103, 60);
  circle(x+100,y+100,200);
  fill(0, 0, 0);
  circle(x+60, y+70, 15);
  circle(x+140, y+70, 15);
  fill(155, 103, 60);
  rect(x+95, y+85, 10, 30);
  fill(244, 243, 239);
  rect(x+60, y+130, 8, 15);
  rect(x+68, y+130, 8, 15);
  rect(x+76, y+130, 8, 15);
  rect(x+84, y+130, 8, 15);
  rect(x+92, y+130, 8, 15);
  rect(x+100, y+130, 8, 15);
  rect(x+108, y+130, 8, 15);
  rect(x+116, y+130, 8, 15);
  rect(x+124, y+130, 8, 15);
  rect(x+132, y+130, 8, 15);
  rect(x+60, y+145, 8, 15);
  rect(x+68, y+145, 8, 15);
  rect(x+76, y+145, 8, 15);
  rect(x+84, y+145, 8, 15);
  rect(x+92, y+145, 8, 15);
  rect(x+100, y+145, 8, 15);
  rect(x+108, y+145, 8, 15);
  rect(x+116, y+145, 8, 15);
  rect(x+124, y+145, 8, 15);
  rect(x+132, y+145, 8, 15);
}
  void draw(){
           background(255);
           x = change(x);
           y = change(y);
           avatar(x,y);
  }
  int change(int value){
    /**
     mode 1: return a random location on the screen.
     mode 2: change each by +1, 0, or -1 randomly
     mode 3: change by +1 each, but if they hit the end of the screen ,
           wrap back around to the other end of the screen
    */

    switch(MODE){
     case 1:
       float rng1 = random(0, 800);
       return (int)rng1;
     case 2:
       float rng2 = random(3);
       int rng3 = x + (int)rng2 - 1;
       return rng3;
     case 3:
       int rng4 = x + 1;
       if (rng4 > 800){
         return 0;
       }
       return rng4;
     default:
       return 0;
    }
  }
