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

  public static int numberLettersInString(String str, char c){
    int answer = 0;
    for (int i = 0; i < str.length(); i++){
      if (str.charAt(i) == c){
        answer++;
      }
    }
    return answer;
  }

  public static void main(String args[]){
    char[] array1 = {'a', 'b', 'c', 'd', 'e'};
    //printAllWords(2);
    //printAllWords(3);
    printNoDoubleLetters(3, array1);
  }
}
