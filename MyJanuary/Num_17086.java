import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num_17086 { // 클래스 시작
    static int n, m; // n -> 행, m -> 열
    static int[][] map; // 행열을 담을 배열(지도)
    static boolean[][] visit; 
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int ans; // 정답

	public static void main(String[] args) throws IOException { // 메인 클래스 시작
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
     
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) { // for문 시작
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } // for문 끝

        for (int i = 0; i < n; i++) { /// for문 시작
            for (int j = 0; j < m; j++) { // 이중 for문 시작
            	
                if (map[i][j] == 0) {
                    shark(i, j); // shark 클래스 호출
                    
                }
                
            } // 이중 for문 끝
        } // for문 끝

        System.out.println(ans);
    }

    static void shark(int x, int y) { // shark 클래스 시작
        for (boolean[] arr : visit) Arrays.fill(arr, false);

        Queue<int[]> q = new LinkedList<>();
         
        visit[x][y] = true;
        
        q.add(new int[]{x, y});
        
        int cnt = 0;

        while (!q.isEmpty()) { // q가 있는 동안
            int size = q.size();

            for (int s = 0; s < size; s++) { // for문 시작
                int[] now = q.poll();

                if (map[now[0]][now[1]] == 1) {
                    ans = Math.max(ans, cnt);

                    return;
                }

                for (int d = 0; d < 8; d++) { // 이중 for문 시작
                    int nx = now[0] + dx[d], ny = now[1] + dy[d];

                    if (!isRange(nx, ny) || visit[nx][ny]) 
                    	continue;

                    visit[nx][ny] = true;
                    
                    q.add(new int[]{nx, ny});
                } // 이중 for문 끝
            } // for문 끝

            cnt++;
        } // shark 클래스 끝
	} // 메인 클래스 끝
    
    static boolean isRange(int x, int y) { // isRange 클래스 시작
        return x >= 0 && x < n && y >= 0 && y < m;
    } // isRange 클래스 끝
} // 클래스 끝
