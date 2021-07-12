import java.util.Scanner;
import java.util.Stack;

public class MyClass {
    public static void main(String args[]) {
      Scanner scan = new Scanner(System.in);
        String[] temp = scan.nextLine().split(" ");
        int row=Integer.parseInt(temp[0]);
        int col = Integer.parseInt(temp[1]);
        int answer=0;
        Stack<Integer> stack = new Stack<Integer>();

        int[][] table = new int[row][col];
        for(int i=0; i<row; i++){
            String t = scan.nextLine();
            for(int j=0; j<col; j++){
                table[i][j]=t.charAt(j)-48;
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(table[i][j]==0){
                    answer++;
                    dfs(table, i*row+j, stack);
                }
            }
        }

        System.out.println(answer);
    }
    
    static void dfs(int[][] table, int start, Stack<Integer> stack){
        int row=table.length;
        int col = table[0].length;
        stack.add(start);
        table[start/row][start%row]=1;

        int top=(int)stack.peek();
        int trow=top/row;
        int tcol=top%row;

        if(trow-1>=0){
            if(table[trow-1][tcol]==0)
                dfs(table, (trow-1)*row+tcol, stack);
        }
        if(trow+1<row){
            if(table[trow+1][tcol]==0)
                dfs(table, (trow+1)*row+tcol, stack);
        }
        if(tcol-1>=0){
            if(table[trow][tcol-1]==0)
                dfs(table, (trow)*row+tcol-1, stack);
        }
        if(tcol+1<col){
            if(table[trow][tcol+1]==0)
                dfs(table, (trow)*row+tcol+1, stack);
        }
    }
}
