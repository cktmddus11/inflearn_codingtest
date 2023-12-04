package section2.problem10;

import java.util.Scanner;

/**
 * packageName    : section2.problem10
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-12-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-04        Cha       최초 생성
 *
 * 10. 봉우리
 * 설명
 *
 * 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
 * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
 * 격자의 가장자리는 0으로 초기화 되었다고 가정한다.
 *
 * TIP : 상하좌우 숫자보다 큰숫자가 봉우리 => 같은 값도 안됨.
 *
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int arr[][] = new int[n+2][n+2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

     /*   for(int i = 0;i<n+2;i++){
            for(int j = 0;j<n+2;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }*/
        int answer = solution(n, arr);
        System.out.println(answer);

    }

    private static int solution(int n, int[][] arr) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
               int num = arr[i][j];
               boolean isTop = num > arr[i+1][j] && num > arr[i][j+1] && num > arr[i - 1][j] && num > arr[i][j - 1 ];
                if(isTop){
                    System.out.println(num);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
