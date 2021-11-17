import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606 {

    static private int N, conn;
    static private boolean[] virus;
    static private boolean[][] arr;
    static private int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        conn = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍

        virus = new boolean[N+1];
        arr = new boolean[N+1][N+1];

        for (int i = 0; i < conn; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = true; arr[y][x] = true; // 간선연결
        }
        dfs(1);
        System.out.print(cnt);
    }

    static void dfs(int now) {
        virus[now] = true; // 방문처리
        for (int next = 2; next <= N; next++) {
            // 이미 바이러스를 확인했거나 연결된 곳이 아니면 패스
            if (virus[next] || !arr[now][next]) continue;
            cnt++; // 바이러스 감염
            dfs(next);
        }
    }
}
