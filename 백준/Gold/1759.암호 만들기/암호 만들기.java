import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L, C;
	static char[] alphabet;
	static char[] tgt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alphabet = new char[C];
		tgt = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alphabet);

		comb(0, 0);
	}
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == L) {
			// complete code
			boolean chk = false;
			int cnt = 0;
			for (int i = 0; i < L; i++) {
				char ch = tgt[i];
				if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') chk = true;
				else cnt++;
			}
			if(chk && cnt>=2) {
				for (int i = 0; i < L; i++) {
					System.out.print(tgt[i]);
				}
				System.out.println();
			}
			return;
		}
		
		if(srcIdx == C) return;
		
		tgt[tgtIdx] = alphabet[srcIdx];
		
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
}