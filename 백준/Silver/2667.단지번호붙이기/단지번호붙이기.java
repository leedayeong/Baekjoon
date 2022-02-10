import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main {

	static char [][] map;
	static int N, cnt;
	static boolean[][] visit;
	
	static int[] dy = {-1, 1, 0, 0}; //상하좌우
	static int[] dx = {0, 0, -1, 1};
	
	static Queue<Node> queue = new ArrayDeque<>();
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][]; // toCharArray로 만들때에는 앞쪽에만 배열크기 지정함
		visit = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] != '1' || visit[i][j] ) continue; //방문했거나 1이 아닌집은 continue!!
				bfs(i, j);
				
				// cnt계산
				list.add(cnt);
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.size());
		
		for (int num : list) {
			System.out.println(num);
		}

	}
	static void bfs(int y, int x) {
		cnt = 1; // 새로운 단지의 시작
		visit[y][x] = true; //방문한 표시해줌
		
		queue.offer(new Node(y, x));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for (int i = 0; i < 4; i++) {//상하좌우
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
				
				if (ny < 0 || nx <0 || ny >= N || nx >= N) continue; // 범위 확인
				if (map[ny][nx] != '1' || visit[ny][nx]) continue; // 집이 아니거나 집을 방문한 경우 continue;
				
				cnt ++; // 단지 수 증가!
				visit[ny][nx] = true; //방문한 표시해줌
				
				queue.offer(new Node(ny, nx));
			}
		}
	}
	
	static class Node{
		int y, x;
		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}