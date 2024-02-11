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
public class Solution1 {
    public static void main(String[] args){
        int N = 5;
        dfs(N, 1);
    }

    private static void dfs(int n, int sum) {
        if(n == 0){
            System.out.println(sum);
            return;
        }else{
            sum *= n--;
            dfs(n, sum);
        }
    }
}
