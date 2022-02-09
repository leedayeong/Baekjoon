import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int k;
	static int [] src;
	static int [] tgt = new int[6];
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if (k==0) break;
			
			src = new int[k];
			
			for (int i = 0; i < k; i++) {
				src[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0, 0);
			System.out.println();
		}
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		StringBuilder sb = new StringBuilder();
		
		if(tgtIdx == 6) {
			for (int num : tgt) {
				sb.append(num).append(" ");
			}
			System.out.println(sb);
			return;
		}
		
		//srcIdx 에 대한 기저조건
		if(srcIdx == k) return;
		
		tgt[tgtIdx] = src[srcIdx];
		
		comb(srcIdx + 1, tgtIdx +1);
		comb(srcIdx + 1, tgtIdx);
	}
}