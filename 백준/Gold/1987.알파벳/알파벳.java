
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, ans;
	static char[][] map;
	static int[] alphabet;
	
	static int[] dy = {-1, 1, 0, 0}; //상하좌우
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][];
		alphabet = new int[26];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		go(0, 0, 1);
		
		System.out.println(ans);
		
	}
	static boolean go(int y, int x, int cnt) {
//		System.out.println(y +" " + x +" : " +map[y][x]);
		
		alphabet[map[y][x] - 'A'] += 1;
		
		if(ans == R*C) return true;
		
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || nx < 0 || ny >= R || nx >=C) continue;
			if(alphabet[map[ny][nx] - 'A'] > 0) continue;
			
			go(ny, nx, cnt+1);
			alphabet[map[ny][nx] - 'A'] -= 1;

		}
		ans = Math.max(cnt, ans);
		
		return false;
	}
}
