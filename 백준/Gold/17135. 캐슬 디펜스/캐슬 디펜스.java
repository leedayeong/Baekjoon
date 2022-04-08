import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 적군 : Enemy => ArrayList
// 궁사 3명 배열에는 position <= 조합
// 시물레이션
// 궁사 3명의 위치가 조합으로 정해지면 시뮬레이션 시작 
// 궁사 1명씩 쏜다 <= 쏘는 궁사와 적들의 거리를 계산 사정거리 안에 오는 적들을 PriorityQueue <= 정렬 기준
// 화살을 맞은 적은 죽은 걸로 count, 이동..

public class Main {
	
	static int N, M, D, max;
	static int[][] map;
	static int[] archer = new int[3]; //조합의 tgt
	
	static ArrayList<Enemy> enemyCopy = new ArrayList<>();
	static ArrayList<Enemy> enemy = new ArrayList<>();
	static PriorityQueue<Enemy> pqueue = new PriorityQueue<>( (e1, e2 ) ->  {
		return e1.d == e2.d ? e1.x - e2.x : e1.d - e2.d;
	} );
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		max = Integer.MIN_VALUE;
		
		map = new int[N][M];
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if(n == 1) enemyCopy.add(new Enemy(i, j));
			}
		}
		
		// 조합
		comb(0, 0);
		System.out.println(max);
	}
	
	static void check() {
		// 적군 자료구조 정리
		enemy.clear();
		for (Enemy e : enemyCopy) {
			enemy.add(new Enemy(e.y, e.x));
		}
		int dead = 0; // 죽는 적군의 수

		
		while(true) {
			// 궁사 3명 각각 활을 쏜다
			for (int i = 0; i < 3; i++) {
				int ac = archer[i]; // 궁사 1명을 꺼내서
				
				// 사정거리안에 드는 적군을 pqueue에 담는다.
				pqueue.clear();
				for (int j = 0; j < enemy.size(); j++) {
					Enemy e = enemy.get(j);
					e.d = Math.abs(ac - e.x) + Math.abs( N - e.y);
					// 유효사거리
					if( e.d <= D ) pqueue.offer(e);
				}
				
				// pqueue에 담긴 적들 중 하나를 꺼내서 죽음 처리
				if(!pqueue.isEmpty()) pqueue.poll().dead = true; 
			}
			
			// 죽은 적군 제거, 적군 이동
			Iterator<Enemy> iter = enemy.iterator();
			while(iter.hasNext()) {
				Enemy e = iter.next();
				if(e.dead) {
					iter.remove();
					dead++;
				}else if(e.y == N -1){ //한칸씩 내려갈 때 ey가 성으로 들어갈 수 있을 때
					iter.remove();
				}else {
					e.y ++;
				}
			}
			// dead 계산 
			
			if( enemy.size() == 0) break;
		}
		
		max = Math.max(max, dead);
	}
	
	static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == 3) {
			// complete code
			check();
			return;
		}
		
		if(srcIdx == M) return;
		
		archer[tgtIdx] = srcIdx;
		
		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}
	
	
	
	static class Enemy{
		int y;
		int x;
		int d; //궁수와의 거리
		boolean dead;
		
		public Enemy(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
