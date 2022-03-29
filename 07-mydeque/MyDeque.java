import java.util.*;
import java.io.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 10;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = initialCapacity;
  }
  public int size(){
    try{
      if (end > start){
        return end - start;
      }
      else{
        return data.length-start+end;
      }
    }
    catch(Exception e){
      System.out.println("Size exception, returning 0");
      return 0;
    }
  }
  public String toString(){
    if (this.size() == 0){
      return "[]";
    }
    if (this.size() == 1){
      return "[" + data[start] + "]";
    }
    String answer = "[";
    if (end > start){
      for (int i = start; i < end+1; i++){
        answer += data[start];
        if (i != end){
          answer+=", ";
        }
      }
    }
    else{
      for (int i = start; i < data.length; i++){
        answer += data[i] + ", ";
      }
      for (int x = 0; x < end+1; x++){
        answer += data[x];
        if (x != end){
          answer+=", ";
        }
      }
    }
    return answer + "]";
  }
  public void addLast(E element){
    if (this.size() == 0){
      System.out.println("Initial");
      start = size / 2;
      end = start + 1;
      data[start] = element;
    }
    else if (start-end == 1){
      System.out.println("Resize triggered");
      this.resize();
    }
    else if (end == data.length){
      end = 0;
    }
    else{
      data[end] = element;
      end++;
    }
  }
  /**
  public void addFirst(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  **/
  public E getFirst(){
    return data[start];
  }
  public E getLast(){
    return data[end];
  }

  //resize function assumes everything else is done properly
  private void resize(){
    if (size == 0){
      size = 10;
    }
    else{
      size = size * 3;
    }
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[size];
    int newStart = size / 2;
    for (int i = 0; i < data.length-start; i++){
      d[newStart] = data[i+start];
      newStart++;
    }
    for (int x = 0; x < end + 1; x++){
      d[newStart] = data[x];
      newStart++;
    }
    data = d;
  }

  public static void main(String args[]){
    MyDeque example1 = new MyDeque();
    System.out.println(example1.size());
    System.out.println(example1.toString());
    example1.addLast(2);
    System.out.println(example1.size());
    System.out.println(example1.toString());
    example1.addLast(21);
    System.out.println(example1.size());
    System.out.println(example1.toString());
    example1.addLast(31);
    System.out.println(example1.size());
    System.out.println(example1.toString());
    example1.addLast(41);
    System.out.println(example1.size());
    System.out.println(example1.toString());
    example1.addLast(51);
    System.out.println(example1.size());
    System.out.println(example1.toString());
    example1.addLast(61);
    System.out.println(example1.size());
    System.out.println(example1.toString());
    example1.addLast(71);
    System.out.println(example1.size());
    System.out.println(example1.toString());
    example1.addLast(81);
    System.out.println(example1.size());
    System.out.println(example1.toString());
    example1.addLast(91);
    System.out.println(example1.size());
    System.out.println(example1.toString());
    example1.addLast(101);
    System.out.println(example1.size());
    System.out.println(example1.toString());
  }
}
