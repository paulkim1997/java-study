import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import static java.lang.Math.max;

public class BOJ_17086 {

    // 인접한 8방향 (대각선 포함) -> 좌,우,상,하,우상,우하,좌상,좌하
    private static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    private static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    private static int N, M;
    private static Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int dist[][] = new int[N][M];

        // 어떤 칸의 안전 거리는 그 칸과 가장 거리가 가까운 아기 상어와의 거리
        // 자기 자신의 칸을 포함하여 계산

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                // 0은 빈 칸, 1은 아기 상어가 있는 칸
                map[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = 987654321;
                if (map[i][j] == 1) { // 아기 상어 있는 칸 체크
                    queue.add(i); queue.add(j);
                    dist[i][j] = 0;
                }
            }
        }
        int safeDist = 0; // 안전 거리 지역 최댓값

        while (!queue.isEmpty()) { // bfs
            int cx = queue.poll(), cy = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 갈 수 있는 위치에 한해서 안전거리 최댓값 갱신
                    if (dist[nx][ny] > dist[cx][cy] + 1) {
                        dist[nx][ny] = dist[cx][cy] + 1;
                        queue.add(nx); queue.add(ny);
                        safeDist = max(dist[nx][ny], safeDist);
                    }
                }
            }
        }
        System.out.println(safeDist); // 안전 거리의 최댓값
    }
}
