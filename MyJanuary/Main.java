/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;

class Queue{ // Queue 클래스
    public int[] queue; // 데이터를 담을 큐 선언
    public int f_pointer = 0; // 큐의 앞을 가리킬 함수
    public int b_pointer = -1; // 큐의 뒤를 가리킬 함수
	
	Queue(){ // 기본 클래스
		
	}
	
	Queue(int number){
		queue = new int[number];
	}
	
	// 데이터 삽입
	public void push(int x) {
		queue[++b_pointer] = x;
	}
	
	// 데이터 삭제
	public int  pop() {
		if (empty() == 0)
			return -1;
		else
			return queue[f_pointer++];
	}
	
	// 데이터 개수
	public int size() {
		return b_pointer - f_pointer + 1;
	}
	
	// 데이터 여부
	public int empty() {
		if (size()==0)
			return 1;
		else
			return 0;
	}
	

	// 가장 앞의 데이터
	public int front() {
		if (empty() == 0)
			return -1;
		else
			return queue[f_pointer];
	}
	
	// 가장 뒤의 데이터
	public int back() {
		if (empty() == 0)
			return -1;
		else
			return queue[b_pointer];
	}
} // Queue 클래스 종료

public class Main { // 클래스 시작
    
	public static void main(String[] args) { // 메인 클래스 시작
	    Scanner s = new Scanner(System.in);
	    
		int number = s.nextInt(); // 데이터의 저장 공간 확보
		
		Queue queue = new Queue(number);
		
		for(int i = 0 ; i < number ; i++){ // cnt 만큼 반복할 수 있도록 for문 사용
		    String a = s.next();
		    
		    switch(a){ // switch-case문 시작
		    case "push":
		    	int x = s.nextInt();
				queue.push(x);
				break;
                
			case "pop":
				System.out.println(queue.pop());
				break;
                
			case "size":
				System.out.println(queue.size());
				break;
                
			case "empty":
				System.out.println(queue.empty());
				break;
                
			case "front":
				System.out.println(queue.front());
				break;
			
			case "back":
				System.out.println(queue.back());
				break;
		    } // switch-case문 종료
		} // for문 종료
	} //메인 클래스 종료
}//클래스 종료

 
