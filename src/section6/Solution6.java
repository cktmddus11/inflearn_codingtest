package section6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * packageName    : section6
 * fileName       : Solution6
 * author         : Cha
 * date           : 2024-01-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-29        Cha       최초 생성
 */
public class Solution6 {
    public static void main(String[] args) {
      //  int N = 9;
      //  int arr[] = {120, 125, 152, 130, 135, 135, 143, 127, 160};

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int arr[] = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = scanner.nextInt();
        }

        int[] answer = solution(arr);

        for(int i = 0;i<answer.length;i++){
            System.out.print(answer[i]+" ");
        }
    }

    private static int[] solution(int[] arr) {
        int tmp[] = arr.clone();

        //  System.out.println("정렬 후 =");
        Arrays.sort(tmp);
        //   System.out.println(Arrays.toString(tmp));

        int answer[] = new int[2];
        int cnt = 0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] != tmp[i]){
                 answer[cnt] = i+1;
                 cnt++;
            }
        }
        //  System.out.println(Arrays.toString(answer));
        return answer;
    }
}
