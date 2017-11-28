public class Comments {
	/* Below are the contstuctors for a Comments object.
		Supports: int, double, String, Scanner, BufferedReader, and char
		
		NOTE: on Strings, scanners and BufferedReaders the first line must be an
		integer. It does not close the scanner or bufferered reader
	*/
	public Comments() {
		init(Defaults);
	}
	public Comments(int a) {
		init(a);
	}
	public Comments(double b) {
		init((int)b);
	}
	//  This is an unchecked operation and will fail if the passed string cannot be parsed
	public Comments(String c) {
		init(Integer.parseInt(c));
	}
	//  This is an unchecked operation and will fail if the passed string cannot be parsed
	public Comments(Scanner foo) {
		init(foo.nextInt());
	}
	//  This is an unchecked operation and will fail if the passed string cannot be parsed
	public Comments(BufferedReader br) {
		init(Integer.parseInt(br.readLine()));
	}
	public Comments(char a) {
		init((int)a)
	}
	//  end of constructors
	
	init(int a) {
		does some initalizing and perhaps runs a for loop setting
		up an array. I haven't written it yet but believe me it's a beauty
	}
}