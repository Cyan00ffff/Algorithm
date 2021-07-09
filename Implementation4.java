import java.util.Scanner;

public class Implementation4 {
    public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
      int answer=0;
      
      int num = Integer.parseInt(scan.nextLine());
      int lLen=Integer.parseInt(scan.nextLine());
      int[][] relation = new int[lLen][2];
      
      
      int[] arr = new int[num];
      for(int i=0; i<num; i++){
          arr[i]=10;
      }
      arr[0]=0;
      
      for(int i=0; i<lLen; i++){
          String[] temp = scan.nextLine().split(" ");
          int a = Integer.parseInt(temp[0]);
          int b = Integer.parseInt(temp[1]);
          relation[i][0]=Math.min(a,b);
          relation[i][1]=Math.max(a,b);
          
          if(a==1){
              arr[b-1]=1;
          }
          
      }
      
      for(int i=0; i<lLen; i++){
          int a = relation[i][0];
          int b = relation[i][1];
          
          if(arr[a-1]==1){
              arr[b-1]=Math.min(arr[b-1],2);
          }else if(arr[b-1]==1){
              arr[a-1]=Math.min(arr[a-1],2);
          }
          
      }
      
      for(int i=1; i<num; i++){
          if(arr[i]<3)
            answer++;
      }

      System.out.println(answer);
    }
}
