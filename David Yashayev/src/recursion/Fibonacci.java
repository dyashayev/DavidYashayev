package recursion;

public class Fibonacci {
	private static int number = 5;
	
	public static void main(String[] args) {
		for(int i = 0; i <= number;i++) {
			System.out.println(findFibonacci(i));
		}
	}

	public static int findFibonacci(int n) {
		if(n <= 1) {
			return 1;
		}else {
			return findFibonacci(n-1)+findFibonacci(n-2);
		}
		
	}
}