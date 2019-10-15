package demo;

public class BadAlgorithm {

	public static int getSolution(int z) {

		boolean[] b = new boolean[z];;
		int c = 0;
		int k = 0;
		int tmp = 0;

		while (c < z - 1) {
			tmp = k;
			
			do {
				tmp = (tmp + 1) % z;
			} while (b[tmp]);
			
			
			b[tmp] = true;
			c++;
			tmp = k;
			
			
			do {
				tmp = (tmp + 1) % z;
			} while (b[tmp]);
			
			
			k = tmp;
		}
		return k;
	}

}
