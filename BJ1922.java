import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        group = new int[N+1];

        StringTokenizer st;
        PriorityQueue<int[]> pqueue = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] arr1, int[] arr2){
                return arr1[2]-arr2[2];
            }
        });
        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[] edge = {a,b,c};
            pqueue.add(edge);
        }
        for(int i=0; i<group.length; i++){
            group[i]=i;
        }

        int cnt=0;


        int answer=0;
        while(cnt<N-1){//가지치기 - 매우 중요!!!!
            int[] now = pqueue.poll();
            if(now[0]==now[1])
                continue;
            if(find(now[0])!=find(now[1])){
                cnt++;
                Union(now[0], now[1]);
                answer+=now[2];
            }
        }
        System.out.println(answer);

    }
    static void Union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        //문제에 따라서 순서가 중요할 수도 있다
        //보통 대소비교
        group[pa] = pb;
        //parent[pb] = pa
    }


    //Find : a의 조상(parent, 같은 집합의 대표)를 찾는 함수, 시간복잡도는 O(N)
    static int find(int a){
//자기 자신이 리더 = 초기화 상태
        if(group[a]==a){
            return a;
        }
        //return find(parent[a]);
        return group[a]= find(group[a]);
        //-> 이런 식으로 하면 전부 다 맨 처음 리더로 갱신이 됨
        //N이 커질 수록 차이가 커지기 때문에 이렇게 코드를 짜는 것을 추천!!
    }
}

