public MazeGenerator{
  public static void generate(char[][] maze, int startrow, int startcol){
    //idea: start with a rectangular maze. ex.
    // # # # # # # # # # #
    // # # # # # # # # # #
    // # # # # # # # # # #
    // # # # # # # # # # #
    // # # # # # # # # # #
    // # # # # # # # # # #
    // # # # # # # # # # #

    //start by putting the start and the end at the first valid and last valid row (could be column but shouldn't make a difference). ex.
    // # # # # # # # # # #
    // # # # # # # # # E #
    // # # # # # # # # # #
    // # # # # # # # # # #
    // # # # # # # # # # #
    // # S # # # # # # # #
    // # # # # # # # # # #

    //from the start, recursively pick either to go up, down, left, or right. if we're currently at the border, the moves that are invalid will not be allowed. for example,
    //the S currently will only be allowed to move up or down

    //continue on a path until there are no more valid spaces. if there is only 2 #'s around a space, there are no more valid spaces. it will continue recursively
    // going back to the last place where it made a decision in a certain direction. when there are no more valid spaces, end the maze generator. ex.
    // # # # # # # # # # #
    // #     # # #     E #
    // # #   #       #   #
    // #     #   # #     #
    // #   # #   # #   # #
    // # S             # #
    // # # # # # # # # # #

    //maze generator should be really similar to the maze solver in some ways. you have to go back to points where there are multiple directions where you can go

  }
}
