import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* 다익스트라: 한 정점에서 다른 모든 정점으로 까지의 최단거리를 구하는 알고리즘 */
public class BOJ_1753 {

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static ArrayList<Node>[] list;
    static int K;
    static int[] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수
        K = Integer.parseInt(br.readLine()); // 시작 정점의 번호
        list = new ArrayList[V + 1];
        dist = new int[V + 1];
        for (int i = 1; i <= V; i++) list[i] = new ArrayList<>();

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0; // 시작점

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w)); // u에서 v로 가는 가중치 w인 간선이 존재
        }
        dijkstra();
        for (int i = 1; i <= V; i++) {
            // i번째 줄에 i번 정점으로의 최단 경로의 경로값 출력
            if (dist[i] != Integer.MAX_VALUE) System.out.println(dist[i]);
            // 경로가 존재하지 않는 경우 INF
            else if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
        }
    }

    static void dijkstra() {
        pq.add(new Node(K, 0)); // 시작정점, 가중치

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
