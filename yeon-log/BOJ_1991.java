import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1991 {

    static StringBuilder pre = new StringBuilder();
    static StringBuilder in = new StringBuilder();
    static StringBuilder post = new StringBuilder();
    static Map<String, List<String>> map;
    static String parent, left, right;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 이진 트리의 노드의 개수
        map = new HashMap<>();

        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드
            parent= st.nextToken(); left = st.nextToken(); right = st.nextToken();
            List <String> list = new ArrayList<>();
            list.add(left); list.add(right);
            map.put(parent, list);
        }
        System.out.println(preOrder("A"));
        System.out.println(inOrder("A"));
        System.out.println(postOrder("A"));
    }
    // 전위순회: 루트-왼쪽자식-오른쪽자식
    public static String preOrder(String input) {
        if(input.equals(".")) return input;
        pre.append(input);
        preOrder(map.get(input).get(0));
        preOrder(map.get(input).get(1));
        return pre.toString();
    }
    // 중위순회: 왼쪽자식-루트-오른쪽자식
    public static String inOrder(String input) {
        if(input.equals(".")) return input;
        inOrder(map.get(input).get(0));
        in.append(input);
        inOrder(map.get(input).get(1));
        return in.toString();
    }
    // 후위순회: 왼쪽자식-오른쪽자식-루트
    public static String postOrder(String input) {
        if (input.equals(".")) return input;
        postOrder(map.get(input).get(0));
        postOrder(map.get(input).get(1));
        post.append(input);
        return post.toString();
    }
}