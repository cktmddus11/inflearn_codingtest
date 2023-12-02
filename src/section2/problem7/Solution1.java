package section2.problem7;

import java.util.Scanner;

/**
 * packageName    : section2.problem7
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-12-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        Cha       최초 생성
 *
 * 7. 점수계산
 *
 */
public class Solution1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = scan.nextInt();
        }

      /*  for(int i = 0;i<n;i++){
          System.out.println(arr[i]);
        }*/

        int answer = solution(arr);
        System.out.println(answer);

    }

    private static int solution(int[] arr){
       // int answer [] = new int[arr.length];
        int answer = 0;

        int point = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 1){
                point++;
                answer += point;
              //  point = answer[i];
            }else{
                point = 0;
            }
        }
        return answer;
    }

}
