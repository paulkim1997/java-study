import java.io.*;

public class Num_1969 { // 클래스 시작
	static int n, m; // n -> DNA 수, m -> 문자열 길이
	static String[] dna;// DNA를 저장할 배열
	static int hd; 
	
	public static void main(String[] args) throws IOException { // 메인 클래스 시작
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] sp = br.readLine().split(" ");
		
		n = Integer.parseInt(sp[0]);
		m = Integer.parseInt(sp[1]);
		
		dna = new String[n];

		for (int i = 0; i < n; i++) {
			dna[i] = br.readLine();
		}

		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < m; i++) { // for문 시작
			int[] cnt = new int[4]; // A C G T
			
			for (int j = 0; j < n; j++) { // 이중 for문 시작
				char ch = dna[j].charAt(i);

				switch (ch) {
				case 'A':
					cnt[0]++;
					break;
				case 'C':
					cnt[1]++;
					break;
				case 'G':
					cnt[2]++;
					break;
				case 'T':
					cnt[3]++;
					break;
				}
			} // 이중 for문 끝

			int idx = 0;
			int max = 0;
			for (int k = 0; k < 4; k++) {
				if (cnt[k] > max || (cnt[k] == max && k < idx)) {
					max = cnt[k];
					idx = k;
				}
			}

			switch (idx) {
			case 0:
				buf.append('A');
				break;
			case 1:
				buf.append('C');
				break;
			case 2:
				buf.append('G');
				break;
			case 3:
				buf.append('T');
				break;
			}
			
			hd += n - max;

		} // for문 끝

		bw.write(buf.toString() + "\n");
		bw.write(hd + "\n");
		bw.flush();

	} // 메인 클래스 끝
} // 클래스 끝
