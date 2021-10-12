import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Num_10814 { // 클래스 시작 
	public static void main(String[] args) { // 메인 클래스 시작
		// TODO Auto-generated method stub
		   
		Scanner s = new Scanner(System.in);
		 
		int a = s.nextInt(); // 받을 단어의 개수 
        String[][] arr = new String[a][2]; // 단어를 담을 배열
		 
		for (int i = 0; i < a; i++) { // for문 시작
					arr[i][0] = s.next(); // 나이
					arr[i][1] = s.next(); // 이름
		} // for문 끝		
		
		Arrays.sort(arr, new Comparator<String[]>() { 
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
		        }
        	});
		
		for(int i = 0; i < a; i++) { // for문 시작
			System.out.println(arr[i][0] + " " + arr[i][1]);
		} // for문 끝
	} // 메인 클래스 끝
} // 클래스 끝 
