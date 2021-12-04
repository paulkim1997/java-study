import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17503 {

    static int N, M, K;
    static int[][] beer;
    static PriorityQueue pq = new PriorityQueue(); // 도수레벨 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 축제가 열리는 기간
        M = Integer.parseInt(st.nextToken()); // 채워야하는 선호도의 합
        K = Integer.parseInt(st.nextToken()); // 마실수있는 맥주 종류의 수
        beer = new int[K + 1][2];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            beer[i][0] = Integer.parseInt(st.nextToken()); // 맥주의 선호도
            beer[i][1] = Integer.parseInt(st.nextToken()); // 맥주의 도수레벨
        }
        Arrays.sort(beer, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) { //도수레벨 오름차순(간 레벨 최소화위함)
                if(o1[1] == o2[1]) return o2[0] - o1[0]; // 같다면 선호도 내림차순
                return o1[1] - o2[1];
            }
        });

        int sum = 0;
        for (int i = 1; i <= K; i++) {
            // 맥주 선호도 저장(도수레벨 기준 낮은순 으로 정렬된 맥주 선호도)
            pq.offer(beer[i][0]);
            sum += beer[i][0];
            if (pq.size() > N) sum -= (int) pq.poll();
            // 선호도의 합 M을 채우면서 N개의 맥주를 모두 마실 수 있는경우
            if (pq.size() == N && sum >= M) {
                System.out.print(beer[i][1]);
                return;
            }
        }
        System.out.print(-1);
    }
}
