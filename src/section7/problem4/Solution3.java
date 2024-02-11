package section7.problem4;

/**
 * packageName    : section7.problem4
 * fileName       : Solution3
 * author         : Cha
 * date           : 2024-02-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        Cha       최초 생성
 */
public class Solution3 {
    public static void main(String[] args){
        int N = 7;

        int answer = fibonacci(N);
        System.out.println("\n"+answer);
    }

    private static int fibonacci(int n) {
        if (n <= 1) return n;

        int a = 0;
        int b = 1;
        int sum = 0;
        for(int i = 2;i<= n;i++){
            sum = a + b;
            a = b;
            b = sum;
            System.out.print(sum+" ");
        }
        return sum;
    }
}
