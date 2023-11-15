package section1.problem4.sycha;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * packageName    : section1.problem4.sycha
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-15
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-15        Cha       최초 생성
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int wordCnt = scan.nextInt();

        String[] wordArr = new String[wordCnt];
        for(int i = 0;i<wordCnt;i++){
            wordArr[i] = scan.next();
        }

        List<String> answerList = solution(wordArr);
        answerList.forEach(System.out::println);
    }

    private static List<String> solution(String[] wordArr) {
        List<String> answerList = new ArrayList<>();
        for(String word : wordArr){
            char[] wordCharArray = word.toCharArray();
            int leftIdx = 0;
            int rightIdx = wordCharArray.length-1;
            // 0 1 2 3
            while(leftIdx < rightIdx){
                char temp = wordCharArray[leftIdx];
                wordCharArray[leftIdx] = wordCharArray[rightIdx];
                wordCharArray[rightIdx] = temp;
                leftIdx++;
                rightIdx--;
            }
            answerList.add(String.valueOf(wordCharArray));
        }
        return answerList;
    }
}
