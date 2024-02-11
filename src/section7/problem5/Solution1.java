package section7.problem5;

import section5.problem1.Solution;

import java.util.PriorityQueue;

/**
 * packageName    : section7.problem5
 * fileName       : Solution1
 * author         : Cha
 * date           : 2024-02-11
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-11        Cha       최초 생성
 * 
 * 전위  - 부모 , 왼쪽, 오른쪽
 * 중위  - 왼쪽, 부모, 오른쪽
 * 후위  - 왼쪽, 오른쪽, 부모
 * 
 * 
 */
class Node {
    int data;
    Node lt, rt; // 노드의 자식노드를 참조하는 객체
    public Node(int val){
        data = val; // data : 노드의 값
        lt = rt = null;
    }
}
public class Solution1 {
    Node root;
    // 전위
    public void preorderTraversal (Node root){
        if(root == null){
            return;
        }else {
            System.out.print(root.data+" ");
            preorderTraversal (root.lt);
            preorderTraversal (root.rt);
        }
    }
    public void inorderTraversal (Node root){
        if(root == null){
            return;
        }else {
            inorderTraversal (root.lt);
            System.out.print(root.data+" ");
            inorderTraversal (root.rt);
        }
    }
    public void postorderTraversal (Node root){
        if(root == null){
            return;
        }else {
            postorderTraversal (root.lt);
            postorderTraversal (root.rt);
            System.out.print(root.data+" ");
        }
    }
    public static void main(String[] args){
        Solution1 tree = new Solution1();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        System.out.print("전위 >> ");
        tree.preorderTraversal(tree.root);
        System.out.println();
        System.out.print("중위 >> ");
        tree.inorderTraversal(tree.root);
        System.out.println();
        System.out.print("후위 >> ");
        tree.postorderTraversal(tree.root);


    }
}
