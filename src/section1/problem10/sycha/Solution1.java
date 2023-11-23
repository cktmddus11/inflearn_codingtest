package section1.problem10.sycha;

import java.util.Arrays;
import java.util.Scanner;

/**
 * packageName    : section1.problem10.sycha
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-20        Cha       최초 생성
 * <p>
 * 10. 가장 짧은 문자거리
 * 설명
 * 한 개의 문자열 s와 문자 t가 주어지면
 * 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str[] = scan.nextLine().split(" ");

        String input1 = str[0];
        char input2 = str[1].charAt(0);

        int answer[] = solution(input1, input2);
        for (int a : answer) {
            System.out.print(a + " ");
        }
    }

    private static int[] solution(String input1, char input2) {
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[input1.length()];

        int p = 1000;
        for (int i = 0; i < arr.length; i++) {
            if (input1.charAt(i) == input2) {
                p = 0;
            } else {
                p++;
            }
            arr[i] = p;
        }
        //  System.out.println(Arrays.toString(arr));
        p = 1000;


        for (int i = arr.length - 1; i >= 0; i--) {
            if (input1.charAt(i) == input2) {
                p = 0;
            } else {
                p++;
                arr[i] = Math.min(arr[i], p);  // (a <= b) ? a : b;
            }
        }
      //  System.out.println(Arrays.toString(arr));

        return arr;
    }
}
