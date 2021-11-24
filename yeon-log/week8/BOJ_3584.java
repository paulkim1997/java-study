import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3584 {

    private static int parent[];
    private static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            check = new boolean[N + 1];

            // 초기화
            for (int i = 1; i <= N; i++) {
                check[i] = false;
                parent[i] = i;
            }
            // 간선 정보 저장
            for (int j = 0; j < N - 1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                parent[B] = A; // A가 B의 부모
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 가장 가까운 공통 조상을 구할 두 노드
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            check[u] = true;

            // 루트 노드가 주어지지 않음: 더이상 못 올라가는 상황이 될 때의 노드 찾기
            // u의 부모를 체크하며 찾기
            while (u != parent[u]) {
                u = parent[u];
                check[u] = true;
            }
            while (true) {
                if (check[v]) { // v를 체크했으면(v가 u의 조상) 출력
                    System.out.println(v);
                    break;
                }
                // 체크하지 않은 경우 부모찾기
                v = parent[v];
            }
        }
    }
}