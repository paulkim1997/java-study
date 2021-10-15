import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_1835 {

    static Deque<Integer> card = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 카드의 개수
        //int[] desk = new int[N];

        while (N != 0) {
            if(card.isEmpty()) card.offerFirst(N); // N 카드를 제일 먼저 책상에 둔다
            N--;
            int cnt = N;
            if(N==0) break;
            while (cnt != 0) {
                if(!card.contains(N)) card.offerFirst(N); // 같은 숫자 카드 추가는 한번만
                int temp = card.peekLast(); // 맨 뒤에 카드를 기록해놓고
                card.pollLast(); // 맨 뒤 카드 삭제하고
                card.offerFirst(temp); // 맨 앞에 그 카드 숫자 추가
                cnt--;
            }
        }
        for (Integer c : card) {
            System.out.print(c + " ");
        }
    }
}