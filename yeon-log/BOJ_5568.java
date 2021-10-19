import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_5568 {

    private static int n,k;
    private static HashSet<String> hs = new HashSet<String>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 총 카드의 개수
        k = Integer.parseInt(br.readLine()); // 선택하는 카드 개수
        int[] arr = new int[n];
        int[] card = new int [n];
        boolean[] visited = new boolean[n];

        // 카드에 쓰인 수
        for(int i=0;i<n;i++) card[i] = Integer.parseInt(br.readLine());
        solve(card, arr, visited, 0);
        System.out.println(hs.size());
    }

    // n장의 카드에 적힌 숫자가 주어졌을 때, k개를 선택해서 만들 수 있는 정수의 개수 hs에 저장
    static void solve(int[] card, int[] arr, boolean[] visited, int depth) {
        String str = "";
        if (depth == k) {
            for (int i = 0; i < k; i++)
                str += arr[i]; // 가능한 조합 저장
            hs.add(str); // 중복 제거 저장
            return;
        }
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = card[i];
                solve(card, arr, visited, depth + 1);
                visited[i] = false;;
            }
        }
    }
}
