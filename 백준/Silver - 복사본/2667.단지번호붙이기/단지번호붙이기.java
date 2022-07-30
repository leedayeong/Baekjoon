import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int N , COUNT = 0;
	static char[][] map;
	static List <Integer> list = new ArrayList<>();
	
	static int [] dy = {-1, 1, 0, 0}; // 상하좌우
	static int [] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '1') {
					COUNT = 0;
					find(i, j);
					list.add(COUNT);
				}
			}
		}
		Collections.sort(list);
		int size = list.size();
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i));
		}
		
	}
	static void find(int i, int j) {
		COUNT++;
		map[i][j] = '0';
		
		for (int d = 0; d < 4; d++) {
			int ny = i + dy[d];
			int nx = j + dx[d];
				
			if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
			if(map[ny][nx] != '1') continue;
			find(ny, nx);	
		}		
	}
}