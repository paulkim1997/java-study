import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5639 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node node = new Node(Integer.parseInt(br.readLine()));
        String str = "";
        // 입력이 없을때까지 노드 추가
        while((str = br.readLine()) != null && str.length() != 0)
            node = node.add(node, Integer.parseInt(str));
        // 전위순회는 트리 노드 입력과 같으므로 바로 후위순회
        postOrder(node);
    }

    // 후위순회: 왼쪽자식-오른쪽자식-루트
    static void postOrder(Node node) {
        if(node.left!=null) postOrder(node.left);
        if(node.right!=null) postOrder(node.right);
        System.out.println(node.num);
    }
}

class Node {
    public int num;
    public Node left;
    public Node right;

    public Node(int num) {
        this.num = num;
        this.left=null;
        this.right=null;
    }

    // 받은 노드로 이진 탐색 트리 구성하기
    public Node add(Node node, int n) {
        Node cur = null;
        // 최초 노드 생성
        if (node == null) return new Node(n);
        // 왼쪽자식, 오른쪽자식 만들기
        if (node.num >= n) {
            cur = add(node.left, n);
            node.left = cur;
        }
        else if (node.num < n) {
            cur = add(node.right, n);
            node.right = cur;
        }
        return node;
    }
}
