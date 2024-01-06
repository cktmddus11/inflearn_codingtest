package section5.problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * packageName    : section5.problem3
 * fileName       : Solutuion1
 * author         : Cha
 * date           : 2024-01-06
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-01-06        Cha       최초 생성
 */
public class Solution1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int board[][] = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                board[i][j] = scan.nextInt();
            }
        }
        int m = scan.nextInt();
        int moves[] = new int[m];
        for(int i = 0;i<m;i++){
            moves[i] = scan.nextInt();
        }
     /*   int n = 5;
        int boards[][] = new int[][]{
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 3 },
                { 0, 2, 5, 0, 1 },
                { 4, 2, 4, 4, 2 },
                { 3, 5, 1, 3, 1 }
        }; // TODO  n 길이 초기화
        int m = 8;
        int moves[] = new int[]{ 1, 5, 3, 5, 1, 2, 1, 4 };*/

        System.out.println(solution(n, board, m, moves));
    }

    private static int solution(int n, int[][] board, int m, int[] moves) {
        int answer = 0;

        // ============== 1. 보드 스택에 담기 ===
        List<Stack> boardList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            Stack<Integer> temp = new Stack<>();
            for (int j = board[i].length-1; j >= 0; j--) {
                if(board[j][i] != 0){
                    temp.push(board[j][i]);
                }
            }
            boardList.add(temp);
        }

        // ============== 2. 리스트 요소 접근해서 스택에서 pop
        Stack<Integer> basket = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int move = moves[i];
            System.out.print(move+"위치의 인형을 뽑았습니다.");

            Stack<Integer> stack = boardList.get(move-1);
            if(stack.isEmpty()){
               continue;
            }
            Integer doll = stack.pop();
            if (basket.isEmpty()) {
                basket.push(doll);
              //  System.out.println("빈 바구니에 인형 "+doll+"을 담습니다.");
            } else {
                if (basket.peek() == doll) {
                    basket.pop();
                  //  System.out.print("바구니에 있는 인형과 뽑은"+doll+"과 동일해서 인형을 꺼냅니다.\n");
                    answer +=2 ;
                } else {
                    basket.push(doll);
                  //  System.out.print("바구니에 있는 인형과 뽑은"+doll+"과 달라서 바구니에 담습니다.\n");

                }
            }

        }

        return answer;
    }


}