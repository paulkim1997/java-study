import java.util.Scanner;

public class Main { // 클래스 시작
    public static int[] stack; // 데이터를 담을 스택 선언
    public static int size = 0;
    
	public static void main(String[] args) { // 메인 클래스 시작
	    Scanner s = new Scanner(System.in);
	    StringBuilder sb = new StringBuilder();
	    
		int cnt = s.nextInt(); // 데이터의 저장 공간 확보
		
		stack = new int[cnt];
		
		for(int i = 0 ; i < cnt ; i++){ // cnt 만큼 반복할 수 있도록 for문 사용
		    String a = s.next();
		    
		    switch(a){ // switch-case문 시작
		    case "push":
				push(s.nextInt());
				break;
                
			case "pop":
				sb.append(pop()).append('\n');
				break;
                
			case "size":
				sb.append(size()).append('\n');
				break;
                
			case "empty":
				sb.append(empty()).append('\n');
				break;
                
			case "top":
				sb.append(top()).append('\n');
				break;
		    } // switch-case문 종료
		} // for문 종료
		System.out.println(sb);
	} //메인 클래스 종료
	
	// 데이터 삽입
	public static void push(int X) {
		stack[size] = X;
		size++;
	}
    
    // 데이터 삭제
	public static int pop() {
		if(size == 0) {
			return -1;
		}
		else {
			int res = stack[size - 1];
			stack[size - 1] = 0;
			size--;
			return res;
		}
	}
    
    // 데이터 개수
	public static int size() {
		return size;
	}
	
	// 데이터 여부
	public static int empty() {
		if(size == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
    
    // 가장 위의 데이터
	public static int top() {
		if(size == 0) {
			return -1;
		}
		else {
			return stack[size - 1];
		}
	}
}//클래스 종료