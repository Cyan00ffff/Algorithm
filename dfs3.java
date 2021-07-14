import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Collections;

public class Main {
    public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      String[] t = scan.nextLine().split(" ");
      int N=Integer.parseInt(t[0]);
      int M=Integer.parseInt(t[1]);
      int start = Integer.parseInt(t[2]);
      int[] visited = new int[N];
      for(int i=0; i<N; i++){
          visited[i]=0;
      }
      
      start--;
      LinkedList<Integer>[] graph = new LinkedList[N];
      for(int i=0; i<N; i++){
          graph[i]=new LinkedList<Integer>();
      }
      
      for(int i=0; i<M; i++){
          String[] temp = scan.nextLine().split(" ");
          int a = Integer.parseInt(temp[0]);
          int b = Integer.parseInt(temp[1]);
          graph[a-1].add(b-1);
          graph[b-1].add(a-1);
      }
      for(int i=0; i<N; i++){
          Collections.sort(graph[i]);
      }
      
      dfs(graph, start, visited);
      for(int i=0; i<N; i++){
          visited[i]=0;
      }
      System.out.println();
      bfs(graph, start, visited);
    }
    
    static void dfs(LinkedList<Integer>[] graph, int v, int[] visited){
        visited[v]=1;
        System.out.print((v+1)+" ");
        for(int i=0; i<graph[v].size(); i++){
            if(visited[graph[v].get(i)]==0)
                dfs(graph, graph[v].get(i),visited);
        }
    }
    
    static void bfs(LinkedList<Integer>[] graph, int v, int[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v]=1;
        while(!queue.isEmpty()){
            int num = queue.poll();
            System.out.print((num+1)+" ");
            for(int i=0; i<graph[num].size(); i++){
                int temp = graph[num].get(i);
                if(visited[temp]==0){
                    queue.offer(temp);
                    visited[temp]=1;        
                }
            }
        }
        
    }
}
