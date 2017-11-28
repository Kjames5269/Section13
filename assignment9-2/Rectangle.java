
public class Rectangle extends Parallelogram{

	public Rectangle(String[] info_) {
		super(info_);
	}
  
    public String shapeType() {
    		return "RECTANGLE";
    }
	public char typeCharHere(int i, int j){
		if ((i>=getY() && i<getY()+getHeight())&&(j>=getX() && j<getX()+getWidth())) {
			return fil;
		}
		return ' ';
	}
}

