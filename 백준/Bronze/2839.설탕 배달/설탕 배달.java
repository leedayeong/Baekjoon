import java.util.Scanner;

public class Main {

	static int W , COUNT;
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count = 0;
		
		while(true) {
			
			if(N < 0) { //0보다 작아지는 것은 딱 맞아 떨어지는 것이 아니므로! 
				System.out.println(-1);
				break;
			}
			if(N % 5 == 0) {
				System.out.println(N/5 + count);
				break;
			}else {// 3kg 봉투를 하나씩 쓴다!
				N -= 3;
				count++;
			}
		}
		sc.close();
	}
}