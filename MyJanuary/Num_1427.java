import java.util.Scanner;

public class Num_1427 { // 클래스 시작

	public static void main(String[] args) { // 메인 클래스 시작
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt(); // 정렬하고자 하는 수
		int[] Array = new int[10]; // 10자리(1,000,000,000) 보다 작은 수
		
		while(n != 0) { // 정렬하고자 하는 수가 0이 아닐 때까지
			Array[n % 10]++;
			
			n/= 10;
		}
		
		for (int i = 9; i >= 0 ; i--) { // for 문 시작
			while(Array[i]-- > 0) {
				System.out.print(i);
			}
		} // for문 끝
	} // 메인 클래스 끝

}// 클래스 끝
