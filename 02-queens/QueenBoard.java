public class QueenBoard{
  private int[][] board;
  private int size;
  public QueenBoard(int n){
    size = n;
    board = new int[n][n];
  }

  public String toString(){
    String answer = "";
    for (int i = 0; i < size; i++){
      for (int x = 0; x < size; x++){
        if (board[i][x] == 0)answer += "_";
        else{
          answer += "Q";
        }
        if (x != size-1)answer += " ";
      }
      if (i != size-1)answer += "\n";
    }
    return answer;
  }

  public static void main(String args[]){
    QueenBoard board1 = new QueenBoard(9);
    System.out.println(board1.toString());
  }
}
