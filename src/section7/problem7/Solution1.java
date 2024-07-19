package section7.problem7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * packageName    : section7.problem7
 * fileName       : Solution1
 * author         : Cha
 * date           : 2024-02-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-19        Cha       최초 생성
 */
class Node {
    int data;
    Node lt, rt;
    public Node(int val){
        data = val;
        lt = rt = null;
    }
}
public class Solution1 {
    Node root;
    public static void main(String[] args) {
        Solution1 tree = new Solution1();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);

    }

    private void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        int L = 0;
        while(!Q.isEmpty()){ // 큐가 비어있으면 loop 중단
            int len = Q.size(); // 레벨에 있는 노드의 개수
            System.out.print(L +" : "); // 이진트리 레벨 출력
            for(int i = 0;i < len;i++){
                Node cur = Q.poll();
                System.out.print(cur.data+" "); // 현재 노드의 값
                if(cur.lt != null){
                    Q.add(cur.lt);
                }
                if(cur.rt != null){
                    Q.add(cur.rt);
                }
            }
            L++;
            System.out.println();
        }
    }
}
