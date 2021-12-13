import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18352 {

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<Node>[] list;
    private static int[] dist;
    static int N, M, K, X;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        list = new ArrayList[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0; // 시작점

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(new Node(B, 1)); // A에서 B로 이동하는 단방향 도로 존재
        }

        dijkstra();
        int cnt = 0;
        // 최단 거리가 K인 모든 도시의 번호 오름차순 출력
        for (int i=1; i<=N; i++)
            if (dist[i] == K) {
                System.out.println(i);
                cnt++;
            }
        if (cnt == 0)  System.out.println(-1);
    }

    static void dijkstra() {
        pq.add(new Node(X, 0)); // 시작정점, 가중치

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cv = node.v;
            int cw = node.w;
            if (dist[cv] < cw) continue;
            // 1. 선택한 정점에 연결된 모든 정점에 대해 기존 dist 배열에 저장된 값과 비교
            // 2. dist 가 작은 경우는 제외하고 갱신 후 pq 에 add
            for (int i = 0; i < list[cv].size(); i++) {
                int nv = list[cv].get(i).v;
                int nw = list[cv].get(i).w + cw;
                if (dist[nv] > nw) {
                    dist[nv] = nw;
                    pq.add(new Node(nv, nw));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int v, w;
        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
        // 거리가 짧은 목적지 가져오기 위해 오름차순
        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }
}
