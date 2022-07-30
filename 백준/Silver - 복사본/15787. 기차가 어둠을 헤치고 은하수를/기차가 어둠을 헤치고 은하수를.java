import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] train;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		train = new int[N];
	
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			
			int cmd = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken()) - 1; //기차번호 
			int num = 0; // x번째 승객 
			switch (cmd) {
				case 1: 
					num = Integer.parseInt(st.nextToken()) - 1;
					train[idx] = train[idx] | 1 << num;
					break;
				case 2: 
					num = Integer.parseInt(st.nextToken()) - 1;
					train[idx] = train[idx] & ~(1 << num);
					break;
				case 3: 
					train[idx] = train[idx] << 1;
					train[idx] = train[idx] & ~ (1 << 20);
					break;
				case 4: 
					train[idx] = train[idx] >> 1;
					break;
			}
		}
		
		HashSet<Integer> set = new HashSet<>();
		for (int num : train) {
			set.add(num);
		}
		
		System.out.println(set.size());
	}
}