public class MazeSearcher {
  private boolean mazeSearcher(int [][]maze,int x,int y)
  {
    if (isIn(x,y)&& maze[x][y]!=1)
    {
      if (x == 4 || y == 4)
      {
        return true;
      }
      maze[x][y]=1;
      return (mazeSearcher(maze,x+1,y)||mazeSearcher (maze,x-1,y)||mazeSearcher(maze,x,y+1)||mazeSearcher(maze,x,y-1));
    }
    return false;
    }
  private boolean isIn(int x,int y)
  {
      if (x >= 0 && x < 5 && y >= 0 && y < 5)
      {
        return true;
        }
    return false; 
}
  
  public static void main(String[] args) { 
    MazeSearcher m=new MazeSearcher();
    int [][] maze={{0,0,1,1,1},
                  {1,0,0,1,1,},
                  {1,0,1,1,1},
                  {1,0,0,0,1},
                  {1,1,1,0,1}};
   System.out.println( m.mazeSearcher(maze,0,0));
    
    
  }
}
