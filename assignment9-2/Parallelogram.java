
import java.util.*;
public class Parallelogram extends Shape{

    public Parallelogram (String[] info_){
        //int int_width, int int_height, char char_fill, int int_xpos, int int_ypos 
        super(Arrays.copyOfRange(info_, 2, 5));
        setWidth(Integer.parseInt(info_[0]));
        setHeight(Integer.parseInt(info_[1]));
        setArea(getWidth()*getHeight());
    }
    
    public String dumpChar(String name){
        String [] baseStr = super.dump(name);
        return baseStr[0]+" (width:"+getWidth()+")"+baseStr[1]+baseStr[2]; 
    }

    public String shapeType() {
        return "PARALLELOGRAM";
    }
    
    public boolean doubleIt(){
        setHeight(getHeight()*2); setWidth(getWidth()*2);
        setArea(getHeight()*getWidth());
    return shapeToLg();
    }
    
    public void half(){
        setHeight(getHeight()/2); setWidth(getHeight()/2);
        setArea(getHeight()*getWidth());
    }

    public char typeCharHere(int i, int j){
    		int shift = getHeight()-j+getY()-1;
    		if (i>=getX()+getWidth()) {
    			return ' ';
    		}
    		if (i>=getX()+getHeight()) {
    			return ' ';
    		}
    		if ((i<getX()||i>=getX()+getWidth()+shift)||(j<getY())) {
    			return ' ';
    		}
    		if (getX()+shift<=i&& i<getX()+getWidth()+shift) {
    			return getFil();
    		}
        return ' ';
    }
    
    public int getWidth() {
		return super.getWidth();
	}
	public int getHeight() {
		return super.getHeight();
	}

    
}
