
import java.util.*;
import java.text.DecimalFormat;

public class Hourglass extends Triangle {

	public Hourglass(String[] info_) {
        setFil(info_[0].charAt(1));
        setX(Integer.parseInt(info_[1]));
        setY(Integer.parseInt(info_[2]));
        setDrawAmt(0);
	}

	public void draw() {
        System.out.println("************************************************************************************************");
        int i, j;
        for (i=0; i<30;i++){
            System.out.print("*");
            for (j = 0; j<94;j++){
            		//if()
            		//	System.out.print(getFil());
            		//else if () {
            		//	System.out.print(getFil());
            		//}
            		//else {
            			System.out.print(' ');
            		//}
            }
            System.out.println("*");
        }
        System.out.println("************************************************************************************************\n");

	}

	public String dumpChar(String name) {
		DecimalFormat formateArea = new DecimalFormat("#.######");

		String s1 = "HOURGLASS (name:"+name+") (x:"+getX()+") (y:"+getY()+")";
		String s2 = " (height:"+getHeight()+") (area:"+formateArea.format(getArea())+")";
		String s3 = " (fill:" +getFil()+") (draw_amount:"+getDrawAmt()+")";
		return s1+s2+s3;
		
	}

}
