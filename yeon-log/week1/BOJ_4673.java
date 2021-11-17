public class BOJ_4673 {
    private static int n;
    public static void main(String[] args) {
        boolean[] check = new boolean[10001];

        // 10000 이하의 수 중 생성자가 있는 수 걸러주기
        for (int i = 1; i <= 10000; i++) {
            n = solve(i);
            if (n <= 10000) check[n] = true;
        }

        // 생성자가 없는 숫자(셀프 넘버) 출력
        for (int i = 1; i <= 10000; i++)
            if (!check[i]) System.out.println(i);
    }

    public static int solve(int N) {
        int ctorN = N;
        // ex) (N=33, ctorN=33) ctorN=33+3, (N=3, ctorN=33+3+3=39)
        while (N != 0) {
            ctorN = ctorN + (N % 10);
            N = N / 10;
        }
        return ctorN; // 생성자가 만들어지는 수
    }
}
