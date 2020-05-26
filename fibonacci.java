public class Fibonacci {
	
	private long fibonacci(int n) {
		long a = 1;
		long b = 1;
		for(int i = 3; i <= n; i++) {
			b += a;
			a = b - a;
		}
		return b;
	}
}
