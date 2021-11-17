import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {

    static Queue<Integer> queue = new LinkedList<Integer>();
    private static int visited[] = new int[100001];
    private static int N, K;
    private static int[] dx = {-1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        K = Integer.parseInt(st.nextToken()); // 동생의 위치

        bfs(N); // 수빈이가 동생을 찾는 최소시간 탐색
    }

    static void bfs(int n) {
        queue.add(n);
        visited[n] = 1;
        if (n == K) { // 수빈이와 동생이 이미 같은 위치 일때
            System.out.print(visited[n] - 1);
            return;
        }
        while(!queue.isEmpty()) {
            int cx = queue.poll();
            for(int i=0; i<3; i++) {
                int nx;
                // 다음위치를 뒤, 앞, 순간이동
                if (i < 2) nx = cx + dx[i];
                else nx = cx * 2;
                if (nx == K) { // 다음에 갈 곳이 동생이 있는 위치 일때 출력
                    System.out.print(visited[cx]);
                    return;
                }
                // 다음 위치 큐에 넣고 시간 증가
                if (nx >= 0 && nx < visited.length && visited[nx] == 0) {
                    queue.add(nx);
                    visited[nx] = visited[cx] + 1;
                }

            }
        }
    }
}
