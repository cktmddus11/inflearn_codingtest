package section6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * packageName    : section6
 * fileName       : Solution7
 * author         : Cha
 * date           : 2024-01-30
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-30        Cha       최초 생성
 */
public class Solution7 {
    public static void main(String[] args){
//        int N = 5;
//        int arr[][] = {
//                {2, 7},
//                {1, 3},
//                {1, 2},
//                {2, 5},
//                {3, 6}
//        };
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int arr[][] = new int[N][2];
        for(int i = 0;i<N;i++){
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }

        solution(arr);


        for(int i = 0;i<N;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }




    }

    private static void solution(int[][] arr) {
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//              if(o1[0] > o2[0]){ // x 좌표 오름 차순
//                  return o1[0] - o2[0];
//              }else if(o1[0] == o2[0]){ // x 좌표 동일하면
//                  return o1[1] - o2[1]; // y 좌표 오름차순
//              }else {
//                  return o1[0] - o2[0];
//              }
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            };
        });
    }
}
