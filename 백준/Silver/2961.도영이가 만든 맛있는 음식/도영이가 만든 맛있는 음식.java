import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, min;
	static int[][] src;
//	static boolean[] select;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//초기화
		src = new int[N][2];
//		select = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			src[i][0] = Integer.parseInt(st.nextToken());
			src[i][1] = Integer.parseInt(st.nextToken());	
		}
		
		min = Integer.MAX_VALUE;
		
		// 모든 부분집합의 수
		int size = 1 << src.length; // 5개 기준 (2*2*2*2*2) : 000001 => 100000 이 됨 
		
		for (int i = 1; i < size; i++) { // 모든 경우의 수를 도는 것임 !  i range 0 ~ 31 
										 // 하지만, 문제에서는  공집합을 제외하라고했음(재료는 한개이상)! 그래서 i = 1 부터 시작하도록 !
			// 한 개의 부분집합을 의미
			
			int sin = 1;
			int ssn = 0;
			
			for (int j = 0; j < src.length ; j++) { // 한 개의 만들어진 부분집합을 한자리씩 도는 것 ! (선택 유무 확인 용도)
				if( (i & (1 << j)) != 0 ) { // i가 select의 의미인데 만약 i=0 => 000000 , i=1 => 000001, i=2 -> 0000010 ..., i = 31 -> 011111
											// j 가 인덱스 0, 1, 2, 3, 4 번째 자리 탐색했을 때 i가 1인 경우 => 선택됨! 
											// 즉, 위의 i가 표현하는 부분집합 0과 1중 현재 j가 선택되어 있다는 의미
					sin *= src[j][0];
					ssn += src[j][1];
				}
			}
			
			min = Math.min(min, Math.abs(sin - ssn));
			
		}
		
		System.out.println(min);
	}
}