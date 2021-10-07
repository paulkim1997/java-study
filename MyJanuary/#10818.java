import java.util.Arrays;
import java.util.Scanner;
 
public class Main { // 클래스 시작
	public static void main(String[] args) { // 메인 클래스 시작
    
		Scanner s = new Scanner(System.in);
        
		int n = s.nextInt(); // 정수의 개수
		
		int[] Array = new int[n]; // 정수를 담을 배열
        
		for (int i = 0; i < n ; i++) { // for 문 시작
			Array[i] = s.nextInt();
		} // for문 끝
        
		s.close();
		Arrays.sort(Array); // 배열에 저장된 원소 값을 오름차순로 정렬해주는 메소드
		System.out.print(Array[0] + " " + Array[n - 1]); // Array[0] -> 최솟값, Array[n - 1] -> 최대값
	} // 메인 클래스 끝
} // 클래스 끝
