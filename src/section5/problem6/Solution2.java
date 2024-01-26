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
public class Solution2 {
    public static void main (String[] args) {
        int n = 8;
        int k = 3;

        int answer = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1;i<=n;i++){
            queue.add(i);
        }
        int arr[] = new int[n-1];
        arr[0] = k;
        int temp[] = {6, 1, 5, 2, 8, 4};
        for(int i = 1;i<arr.length;i++){
            arr[i] = temp[i-1];
        }
        System.out.println(Arrays.toString(arr));

        while(queue.size() != 1){
            Integer p = queue.peek();
            for(int i = 0;i<arr.length;i++){
                if(arr[i] == p){
                    System.out.println("arr[i] = "+arr[i] +" p = "+p);
                    queue.poll();
                    break;
                }
            }
        }

       answer =  queue.peek();

        System.out.println(answer);

    }
}
