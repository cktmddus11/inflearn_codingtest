package section7.problem9;

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

    Node(int val) {
        data = val;

        lt = null;
        rt = null;
    }

    Node lt, rt;
}

public class Solution1 {
    Node root;

    public int DFS(int L, Node root) {
        if (root.lt == null && root.rt == null) { // 말단 노드
            return L;
        } else {
            return Math.min(DFS(L + 1, root.lt), DFS(L + 1, root.rt));
        }
    }

    public static void main(String[] args) {
        Solution1 tree = new Solution1();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        //tree.root.rt.lt = new Node(6);
        System.out.println(tree.DFS(0, tree.root));
    }
}
