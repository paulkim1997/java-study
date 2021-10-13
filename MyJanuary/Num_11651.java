import java.util.Scanner;
import java.util.Arrays;

public class Num_11651 { // 메인 클래스 시작

	public static void main(String[] args) { // 메인 클래스 시작
		// TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(); // 좌표를 찍을 
		
		int[][] Array = new int[n][2]; // 좌표를 담을 배열
		
		for(int i = 0; i < n; i++) { // for 문 시직
			Array[i][0] = s.nextInt();
			
			Array[i][1] = s.nextInt();
		} // for 문 끝
		
		Arrays.sort(Array, (s1, s2) -> {
			if(s1[1] == s2[1]) {
				return Integer.compare(s1[0], s2[0]);
			} 
			
			else {
				return Integer.compare(s1[1], s2[1]);
			}
		});
		
		for(int i = 0; i < n; i++) { // for문 시작
			System.out.println(Array[i][0] + " " + Array[i][1]);
		} // for문 끝
	} // 메인 클래스 시작
} // 메인 클래스 끝
