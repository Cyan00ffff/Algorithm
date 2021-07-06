import java.util.Scanner;

public class Implementation1{

     public static void main(String []args){
        
        Scanner scan = new Scanner(System.in);
        
        String temp = scan.nextLine();
        int col = temp.charAt(0)-96;//a=1
        int row = temp.charAt(1)-48;
        
        int answer=0;
        
        //+2-1 +2+1 -2+1 -2-1 +1-2 +1+2 -1-2 -1+2
        
        int[][] move = {{2,-1},{2,1},{-2,1},{-2,-1},{1,-2},{1,2},{-1,-2},{-1,2}};
        
        int rTemp=0, cTemp=0;
        for(int i=0; i<8; i++){
            rTemp=row+move[i][0];
            cTemp=col+move[i][1];
            if(rTemp>0&&rTemp<9&&cTemp>0&&cTemp<9)
                answer++;
        }
        
        System.out.println(answer);
        
     }
}
