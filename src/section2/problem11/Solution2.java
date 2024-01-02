package section2.problem11;

import java.util.Scanner;

/**
 * packageName    : section2.problem11
 * fileName       : Solution2
 * author         : Cha
 * date           : 2023-11-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-26        Cha       최초 생성
 *
 * 11. 임시반장 정하기
 * 김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
 * 김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로
 * 선거를 통해 반장을 선출하려고 한다.
 * 그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을
 * 임시 반장으로 정하려 한다.
 * 그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.
 */

public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int arr[][] = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scan.nextInt();
            }
        }

        int answer = solution(n, arr);
        System.out.println(answer);
    }

    private static int solution(int n, int[][] arr) {
        int answer = 0;
        int temp[] = new int[n]; // 각 학생이 같은반이 된횟수


        int cnt = 0;
        for (int i = 0; i < n; i++) { // 확인 학생
            for (int grade = 0; grade < 5; grade++) { //  5학년
                int student = arr[i][grade];
                for (int j = 0 ; j < n; j++) { // 비교학생
                    if(i == j){
                        break;
                    }

                    // 같은 학년 끼리 같은 반있는지 확인하므로 행 증감
                    int compareStudent = arr[j][grade];
                    if ( student == compareStudent) {
                        cnt++;
                    }
                }

            }
            temp[i] = cnt;
          //  System.out.println(i+1+"학생 : "+ temp[i]);
        }
        int min = 0;
        for(int i = 0;i<n;i++){
            if(min < temp[i]){
                answer = i+1;
                min = temp[i];
            }
        }
        return answer;
    }

}
