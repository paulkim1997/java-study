import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {

    static int N, M;
    static int[] arr;
    static boolean[] visited = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(0);
    }
    static void dfs(int x) {
        if (x == M) { // 선택한 원소의 개수와 M의 개수가 같다면
            // 사전 순으로 증가하는 순서로 출력
            for (int i : arr) System.out.print(i+" ");
            System.out.print("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[x] = i;
            dfs(x + 1);
            visited[i] = false;
        }
    }
}
