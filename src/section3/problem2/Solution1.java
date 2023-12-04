package section3.problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * packageName    : section3.problem2
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-12-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-04        Cha       최초 생성
 */
public class Solution1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr1 = new int[n];
        for(int i =0;i<n;i++){
            arr1[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        int[] arr2 = new int[m];
        for(int i =0;i<m;i++){
            arr2[i] = scan.nextInt();
        }
        List<Integer> answer = solution(n, arr1, m, arr2);
        for(int i = 0;i<answer.size();i++){
            System.out.print(answer.get(i)+" ");
        }
    }

    private static List solution(int n, int[] arr1, int m, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);


        List<Integer> answer = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        while(index1 < n && index2 < m){
            if(arr1[index1] == arr2[index2]){
                answer.add(arr1[index1++]);
                index2++;
            }else if(arr1[index1] > arr2[index2]){
                index2++;
            }else {
                index1++;
            }
        }


        return answer;
    }

}
