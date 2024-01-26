//package section5.problem8;
//
//import java.util.*;
//
///**
// * packageName    : section5.problem8
// * fileName       : Solution1
// * author         : Cha
// * date           : 2024-01-24
// * description    :
// * ===========================================================
// * DATE              AUTHOR             NOTE
// * -----------------------------------------------------------
// * 2024-01-24        Cha       최초 생성
// */
//public class Solution1 {
//    public static void main(String[] args) {
//        int n = 5;
//        int m = 2;
//        int arr[] = {60, 50, 70, 80, 90};
//
//        int answer = 0;
//
//        answer = solution(arr, m, answer);
//        System.out.println(answer);
//
//
//    }
//
//    private static int solution(int[] arr, int m, int answer) {
//        Stack<Integer>
//
//
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i : arr) {
//            queue.add(i);
//        }
//        int idx = 0; // 몇번째 진료 받는 환자인지 증감
//        while (!queue.isEmpty()) {
//            int cur = queue.poll();
//            if (!queue.isEmpty()) {
//                int next = queue.peek();
//                if (cur < next) {
//                    queue.add(cur);
//                    continue;
//                }
//            }
//            System.out.println("현재 진료자는 "+cur);
//            idx++;
//            map.put(idx, cur);
//            if (idx == m) {
//                answer = cur;
//            }
//        }
//        return map.get(m);
//    }
//}
