
import java.util.*;

public class Triangle extends Shape{
    
	public Triangle (String[] info_) {
		super(Arrays.copyOfRange(info_, 2, 5));
		setDir(info_[1]);
		setHeight(Integer.parseInt(info_[0]));
		setArea( (Math.pow(getHeight(), 2) * (Math.sqrt(3) /4)));
	}
	public boolean doubleIt(){
		setHeight(getHeight()*2);
		setArea(getArea()*4);
		return false;
	}

	public void half() {
		setHeight(getHeight()/2);
		setArea(getArea()/4);
	}

	public char typeCharHere(int i, int j){
		if (getDir().equals("DOWN")) {
			int depthIn = j-getY();
			if ((getX()+depthIn<=i) && (i < 2*getHeight() -depthIn+getX())){
				if(j>=getY()&&j<getY()+getHeight()) {
				return getFil();
				}
			}
		}
		else {
			int depthIn = getY()-j;
			if ((getX()+depthIn<=i) && (i < 2*getHeight()-depthIn+getX())){
				if(j>=getY()&&j<getY()+getHeight()) {
				return getFil();
				}
			}			
		}	
		return ' ';
	}
	public String shapeType() {
		return "TRIANGLE";
	}
	
	public String dumpChar(String name) {
		String[] ret = super.dump(name);
		return ret[0]+ret[1]+" (direction:"+getDir()+")"+ret[2];
	}

}
