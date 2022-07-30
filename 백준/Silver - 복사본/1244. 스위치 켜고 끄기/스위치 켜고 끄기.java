import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 남학생은 1로, 여학생은 2
public class Main {
	static int N, K;
	static boolean[] switches ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		switches = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			switches[i] = Integer.parseInt(st.nextToken()) == 0 ? false : true;
		}
		
		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())  == 1) {
				//남학생
				int num = Integer.parseInt(st.nextToken());
				boy(num);
			}
			else {
				//여학생
				int num = Integer.parseInt(st.nextToken());
				girl(num);
			}
		}
		
		int size = N/20 + 1;
		int idx = 0;
		outer: for (int i = 0; i < size; i++) {
			for (int j = 0; j < 20; j++) {
				idx++;
				sb.append(switches[idx] == true ? "1 " : "0 ");
				if(idx == N) break outer;
			}
			sb.append("\n");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
		
	}
	static void boy(int num) {
		for (int i = num; i <= N; i+= num) {
			switches[i] = !switches[i];
		}
	}
	static void girl(int num) {
		switches[num] = !switches[num];
		int before = num - 1;
		int after = num + 1;
		while(true) {
			if(before < 1 || after > N) break;
			if(switches[before] != switches[after]) break;
			
			switches[before] = !switches[before];
			switches[after] = !switches[after];
			
			before --;
			after ++;
		}
	}

}