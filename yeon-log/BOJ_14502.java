import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {

    static int N, M;
    static int[][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dy = {1, -1, 0, 0}, dx = {0, 0, 1, -1};
    static int res = Integer.MIN_VALUE;
    static int[][] visited;
    static int[][] virus;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        virus = new int[N][M];

        // 연구소의 지도(0은 빈 칸, 1은 벽, 2는 바이러스)
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0); // 벽을 3개 세울 수 있는 모든 경우의 수 만들기
        System.out.print(res);
    }

    static int bfs() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                virus[i][j] = map[i][j];

        // 바이러스 지역 체크
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (virus[i][j] == 2)
                    queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] list = queue.poll();
            int cx = list[0], cy = list[1];
            // 상하좌우로 가능한 만큼 바이러스 퍼뜨리기
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i], ny = cy + dy[i];
                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) continue;
                if(virus[nx][ny]==0){
                    virus[nx][ny] = 2;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        int safe = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (virus[i][j] == 0) safe++;
        if (safe > res) res = safe; // 안전영역 가장 크도록 갱신
        return res;
    }

    static void recursion(int wall) {
        if (wall == 3) {
            bfs(); // 바이러스를 퍼뜨려 안전영역의 최대 크기 구하기
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1; // 벽 세우기
                    recursion(wall + 1);
                    map[i][j] = 0; // 벽 치우기
                }
            }
        }
    }
}