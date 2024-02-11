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
public class Solution1 {
    public static void main(String[] args){
        int N = 7;
        System.out.print(1+" "+1+" ");
        dfs(N-2, 1, 1);
    }

    private static void dfs(int n, int first, int second) {
        if(n == 0){
            System.out.println("\n >>> "+second);
            return;
        }else {
            System.out.print((first+second)+" ");
            dfs(--n, second, first+second);
        }
    }
}
