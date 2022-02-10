import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static int N;
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		N = Integer.parseInt(str);
		
		if(N>20) {
			BigInteger bigNum = new BigInteger("1");
			for (int i = 0; i < N; i++) {
				bigNum = bigNum.multiply(new BigInteger("2"));
			}
			System.out.println(bigNum.subtract(new BigInteger("1"))); // cnt : 2^n-1
			
		}else {
			hanoitop(N, 1, 2, 3);
			System.out.println(cnt);
			System.out.println(sb);
		}
		
		
		
	}
	static void hanoitop(int n, int start, int src, int tgt) {
		// 기저조건
		if(n == 0) return;
		cnt++;
		
		hanoitop(n-1, start, tgt, src);
		
		//가장큰 원판 하나를 start -> tgt으로 옮긴다.
		sb.append(start).append(" ").append(tgt).append("\n");
		
		hanoitop(n-1, src, start, tgt);
		
	}
}