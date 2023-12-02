package section2.problem8;

import java.util.*;

/**
 * packageName    : section2.problem8
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-12-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        Cha       최초 생성
 *
 * 8. 등수구하기  =>  TIP : 나보다 큰 수있으면 증감시키기
 * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
 * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
 * 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
 *
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int [] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        int[] answer = solution(arr);
        for(int i = 0;i<n;i++){
            System.out.print(answer[i]+" ");
        }
    }
    private static int[] solution(int[] arr) {
        int [] answer = new int[arr.length];


        for(int i = 0;i<arr.length;i++){
            int targetScore = arr[i];
            int grade = 1;
            for(int j = 0;j<arr.length;j++){
                int score = arr[j];
                if(targetScore < score){
                    grade++;
                }
            }
            answer[i] = grade;

        }

        return answer;
    }

}
