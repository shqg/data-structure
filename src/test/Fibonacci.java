package test;

public class Fibonacci{
	 
		public static void main(String[] args) {
		System.out.println(fibonacci(10));
			 for(int i=1;i<=10;i++){
				 System.out.println(fibonacci(i));
			 }
		}

		static int fibonacci(int n) {
			 
		if (n == 1 || n == 2)
		return 1;
		else
		 
		return fibonacci(n - 1) + fibonacci(n - 2);
		 
		}  
		}