/**
 * Anon
 * Assignment #7 hourglass.java CSc 210, Spring 2017
 * implementation of Interaction program
 */
public class hourglass extends shape{
    private static int hour_id;
    boolean x_bound = false;
    boolean y_bound = false;



    public hourglass(String name, int int_height,char char_fill, int x_pos, int y_pos){
        super(name, int_height, char_fill, x_pos, y_pos);
    }

    public void dump(){
        //dump method
        System.out.println("HOURGLASS "+"(name:"+name+") (x:"+x_pos+") (y:"+y_pos+
                ") (height:"+int_height+") (area:"+String.format("%.6f",getArea())+
                ") (fill:"+char_fill+ ") (draw_amount:"+hour_id + ")");
    }

    public void draw(){
        /**draw method, consider several situations: 1. all the graph within border
         * 2. less than half in border
         * 3.more than half in border
         * 4.consider x and y two dimensions
         **/
        int down_height = (int)Math.ceil(int_height/2.0);
        int up_height = (int)Math.floor(int_height/2.0);
        int up_x_pos = x_pos + down_height - up_height;
        int up_y_pos = y_pos + down_height;
        boolean down_special = (x_pos > 94 - down_height && x_pos < 94) ? true: false;
        boolean up_special = (up_x_pos > 94 - up_height && x_pos < 94) ? true: false;
        int no_up = (y_pos+down_height > 30) ? 1 : 0;
        int int_up_special = up_special ? 1 : 0;
        if (y_pos > (30 - int_height) || (x_pos > 95 - 2 * down_height)) {
            System.out.println("Shape exceeds bounds of screen");
        }
        draw_head();
        draw_down(down_height,x_pos,y_pos);
        if (down_special){
            for (int i = 0; i < Math.min(down_height - 94 + x_pos,x_pos-y_pos-64); i++) {
                draw_board();
            }
        }
        if (up_special && (no_up == 0)){
            for (int i = 0; i < Math.min(up_height - 94 + up_x_pos,30-y_pos-down_height) ; i++) {
                draw_board();
            }
        }
        if (y_pos + down_height + Math.min(up_height - 94 + up_x_pos,30-y_pos-down_height) +
                Math.min(up_height - 94 + up_x_pos,30-y_pos-down_height)< 30) {
            draw_up(up_height, up_x_pos, up_y_pos);
        }
        draw_head();
        hour_id += 1;
        System.out.println();
    }

    public void draw_down(int int_height,int x_pos,int y_pos){
        /**draw down triangle method, consider several situations: 1. all the graph within border
         * 2. less than half in border
         * 3.more than half in border
         * 4.consider x and y two dimensions
         * 5. it's a lot different from the original draw triangle method, especially when you reach the border
         **/
        boolean hour_glass = true;
        triangle down_tri = new triangle(name,int_height,"DOWN",char_fill,x_pos,y_pos);
        if (x_pos >= 0 && x_pos <= (95 - 2 * int_height) && y_pos >= 0 && y_pos <= (30 - int_height)) {
            x_bound = false;
            y_bound = false;
            down_tri.draw_down(x_bound, y_bound,hour_glass);
        }
        if (y_pos > (30 - int_height) || (x_pos > 95 - 2 * int_height)) {
            if ((x_pos > 95 - 2 * int_height)) {
                x_bound = true;
                if (y_pos > (30 - int_height)) {
                    y_bound = true;
                    down_tri.draw_down(x_bound, y_bound,hour_glass);

                } else {
                    y_bound = false;
                    down_tri.draw_down(x_bound, y_bound,hour_glass);
                }
            }

            if ((x_pos < 95 - 2 * int_height)) {
                x_bound = false;
                if (y_pos > (30 - int_height)) {
                    y_bound = true;
                    down_tri.draw_down(x_bound, y_bound,hour_glass);

                } else {
                    y_bound = false;
                    down_tri.draw_down(x_bound, y_bound,hour_glass);
                }
            }
        }
    }

    public void draw_up(int int_height,int x_pos,int y_pos){
        /**draw up triangle method, consider several situations: 1. all the graph within border
         * 2. less than half in border
         * 3.more than half in border
         * 4.consider x and y two dimensions
         **/
        boolean hour_glass = true;
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




    public void draw_head(){
        //draw the first and last line
        for(int i = 0; i < 96; i++){
            System.out.print("*");
        }
        System.out.println();
    }

    public void double_method(){
        this.int_height = int_height*2;
    }

    public void half(){
        this.int_height = int_height/2;
    }




    public Double getArea(){
        //get area
        int down_height = (int)Math.ceil(int_height/2.0);
        int up_height = (int)Math.floor(int_height/2.0);
        triangle tri_up = new triangle(name, up_height, "down",char_fill, x_pos,y_pos);
        triangle tri_down = new triangle(name, down_height,"up",char_fill,x_pos,y_pos);
        double area = tri_up.getArea() + tri_down.getArea();
        return area;
    }

    public void draw_board(){
        //draw the lines without graph
        System.out.print("*");
        for (int i = 0; i < 94; i++){
            System.out.print(" ");
        }
        System.out.println("*");
    }


}
