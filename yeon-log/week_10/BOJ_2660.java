import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.Math.min;

public class BOJ_2660 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회원의 수
        int[][] friend = new int[51][51]; // 친구관계인 회원번호
        int[] score = new int[51];
        int[] candi = new int[51];
        int INF = 987654321;

        // 자기자신 제외하고 초기화
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                friend[i][j] = INF;
            }

        // 친구관계인 회원 저장
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1) break;
            friend[a][b] = 1;
            friend[b][a] = 1;
        }

        // 플로이드-와샬(i에서 j까지 k를 거치는게 가까우면 갱신)
        for (int k = 1; k <= N; k++)
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (friend[i][j] > friend[i][k] + friend[k][j])
                        friend[i][j] = friend[i][k] + friend[k][j];

        // 최소 점수 저장
        int minScore = INF;
        for (int i = 1; i <= N; i++) {
            int temp = 0;
            for (int j = 1; j <= N; j++)
                if (temp < friend[i][j]) temp = friend[i][j];
            score[i] = temp;
            minScore = min(minScore, temp);
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++)
            if (score[i] == minScore) { // 최소 점수는 모두 회장 후보
                ++cnt;
                candi[i] = i;
            }
        System.out.println(minScore + " " + cnt); // 회장 후보의 점수와 후보의 수
        for (int i : candi) if(i!=0) System.out.print(i + " "); // 각 회장 후보들
    }
}