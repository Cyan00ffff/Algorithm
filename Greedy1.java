import java.util.Scanner;

public class Greedy1{
    public static void main(String[] args) {
        //0629 00:10~00:19
        Scanner scan = new Scanner(System.in);
        String[] input=scan.nextLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        String[] temp = scan.nextLine().split(" ");
        int[] nums=new int[N];
        int first=0, second =0;
        for(int i=0; i<nums.length; i++){
            nums[i]=Integer.parseInt(temp[i]);
            if(nums[i]>first){
                second=first;
                first=nums[i];
            }
        }

        int maxRot=M/(K+1);
        int rest = M%(K+1);

        int answer = maxRot*(first*K+second)+rest*first;
        System.out.println(answer);


        
    }
    
}