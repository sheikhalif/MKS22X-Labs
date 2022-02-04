public class Recursion{
  /*Print all words that are made of the letters a-e inclusive.
  *@param length : the length of the words that are to be printed
  */
  public static void printAllWords(int length){
    printAllWords(length,"");
  }

  /*Print all words that are made of the letters a-e inclusive.
  *@param length : either how many more letters or the total length depending on implementation
  *@param word   : the partial word so far.
  */
  public static void printAllWords(int length,String word){
    if (length == word.length()){
      System.out.println(word);
    }else{
      for(char letter = 'a' ; letter <= 'e'; letter++){
        printAllWords(length, word+letter);
      }
    }
  }

  public static void printNoDoubleLetters(int length, char[] letters){
    printNoDoubleLetters(length, "", letters);
  }

  public static void printNoDoubleLetters(int length, String word, char[] letters){
    if (length == word.length()){
      System.out.println(word);
    }else{
      for(int i = 0; i < letters.length; i++){
        if (word.equals("") || word.charAt(word.length()-1) != letters[i]){
          printNoDoubleLetters(length, word+letters[i], letters);
        }
      }
    }
  }

  public static String reverse(String s){
    if (s.length() == 0){
      return s;
    }else{
      return s.charAt(s.length()-1)+reverse(s.substring(0, s.length()-1));
    }
  }

  public static double sqrt(double n, double intValue, double guess){
    if (n == 0){
      return 0;
    }
    if (((n*n) - intValue) < 0.00001 && ((n*n) - intValue) > -0.00001){
      return n;
    }else{
      guess = ((n/guess) + guess) / 2;
      return sqrt(guess, intValue, guess);
    }
  }

  public static void main(String args[]){
    char[] array1 = {'a', 'b', 'c', 'd', 'e'};
    //printAllWords(2);
    //printAllWords(3);
    //printNoDoubleLetters(3, array1);
    System.out.println(reverse("abcdef"));
    System.out.println(reverse(""));
    System.out.println(reverse("a"));
    System.out.println(sqrt(100, 100, 1));
    System.out.println(sqrt(0, 0, 1));
    System.out.println(sqrt(22, 22, 1));
  }
}
