package section2.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * packageName    : section2.problem6
 * fileName       : Solution2
 * author         : Cha
 * date           : 2023-12-02
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-12-02        Cha       최초 생성
 */
public class Solution2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        String arr[] = new String[n];
        for(int i = 0;i<n;i++){
            arr[i] = scan.next();
        }
        List<Integer> answerList = solution(arr);

        for(int i = 0;i<answerList.size();i++){
            System.out.print(answerList.get(i));

            if(i != n-1){
                System.out.print(" ");
            }
        }
    }
    private static List<Integer> solution(String[] arr) {
        List<Integer> reverseList = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            String reverseStrNum = new StringBuilder(arr[i]).reverse().toString();
            int reverseNum = Integer.parseInt(reverseStrNum);

            boolean isPrimeNumber = isReverseNumberPrimeNumber(reverseNum);
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
