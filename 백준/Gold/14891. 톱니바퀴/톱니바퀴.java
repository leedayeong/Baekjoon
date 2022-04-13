import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int K;
	
	static int[][] command;
	static int[][] map;
	static int[] dir;
	static boolean[] isRotate;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[4][8];
		
		for (int i = 0; i < 4; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		K = Integer.parseInt(br.readLine());
		command = new int[K][2];
		
		StringTokenizer st = null;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			command[i][0] = Integer.parseInt(st.nextToken()) -1 ;
			command[i][1] = Integer.parseInt(st.nextToken());
			move(i);
		}
		
		int sum = 0;
		for (int d = 0; d < 4; d++) {
			if(map[d][0] == 1) sum+= Math.pow(2, d);
		}
		
		System.out.println(sum);
	}
	
	static void move(int i) {
		isRotate = new boolean[4];
		dir = new int[4];
		
		int wheel = command[i][0];
		int direction = command[i][1];
		
		isRotate[wheel] = true;
		dir[wheel] = direction;
		
		// 극비교
		// 오른쪽  확인
		for (int d = wheel + 1; d < 4; d++) {
			if(map[d-1][2] != map[d][6]) {
				dir[d] = dir[d-1] == 1 ? -1 : 1;
				isRotate[d] = true;
			}
			else break;
		}
		
		// 왼쪽 확인
		for (int d = wheel - 1; d >= 0; d--) {
			if(map[d+1][6] != map[d][2]) {
				dir[d] = dir[d+1] == 1 ? -1 : 1;
				isRotate[d] = true;
			}
			else break;
		}
		
		for (int d = 0; d < 4; d++) {
			if(isRotate[d]) rotate(d, dir[d]);
		}
		
	}
	
	static void comp(int i) {// 해당하는 톱니바퀴부터 일단 회전
		int wheel = command[i][0];
		int direction = command[i][1];
		
		rotate(wheel, direction);
	}
	
	static void rotate(int wheel, int dir) {
		
		if(dir == 1) {// 시계방향
			int last = map[wheel][7];
			for (int i = 7; i > 0; i--) {
				map[wheel][i] = map[wheel][i-1];
			}
			map[wheel][0] = last;
		}else { // 반시계방향
			int first = map[wheel][0];
			for (int i = 1; i <= 7; i++) {
				map[wheel][i-1] = map[wheel][i];
			}
			map[wheel][7] = first;
		}
	}

}