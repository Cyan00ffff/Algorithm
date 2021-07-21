import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(-1);

        int N = Integer.parseInt(st.nextToken());
        int nums[] = new int[N];
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            int temp = Integer.parseInt(st.nextToken());
            nums[i]=temp;
        }

        for(int i=1; i<N+1; i++){
            int val = nums[i-1];
            if(val==0){
                System.out.println(pop(arr));
            }else{
                push(val, arr);
            }
        }


    }
    static void push(int n, ArrayList<Integer> arr){
        arr.add(n);
        int index=arr.size()-1;


        while(true) {
            int parent = index/2;

            if(parent==0||arr.get(parent)<=arr.get(index)){
                break;
            }
            int p = arr.get(parent);
            if(p>n){
                int temp = p;
                arr.set(parent, arr.get(index));
                arr.set(index,temp);
                index=parent;
            }else
                break;


        }
    }

    static int pop(ArrayList<Integer> arr){

        if(arr.size()<=1){
            return 0;
        }
        if(arr.size()==2){
            int tt=arr.get(1);
            arr.remove(1);
            return tt;
        }
        int ret = arr.get(1);

        int last=arr.get(arr.size()-1);
        arr.set(1, last);
        arr.remove(arr.size()-1);

        int index=1;
        int smaller=0;

        while(true){

            int temp = arr.get(index);
            int left = index*2;
            int right = index*2+1;
            if(left>=arr.size())
                break;

            int minPos=left;
            int minVal=arr.get(left);
            if(right<arr.size()&&arr.get(right)<minVal){
                minVal=arr.get(right);
                minPos=right;
            }

            if(arr.get(index)>minVal){
                int tt = arr.get(index);
                arr.set(index, arr.get(minPos));
                arr.set(minPos, tt);
                index=minPos;
            }else
                break;

        }



        return ret;
    }


}

