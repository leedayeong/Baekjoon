import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, R,C;
	static char[][] email;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		N = str.length();
		
		for (int r = 1; r <= N; r++) {
			if(N%r == 0 && r <= N/r) {
				R = r;
				C = N/r;
			}
		}
		
		email = new char[R][C];
		
		int idx = 0;
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {
				email[i][j] =  str.charAt(idx++);
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(email[i][j]);
			}
		}
		
		System.out.println(sb);
	}
}