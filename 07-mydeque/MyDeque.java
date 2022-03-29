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
        return end - start + 1;
      }
      else{
        return data.length-start+end+1
      }
    }
    catch{
      return 0;
    }
  }
  public String toString(){
    if (this.size() == 0){
      return "[]";;
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
    return answer;
  }
  public void addLast(E element){
    if (this.size() == 0){
      start = size / 2;
      end = start + 1;
      data[start] = element;
    }
    else if (start-end == 1){
      this.resize();
    }
    if (end == data.length-1){
      end = 0;
    }
    data[end] = element;
    end++;
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
      newStart++
    }
    data = d;
  }

  public static void main(String args[]){
    MyDeque example1 = new MyDeque();
    System.out.println(example1.toString());
    example1.addLast(1);
    System.out.println(example1.toString());
    example1.addLast(2);
    System.out.println(example1.toString());
    example1.addLast(3);
    System.out.println(example1.toString());
    example1.addLast(4);
    System.out.println(example1.toString());
    example1.addLast(5);
    System.out.println(example1.toString());
    example1.addLast(6);
    System.out.println(example1.toString());
    example1.addLast(7);
    System.out.println(example1.toString());
    example1.addLast(8);
    System.out.println(example1.toString());
    example1.addLast(9);
    System.out.println(example1.toString());
    example1.addLast(10);
    System.out.println(example1.toString());
  }
}
