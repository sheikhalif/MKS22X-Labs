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

  private boolean addQueen(int r, int c){
    for (int i = 0; i < c; i++){
      if (board[r][i] == -1)return false;
    }
    board[r][c] = -1;
    for (int x = r+1; x < n; x++){
      board[x][c] += 1;
    }
    int row = r+1;
    int col = c+1;
    while (row <= n && col <= n){
      board[row][col] += 1;
      row++;
      col++;
    }
    row = r-1;
    col = c-1;
    while (row <= n && col <= n){
      board[row][col] += 1;
      row--;
      col--;
    }
  }

  public static void main(String args[]){
    QueenBoard board1 = new QueenBoard(9);
    System.out.println(board1.toString());
  }
}
