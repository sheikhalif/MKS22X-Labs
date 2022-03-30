import java.util.*;
import java.io.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;
  private boolean firstRound = true;

  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[0];
    data = d;
    size = 0;
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
    int tempStart;
    int tempEnd;
    if (start != data.length-1){
      tempStart = start+1;
    }
    else{
      tempStart = 0;
    }
    if (end != 0){
      tempEnd = end-1;
    }
    else{
      tempEnd = data.length-1;
    }
    if (this.size() == 0){
      return "[]";
    }
    if (this.size() == 1){
      return "[" + data[start] + "]";
    }
    String answer = "[";
    if (tempEnd > tempStart){
      for (int i = tempStart; i < tempEnd+1; i++){
        answer += data[i];
        if (i != tempEnd){
          answer+=", ";
        }
      }
    }
    else{
      for (int i = tempStart; i < data.length; i++){
        answer += data[i] + ", ";
      }
      for (int x = 0; x < tempEnd+1; x++){
        answer += data[x];
        if (x != tempEnd){
          answer+=", ";
        }
      }
    }
    return answer + "]";
  }

  public void addLast(E element) throws NullPointerException{
    if (element == null){
      throw new NullPointerException("You cannot add a null value");
    }
    if (firstRound){
      if (this.size() == 0){
        //System.out.println("First round");
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        size = 10;
      }
      int middle = size/2;
      start = middle-1;
      end = middle + 1;
      data[middle] = element;
      //System.out.println("Data: " + this.debugToString());
    }
    else{
      if (this.size() == 0){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        size = 10;
      }
      //System.out.println("addLast:");
      //System.out.println("Size: " + this.size());
      if (this.size() == data.length){
        //System.out.println("Resize");
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
    //System.out.println(this.debugToString());
  }

  public void addFirst(E element) throws NullPointerException{
    if (element == null){
      throw new NullPointerException("You cannot add a null value");
    }
    if (firstRound){
      if (this.size() == 0){
        //System.out.println("First round");
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        size = 10;
      }
      int middle = size/2;
      start = middle-1;
      end = middle + 1;
      data[middle] = element;
      //System.out.println("Data: " + this.debugToString());
    }
    else{
      if (this.size() == 0){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        size = 10;
      }
      //System.out.println("addFirst:");
      if (this.size() == data.length){
        //System.out.println("Resize");
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
    //System.out.println(this.debugToString());
  }

  public E getFirst() throws NoSuchElementException{
    if (this.size() == 0){
      throw new NoSuchElementException("Cannot be called if deque is empty");
    }
    if (start != data.length-1){
      return data[start+1];
    }
    else{
      return data[0];
    }
  }
  public E getLast() throws NoSuchElementException{
    if (this.size() == 0){
      throw new NoSuchElementException("Cannot be called if deque is empty");
    }
    if (end != 0){
      return data[end-1];
    }
    else{
      return data[data.length-1];
    }
  }

  public E removeFirst() throws NoSuchElementException{
    if (this.size() == 0){
      throw new NoSuchElementException("Cannot be called if deque is empty");
    }
    E element;
    if (start != data.length-1){
      element = data[start+1];
      data[start+1] = null;
      start = start + 1;
    }
    else{
      element = data[0];
      data[0] = null;
      start = 0;
    }
    return element;
  }

  public E removeLast() throws NoSuchElementException{
    if (this.size() == 0){
      throw new NoSuchElementException("Cannot be called if deque is empty");
    }
    E element;
    if (end != 0){
      element = data[end-1];
      data[end-1] = null;
      end = end - 1;
    }
    else{
      element = data[data.length-1];
      data[data.length-1] = null;
      end = data.length-1;
    }
    return element;
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
    if (start == -1 && end == data.length){
      for (int i = 0; i < data.length; i++){
        d[newStart] = data[i];
        newStart++;
      }
    }
    else{
      for (int i = 0; i < data.length-start-1; i++){
        d[newStart] = data[i+start+1];
        newStart++;
      }
      for (int x = 0; x < end; x++){
        d[newStart] = data[x];
        newStart++;
      }
    }
    data = d;
    start = newStartCopy-1;
    end = newStartCopy + oldSize;
  }
  public static void AddFirstLast15() {
    MyDeque test = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    for (int i = 0; i < 15; i++) {
      test.addLast(i);
      test.addFirst(i);
      real.addLast(i);
      real.addFirst(i);
    }
    System.out.println("Should print a deque of numbers 14 to 0 and then 0 to 14 incrementing by 1");
    System.out.println(test);
    System.out.println("Correct: " + (real.toString().equals(test.toString())));
    System.out.println();
  }

  public static void AddRemove15Add10() {
    MyDeque test = new MyDeque<Integer>();
    Deque real = new LinkedList<Integer>();
    for (int i = 0; i < 15; i++) {
      test.addLast(i);
      test.removeLast();
      real.addLast(i);
      real.removeLast();
    }
    for (int i = 0; i < 10; i++) {
      test.addLast(i);
      real.addLast(i);
    }
    System.out.println("Should print a deque of numbers from 0 to 9");
    System.out.println(test);
    System.out.println("Correct: " + (real.toString().equals(test.toString())));
    System.out.println();
  }

  public static void main(String args[]){
    AddRemove15Add10();
  }
}
