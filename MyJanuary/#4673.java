public class Main { // 클래스 시작
    public static void main(String[] args) { // 메인 클래스 시작
        int[] f = new int[10001]; // 배열 생성 (<= 10,000) 
        
        for (int i = 1; i <= 10000; i++) { // for문 시작
            if(d(i) < 10001){ // 셀프 넘버가 10,001 보다 작으면
                f[d(i)] = 1;
            }
        } // for문 끝
        for (int i = 1; i <= 10000; i++) { // for문 시작
            if(f[i] != 1){ // 배열의 개수가 1이 아니라면 
                System.out.println(i); // 출력
            }
        }// for문 끝
    } // 메인 클래스 끝
    
    public static int d(int i) {
        int sum = i; // 전부 더한 수
        if (i >= 10000) { sum += i / 10000; i %= 10000; } // 첫째 자리수
        if (i >= 1000) { sum += i / 1000; i %= 1000; } // 둘째 자리수
        if (i >= 100) { sum += i / 100; i %= 100; } // 셋째 자리수
        if (i >= 10) { sum += i / 10; i %= 10; } // 넷째 자리수
        
        return sum += i;
    }
} // 클래스 끝
