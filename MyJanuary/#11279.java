import java.io.*;
import java.util.*;

public class Main { // 클래스 시작
	   static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   
	   static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	   
	   static StringBuilder sb=new StringBuilder();
	   
	   static int N; // 연산의 개수
	   
	   static int heap[] = new int[100001]; // 100001을 넘어가지 않도록 설정함.
	   
	   static int top = 0; // root 트리
	   
	   public static void main(String args[]) throws Exception { // 메인 클래스 시작
		   N=Integer.parseInt(br.readLine());
		   
		   for(int i = 0; i < N; i++) { // for문 시작
			   int num=Integer.parseInt(br.readLine());
			   
			   if(num == 0) { 
				   if(top==0) sb.append(0+"\n");
				   else sb.append(pop()+"\n");
			   }
			   else {
				   push(num);
			   }
		   } // for문 끝
		   System.out.println(sb);
	   } // 메인 클래스 끝
	   
	   // 데이터의 비교
	   static void swap(int a, int b) {
		   int temp=heap[a];
		   heap[a]=heap[b];
		   heap[b]=temp;
	   }
	   
	   // 데이터 입력
	   static void push(int n) {
		   heap[++top]=n;
		   
		   int i = top;
		   
		   while(i > 1 && heap[i/2] < heap[i]) {
			   swap(i, i/2);
			   i/=2;
		   }
	   }
	   
	   // 데이터의 삭제
	   static int pop() {
		   int result=heap[1];

		   heap[1]=heap[top];
		   heap[top--]=0;
		   for(int i = 1; i * 2 <=top;) { // for문 시작
			   if(heap[i]>heap[i*2]&&heap[i]>heap[i*2+1]) break;
			   else if(heap[i*2]>heap[i*2+1]) {
				   swap(i, i*2);
				   i=i*2;
			   }
			   else {
				   swap(i, i*2+1);
				   i=i*2+1;
			   }
		   } // for문 끝
		   return result;
	   }
	} // 클래스 끝
