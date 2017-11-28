public class Looper {
	private char[][] a;
	public Looper(char [][] a) {
		this.setA(a);
	}
	
	public void setA(char[][] a) {
		this.a = a;
	}
	
	public void printIt() {
		int i = 0;
		int j = 0;
		while(j < a[i].length) {
			if(i < a.length)
				System.out.println(char[i][j]);
			else {
				i = 0;
				j++;
			}
		}
	}
}
		
	