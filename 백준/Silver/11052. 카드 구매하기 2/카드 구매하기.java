import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] card;
	static int[][] dp;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		card = new int[N+1];
		dp = new int[N+1][N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		
		for (int i = 1; i <= N; i++) {
			
			for (int j = 1; j <= N; j++) {
				if(i <= j) {
					dp[i][j] = Math.max(dp[i][j-i]+card[i], dp[i-1][j]);
				}else dp[i][j] = dp[i-1][j];
			}
		}
		
		System.out.println(dp[N][N]);
	}
}