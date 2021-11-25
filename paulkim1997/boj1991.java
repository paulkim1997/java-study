import java.util.*;
import java.io.*;

public class boj1991 {
    static int n;
    static Node[] arr;
    static boolean vis[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new Node[n];
        vis = new boolean[n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            Node parent = new Node(st.nextToken());
            Node leftChild = new Node(st.nextToken());
            Node rightChild = new Node(st.nextToken());

            if(!".".equals(leftChild.data))
                parent.leftChild = leftChild;

            if(!".".equals(rightChild.data))
                parent.rightChild = rightChild;

            arr[i] = parent;
        }
        //여기까지 트리 저장 완료

        preOrder(arr[0]);
        sb.append("\n");
        inOrder(arr[0]);
        sb.append("\n");
        postOrder(arr[0]);

        System.out.println(sb);
    }

    static void preOrder(Node start) {
        for(Node node : arr) {
            if(node.data.equals(start.data)) {
                Node left = node.leftChild;
                Node right = node.rightChild;

                sb.append(start.data);
                if(left != null) preOrder(left);
                if(right != null) preOrder(right);
            }
        }
    }

    static void inOrder(Node start) {
        for(Node node : arr) {
            if(node.data.equals(start.data)) {
                Node left = node.leftChild;
                Node right = node.rightChild;

                if(left != null) inOrder(left);
                sb.append(start.data);
                if(right != null) inOrder(right);
            }
        }
    }

    static void postOrder(Node start) {
        for(Node node : arr) {
            if(node.data.equals(start.data)) {
                Node left = node.leftChild;
                Node right = node.rightChild;

                if(left != null) postOrder(left);
                if(right != null) postOrder(right);
                sb.append(start.data);
            }
        }
    }

    static class Node {
        String data;
        Node leftChild;
        Node rightChild;

        public Node(String data) {
            this.data = data;
        }
    }
}
