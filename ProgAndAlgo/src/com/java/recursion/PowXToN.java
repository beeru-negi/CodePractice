package src.com.java.recursion;

public class PowXToN {

	public static void main(String [] str)
	{
		double x=2;
		int n=7;
		
		double s = myPow(x,n);
		
		System.out.print("Power of x= "+x+" to-> "+n +" is-> "+s);
	}
	public static double myPow(double x, int n) {
		double powerof10 = 0;

		if (n == 0) {
			return 1;
		}

		powerof10 = myPow(x, n / 2);

		if (n % 2 == 0.0) {
			return powerof10 * powerof10;
		} else {
			if (n > 0) {
				return x * powerof10 * powerof10;
			} else {
				return (1 / x) * powerof10 * powerof10;
			}

		}
	}
}
