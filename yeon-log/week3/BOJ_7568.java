import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        // 각 사람의 몸무게와 키
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            int grade = 1;
            for(int j = 0; j < N; j++)
                // 각 사람의 덩치 등수를 계산
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) grade++;
            System.out.print(grade + " ");
        }
    }
}
