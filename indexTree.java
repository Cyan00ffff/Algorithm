import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int S;
    static long[] nums;
    static long[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N];

        for(int i=0; i<N; i++){
            nums[i]=Long.parseLong(br.readLine());
        }

        S=1;
        while(S<N){
            S*=2;
        }
        tree = new long[S*2+1];
        tree[0]=0;

        initBU();
        for(int i=0; i<M+K; i++){
            st=new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a==1){
                update(1, S, 1, b, c-tree[S+b-1]);
            }else if(a==2){
                System.out.println(query(1,S,1,b,(int)c));
            }

        }





    }
    static void initBU(){
        //leaf에 값 반영
        for(int i=0; i<N; i++){
            tree[S+i]=nums[i];
        }
        //내부 노드 채움
        for(int s=S-1; s>=1; s--){
            tree[s]=tree[s*2]+tree[s*2+1];
        }
        //S-1 ~ 1


    }
    static long query(int left, int right, int node, int queryLeft, int queryRight){
        //연관이 없음 -> 결과에 영향이 없는 값 return
        if(right<queryLeft||left>queryRight){
            return 0L;
        }
        //판단 가능 -> 현재 노드 값 return
        else if(left>=queryLeft&&right<=queryRight){
            return tree[node];
        }
        //판단 불가, 자식에게 위임, 자식에서 올라온 값을 return
        else {
            return query(left, (left + right) / 2, node * 2, queryLeft, queryRight) +
                    query((left + right) / 2 + 1, right, node * 2 + 1, queryLeft, queryRight);
        }
        //재귀를 이용해서 물어봐야 함
        //만약 1~8까지에서 3~7까지의 부분합을 구하고 싶으면 ? -> quert(1,8,1,3,7)
        //처음 부를 때는 left, right 가 1~S 가 돼야 함

        //return 0;
    }
    static void update(int left, int right, int node, int target, long diff){
        //연관 없음 - 무시
        //연관 있음 -> 현재 노드에 diff 반영 -> 자식에게 diff 전달
        if(target<=right&&target>=left){
            tree[node]+=diff;
            if(node<S){//혹은 if(left!=right)
                update(left, (left+right)/2, node*2, target, diff);
                update((left+right)/2+1, right, node*2+1, target, diff);
            }
        }

        //왼쪽 update(left, mid, node*2, 3, -2)
        //오른쪽 update(mid+1, right, node*2+1, 3, -2)
    }
   

}
