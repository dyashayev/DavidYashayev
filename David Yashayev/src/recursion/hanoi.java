package recursion;

public class hanoi {

	public static void main(String[] args) {
		doHanoi(20,"A","B","C");
	}

	public static void doHanoi(int n, String start, String help, String end) {
		if(n == 1) {
			print(start + " to "+ end);
		}
		else {
			doHanoi(n-1,start,end,help);
			print(start + " to "+ end);
			doHanoi(n-1,help,start,end);
		}
	}
	
	public static void print(String s) {
		System.out.println(s);
	}
}
