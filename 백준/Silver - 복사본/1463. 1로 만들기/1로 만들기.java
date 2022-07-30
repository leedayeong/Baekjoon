import java.util.Scanner;

public class Main {
	static int N;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		dp = new int[N+1];
		
		dp[1] = 0;
		if(N >= 2) dp[2] = 1;
		if(N >= 3) dp[3] = 1;
		
		if(N >= 4) {
			for (int i = 4; i <= N ; i++) {
				int min = Integer.MAX_VALUE;
				if(i%3 == 0) min = Math.min(min, dp[i/3] + 1);
				if(i%2 == 0) min = Math.min(min, dp[i/2] + 1);
				min = Math.min(min, dp[i-1] + 1);
				dp[i] = min;
			}
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}
}
