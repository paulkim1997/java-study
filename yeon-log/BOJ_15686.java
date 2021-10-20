import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import static java.lang.Math.abs;
import static java.lang.Math.min;

public class BOJ_15686 {

    private static int N, M, res;
    private static int[][] map;
    private static ArrayList<int[]> house, chicken;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        res = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // 0은 빈 칸, 1은 집, 2는 치킨집
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) house.add(new int[]{i, j});
                else if (map[i][j] == 2) chicken.add(new int[]{i, j});
            }
        }
        arr = new int[M];
        dfs(0, 0);
        System.out.println(res); // 도시의 치킨 거리의 최솟값을 출력
    }

    private static void dfs(int idx, int start) {
        if (idx == M) { // 치킨집 리스트에서 M개를 뽑으면
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                int[] ch = house.get(i);
                // 각 집에서 M개의 치킨집 중 가장 가까운 거리를 구해 dist 에 저장
                int dist = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    int[] cc = chicken.get(arr[j]);
                    dist = min(dist, abs(ch[0] - cc[0]) + abs(ch[1] - cc[1]));
                }
                sum += dist; // 치킨 거리에 누적
            }
            res = min(res, sum); // 갱신하면서 최소 치킨 거리를 저장
            return;
        }
        // 조합
        for (int i = start; i < chicken.size(); i++) {
            arr[idx] = i;
            dfs(idx + 1, i + 1);
        }
    }
}
