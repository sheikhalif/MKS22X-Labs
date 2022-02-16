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
        if (board[i][x] != -1)answer += board[i][x];
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
      if (board[r-1][i] == -1)return false;
    }
    queenOperations(r, c, -1, 1);
    return true;
  }

  public boolean removeQueen(int r, int c){
    if (board[r][c  ] != -1)return false;
    queenOperations(r, c, 0, -1);
    return true;
  }

  public boolean solve(int row){
    if (row == 0){
      for (int i = 0; i < size; i++){
        for (int x = 0; x < size; i++){
          if (board[i][x] != 0){
            throw new IllegalStateException("Board is not clear. Clear board before running solve function");
          }
        }
      }
    }
    if (row > size){
      return true;
    }
    else{
      for (int a = 0; a < size; a++){
        if (addQueen(row, a)){
          if (solve(row+1)){
            return true;
          }
          else{
            remove(row, a);
          }
        }
      }
      return false;
    }

  }


  public static void main(String args[]){
    QueenBoard board1 = new QueenBoard(9);
    System.out.println(board1.addQueen(2, 3));
    System.out.println(board1.removeQueen(2, 3));
    System.out.println(board1.toString());
  }
}
