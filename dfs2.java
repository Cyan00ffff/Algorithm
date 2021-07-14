import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.lang.Math;

public class MyClass {
    public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      String[] t = scan.nextLine().split(" ");
      int N = Integer.parseInt(t[0]);
      int M = Integer.parseInt(t[1]);
      
      int[][] maze = new int[N][M];
      
      for(int i=0; i<N; i++){
          String temp = scan.nextLine();
          for(int j=0; j<M; j++){
              maze[i][j]=temp.charAt(j)-49;//0->-1 1->0
          }
        }
    
    Queue<Integer> queue = new LinkedList<>();
    
    queue.add(0);
    maze[0][0]=1;
    while(!queue.isEmpty()){
        int num=queue.poll();
        int r=num/M;
        int c=num%M;
        if(r+1<N){
            if(maze[r+1][c]==0){
                queue.add((r+1)*M+c);
                maze[r+1][c]=maze[r][c]+1;
            }
        }
        if(c+1<M){
            if(maze[r][c+1]==0){
                queue.add(r*M+c+1);
                maze[r][c+1]=maze[r][c]+1;
            }
        }
        if(r-1>=0){
            if(maze[r-1][c]==0){
                queue.add((r-1)*M+c);
                maze[r-1][c]=maze[r][c]+1;
            }
        }
        if(c-1>=0){
            if(maze[r][c-1]==0){
                queue.add(r*M+c-1);
                maze[r][c-1]=maze[r][c]+1;
            }
        }
    }
    
    System.out.println(maze[N-1][M-1]);
    
    }
}
