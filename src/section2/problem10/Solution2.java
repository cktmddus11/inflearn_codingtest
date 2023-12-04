package section2.problem10;

import java.util.Scanner;

/**
 * packageName    : section2.problem10
 * fileName       : Solution2
 * author         : Cha
 * date           : 2023-12-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-04        Cha       최초 생성
 * 
 * TIP : 상하좌우만을 확인하지만 다른 문제에서 다양한 부분을 확인할 수 있기 때문에
 * 확인할 위치의 인덱스를 저장한 배열을 선언하고 loop를 돌리는 방식 추천
 * 
 * TODO 다시풀기
 */
public class Solution2 {
    final int[] dx = {-1,  0, 1,  0};// 행
    final int[] dy = { 0,  1, 0, -1}; // 열
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int arr[][] = new int[n][n];

        for (int i = 0; i < n; i++) { //  행
            for (int j = 0; j < n; j++) { // 열
                arr[i][j] = scan.nextInt();
            }
        }

        int answer = solution2.solution(n, arr);
        System.out.println(answer);


    }
    private  int solution(int n, int[][] arr) {
        int cnt = 0;
        for (int i = 0; i < n; i++) { //  행
            for (int j = 0; j < n; j++) { // 열
                int num = arr[i][j];

                boolean isTop = isTopCheck(n, arr, i, j, num);
                if(isTop){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isTopCheck(int n, int[][] arr, int i, int j, int num) {
        boolean isTop = true;
        for(int k =0;k<dx.length;k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            int cNum = arr[nx][ny];

            // 봉오리가 아닌조건
            if(nx >= 0 && nx < n && ny >= 0 && ny < n // 배열을 벗어난 상하좌우 조회를 막기위한 조건. outofIndex 방지
                    && cNum >= num // 확인지점이 상하좌우보다 크거나 같은 값이 있으면 봉오리아님.
            ) {
                isTop = false;
                break;
            }
        }


        return isTop;
    }
}