
import java.text.DecimalFormat;
//files Shape.java,   Rectangle.java,   Triangle.java,   Parallelogram.java,   and Hourglass.java.
abstract class Shape{
	protected double area;
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    protected char fil;
    protected int drawAmt;
    protected String dir;
    
    protected Shape(String[] info_){
    		
        fil = info_[0].charAt(1);
        x = Integer.parseInt(info_[1]);
        y = Integer.parseInt(info_[2]);
        drawAmt = 0;
    }
	//---------------methods---
    abstract public boolean doubleIt();

    abstract public void half();

    abstract public char typeCharHere(int i, int j);
    
    abstract public String shapeType();
    
    abstract public String dumpChar(String name);
    
    public boolean shapeToLg() {
    		for (int row=0;row<94;row++) {
    			if (typeCharHere(row, 31)!=' '||typeCharHere(row, -1)!=' ') {
    				return true;
    			}
    		}
    		for(int col=0; col<31;col++) {
    			if(typeCharHere(94, col)!=' '|| typeCharHere(-1, col)!=' ') {
    				return true;
    			}
    		}
    		return false;
    }
    public void draw()
    {
        if (shapeToLg()){//true=>too large
            System.out.println("Shape exceeds bounds of screen");
        }
        drawAmt++;
        System.out.println("************************************************************************************************");
        int i, j;
        for (i=0; i<30;i++){
            System.out.print("*");
            for (j = 0; j<94;j++){
                System.out.print(typeCharHere(i,j));
            }
            System.out.println("*");
        }
        System.out.println("************************************************************************************************\n");
    }
    public String[] dump(String name) {
	    	DecimalFormat formateArea = new DecimalFormat("#.######");

    		String s1 = shapeType()+" (name:"+name+") (x:"+x+") (y:"+y+")";
        String s2 = " (height:"+height+") (area:"+formateArea.format(area)+")";
        String s3 = " (fill:" +fil+") (draw_amount:"+drawAmt+")";
        String[] dumpStr = {s1, s2, s3};
        return dumpStr;
    }
    /*-----------------SETTERS-----*/

    public void setPosition(int x_, int y_){
        x = x_;
        y = y_;
    }
    public void setFil(char fil_){
        fil = fil_;
    }
    public void setHeight(int h_) {
    		height = h_;
    }
    public void setWidth(int w_) {
    		width = w_;
    }
    public void setArea(double a_) {
    		area = a_;
    }
    public void setDir(String di) {
    		dir=di;
    }
    public void setDrawAmt(int v){
        drawAmt=v;
    }
    public void setX(int x_) {
        x = x_;
    }
    public void setY(int y_) {
        y = y_;
    }
    /*-------------------GETTERS-----*/
    public int[] getPosition(){
    		int[] pos_ = {x,y};
        return pos_;
    }
    public int getX() {
    		return x;
    }
    public int getY() {
    		return y;
    }
    public char getFil(){
        return fil;
    }
    public int getWidth() {
    		return width;
    }
    public int getHeight() {
    		return height;
    }
    public double getArea() {
    		return area;
    }
    public String getDir() {
    		return dir;
    }
    public int getDrawAmt() {
    		return drawAmt;
    }
}
