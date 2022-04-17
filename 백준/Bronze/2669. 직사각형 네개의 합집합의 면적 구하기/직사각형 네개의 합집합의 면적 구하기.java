import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N = 101, ans;
	static boolean [][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new boolean[N][N];
		
		StringTokenizer st = null;
		for (int t = 0; t < 4; t++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			for (int i = sy; i < ey; i++) {
				for (int j = sx; j < ex; j++) {
					map[i][j] = true;
				}
			}
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if(map[i][j]) ans++;
			}
		}
		System.out.println(ans);
	}
}