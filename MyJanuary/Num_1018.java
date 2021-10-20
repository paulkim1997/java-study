import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
 
public class Num_1018 { // 클래스 시작
	public static boolean[][] arr; // 배열
	public static int min = 64; // 최소값 (8*8)

	public static void main(String[] args) throws IOException { // 메인 클래스 시작
		// TODO Auto-generated method stub
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
 
		arr = new boolean[n][m];
		
 
		// 배열 입력 
		for (int i = 0; i < n; i++) { // for문 시작
			String str = br.readLine();
			
			for (int j = 0; j < m; j++) { // 이중 for문 시작
				if (str.charAt(j) == 'W') {
					arr[i][j] = true;		// W일 때는 true 
				} 
				
				else {
					arr[i][j] = false;		// B일 때는 false
				}
			} // 이중 for문 끝
		} // for문 끝 
 
		
		int n_row = n - 7;
		int m_col = m - 7;
 
		for (int i = 0; i < n_row; i++) { // for문 시작
			for (int j = 0; j < m_col; j++) { // 이중 for문 시작
	
				find(i, j); // find 클래스 호출
				
			} // 이중 for문 끝
		} // for문 끝
		
		System.out.println(min); // min 값 출력

	}
	
	public static void find(int x, int y) { // find 클래스 시작
		int end_x = x + 8; // x의 끝
		int end_y = y + 8; // y의 끝
		int count = 0;
 
		boolean TF = arr[x][y];	// 첫 번째 칸의 색 
 
		for (int i = x; i < end_x; i++) { // for문 시작
			for (int j = y; j < end_y; j++) { // 이중 for문 시작
				// 올바른 색이 아닐경우 count 1 증가 
				if (arr[i][j] != TF) {	
					count++;
				}
				
				/* 
				 * 다음 칸은 색이 바뀌므로
				 * true라면 false로, false 라면 true 로
				 * 값을 변경한다.
				 */
				TF = (!TF);
			}
			
			TF = !TF;
		}
		
		/*
		 *  첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
		 *  첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
		 *  색칠 할 개수(64 - count) 중 최솟값을 count 에 저장 
		 */
		count = Math.min(count, 64 - count);
		
		/*
		 * 이전까지의 경우 중 최솟값보다 현재 count 값이
		 * 더 작을 경우 최솟값을 갱신 
		 */
		min = Math.min(min, count);
	}

}
