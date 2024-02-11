package section7;

/**
 * packageName    : section7
 * fileName       : Solution2
 * author         : Cha
 * date           : 2024-02-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        Cha       최초 생성
 */
public class Solution2 {
    public static void main(String[] args) {
        int N = 11;
        dfs(N);
    }

    private static void dfs(int n) {

        if (n == 0) return;
        else {
            dfs(n / 2);
            System.out.print(n % 2);
        }

    }
}
