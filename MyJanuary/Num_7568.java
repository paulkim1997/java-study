import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Num_7568 { // 클래스 시작

	public static void main(String[] args) throws IOException { // 메인 클래스 시작
		// TODO Auto-generated method stub 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
 
		int[][] arr = new int[n][2];// 몸무게, 키 담을 배열
 
		String[] sp;  // split() 사용
		
		for(int i = 0; i < n; i++) { // for문 시작
			sp = br.readLine().split(" ");			// 문자열 분리
			
			arr[i][0] = Integer.parseInt(sp[0]);	// [i][0] : 몸무게 
			arr[i][1] = Integer.parseInt(sp[1]);	// [i][1] : 키 
			
		} // for문 끝
		
				
		for(int i = 0; i < n; i++) { // for문 시작
			int rank = 1; // 순위
			
			for(int j = 0; j < n; j++) { // 이중 for문 시작
				if(i == j) 
					continue;
				
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			} // 이중 for문 끝
 
			System.out.print(rank + " ");
		} // for문 끝
	} // 메인 클래스 끝
} // 클래스 끝
