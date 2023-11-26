package section2.problem3;

import java.util.Scanner;

/**
 * packageName    : section2.problem3
 * fileName       : Solution1
 * author         : Cha
 * date           : 2023-11-26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023-11-26        Cha       최초 생성
 *
 * 3. 가위바위보 
 * 두사람의 이기는 경우가 각각 발생하는 경우 
 * 한사람의 경우를 기준으로 작성하자
 *
 * 'A가 이기는 경우를 기준으로
 * 
 * TODO 다시
 *
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int aArr[] = new int[n];
        int bArr[] = new int[n];

        for (int i = 0; i < aArr.length; i++) {
            aArr[i] = scan.nextInt();
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = scan.nextInt();
        }

        String[] answer = solution(aArr, bArr);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

    // 1 가위 , 2 바위 , 3 보,
    // 이긴사람 출력 A, B / D 비김
    private static String[] solution(int[] aArr, int[] bArr) {
        String winner[] = new String[aArr.length];
        for (int i = 0; i < aArr.length; i++) {
            int a = aArr[i];
            int b = bArr[i];
            
            if(a == b) winner[i] = "D";
            else if(a==1 && b==3) winner[i] = "A";
            else if(a==2 && b==1) winner[i]  = "A";
            else if(a==3 && b==2) winner[i]  = "A";
            else  winner[i]  = "B";

        }
        return winner;
    }

}
