/**
 * Anon
 * Assignment #7 parallelogram.java CSc 210, Spring 2017
 * implementation of Interaction program
 */
public class parallelogram extends shape{
    private int int_width;
    private static int para_id;
    private int blank_y_pos = 0;
    private int minus_y_pos = 0;
    private boolean y_bound = false;
    private boolean x_bound = false;

    public parallelogram(String name, int int_width, int int_height, char char_fill, int x_pos, int y_pos){
        super(name, int_height, char_fill, x_pos, y_pos);
        this.int_width = int_width;


    }
    public void dump(){
        System.out.println("PARALLELOGRAM "+"(name:"+name+") (x:"+x_pos+") (y:"+y_pos+") (width:"+int_width+
                ") (height:"+int_height+") (area:"+getArea()+") (fill:"+char_fill+") (draw_amount:"+para_id + ")");
    }

    public void draw(){
        /**draw up triangle method, consider several situations: 1. all the graph within border
         * 2. less than half in border
         * 3.more than half in border
         * 4.consider x and y two dimensions
         **/
        if (x_pos >= 0 && x_pos <= (95 - int_width - int_height) && y_pos >= 0 && y_pos <= (30-int_height)){
            if (x_pos < 94 && x_pos > 94 - int_height){
                draw_head();
                draw_up(int_height, x_pos, y_pos);
            }
            else{
                draw_head();
                normal_draw(x_pos,y_pos,int_width,int_height, char_fill,blank_y_pos,minus_y_pos,false,false);
            }
            draw_head();
            System.out.println();
        }

        else{
            draw_head();
            if (125-x_pos-y_pos-int_height < 0){
                for (int i = 0 ; i < 30 ; i++)
                    draw_board();
            }
            else {
                draw_body(x_pos, y_pos, int_width, int_height, char_fill);
            }
            draw_head();
            System.out.println("Shape exceeds bounds of screen");
        }
        para_id += 1;
    }

    public void draw_head(){
        for(int i = 0; i < 96; i++)
            System.out.print("*");
        System.out.println();
    }

    public void draw_body(int x_pos,int y_pos,int int_width,int int_height,char char_fill){
        /** "version" control, choose which kind of graph to implement
         * 1. intersect with x (there are more than one situation in this situation)
         * 2. intersect with y
         * 3. intersect with x&y
         * 4. intersect with neither x,y
         **/
        if (y_pos > (30-int_height)) {
            int_height = 30 - y_pos;
            y_bound = true;
            minus_y_pos = Math.abs(y_pos+int_height-30);
            int x_bound = (x_pos > (95 - int_width - int_height)) ? 1 : 0;
            if (x_bound == 1){
                int_width = 95 - x_pos - int_height;
            }
            normal_draw(x_pos,y_pos,int_width,int_height,
                    char_fill,blank_y_pos,minus_y_pos,x_bound==1,y_bound);
        }

        if (x_pos > 95 - int_width - int_height){
            if (y_pos > (31-int_height)){
                y_bound = true;
                minus_y_pos = Math.abs(y_pos+int_height-30);
                y_pos = 30;
            }
            y_bound = false;
            int x_bound = (x_pos > (95 - int_width - int_height)) ? 1 : 0;
            if (x_bound == 1){
                int_width = 95 - x_pos - int_height;
            }
            normal_draw(x_pos,y_pos,int_width,int_height,
                    char_fill,blank_y_pos,minus_y_pos,x_bound==1,y_bound);
        }

    }

    public void draw_up(int int_height,int x_pos,int y_pos){
        // one situation you can transplant the up triangle into it
        boolean hour_glass = false;
        triangle up_tri = new triangle(name,int_height,"UP",char_fill,x_pos,y_pos);
        if (x_pos >= 0 && x_pos <= (95 - 2 * int_height) && y_pos >= 0 && y_pos <= (30 - int_height)) {
            x_bound = false;
            y_bound = false;
            up_tri.draw_up(x_bound, y_bound,hour_glass);
        }
        if (y_pos > (30 - int_height) || (x_pos > 95 - 2 * int_height)) {
            if ((x_pos > 95 - 2 * int_height)) {
                x_bound = true;
                if (y_pos > (30 - int_height)) {
                    y_bound = true;
                    up_tri.draw_up(x_bound, y_bound,hour_glass);

                } else {
                    y_bound = false;
                    up_tri.draw_up(x_bound, y_bound,hour_glass);
                }
            }

            if ((x_pos < 95 - 2 * int_height)) {
                x_bound = false;
                if (y_pos > (30 - int_height)) {
                    y_bound = true;
                    up_tri.draw_up(x_bound, y_bound,hour_glass);

                } else {
                    y_bound = false;
                    up_tri.draw_up(x_bound, y_bound,hour_glass);
                }
            }
        }
    }

    public void normal_draw(int x_pos,int y_pos,int int_width,int int_height,
                            char char_fill,int blank_y_pos,int minus_y_pos,boolean special,boolean y_out){
        int x_bound = special ? 1 : 0;
        int y_bound = y_out ? 0 : 1;
        for (int i = 0; i < Math.max(y_pos,blank_y_pos); i++)
            draw_board();
        for (int i = 0; i < int_height; i++){
            System.out.print("*");
            for (int j = 0; j < Math.min((x_pos+int_height-i-1),94); j++)
                System.out.print(" ");

            for (int j = 0; j < int_width + x_bound*i; j++){
                System.out.print(char_fill);
            }
            for (int j = (x_pos+int_width-i+int_height)+x_bound*i; j < 95; j++)
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
