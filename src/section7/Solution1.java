package section7;

/**
 * packageName    : section7
 * fileName       : Solution1
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
        int n = 3;
        dfs(n);
    }

    private static void dfs(int n) {
        if(n == 0){
            return;
        }else{
            dfs(n-1);
            System.out.println(n);
        }
    }

}
