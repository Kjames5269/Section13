public class Looper {
	private char[][] a;
	public Looper(char [][] a) {
		this.a = a;
	}
	
	public void setA(char[][] a) {
		this.a = a;
	}
	
	public void printIt() {
		int i = 0;
		int j = 0;
		while(j < a[i].length) {
			try {
				System.out.println(char[i][j]);
			}
			catch(Exception e) {
				i = 0;
				j++;
			}
		}
	}
}
		
	