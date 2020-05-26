import java.util.HashMap;

import acm.program.ConsoleProgram;

public class Hashmap extends ConsoleProgram{
	public void run(){
		while(true) {
		int n = readInt("Enter Number");
		
		println(fibonacci(n));
	
	}
	}
	
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
