import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] heights;
    static int[] inDegree;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        inDegree = new int[N+1];
        heights=new ArrayList[N+1];
        for(int i=1; i<N+1; i++){
            heights[i] = new ArrayList<>();
            inDegree[i]=0;
        }

        for(int i=0; i<M; i++){
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            inDegree[b]++;
            heights[a].add(b);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<N+1; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp+" ");
            for(int i=0; i<heights[temp].size(); i++){
                inDegree[heights[temp].get(i)]--;
                int nowDegree=inDegree[heights[temp].get(i)];
                if(nowDegree==0) {
                    queue.add(heights[temp].get(i));
                }
            }
        }
    }
}

