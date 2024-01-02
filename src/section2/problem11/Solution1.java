package section2.problem11;

import java.util.Scanner;

/**
 * packageName    : section2.problem11
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-26        Cha       최초 생성
 * 11. 임시반장 정하기
 *
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int arr[][] = new int[n][n];

        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[i].length;j++){
                arr[i][j] = scan.nextInt();
            }
        }

        int answer = solution(n, arr);
        System.out.println(answer);
    }
    private static int solution(int n, int[][] arr){
        int answer = 0;

        int MAX = 0;
        for (int i =0; i < 5; i ++){ // 학년
            int cnt = 0;
            for (int j=0; j < n;j++){ // 학생
                int temp = arr[j][i]; // 2
                for (int k =0; k <n; k++){  // 다른 학생
                    if (k == j) continue;  // 0 == 0
                    else if (temp == arr[k][i]){
                        cnt++;
                    }
                }
                if (cnt > MAX){
                    MAX = cnt;
                    answer = j;
                }
            }
        }
        return answer;
    }
}
