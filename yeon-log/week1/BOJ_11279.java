import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 연산의 개수

        // 자바 문법) Collections.reverseOrder() 사용 시 내림차순 정렬 가능
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                // 빈 배열인데 출력하라고 한 경우
                if (pq.isEmpty()) System.out.println("0");
                // 배열에서 가장 큰 값을 출력
                else System.out.println(pq.poll());
            }
            // x가 자연수라면 배열에 x라는 값을 추가
            else pq.add(x);
        }
    }
}
