import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine()); // 원판의 개수
        // 원판을 옮길 횟수는 K = 2^N-1
        sb.append((int) (Math.pow(2, N) - 1)).append('\n');
        Hanoi(N, 1, 2, 3, sb);
        System.out.println(sb);
    }

    public static void Hanoi(int N, int from, int mid, int to, StringBuilder sb) {
        // 이동할 원판 수 1개 일 때까지 움직이기
        if (N == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }
        Hanoi(N - 1, from, to, mid, sb);
        sb.append(from + " " + to + "\n");
        Hanoi(N - 1, mid, from, to, sb);
    }
}

