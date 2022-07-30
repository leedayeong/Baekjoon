import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	
	static char[][] src;
	static char[][] tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		
		src = new char[N][];
		tgt = new char[N][];
		
		for (int i = 0; i < N; i++) {
			src[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			tgt[i] = br.readLine().toCharArray();
		}
		
		
		for (int i = 0; i < N-2; i++) {
			for (int j = 0; j < M-2; j++) {
				if(src[i][j] != tgt[i][j]) {
					ans++;
					for (int y = 0; y < 3; y++) {
						for (int x = 0; x < 3; x++) {
							src[i+y][j+x] = src[i+y][j+x]=='0'? '1' : '0';
						}
					}
				}
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(src[i][j] != tgt[i][j]) {
					ans = -1;
					break;
				}
			}
		}
		
		System.out.println(ans);

	}
}