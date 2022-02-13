import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] src;
	static int [] tgt;

	static int N;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			if (N==0) break;
			
			//초기화
			src = new int[N];
			tgt = new int[6]; //6개 고정
			
			for (int i = 0; i < N; i++) {
				src[i] = Integer.parseInt(st.nextToken());
			}
			
			comb(0, 0);
			sb.append("\n");
		}
		sb.setLength(sb.length()-2);
		System.out.println(sb);
	}
	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == 6) {
			for (int i = 0; i < 6; i++) {
				sb.append(tgt[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = srcIdx; i < N; i++) {
			tgt[tgtIdx] = src[i];
			comb(i+1, tgtIdx + 1);
		}
	}

}