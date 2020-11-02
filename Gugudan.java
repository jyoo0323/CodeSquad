import java.util.Scanner;
public class Gugudan {
	public static void main(String[] args) {
		int start,end;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("첫단을 입력해 주세요: ");
		start = sc.nextInt();
		System.out.println("끝단을 입력해 주세요: ");
		end = sc.nextInt();
		
		for(int i = start;i <= end; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d",i,j,i*j);
				System.out.println();
			}
		}
	}
}
