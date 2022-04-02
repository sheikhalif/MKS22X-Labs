import java.util.*;

public class Calculator{
  public static double eval (String s) throws IllegalArgumentException{
    ArrayDeque<Double> deque = new ArrayDeque<Double>();
    String[] inputs = s.split(" ");
    if (inputs.length == 0){
      throw new IllegalArgumentException("too few operands");
    }
    for (int i = 0; i < inputs.length; i++){
      double second = 1;
      double first = 1;
      switch(inputs[i]){
        case "+":
          if (deque.size() < 2){
            throw new IllegalArgumentException("too few operands");
          }
          second = deque.pollLast();
          first = deque.pollLast();
          deque.add(first+second);
          break;
        case "-":
          if (deque.size() < 2){
            throw new IllegalArgumentException("too few operands");
          }
          second = deque.pollLast();
          first = deque.pollLast();
          deque.add(first-second);
          break;
        case "*":
          if (deque.size() < 2){
            throw new IllegalArgumentException("too few operands");
          }
          second = deque.pollLast();
          first = deque.pollLast();
          deque.add(first*second);
          break;
        case "/":
          if (deque.size() < 2){
            throw new IllegalArgumentException("too few operands");
          }
          second = deque.pollLast();
          first = deque.pollLast();
          deque.add(first/second);
          break;
        case "%":
          if (deque.size() < 2){
            throw new IllegalArgumentException("too few operands");
          }
          second = deque.pollLast();
          first = deque.pollLast();
          if (second < 0)second*=-1;
          if (first < 0)first*=-1;
          deque.add(first % second);
          break;
        default:
          deque.add(Double.parseDouble(inputs[i]));
      }
    }
    if (deque.size() > 1){
      throw new IllegalArgumentException("too many operands");
    }
    return deque.getFirst();
  }

  public static void main(String[] args){
    System.out.println("ANSWER 1: " + eval("11 3 - 4 + 2.5 *"));
    System.out.println("ANSWER 2: " + eval("10 2.0 +"));
    System.out.println("ANSWER 3: " + eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println("ANSWER 4: " + eval("1 2 3 4 5 + * - -"));
    System.out.println("ANSWER 5: " + eval("2"));
    System.out.println("ANSWER 6: " + eval(""));
    /**
    }
    catch(IllegalArgumentException e){
      System.out.println("Error");
    }
    **/

  }
}
