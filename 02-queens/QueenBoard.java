public class QueenBoard{
  private int[][] board;
  private int size;
  private boolean animated;
  private int delay;
  public void setAnimate(boolean newValue){
    animated = newValue;
  }
  public void setDelay(int newValue){
    delay = newValue;
  }
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
    if(animated){
      System.out.println(Text.go(1,1));
      System.out.println(this);//can modify here
      Text.wait(delay);
    }
    return true;
  }

  public boolean removeQueen(int r, int c){
    if (board[r][c] != -1)return false;
    queenOperations(r, c, 0, -1);
    if(animated){
      System.out.println(Text.go(1,1));
      System.out.println(this);//can modify here
      Text.wait(delay);
    }
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
}
