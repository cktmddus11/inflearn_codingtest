package section7.problem10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * packageName    : section7.problem10
 * fileName       : Solution1
 * author         : Cha
 * date           : 2024-03-03
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-03        Cha       최초 생성
 */
class Node {
    int data;
    Node lt, rt;

    Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class Solution1 {
    Node root;
    public static void main(String[] args) {
        Solution1 tree=new Solution1();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        System.out.println(tree.BFS(tree.root));
    }

    public int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);

        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0;i<len;i++){
                Node cur = Q.poll();
                if(cur.lt == null && cur.rt == null ){
                    return L;
                }
                if(cur.lt != null){
                    Q.offer(cur.lt);
                }
                if(cur.rt != null){
                    Q.offer(cur.rt);
                }
            }
            L++;
        }
        return 0;
    }

}
