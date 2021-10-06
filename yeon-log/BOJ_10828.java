import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 주의: BOJ 제출시 class 이름 Main 으로 변경해야한다.(컴파일에러)
public class BOJ_10828 {
    private static int N, cmd;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        // Scanner + ArrayList 는 시간초과
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 명령의 수

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            // push X: 정수 X를 스택에 넣는 연산이다.
            if (s.equals("push")) {
                cmd = Integer.parseInt(st.nextToken());
                stack.push(cmd);
            }

            // pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            else if (s.equals("pop")) {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.pop());
            }

            // size: 스택에 들어있는 정수의 개수를 출력한다.
            else if (s.equals("size")) {
                System.out.println(stack.size());
            }

            // empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
            else if (s.equals("empty")) {
                if (stack.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }

            // top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            else if (s.equals("top")) {
                if (stack.isEmpty()) System.out.println(-1);
                else System.out.println(stack.peek());

            }
        }
    }
}
