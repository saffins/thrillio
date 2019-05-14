package practice;

public class Zeros {

	public static void main(String[] args) {

		int[] zeros = { 0,0,7,1,2,8,9,7 };

		//int[] nonzeros = { 1, 2, 7, 8, 9, 0 };
		int zero = 0;
		int seven = 0;
		for (int i = 0; i < zeros.length; i++) {

		  int	NoZero = zeros[i];
			int NoSeven = zeros[i];

			if (NoZero == 0) {
            
				zero++;

			}

			if (NoSeven == 7) {
				seven++;
				break;
			}
			
			if(NoZero == 1 | NoSeven == 1){
				break;
			}

		}

		 

		if (zero == 2 ) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}

}
