package hwalgo18_부울경_3반_이다영;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_녹색옷입은애가젤다지_4485 {

	
	static int N;
	static int[][] map, distance;
	static int min;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			map = new int[N][N];
			distance = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("Problem " + cnt++ + ": " + dijkstra());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static class Point implements Comparable<Point> {
		int r, c, w;

		public Point(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			int diff = this.w - o.w;
			return diff;
		}

	}


	private static int dijkstra() {
		// 초기값
		distance[0][0]=map[0][0];
		
		PriorityQueue<Point> pq=new PriorityQueue<Point>();
		pq.add(new Point(0, 0, map[0][0]));
		
		while(!pq.isEmpty()) {
			Point cur= pq.poll();
			
			for (int i = 0; i < 4; i++) {
				int ny=cur.r+dy[i];
				int nx=cur.c+dx[i];
				
				if(ny>=0 && ny<N && nx>=0 && nx<N) {
					// 현재 가중치보다 작다면 최소 비용이니까 update
					if(distance[ny][nx] > distance[cur.r][cur.c] + map[ny][nx]) {
						distance[ny][nx]=distance[cur.r][cur.c] + map[ny][nx];
						pq.add(new Point(ny,nx,distance[ny][nx]));
					}
				}
			}
		}
		return distance[N-1][N-1];
	}
}