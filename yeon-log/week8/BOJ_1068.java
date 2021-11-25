import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1068 {

    private static int N;
    private static int[] arr;
    private static int delN, leafN = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int root = 0; // root 는 입력에 따라 달라지므로
        N = Integer.parseInt(br.readLine()); // 노드의 개수
        arr = new int[50];
        String s = br.readLine(); // 각 노드의 부모
        delN = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(s);

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            // 부모가 없는 node 는 root
            if (arr[i] == -1) root = i;
        }
        if (delN != root) search(root);
        else leafN = 0;
        System.out.print(leafN);
    }

    static void search(int r) {
        int check = 0;
        for (int i = 0; i < N; i++) {
            // 해당 node 를 바라보는 자식 node 가 있고 삭제할 node 가 아니라면 리프노드 X
            if (arr[i] == r && i != delN) {
                check = 1;
                search(i);
            }
        }
        if (check == 0) leafN++;
    }
}