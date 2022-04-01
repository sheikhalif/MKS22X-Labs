import java.util.*;

public class Calculator{
  public static double eval (String s) throws IllegalArgumentException{
    ArrayDeque<Double> deque = new ArrayDeque<Double>();
    String[] inputs = s.split(" ");
    for (int i = 0; i < inputs.length; i++){
      if (inputs[i] == "+"){
        if (deque.size() < 2){
          throw new IllegalArgumentException("Too many operations");
        }
        double second = deque.pollLast();
        double first = deque.pollLast();
        deque.add(first+second);
      }
      else if(inputs[i] == "-"){
        if (deque.size() < 2){
          throw new IllegalArgumentException("Too many operations");
        }
        double second = deque.pollLast();
        double first = deque.pollLast();
        deque.add(first-second);
      }
      else if(inputs[i] == "*"){
        if (deque.size() < 2){
          throw new IllegalArgumentException("Too many operations");
        }
        double second = deque.pollLast();
        double first = deque.pollLast();
        deque.add(first*second);
      }
      else if(inputs[i] == "/"){
        if (deque.size() < 2){
          throw new IllegalArgumentException("Too many operations");
        }
        double second = deque.pollLast();
        double first = deque.pollLast();
        deque.add(first/second);
      }
      else if (inputs[i] == "%"){
        if (deque.size() < 2){
          throw new IllegalArgumentException("Too many operations");
        }
        double second = deque.pollLast();
        double first = deque.pollLast();
        if (second < 0)second*=-1;
        if (first < 0)first*=-1;
        deque.add(first % second);
      }
      else{
        queue.add((double)inputs[i]);
      }
    }
    if (deque.size() > 1){
      throw new IllegalArgumentException("Not enough operations");
    }
    return deque.getFirst();
  }
}
