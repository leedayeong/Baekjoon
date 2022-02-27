import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, H, W, N;
	static Queue<String> queue;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			queue = new ArrayDeque<>();
			
			for (int i = 1; i <= W; i++) {
				for (int j = 1; j <= H; j++) {
					if(i<10) {
						queue.offer(Integer.toString(j) + "0" + Integer.toString(i));
					}else {
						queue.offer(Integer.toString(j) + Integer.toString(i));
					}
				}
			}
			
			for (int i = 0; i < N-1; i++) {
				queue.poll();
			}
			sb.append(queue.poll()).append("\n");
		}
		System.out.println(sb);
	}

}