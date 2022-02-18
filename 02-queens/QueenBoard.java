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
        if (board[i][x] != -1)answer += "_";
        else{
          answer += "Q";
        }
        if (x != size-1)answer += " ";
      }
      if (i != size-1)answer += "\n";
    }
    return answer;
  }

  public void queenOperations(int r, int c, int addOrRemove, int incOrDec){
    board[r][c] = addOrRemove;
    for (int x = r+1; x < size; x++){
      board[x][c] += incOrDec;
    }
    int row = r+1;
    int col = c+1;
    while (row < size && col < size){
      board[row][col] += incOrDec;
      row++;
      col++;
    }
    row = r+1;
    col = c-1;
    while (row < size && col > -1){
      board[row][col] += incOrDec;
      row++;
      col--;
    }
  }

  public boolean addQueen(int r, int c){
    for (int i = 0; i < c; i++){
      if (board[r][i] <= -1)return false;
    }
    if (board[r][c] != 0)return false;
    queenOperations(r, c, -1, 1);
    return true;
  }

  public boolean removeQueen(int r, int c){
    if (board[r][c] != -1)return false;
    queenOperations(r, c, 0, -1);
    return true;
  }

  public boolean solve(int row){
    if (row == 0){
      for (int i = 0; i < size; i++){
        for (int x = 0; x < size; x++){
          if (board[i][x] != 0){
            throw new IllegalStateException("Board is not clear. Clear board before running solve function");
          }
        }
      }
    }
    if (row >= size){
      return true;
    }
    else{
      for (int a = 0; a < size; a++){
        if (addQueen(row, a)){
          if (solve(row+1)){
            return true;
          }
          else{
            removeQueen(row, a);
          }
        }
      }
      return false;
    }
  }

  public boolean solve(){
    return solve(0);
  }

  public int countSolutions(int row){
    if (row == 0){
      for (int i = 0; i < size; i++){
        for (int x = 0; x < size; x++){
          if (board[i][x] != 0){
            throw new IllegalStateException("Board is not clear. Clear board before running solve function");
          }
        }
      }
    }
    int answer = 0;
    if (row < size){
      for (int a = 0; a < size; a++){
        if (addQueen(row, a)){
          answer+=countSolutions(row+1);
          removeQueen(row, a);
        }
      }
    }
    else{
      return 1;
    }
    return answer;
  }

  public int countSolutions(){
    return countSolutions(0);
  }


  public static void main(String args[]){
    QueenBoard board1 = new QueenBoard(1);
    QueenBoard board2 = new QueenBoard(2);
    QueenBoard board3 = new QueenBoard(3);
    QueenBoard board4 = new QueenBoard(4);
    QueenBoard board5 = new QueenBoard(5);
    QueenBoard board6 = new QueenBoard(6);
    QueenBoard board7 = new QueenBoard(7);
    QueenBoard board8 = new QueenBoard(8);
    System.out.println(board1.countSolutions());
    System.out.println("\n");
    System.out.println(board2.countSolutions());
    System.out.println("\n");
    System.out.println(board3.countSolutions());
    System.out.println("\n");
    System.out.println(board4.countSolutions());
    System.out.println("\n");
    System.out.println(board5.countSolutions());
    System.out.println("\n");
    System.out.println(board6.countSolutions());
    System.out.println("\n");
    System.out.println(board7.countSolutions());
    System.out.println("\n");
    System.out.println(board8.countSolutions());


  }
  /**

  **/
}
