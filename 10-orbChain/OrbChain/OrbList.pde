 public class OrbList {
  OrbNode first, last;

  //create a fixed orb
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
  }

  /**
  *complete this method
  */
  void add(OrbNode orb){
    orb.next = last;
    orb.prev = last.prev;    
    last.prev = orb;
    last.prev.prev.next = orb;
   //insert orb at the end of the list before the last node.
  }
  
  void add(int xcor, OrbNode toBeAdded){
    OrbNode current = first;
    while(current.x < xcor){
      current = current.next;
    }
    toBeAdded.next = current;
    toBeAdded.prev = current.prev;    
    current.prev = toBeAdded;
    current.prev.prev.next = toBeAdded;
  }
  
  void delete(OrbNode target){
    if (target != null){
      target.prev.next = target.next;
      target.next.prev = target.prev;
    }
  }
  
  OrbNode getNodeAt(int x, int y){
    OrbNode current = first;
    while (current != null && sqrt(((x-current.x)*(x-current.x))+((y-current.y)*(y-current.y))) > 30){
      current = current.next;
    }
    if (current != last){
      return current;
    }
    return null;
  }

  /**
  *complete this method
  *process all nodes by running move.
  */
  void processAll() {
    OrbNode current = first;
    while (current != null){
      current.move();
      current = current.next;
    }
    //advance current to next until it is null, move() each of the nodes
  }
  /**
  *complete this method
  *Display all nodes by running their display().
  */
  void display() {
    OrbNode current = first;
    while (current != null){
      current.display();
      current = current.next;
    }
    //advance current to next until it is null, display() each of the nodes
  }
}
