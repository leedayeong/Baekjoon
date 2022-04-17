import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] Acard;
	static int[] Bcard;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
	
		StringTokenizer st = null;
		for (int t = 0; t < N; t++) {
			Acard = new int[5];
			Bcard = new int[5];
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < A; i++) {
				Acard[Integer.parseInt(st.nextToken())]++;
			}
			
			st = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < B; i++) {
				Bcard[Integer.parseInt(st.nextToken())]++;
			}
			
			boolean chk = false;
			for (int i = 4; i > 0; i--) {
				if(Acard[i] > Bcard[i]) {
					chk = true;
					sb.append("A\n");
					break;
				}else if(Acard[i] < Bcard[i]) {
					chk = true;
					sb.append("B\n");
					break;
				}
			}
			
			if(!chk) sb.append("D\n");
		}
		
		System.out.println(sb);
	}
}