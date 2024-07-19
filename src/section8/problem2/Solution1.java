package section8.problem2;

/**
 * packageName    : section8.problem2
 * fileName       : Solution
 * author         : Cha
 * date           : 2024-03-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-03        Cha       최초 생성
 */
/*class Node {
    int data;
    Node(int val){
        data = val;
        lt = rt = null;
    }
    Node lt, rt;

}*/
public class Solution1 {
    public static void main(String[] args){
        int C = 259;
        int N = 5;

        int arr[] = {81, 58, 42, 33, 61};

        int answer = solution(C, N, arr);
        System.out.println(answer);
    }

    static int max;
    static int total = 0;
    private static int solution(int c, int n, int[] arr) {
        max = c;
        DFS(0, 0, arr);
        return 0;
    }


    private static void DFS(int L, int sum, int[] arr) {
     //   if(sum > total / 2) return;
//        if(L == ){
//            if((total - sum) == sum){
//                answer = "YES";
//                flag = true;
//            }
//        }	else{
//            DFS(L+1, sum+arr[L], arr);
//            DFS(L+1, sum, arr);
//        }
    }
}
