import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int  N, M, V;
	
	static boolean[] visit;
	static int[][] matrix;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		matrix = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			matrix[from][to] = 1;
			matrix[to][from] = 1;
		}
		
		dfs(V);
		sb.append("\n");
		
		for (int i = 0; i <= N; i++) {
			visit[i] = false;
		}
		
		bfs(V);
		
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
	}
	static void dfs(int start) {
		visit[start] = true;
		sb.append(start).append(" ");
		
		for (int i = 0; i <= N; i++) {
			if(visit[i] || matrix[start][i] == 0) continue;
			dfs(i);
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		visit[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			sb.append(current).append(" ");
			
			for (int i = 0; i <= N; i++) {
				if(visit[i] == true || matrix[current][i] == 0) continue;
				visit[i] = true;
				queue.offer(i);
			}
		}
	}
}