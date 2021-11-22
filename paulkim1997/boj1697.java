import java.util.*;
import java.io.*;

public class boj1697 {
    static int n,k;
    static int arr[];
    static int dis[];
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        dis = new int[100001];
        Arrays.fill(dis, -1);
        //동생 위치 부터 BFS 시작
        q.add(n);
        dis[n] = 0;
        if(n==k) {
            System.out.println(0);
            return;
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            int nx = 0;
            for(int dir=0;dir<3;dir++) {
                switch (dir) {
                    case 0:
                        nx = cur + 1;
                        break;
                    case 1:
                        nx = cur - 1;
                        break;
                    case 2:
                        nx = cur * 2;
                        break;
                    default:
                        break;
                }
                //벗어나면 continue
                if(nx < 0 || nx > 100000 || dis[nx] > 0) continue;

                //잡았으면!
                if(nx == k) {
                    System.out.println(dis[cur]+1);
                    return;
                }
                //갔는데, 현재 거리가 방문된 거리보다 작으면 갱신
                if(dis[nx] == -1) {
                    dis[nx] = dis[cur] + 1;
                    q.add(nx);
                }
            }
        }
    }
}
