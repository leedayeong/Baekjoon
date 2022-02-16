import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, min;
	static int[][] src;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//초기화
		src = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());	
		}
		
		min = Integer.MAX_VALUE;
		
		comb(0, 1, 0); // 신 맛은 곱하기때문에 1을 줌 ! 
		
		System.out.println(min);
	}
	
	static void comb(int srcIdx, int sinSum, int ssnSum) {
		
		if(srcIdx == N) return; // 모든 재료를 다 확인해봤으면 return 하는 것 ! 
		
		int currSin = src[srcIdx][0] * sinSum;
		int currSsn = src[srcIdx][1] + ssnSum;
		
		min = Math.min(min, Math.abs(currSin - currSsn));
	
		comb(srcIdx + 1, currSin, currSsn); // 현재의 선택 O !
		comb(srcIdx + 1, sinSum, ssnSum);	// 현재 선택  X => 파라미터로 받은 값 그대로 전달 !  
		
	}
}