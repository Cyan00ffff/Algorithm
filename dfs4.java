import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main
{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] t = scan.nextLine().split(" ");
		int N = Integer.parseInt(t[0]);
		int M = Integer.parseInt(t[1]);
		
		int[][] maze = new int[N][M];
		for(int i=0; i<N; i++){
		    String temp = scan.nextLine();
		    for(int j=0; j<M; j++){
		        maze[i][j]=temp.charAt(j)-49;
		    }
		}
		
		maze[0][0]=1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(0);
		while(!queue.isEmpty()){
		    int v = queue.poll();
		    int r = v/M;
		    int c = v%M;
		    int[] dr = {0,-1,1,0};
    	    int[] dc = {1,0,0,-1};
    	    
    	    for(int i=0; i<4; i++){
    	        int rTemp=r+dr[i];
    	        int cTemp=c+dc[i];
    	        if(rTemp>=0&&rTemp<N&&cTemp>=0&&cTemp<M){
    	            if(maze[rTemp][cTemp]==0){
    	                queue.offer(rTemp*M+cTemp);
    	                maze[rTemp][cTemp]=maze[r][c]+1;
    	            }
    	        }
    	    }
		    
		}

		System.out.println(maze[N-1][M-1]);
		
		
	}
	
	
}
