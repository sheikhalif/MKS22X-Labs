import java.util.*;
import java.io.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;
  private boolean firstRound = true;

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
    int answer = 0;
    for (int i = 0; i < data.length; i++){
      if (data[i] != null)answer++;
    }
    return answer;
  }






  public String debugToString(){
    String answer = "[";
    for (int i = 0; i < data.length; i++){
      answer += data[i];
      if (i != data.length-1){
        answer+= ", ";
      }
    }
    return answer + "]";
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
      for (int i = start+1; i < end; i++){
        answer += data[i];
        if (i != end-1){
          answer+=", ";
        }
      }
    }
    else{
      for (int i = start+1; i < data.length; i++){
        answer += data[i] + ", ";
      }
      for (int x = 0; x < end; x++){
        answer += data[x];
        if (x != end){
          answer+=", ";
        }
      }
    }
    return answer + "]";
  }


/**
  public void addLast(E element){
    if (firstRound){
      start = size / 2;
      end = start + 1;
      data[start] = element;
    }
    else{
      if (start-end == 0 && (firstRound == false)){
        this.resize();
      }
      if (end == data.length){
        end = 0;
      }
      data[end] = element;
      end++;
    }
    if (firstRound){
      firstRound = false;
    }
  }
**/
  public void addLast(E element){
    if (firstRound){
      int middle = size/2;
      start = middle-1;
      end = middle + 1;
      data[middle] = element;
    }
    else{
      if ((start-end == 1 || start-end == -1) && (firstRound == false) && (this.size() == data.length)){
        System.out.println("resize");
        this.resize();
      }
      if (end == data.length){
        end = 0;
      }
      data[end] = element;
      end++;
    }
    if (firstRound){
      firstRound = false;
    }
  }




  public void addFirst(E element){
    if (firstRound){
      int middle = size/2;
      start = middle-1;
      end = middle + 1;
      data[middle] = element;
    }
    else{
      if ((start-end == 1 || start-end == -1) && (firstRound == false) && (this.size() == data.length)){
        System.out.println("resize");
        this.resize();
      }
      if (start == -1){
        start = data.length-1;
      }
      data[start] = element;
      start--;
    }
    if (firstRound){
      firstRound = false;
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
    int oldSize = size;
    if (size == 0){
      size = 10;
    }
    else{
      size = size * 3;
    }
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[size];
    int newStart = size / 2;
    int newStartCopy = newStart;
    for (int i = 0; i < data.length-start-1; i++){
      d[newStart] = data[i+start+1];
      newStart++;
    }
    for (int x = 0; x < end; x++){
      d[newStart] = data[x];
      newStart++;
    }
    data = d;
    start = newStartCopy-1;
    end = newStartCopy + oldSize;
  }

  public static void main(String args[]){
    /**
    MyDeque example1 = new MyDeque();
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(2);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(3);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(4);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(5);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(6);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(7);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(8);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(9);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(10);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(11);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(12);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(13);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(14);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(15);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(16);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(17);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(18);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());
    example1.addLast(19);
    System.out.println(example1.size());
    System.out.println(example1.debugToString());

    example1.addLast(5);
    System.out.println(example1.size());
    System.out.println(example1.toString());
    example1.addLast(6);
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
    **/
    MyDeque example2 = new MyDeque();
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(2);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(3);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(4);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(5);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(6);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(7);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(8);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(9);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(10);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(11);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(12);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(13);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(14);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(15);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(16);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(17);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(18);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    example2.addFirst(19);
    System.out.println(example2.size());
    System.out.println(example2.debugToString());
    System.out.println(example2.toString());
  }
}
