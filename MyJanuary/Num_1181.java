/* import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Num_1181 { // 클래스 시작

	public static void main(String[] args) { // 메인 클래스 시작
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int a = s.nextInt(); // 단어의 개수
		String[] Array = new String[a]; // 단어를 담을 배열
		
		s.nextLine();
		
		for(int i = 0 ; i < a ; i++) { // for문 시작
			Array[a] = s.nextLine();
		} // for문 끝
		
		Arrays.sort(Array, new Comparator<String>() { // 객체 타입 정렬 (Comparator 사용)
			@Override
			public int compare(String s1, String s2) { // compare 구현
				if(s1.length() == s2.length()) { // 단어 길이가 같은 경우
					return s1.compareTo(s2);
				}
				
				else { // 단어의 길이가 같지 않는 경우
					return s1.length() - s2.length();
				}
			}
		}); // 배열에 저장된 원소 값을 오름차순로 정렬해주는 메소드
		
		System.out.println(Array[0]);
		
		for (int i = 1; i < a; i++) { // for문 시작
			if (!Array[i].equals(Array[i - 1])) { // 중복되지 않는 단어만 출력
				System.out.println(Array[i]);
			}
		} // for문 끝
	} // 메인 클래스 끝
} // 클래스 끝 */

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
 
 
public class Num_1181 { // 클래스 시작
	public static void main(String[] args) { // 메인 클래스 시작
    
		Scanner s = new Scanner(System.in);
 
		int a = s.nextInt(); // 받을 단어의 개수 
		String[] arr = new String[a]; // 단어를 담을 배열
		
		s.nextLine();
 
		for (int i = 0; i < a; i++) { 
			arr[i] = s.nextLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() { 
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) { // 단어 길이가 같을 경우 
					return s1.compareTo(s2);
				} 

				else { // 단어의 길이가 같지 않는 경우
					return s1.length() - s2.length();
				}
			}
		});
 
		System.out.println(arr[0]);
		
		for (int i = 1; i < a; i++) {
			// 중복되지 않는 단어만 출력
			if (!arr[i].equals(arr[i - 1])) {
				System.out.println(arr[i]);
			}
		}
	} // 메인 클래스 시작
} //클래스 시작