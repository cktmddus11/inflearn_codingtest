package section6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * packageName    : section6
 * fileName       : Solution4
 * author         : Cha
 * date           : 2024-01-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-26        Cha       최초 생성
 * <p>
 * 4. Least Recently Used
 * 최근사용한걸 사용하는 캐시메모리
 * <p>
 * 삽입정렬을 활용해서 현재값을 뒤의 인덱스로 이동시킴.
 * 캐시 miss 일때는 뒤에서 부터 다 밀어야하고
 * 캐시 hit일 때는 hit 위치부터 땡기고 맨앞에 값을 넣어주면 됨.
 */
public class Solution4 {
    public static void main(String[] args) {
//        int S = 5; // 캐시 크기
//        int N = 9; // 작업의 개수
//        int arr[] = {1, 2, 3, 2, 6, 2, 3, 5, 7};
        Scanner scan = new Scanner(System.in);
        int S = scan.nextInt();
        int N = scan.nextInt();

        int arr[] = new int[N];
        for(int t = 0;t<N;t++){
            arr[t] = scan.nextInt();
        }

        printCacheStatus(S, arr);
    }

    private static void printCacheStatus(int S, int[] arr) {
        int tmp[] = new int[S];

        for (int i = 0; i < arr.length; i++) {
            int idx = -1;
            for (int j = 0; j < tmp.length; j++) {
                if (arr[i] == tmp[j]) { // chache hit
                   // System.out.println("chache hit value = " + arr[i] + ", idx = " + j);
                    idx = j;
                    break;
                } else {
                    idx = S - 1;
                }
            }

            for (int z = idx; z >= 1; z--) {
                tmp[z] = tmp[z - 1];
            }
            tmp[0] = arr[i];
            //System.out.println(Arrays.toString(tmp));
            for(int p : tmp){
                System.out.print(p+" ");
            }
            System.out.println();

        }



    }


}

