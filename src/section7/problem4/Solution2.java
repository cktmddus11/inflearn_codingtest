package section7.problem4;

/**
 * packageName    : section7
 * fileName       : Solution4
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
        int N = 7;

        int answer = dfs(N);
        System.out.println(answer);
    }

    private static int dfs(int n) {
        if(n == 1) return 1;
        else if (n == 2) return 1;
        else
            return dfs(n-1)+ dfs(n-2);
    }
}
