import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5052 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // tc

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 전화번호 수
            String[] s = new String[n];
            for (int i = 0; i < n; i++) s[i] = br.readLine(); // 각 전화번호(중복x)
            Arrays.sort(s);

            boolean check = false; // 일관성 체크
            // statsWith: 자바 String 클래스의 메소드
            // 문자열이 지정한 문자열로 시작하는지 판단 후, 같으면 true 다르면 false 반환
            for (int i = 0; i < n - 1; i++)
                if (s[i + 1].startsWith(s[i])) check = true;

            if (check) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}