
public class for_if_statements {
	public static void main(String[] args) {
		int A = Integer.parseInt(args[0]);
		int B = Integer.parseInt(args[1]);
		System.out.println(solution(A,B));
	 }
	public static String solution(int A, int B) {
		String ans = null;
		if(A < B) {
			ans = "<";
		}
		if(A == B) {
			ans = "==";
		}
		if(A > B) {
			ans = ">";
		}
		return ans;
	}
}