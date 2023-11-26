package section2.problem2;

import java.util.Scanner;

/**
 * packageName    : section2.problem2
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-26        Cha       최초 생성
 * 
 * 2. 보이는 학생
 * 
 */
public class Solution1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = scan.nextInt();
        }

        int answer = solution(n, arr);
        System.out.println(answer);
    }

    public static int solution(int n, int[] arr){
        int cnt = 1;
        int min = arr[0];

        for(int i = 1;i<n;i++){
            if(min < arr[i]){
                cnt++;
                min = arr[i];
            }
        }

        return cnt;
    }
}
