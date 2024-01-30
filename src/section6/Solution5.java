package section6;

import java.util.Arrays;

/**
 * packageName    : section6
 * fileName       : Test
 * author         : Cha
 * date           : 2024-01-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-29        Cha       최초 생성
 */
public class Solution5 {
    public static void main(String[] args) {
        int N = 8;
        int arr[] = {20, 25, 52, 30, 39, 34, 43, 33};
       /* System.out.println("정렬 전 배열: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length-1);
        System.out.println("정렬 후 배열: " + Arrays.toString(arr));*/

        Arrays.sort(arr);
        String answer = "U";
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
                answer = "D";
                break;
            }
        }
        System.out.println(answer);

    }

   /* private static void mergeSort(int[] arr, int left, int right) {
        if(left < right){
            int middle = (left + right ) / 2; // 0 + 5 / 2 = 2

            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);

        }


    }*/


}
