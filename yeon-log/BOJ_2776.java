import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_2776 {

    /* 조사: HashSet 은 Set 과 Tree 그리고 Map 의 특성을 갖고 있다.
    contains()메소드를 수행하면 map 에서 key 를 통해 찾기 위해 containsKey()를 수행하고
    hashcode 를 통한 equals()를 통해 결과를 출력한다.
    원소가 8개 이상인 경우 균형 트리 구조로 전환되므로 시간복잡도 O(log n)이 보장된다. */

    /* System.out.println -> 입출력 양이 많아지면 시간초과 유발
    *  C++ 에서 endl 쓰면 시간초과 되서 \n 쓰는 느낌 인 듯!
    *  입출력 많을 때는 Buffered R,W 사용하자! */

   private static HashSet<Integer> hs = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // tc

        while(T != 0) {
            hs.clear(); // tc 가 2이상일때 문제되므로
            T--;
            int N = Integer.parseInt(br.readLine()); // 수첩1 정수 개수
            String [] note = br.readLine().split(" ");
            // 수첩1에 숫자 적어둠
            for(int i = 0; i < N; i++) hs.add(Integer.parseInt(note[i]));
            int M = Integer.parseInt(br.readLine()); // 수첩2 정수 개수
            note = br.readLine().split(" ");
            for(int j = 0; j < M; j++)
                if(hs.contains(Integer.parseInt(note[j]))) bw.write(String.valueOf(1)+"\n");
                else bw.write(String.valueOf(0)+"\n");
            bw.flush();
        }
        bw.close();
    }
}
