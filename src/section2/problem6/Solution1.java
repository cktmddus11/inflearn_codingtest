package section2.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * packageName    : section2.problem6
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-12-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        Cha       최초 생성
 *
 * 6. 뒤집은 소수
 *
 * 설명
 *
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
 * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
 *
 */
public class Solution1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scan.nextInt();
        }
/*
        for(int i = 0;i<n;i++){
          System.out.println(arr[i]);
        }*/


        List<Integer> answerList = solution(arr);

        for(int i = 0;i<answerList.size();i++){
            System.out.print(answerList.get(i));

            if(i != n-1){
                System.out.print(" ");
            }
        }


    }

    private static List<Integer> solution(int[] arr) {
        List<Integer> reverseList = new ArrayList<>();
        for(int i = 0;i<arr.length;i++) {
            int number = arr[i];
            int reverseNum = 0;

            while(number != 0) {
                reverseNum = (number % 10) + (reverseNum * 10);
                number = number / 10;
            }

            Boolean isPrimeNumber = isReverseNumberPrimeNumber(reverseNum);

            if(isPrimeNumber){
                reverseList.add(reverseNum);
            }



        }
        return reverseList;
    }

    private static Boolean isReverseNumberPrimeNumber(int reverseNum) {
        if(reverseNum < 2){
            return false;
        }
        boolean isPrimeNumber = true;
        for(int j = 2; j<=Math.sqrt(reverseNum); j++){
            if(reverseNum % j == 0){
                isPrimeNumber = false;
                break;
            }
        }
        return isPrimeNumber;
    }
}
