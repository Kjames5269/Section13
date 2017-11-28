/**
 * Anon
 * Assignment #7 rectangle.java CSc 210, Spring 2017
 * implementation of Interaction program
 */

public class rectangle extends shape{
    public static int int_width;
    private static int rec_id = 0;
    private int blank_y_pos = 0;
    private int minus_y_pos = 0;

    public rectangle(String name, int int_width, int int_height, char char_fill, int x_pos, int y_pos){
        super(name, int_height, char_fill, x_pos, y_pos);
        this.int_width = int_width;

    }
    public void dump(){

        System.out.println("RECTANGLE "+"(name:"+name+") (x:"+x_pos+") (y:"+y_pos+") (width:"+int_width+
                ") (height:"+int_height+") (area:"+getArea()+") (fill:"+char_fill+") (draw_amount:"+rec_id + ")");

    }

    public void draw(){
        /** "version" control, choose which kind of graph to implement
         * 1. intersect with x (there are more than one situation in this situation)
         * 2. intersect with y
         * 3. intersect with x&y
         * 4. intersect with neither x,y
         **/
        if (x_pos >= 0 && x_pos <= (94 - int_width) && y_pos >= 0 && y_pos <= (30-int_height)){
            draw_head();
            normal_draw(x_pos,y_pos,int_width,int_height,
                    char_fill,blank_y_pos,minus_y_pos);
            draw_head();
            System.out.println();
        }
        else{
            draw_head();
            draw_body(x_pos,y_pos,int_width,int_height,char_fill);
            draw_head();
            System.out.println("Shape exceeds bounds of screen");
            System.out.println();
        }
        rec_id += 1;
    }

    public void draw_head(){
        for(int i = 0; i < 96; i++)
            System.out.print("*");
        System.out.println();
    }


    public void draw_body(int x_pos,int y_pos,int int_width,int int_height,char char_fill){

        if (y_pos < 0) {
            blank_y_pos = 0;
            minus_y_pos = Math.abs(y_pos);
            if (x_pos < 0) {
                int_width = int_width - Math.abs(x_pos);
                x_pos = 0;
            }
            if (x_pos > 94 - int_width){
                int_width = 94 - x_pos;
            }
            normal_draw(x_pos,y_pos,int_width,int_height,
                    char_fill,blank_y_pos,minus_y_pos);
        }
        if (y_pos > (30-int_height)) {
            int_height = 30 - y_pos;
            minus_y_pos = Math.abs(y_pos+int_height-30);
            if (x_pos < 0) {
                int_width = int_width - Math.abs(x_pos);
                x_pos = 0;
            }
            if (x_pos > 94 - int_width){
                int_width = 94 - x_pos;
            }
            normal_draw(x_pos,y_pos,int_width,int_height,
                    char_fill,blank_y_pos,minus_y_pos);
        }
        if (x_pos < 0) {
            int_width = int_width - Math.abs(x_pos);
            x_pos = 0;
            if (y_pos < 0) {
                blank_y_pos = 0;
                minus_y_pos = Math.abs(y_pos);
            }
            if (y_pos > (30-int_height)){
                minus_y_pos = Math.abs(y_pos+int_height-30);
                y_pos = 30;
            }
            normal_draw(x_pos,y_pos,int_width,int_height,
                    char_fill,blank_y_pos,minus_y_pos);
        }
        if (x_pos > 94 - int_width){
            int_width = 94 - x_pos;
            if (y_pos < 0) {
                blank_y_pos = 0;
                minus_y_pos = Math.abs(y_pos);
            }
            if (y_pos > (30-int_height)){
                minus_y_pos = Math.abs(y_pos+int_height-30);
                y_pos = 30;
            }
            normal_draw(x_pos,y_pos,int_width,int_height,
                    char_fill,blank_y_pos,minus_y_pos);
        }

    }

    public void normal_draw(int x_pos, int y_pos, int int_width, int int_height,
                            char char_fill, int blank_y_pos,int minus_y_pos){
        for (int i = 0; i < Math.max(y_pos,blank_y_pos); i++)
            draw_board();
        for (int i = 0; i < int_height; i++){
            System.out.print("*");
            for (int j = 0; j < x_pos; j++)
                System.out.print(" ");
            for (int j = 0; j < int_width; j++){
                System.out.print(char_fill);
            }
            for (int j = Math.min(x_pos+int_width+1,95); j < 95; j++)
                System.out.print(" ");
            System.out.println("*");
        }
        for (int i = Math.min(y_pos+int_height+1,31); i < 31; i++){
            draw_board();
        }
    }

    public void draw_board(){
        System.out.print("*");
        for (int i = 0; i < 94; i++){
            System.out.print(" ");
        }
        System.out.println("*");
    }

    public void double_method(){
        this.int_width = int_width*2;
        this.int_height = int_height*2;
    }

    public void half(){
        this.int_width = int_width/2;
        this.int_height = int_height/2;
    }




    public String getArea(){
        return (int_width*int_height)+".000000";
    }


}
