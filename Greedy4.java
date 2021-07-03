import java.util.Scanner;
import java.util.Arrays;
class Main{
    
    public static void main(String[] args){
        
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] temp = scan.nextLine().split(" ");
        int[] nums = new int[n];
        
        for(int i=0; i<n; i++){
            nums[i]=Integer.parseInt(temp[i]);
        }
        
        Arrays.sort(nums);
        
        int answer=0;
        for(int i=0; i<n; i++){
            answer+=nums[i]*(n-i);
        }
        System.out.print(answer);
    }
}
