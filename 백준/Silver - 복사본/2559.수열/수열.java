import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, sum;
	static int[] temp;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		temp = new int[N];
		
		sum = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N-K+1; i++) {
			int tmpSum = 0;
			for (int j = i; j < i+K; j++) {
				tmpSum+= temp[j];
			}
			sum = Math.max(sum, tmpSum);
		}
		System.out.println(sum);
	}

}