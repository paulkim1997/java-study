import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_1835 {

    private static int N;
    static Deque<Integer> card = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 카드의 개수

        int[] desk = new int[N + 1];

        int idx = 1; // 책상 인덱스

        // 1~N 까지 차례로 저장
        for (int i = 1; i <= N; i++) card.offer(i);

        // 1~N번 만큼 반복하면서 앞에꺼 삭제, 맨뒤로 삽입
        for (int i = 1; i <= N; i++) {
            int cnt = i;
            while (cnt != 0) {
                int temp = card.peekFirst(); // 맨 앞에 카드를 기록해놓고
                card.pollFirst(); // 맨 앞 카드 삭제하고
                card.offerLast(temp); // 맨 뒤에 그 카드 숫자 추가
                cnt--;
            }
            // 맨 앞꺼 책상으로 두고 삭제
            desk[idx-1] = card.peekFirst();
            card.pollFirst();
            idx++;
        }
        // 첫 번째 줄부터 N번째 줄까지 차례로 카드의 순서를 출력
        for(int i=0;i<N;i++) System.out.print(desk[i]+" ");
    }
}