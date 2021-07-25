import java.util.Scanner;

public class DistributeCandies {
    static int A,B,C,D;
    public static void main(String[] args) {
        //X : 인당 나눠줄 사탕의 수
        //Y : 사탕 봉지의 수
        //A * x + 1 = B * y
        //Ax + By = C의 형태로 변환
        //-Ax + By = 1
        //A(-x) + By = 1

        //X>0 , 0<Y<=10^9
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());
        //int A,B,C,D;
        for(int i=0; i<N; i++){
            A=scan.nextInt();
            B=scan.nextInt();

            //확자 유클리드 호제법의 결과는 s, t, r 임

            EGResult result = extendedGcd(A,B);
            //D = gcd(A,B);
            //C%D==0 이어야 해를 가질 수 있으 => 베주 항등식
            if(result.r!=1) {
                System.out.println("IMPOSSIBLE");
            }else{
                //x0 = s * C/D
                //y0 = t * C/D
                long x0 = result.s * 1 / 1;
                long y0 = result.t;

                //x = x0 + B/D * k
                //y = y0 - A/D * k


                //x<0   -> 아까 위에서 편의를 위해 A(-x) 이렇게 바꿨어서 범위가 뒤집어짐
                //확장 유클리드 호제법에 음수가 들어가면 일이 귀찮아져서 이렇게 처리했었음
                //x + B * k < 0
                //k < -x0 / B
                //0 < y <= 1e9
                //0 < y0 - A * k <=1e9
                //-y0 < -A * k <= 1e9 - y0

                //(y0 - 1e9 ) / A  <= k < y0/A
                //                   k < -x0 / B

                //우측 경계 정하기
                //일단 올림하고 -1 하면 구해지는 어떤 소숫점보다 작은 정수를 구할 수 있음
                long kFromY = (long)Math.ceil((double)y0 / (double)A) -1;
                long kFromX = (long)Math.ceil((double) -x0 / (double) B) -1;

                long k = Math.min(kFromY, kFromX);
                long y = y0 - A * k;
                if(y<=1e9)//10의 9승을 1e9 이렇게 쓸 수 있음
                {
                    System.out.println(y);
                }else{
                    System.out.println("IMPOSSIBLE");
                }
            }
        }



        //KX + 1 = C*Y
        //-KX + CY = 1
        //ax + by = c    를 만족하는 x,y를 구하면 됨

        //답이 없으면 IMPOSSIBLE => 나오는 조건?? => 해가 없는 경우
        //gcd(a,b) 가 1 이 아닌 다른게 나오면 그게 해가 없는 케이스가 될거임
        //그 외의 케이스에서는 s,t,r을 구해서 거기서부터 x,y를 만들어낼 수 있을거임........

        //사탕 봉지가 10^9보다 작아야 하므로 Y<=10^9
        //그리고 사탕 봉지는 음수가 될 수 없으므로 Y>0
        //X는 자연수라고 문제에서 주어짐 X>0
        //우리가 x0, y0 을 구함 -> 얘의 일반해 공식을 이용해서 무수히 많은 답들 중 저 범위 안에 들어가는 답을 찾아내야 함

    }

    public static EGResult extendedGcd(long a, long b){
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while(r1!=0){
            long q = r0 / r1;

            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1= temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;

        }
        return new EGResult(s0, t0, r0);
    }
}

class EGResult{

    long s;
    long t;
    long r;

    public EGResult(long s, long t, long r){
        super();
        this.s=s;
        this.t=t;
        this.r=r;
    }

}
