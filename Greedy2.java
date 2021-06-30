import java.util.Scanner;


public class Greedy2{

     public static void main(String []args){
        
        Scanner scan = new Scanner(System.in);
        String[] temp = scan.nextLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        
        int[][] nums = new int[N][M];
        
        int bigNum=-1;
       // int indexN=0;
        
        for(int i=0; i<N; i++){
            String[] t = scan.nextLine().split(" ");
            int smallest = 1000000;
            for(int j=0; j<M; j++){
                nums[i][j]=Integer.parseInt(t[j]);
                if(nums[i][j]<smallest){
                    smallest=nums[i][j];
                }
            }
            if(smallest>bigNum){
                bigNum=smallest;
              //  indexN=i;
            }
        }
        
        System.out.println(bigNum);
        
     }
}
