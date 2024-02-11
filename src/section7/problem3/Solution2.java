
package section7.problem3;

/**
 * packageName    : section7
 * fileName       : Solution3
 * author         : Cha
 * date           : 2024-02-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        Cha       최초 생성
 */
public class Solution2 {
    public static void main(String[] args){
        int N = 5;
        int answer = dfs(N);
        System.out.println(answer);
    }

    private static int dfs(int n) {
        if(n == 1){
            return 1;
        }else{
           return n * dfs(n-1);
        }
    }
}
