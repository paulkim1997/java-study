import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1969 {

    private static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // DNA 의 수
        M = Integer.parseInt(st.nextToken()); // 문자열의 길이

        char[][] arr = new char[N][M];
        String res = "";
        int sum = 0;

        for(int i=0; i<arr.length; i++) {
            String str = br.readLine();
            for(int j=0; j<arr[i].length; j++)
                arr[i][j] = str.charAt(j);
        }

        // 배열을 행마다 보면서 저장된 문자 빈도 체크
        for(int i=0; i<M; i++) {
            int[] arr2 = new int[4];
            for (int j = 0; j < N; j++) { // 행 기준 반대
                if (arr[j][i] == 'A') arr2[0]++;
                else if (arr[j][i] == 'C') arr2[1]++;
                else if (arr[j][i] == 'G') arr2[2]++;
                else if (arr[j][i] == 'T') arr2[3]++;
                else break;
            }

            // 각 행에서 가장 많이 사용된 문자 체크
            int freq = arr2[0], idx = 0;
            for (int j = 1; j < arr2.length; j++) {
                if (arr2[j] > freq) {
                    freq = arr2[j];
                    idx = j;
                }
            }

            // Hamming Distance 의 합이 최소가되는 문자열 출력 위해 체크
            switch (idx){
                case 0: { res += 'A'; break;}
                case 1: { res += 'C'; break;}
                case 2: { res += 'G'; break;}
                case 3: { res += 'T'; break;}
                default: break;
            }
        }

        // Hamming Distance 의 합, 문자가 다를 경우 체크
        for(int i=0; i<N; i++)
            for(int j=0; j<M; j++)
                if(res.charAt(j) != arr[i][j]) sum++;

        System.out.println(res); //  Hamming Distance 의 합이 가장 작은 DNA
        System.out.println(sum); //  위 Hamming Distance 의 합
    }
}
