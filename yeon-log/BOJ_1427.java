import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1427 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] N = br.readLine().toCharArray();
        Arrays.sort(N); // 2143 -> 1234
        for(int i=N.length-1; i>=0; i--) System.out.print(N[i]); // 1234 -> 4321
    }
}
