import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10845 {

    private static int N, cmd, back;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 명령의 수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            // 스택의 push 역할이 큐에서는 offer
            if (s.equals("push")) {
                cmd = Integer.parseInt(st.nextToken());
                queue.offer(cmd);
                // 덱을 쓰지않는이상, 큐에는 back 을 출력하는 함수가 없으므로 기억해주기
                back = cmd;
            }

            // 스택의 pop 역할이 큐에서는 poll
            else if (s.equals("pop")) {
                if (queue.isEmpty()) System.out.println(-1);
                else System.out.println(queue.poll());
            }

            else if (s.equals("size")) {
                System.out.println(queue.size());
            }

            else if (s.equals("empty")) {
                if (queue.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }

            else if (s.equals("front")) {
                if (queue.isEmpty()) System.out.println(-1);
                else System.out.println(queue.peek());

            }

            else if (s.equals("back")) {
                if (queue.isEmpty()) System.out.println(-1);
                else System.out.println(back);

            }
        }
    }
}
