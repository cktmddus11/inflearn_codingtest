package section7.problem8;

import java.util.LinkedList;
import java.util.Queue;

/**
 * packageName    : section7.problem8
 * fileName       : Solution1
 * author         : Cha
 * date           : 2024-02-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-20        Cha       최초 생성
 */

public class Solution1 {
    public static void main(String[] args){
        int S = 5;
        int E = 14;

        int answer = solution(S, E);
        System.out.println(answer);
    }

    private static int solution(int S, int E) {
        Solution1 tree = new Solution1();

        int minDistance = BFS(S, E);
        return minDistance;
    }

    private static int BFS(int rootNum, int endNum) {
        int level = 0;
        int ch[] = new int[100001]; // 이미 지나간 1 ~ 10000 위치를 저장하기 위함.
        int jump[] = {1, -1, 5};

        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootNum);

        while(!queue.isEmpty()){
            int len = queue.size(); // 레벨에 있는 노드의 수
            System.out.print(level +" : "); //

            for(int i = 0;i<len;i++){
                int cur = queue.poll();
                for(int j = 0;j<jump.length;j++){
                    int idx = rootNum + jump[j];
                    
                    // 이동한 위치에 이미 간적이 있으면 큐에 넣지 않기 위해
                    if(ch[idx] == 1){ // 이미 지나간 길이면 X

                    }else if (idx == endNum){  // 찾을 위치에 도달했으면
                        return level+1;
                    }else { // 이미 지나가지 않았으면
                        ch[idx] = 1;
                        queue.add(idx);
                    }


                }
            }
            level++;
            System.out.println();
        }

        return level;
    }
}
