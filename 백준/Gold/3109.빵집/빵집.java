import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, ans;
	static char[][] map;
	
	static int[] dy = {-1, 0, 1}; // 우상-> 우-> 우하
//	static int[] dx = {1, 1, 1}; // 모두 1 이기때문에 dx배열 필요 없음! 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		// 각각의 행별로 따진다. 
		for (int i = 0; i < R; i++) {
			if(dfs(i, 0)) ans++;
		}
		
		System.out.println(ans);
	}
	static boolean dfs(int i, int j) {
		
		int nx = j + 1; // x는 항상 오른쪽으로 한 칸 이동!
		
		for (int d = 0; d < 3; d++) {
			int ny = i + dy[d];
			
			if(nx == C-1) return true; //끝까지 다 도착했으면 
			if(ny < 0 || ny >= R || map[ny][nx] == 'x') continue;
			
			map[ny][nx] = 'x'; // 방문할 인덱스를 x로 처리함으로써 다시 방문할수없도록 ! 
			// 해당하는 방향으로 가서  올바르게 갈 수 있다면!
			if(dfs(ny, nx)) return true;
			
		}
		return false;
	}
}