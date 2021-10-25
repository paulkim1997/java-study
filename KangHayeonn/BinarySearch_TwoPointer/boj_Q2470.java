// 두 용액 (백준 2470번)
// 실패

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[count];
		
		for(int i=0; i<count; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = count-1;
		int min = Math.abs(arr[left] + arr[right]);
		int min_left = arr[left];
		int min_right = arr[right];
		
		while(left < right) {
			int v1 = arr[left] + arr[right];   // 두 용액의 합
	
			if(v1 == 0) {
				min = 0;
				min_left = arr[left];
				min_right = arr[right];
				break;
			}
			else if(v1 > 0) right--;
			else left++;
			
			int v2 = Math.abs(arr[left] + arr[right]); // 두 용액의 합의 절댓값
			
			if(v2 < min) {
				min = v2;
				min_left = arr[left];
				min_right = arr[right];
			}
		}
		
		System.out.print(min_left + " " + min_right);
	}
}