package section8.problem1;

/**
 * packageName    : section8.problem1
 * fileName       : Solution2
 * author         : Cha
 * date           : 2024-03-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-03        Cha       최초 생성
 */
public class Solution2 {
    static String answer="NO";
    static int n, total=0;
    boolean flag=false;
    public static void main(String[] args){
        Solution2 tree = new Solution2();
        int sum = //6;
                9;
        int arr[] = //{2, 4, 5, 10, 12, 13};
                {3, 6, 13, 11, 7 ,16, 34, 23, 12};//{1, 3, 5, 6, 7, 8};*/

        n = sum;

        tree.DFS(0, 0, arr);
        System.out.println(answer);

    }

    private void DFS(int L, int sum, int[] arr) {
        if(flag) return;
        if(sum > total / 2) return;
        if(L == n){
            if((total - sum) == sum){
                answer = "YES";
                flag = true;
            }
        }	else{
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }
}
