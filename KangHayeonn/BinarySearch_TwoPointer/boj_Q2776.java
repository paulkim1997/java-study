// 암기왕 (백준 2776번)
// 성공

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		
		for(int i=0; i<count; i++) {
			StringBuilder sb = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr1 = new int[N];
			for(int j=0; j<N; j++) {
				arr1[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr1);
			
			int M = Integer.parseInt(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for(int k=0; k<M; k++) {
				int target = Integer.parseInt(st2.nextToken());
				sb.append(binarySearch(arr1, target) ? 1 : 0).append('\n');
			}
			System.out.print(sb);
		}
	}
	
	// ver1: for문으로 구현
	public static boolean binarySearch(int arr[], int target) {
		 int left = 0;
		 int right = arr.length-1;
	
		 while(left<=right) {
			 int mid = (left+right) /2;
			 
			 if(arr[mid]==target) return true;
			 if(target > arr[mid]) left = mid+1;
			 else right = mid-1;
		 }
		 
		 return false;
	}
}