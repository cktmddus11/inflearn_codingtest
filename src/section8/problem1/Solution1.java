package section8.problem1;

import java.awt.print.Pageable;
import java.util.*;

/**
 * packageName    : section7.problem9
 * fileName       : Solution1
 * author         : Cha
 * date           : 2024-02-27
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-27        Cha       최초 생성
 * <p>
 * 합이 같은 부분집합(DFS : 아마존 인터뷰)
 * STEP1 모든 경우의 수 구하기
 * STEP2 빈집합인 경우는 제외 //
 */
public class Solution1 {
    public static void main(String[] args) {

 /*       int sum = //6;
         9;
        int arr[] = //{2, 4, 5, 10, 12, 13};
                 {3, 6, 13, 11, 7 ,16, 34, 23, 12};//{1, 3, 5, 6, 7, 8};*/

        Scanner scan = new Scanner(System.in);
        int sum = scan.nextInt();
        int arr[] = new int[sum];
        for(int i = 0;i<sum;i++){
            arr[i] = scan.nextInt();
        }
        String answer = solution(sum, arr);
        System.out.println(answer);
    }

    static int[] ch;
    static int arr2[];

    private static String solution(int sum, int[] arr) {
        ch = new int[arr.length];
        arr2 = arr;
        DFS(0);

       // System.out.println("cnt = " + cnt);
        return check == 1 ? "YES" : "NO";
    }

 //   static int cnt = 0;
    static Set<List> set = new HashSet<>();

    static int check = -1;

    private static void DFS(int idx) {
        if (idx == arr2.length) {
            List<Integer> list = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 1) {
                    list.add(arr2[i]);
                } else {
                    list2.add(arr2[i]);
                }
            }
            if (list.size() != arr2.length && list2.size() != arr2.length) {
                boolean isNotContainsSet = !set.contains(list) || !set.contains(list);
                if (isNotContainsSet) {
                    set.add(list);
                    set.add(list2);
//                    list.forEach(i -> System.out.print(i + " "));
//                    System.out.print("|");
//                    list2.forEach(i -> System.out.print(i + " "));
//                    System.out.println();
             //       cnt++;
                    int listSum = list.stream().reduce(0, Integer::sum);
                    int listSum2 = list2.stream().reduce(0, Integer::sum);
//                    System.out.println(listSum);
//                    System.out.println(listSum2);

                    if(listSum == listSum2){
                        check = 1;
                    }
                }
            }
        } else {
            ch[idx] = 1;
            DFS(idx + 1);

            ch[idx] = 0;
            DFS(idx + 1);
        }
    }
}
