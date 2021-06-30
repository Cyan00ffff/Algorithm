import java.util.Scanner;


public class Greedy3{

     public static void main(String []args){
        
        Scanner scan = new Scanner(System.in);
        String[] temp = scan.nextLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);
        int answer=0;
        
        while(N!=1){
            if(N%K==0){
                N=N/K;
            }else{
                N--;
            }
            answer++;
        }
        
        
        System.out.println(answer);
        
     }
}
