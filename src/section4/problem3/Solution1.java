package section4.problem3;

import java.util.*;

/**
 * packageName    : section4.problem3
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-12-31
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-31        Cha       최초 생성
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        List answer = solution(n, k, arr);
        /*for(int a  : answer){
            System.out.print(a+" ");
        }*/
    }

    private static List solution(int n, int k, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        int lt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<k-1;i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }


        for (int rt = 0; rt < arr.length; rt++) {

        }


        return answer;
    }
}
