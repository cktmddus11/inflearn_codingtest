package section5.problem6;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * packageName    : section5.problem6
 * fileName       : Solution1
 * author         : Cha
 * date           : 2024-01-16
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-16        Cha       최초 생성
 */
public class Solution1 {
    public static void main (String[] args) {
        int n = 8;
        int k = 3;

        int answer = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        int popIdxArr[] = new int[n - 1];
        popIdxArr[0] = k;
        int temp [] = { 6, 1, 5, 2, 8, 4 };


        for(int i = 0;i<temp.length;i++){
            popIdxArr[i+1] = temp[i];
        }
        System.out.println(Arrays.toString(popIdxArr));


        for (int i = 0; i < popIdxArr.length; i++) {
            queue.add(popIdxArr[i]);
        }
        while (!queue.isEmpty()) {
            for (int i = 1; i <= n; i++) {
                if (queue.peek() == i) {
                    queue.poll();
                    break;
                }else if(queue.peek() != i){
                    int p = queue.poll();
                    queue.add(p);
                }else {
                    answer = queue.poll();
                }
            }
        }

        System.out.println(answer);
    }
}
