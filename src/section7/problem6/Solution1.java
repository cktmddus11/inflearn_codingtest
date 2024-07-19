package section7.problem6;

import section2.problem10.Solution2;

/**
 * packageName    : section7.problem6
 * fileName       : Solution1
 * author         : Cha
 * date           : 2024-02-12
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-12        Cha       최초 생성
 */
public class Solution1 {
    static int n;
    static int[] ch; // 부분집합 사용유무 체크를 위함.

    public void DFS(int L) {
        if(L == n+1){ // 집합 한개 완성으로 종료지점.
            for(int i = 1;i<ch.length;i++){
                if(ch[i] == 1){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
        }else{
            ch[L] = 1;
            DFS(L+1); // 왼쪽 자식
            ch[L] = 0;
            DFS(L+1); // 오른쪽 자식
        }
    }

    public static void main(String[] args) {
        n = 3;
        ch = new int[n+1]; // 0, /  0, 0, 0 =>
        Solution1 s = new Solution1();
        s.DFS(1);

    }
}
