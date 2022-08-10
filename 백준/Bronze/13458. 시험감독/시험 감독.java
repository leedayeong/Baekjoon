import java.util.Scanner;

// 시험 감독
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		long cnt = 0; // 감독관 수
		int[] a = new int[n]; // 응시자 수
		
		for(int i=0; i<n; i++) {
			a[i] = input.nextInt();
		}
		
		int b = input.nextInt(); // 총감독이 맡을 수 있는 사람수
		int c = input.nextInt(); // 부감독이 맡을 수 있는 사람수
		
		for(int i=0; i<n; i++) {
			a[i]-=b;
			cnt++;
			
			// 총 감독이 맡을 수 있는 경우는 부감독 필요 없으므로 넘어감
			if(a[i]<=0) {
				continue;
			}
			// 부감독이 추가로 필요한 경우
			else {
				cnt += a[i]/c;
				// 나머지가 0보다 크면 부감독 한명 더 추가
				if(a[i]%c > 0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}