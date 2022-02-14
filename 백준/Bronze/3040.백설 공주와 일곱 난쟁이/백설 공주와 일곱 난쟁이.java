import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] src;
	static int[] tgt;
	static int N = 7;
	
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       src = new int[9];
       tgt = new int[N];
       
       for (int i = 0; i < 9; i++) {
    	   src[i] = Integer.parseInt(br.readLine());
       }
       
       comb(0, 0, 0);
       
       
    }
    
    static void comb(int srcIdx, int tgtIdx, int sum) {
    	
    	if(tgtIdx == N) {
    		if (sum == 100) {
    			for (int i = 0; i < N; i++) {
					System.out.println(tgt[i]);
				}
    		}
    		return;
    	}
    	
    	for (int i = srcIdx; i < 9; i++) {
			tgt[tgtIdx] = src[i];
			comb(i+1, tgtIdx + 1, sum + tgt[tgtIdx]);
		}
    }
}