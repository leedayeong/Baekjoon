import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[][] cost;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		ans = Integer.MAX_VALUE;
		cost = new int[N+1][3];
		dp = new int[N+1][3];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		
		dp[1][0] = cost[1][0];
		dp[1][1] = cost[1][1];
		dp[1][2] = cost[1][2];
		
		for (int i = 2; i <=  N ; i++) {
			dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
	}
}
