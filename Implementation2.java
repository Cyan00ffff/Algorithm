import java.util.Scanner;

public class Implementation2{

     public static void main(String []args){
        
        Scanner scan = new Scanner(System.in);
        
        String[] temp = scan.nextLine().split(" ");
        int N=0, M=0;
        N=Integer.parseInt(temp[0]);
        M=Integer.parseInt(temp[1]);
        
        int cRow=0, cCol=0;
        int direction = -1;
        temp=null;
        temp = scan.nextLine().split(" ");
        cRow=Integer.parseInt(temp[0]);
        cCol=Integer.parseInt(temp[1]);
        direction=Integer.parseInt(temp[2]);
        
        int[][] map = new int[N][M];
        int[][] check = new int[N][M];
        for(int i=0; i<N; i++){
            String[] t = scan.nextLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j]=Integer.parseInt(t[j]);
                if(map[i][j]==1){
                    check[i][j]=1;
                }else
                    check[i][j]=0;
            }
        }
        
        //북0(-1,0) 동1(0,+1) 남2(+1,0) 서3(0,-1)
        //진행 순서 : 0321032103210321
        //다음 방향 : (direction-1)
        
        int answer=1;
        int count=0;
        check[cRow][cCol]=1;
        
        while(true){
            direction--;
            if(direction<0) direction=3;
            int rTemp=cRow, cTemp=cCol;
            switch(direction){
                case 0: rTemp--; break;
                case 1: cTemp++; break;
                case 2: rTemp++; break;
                case 3: cTemp--; break;
            }
            if(check[rTemp][cTemp]==0){
                cRow=rTemp;
                cCol=cTemp;
                check[cRow][cCol]=1;
                answer++;
                count=0;
            }else{
                count++;
            }
            
            if(count==4){
                count=0;
                int rt=cRow, ct=cCol;
                switch(direction){
                    case 0:rt--;break;
                    case 1:ct++;break;
                    case 2:rt++;break;
                    case 3:ct--;break;
                }
                if(map[rt][ct]==1)
                    break;
                else{
                    cRow=rt;
                    cCol=ct;
                }
            }
           // System.out.println("row : "+cRow+" col : "+cCol+" answer : "+answer);
        }
        
        System.out.println(answer);
        
        
     }
}
