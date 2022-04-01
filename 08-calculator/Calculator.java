import java.util.*;

public class Calculator{
  public static double eval (String s) throws IllegalArgumentException{
    ArrayDeque<Double> deque = new ArrayDeque<Double>();
    String[] inputs = s.split(" ");
    for (int i = 0; i < inputs.length; i++){
      if (inputs[i].equals("+")){
        if (deque.size() < 2){
          throw new IllegalArgumentException("Too many operations");
        }
        double second = deque.pollLast();
        double first = deque.pollLast();
        deque.add(first+second);
      }
      else if(inputs[i].equals("-")){
        if (deque.size() < 2){
          throw new IllegalArgumentException("Too many operations");
        }
        double second = deque.pollLast();
        double first = deque.pollLast();
        deque.add(first-second);
      }
      else if(inputs[i].equals("*")){
        if (deque.size() < 2){
          throw new IllegalArgumentException("Too many operations");
        }
        double second = deque.pollLast();
        double first = deque.pollLast();
        deque.add(first*second);
      }
      else if(inputs[i].equals("/")){
        if (deque.size() < 2){
          throw new IllegalArgumentException("Too many operations");
        }
        double second = deque.pollLast();
        double first = deque.pollLast();
        deque.add(first/second);
      }
      else if (inputs[i].equals("%")){
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
        deque.add(Double.parseDouble(inputs[i]));
      }
    }
    if (deque.size() > 1){
      throw new IllegalArgumentException("Not enough operations");
    }
    return deque.getFirst();
  }

  public static void main(String[] args){
    System.out.println("ANSWER 1: " + eval("11 3 - 4 + 2.5 *"));
    System.out.println("ANSWER 2: " + eval("10 2.0 +"));
    System.out.println("ANSWER 3: " + eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println("ANSWER 4: " + eval("1 2 3 4 5 + * - -"));
  }
}
