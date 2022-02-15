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

  public boolean addQueen(int r, int c){
    for (int i = 0; i < c; i++){
      if (board[r-1][i] == -1)return false;
    }
    board[r-1][c-1] = -1;
    for (int x = r; x < size; x++){
      board[x][c-1] += 1;
    }
    int row = r;
    int col = c;
    while (row < size && col < size){
      board[row][col] += 1;
      row++;
      col++;
    }
    row = r;
    col = c-2;
    while (row < size && col > -1){
      board[row][col] += 1;
      row++;
      col--;
    }
    return true;
  }

  public static void main(String args[]){
    QueenBoard board1 = new QueenBoard(9);
    board1.addQueen(2, 3);
    System.out.println(board1.toString());
  }
}
