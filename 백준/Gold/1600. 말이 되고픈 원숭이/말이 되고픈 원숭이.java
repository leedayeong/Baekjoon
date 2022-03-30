import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K, W, H, ans;
	
	static int[][] map;
	static boolean[][][] visit;
	static Queue<Node> queue = new ArrayDeque<>(); 
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	static int[] hy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hx = {2, 1, -1, -2, -2, -1, 1, 2};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		
		visit = new boolean[K+1][H][W];
		
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		queue.offer(new Node(0, 0, K));
		
		for (int i = 0; i <= K ; i++) {
			visit[i][0][0] = true;
		}
		
		bfs();

	}
	
	public static void bfs() {
		
		while(!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Node n = queue.poll();
				visit[n.k][n.y][n.x] = true;
				if(n.y == H-1 && n.x == W-1) {
					// 도착
					System.out.println(ans);
					return;
				}
				
				if(n.k > 0) {
					// 일반적으로 가기
					for (int d = 0; d < 4; d++) {
						int ny = n.y + dy[d];
						int nx = n.x + dx[d];
						
						if(ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
						if(map[ny][nx] == 1 || visit[n.k][ny][nx]) continue; 
						visit[n.k][ny][nx] = true;
						queue.offer(new Node(ny, nx, n.k));
					}
					// 말처럼 가기
					for (int d = 0; d < 8; d++) {
						int ny = n.y + hy[d];
						int nx = n.x + hx[d];
						
						if(ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
						if(map[ny][nx] == 1 || visit[n.k-1][ny][nx]) continue; 
						visit[n.k-1][ny][nx] = true;
						queue.offer(new Node(ny, nx, n.k-1));
					}
				}else {
					// 일반적으로 가기
					for (int d = 0; d < 4; d++) {
						int ny = n.y + dy[d];
						int nx = n.x + dx[d];
						
						if(ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
						if(map[ny][nx] == 1 || visit[n.k][ny][nx]) continue; 
						visit[n.k][ny][nx] = true;
						queue.offer(new Node(ny, nx, n.k));
					}
				}
			}
			ans++;
		}
		// 도착 못하면
		System.out.println(-1);
	}
	
	
	static class Node{
		int y, x, k;
		public Node (int y, int x, int k) {
			this.y = y;
			this.x = x;
			this.k = k;
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", k=" + k + "]";
		}
	}
}