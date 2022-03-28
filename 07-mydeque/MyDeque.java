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
  public int size(){}
  public String toString(){ }
  public void addFirst(E element){ }
  public void addLast(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }

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
}
