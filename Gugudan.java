import java.util.Scanner;
public class Gugudan {
	public static void main(String[] args) {
		int start,end;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("ù���� �Է��� �ּ���: ");
		start = sc.nextInt();
		System.out.println("������ �Է��� �ּ���: ");
		end = sc.nextInt();
		
		for(int i = start;i <= end; i++) {
			for(int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %d",i,j,i*j);
				System.out.println();
			}
		}
	}
}
