import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N = 7;
	static int[] src;
	static int[] tgt;
	static boolean chk = false;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		src = new int[9];
		tgt = new int[N];
		
		for (int i = 0; i < 9; i++) {
			src[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(src);
		comb(0, 0, 0);
	}
	static void comb(int srcIdx, int tgtIdx, int sum) {
		if(chk) return;
		
		if(tgtIdx == N) {
			//complete code;
			if(sum == 100) {
				chk = true;
				for (int i = 0; i < N; i++) {
					System.out.println(src[tgt[i]]);
				}
			}
			return;
		}
		
		if(srcIdx == 9) return;
		
		tgt[tgtIdx] = srcIdx;
		comb(srcIdx + 1, tgtIdx + 1, sum+src[srcIdx]);
		comb(srcIdx + 1, tgtIdx, sum);
	}
}