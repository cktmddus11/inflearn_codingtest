package section2.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * packageName    : section2.problem1
 * fileName       : Solution2
 * author         : Cha
 * date           : 2023-11-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-26        Cha       최초 생성
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<arr.length;i++){
            arr[i] = scan.nextInt();
        }

        List<Integer>  answerList = solution(n, arr);
        for(int a : answerList){
            System.out.print(a+" ");
        }

    }
    public static List<Integer> solution(int n, int[] arr){
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for(int i = 1;i<arr.length;i++){
            if(arr[i] > arr[i-1]){
                answer.add(arr[i]);
            }
        }
        return answer;
    }
}
