/**
 * Anon
 * Assignment #7 triangle.java CSc 210, Spring 2017
 * implementation of Interaction program
 */
public class triangle extends shape{
    private String dir;
    private static int tri_id;
    private int blank_y_pos = 0;
    private int minus_y_pos = 0;
    private boolean hour_glass = false;
    private boolean hour_special = false;

    public triangle(String name, int int_height, String dir, char char_fill, int x_pos, int y_pos){
        super(name, int_height, char_fill, x_pos, y_pos);
        this.dir = dir;

    }

    public void dump(){
        System.out.println("TRIANGLE "+"(name:"+name+") (x:"+x_pos+") (y:"+y_pos+
                ") (height:"+int_height+") (area:"+String.format("%.6f",getArea())+") (direction:"+dir+
                ") (fill:"+char_fill+ ") (draw_amount:"+tri_id + ")");
    }


    public void draw() {
        /**draw method, consider several situations: 1. all the graph within border
         * 2. less than half in border
         * 3.more than half in border
         * 4.consider x and y two dimensions
         **/
        boolean x_bound = false;
        boolean y_bound = false;

        if (x_pos >= 0 && x_pos <= (95 - 2 * int_height) && y_pos >= 0 && y_pos <= (30 - int_height)) {
            x_bound = false;
            y_bound = false;
            if (dir.equals("UP")) {
                draw_head();
                draw_up(x_bound, y_bound,hour_glass);
            }
            if (dir.equals("DOWN")) {
                draw_head();
                draw_down(x_bound, y_bound,hour_glass);
            }
            draw_head();
            tri_id += 1;
            System.out.println();
        }
        if (y_pos > (30 - int_height) || (x_pos > 95 - 2 * int_height)) {
            if ((x_pos > 95 - 2 * int_height)) {
                x_bound = true;
                if (y_pos > (30 - int_height)) {
                    y_bound = true;
                    if (dir.equals("UP")) {
                        draw_head();
                        draw_up(x_bound, y_bound,hour_glass);

                    }
                    if (dir.equals("DOWN")) {

                        draw_head();
                        draw_down(x_bound, y_bound,hour_glass);
                    }
                } else {
                    y_bound = false;
                    if (dir.equals("UP")) {
                        draw_head();
                        draw_up(x_bound, y_bound,hour_glass);

                    }
                    if (dir.equals("DOWN")) {

                        draw_head();
                        draw_down(x_bound, y_bound,hour_glass);
                    }
                }
            }
            if ((x_pos < 95 - 2 * int_height)) {
                x_bound = false;
                if (y_pos > (30 - int_height)) {
                    y_bound = true;
                    if (dir.equals("UP")) {
                        draw_head();
                        draw_up(x_bound, y_bound,hour_glass);

                    }
                    if (dir.equals("DOWN")) {

                        draw_head();
                        draw_down(x_bound, y_bound,hour_glass);
                    }
                } else {
                    y_bound = false;
                    if (dir.equals("UP")) {
                        draw_head();
                        draw_up(x_bound, y_bound,hour_glass);

                    }
                    if (dir.equals("DOWN")) {

                        draw_head();
                        draw_down(x_bound, y_bound,hour_glass);
                    }
                }
            }
            draw_head();
            tri_id += 1;
            System.out.println("Shape exceeds bounds of screen");
        }

    }

    public void draw_up(boolean x_out_bound, boolean y_out_bound, boolean if_hour_glass){
        /**draw up triangle method, consider several situations: 1. all the graph within border
         * 2. less than half in border
         * 3.more than half in border
         * 4.consider x and y two dimensions
         **/
        boolean is_special = ((95-2*int_height) < x_pos && x_pos < (94 - int_height));
        int real_height = int_height-Math.abs(y_pos + int_height - 30);
        if(y_out_bound){

            if(!if_hour_glass) {
                for (int i = 0; i < y_pos; i++)
                    draw_board();
            }
            if(if_hour_glass && is_special){
                for (int i = 0; i < int_height - real_height; i++)
                    draw_board();
            }
            for (int i = 0; i < real_height; i++){
                System.out.print("*");
                for (int j = 0; j < Math.min(x_pos + int_height - i - 1,94); j++){
                    System.out.print(" ");
                }
                if(x_out_bound) {
                    for (int j = 0; j < Math.min(95+i-x_pos-int_height,2*i + 1); j++) {
                        System.out.print(char_fill);

                    }
                }
                if(!x_out_bound){
                    for (int j = 0; j < (2 * i + 1); j++) {
                        System.out.print(char_fill);
                    }
                }
                for (int j = (x_pos+int_height+i+1); j < 95; j++)
                    System.out.print(" ");
                System.out.println("*");
            }

            for (int i = y_pos + int_height + 1; i < 31; i++) {
                draw_board();
            }

        }
        if(!y_out_bound){
            int bound = x_out_bound ? 1 : 0;
            int special_bound = ((95-2*int_height) < x_pos && x_pos < (94 - int_height)) ? 1 : 0;
            int partial = ((x_pos < 94 - int_height) && (x_pos > 95 - 2*int_height)) ? 1 : 0;
            if(!if_hour_glass) {
                for (int i = 0; i < y_pos + bound * (int_height - 94 + x_pos)*(1-special_bound); i++) {
                    draw_board();
                }
            }
            if(if_hour_glass && is_special && partial == 0){
                for (int i = 0; i < int_height - real_height; i++) {
                    draw_board();
                }
            }
            for (int i = 0; i < int_height - bound*(int_height-94+x_pos)*(1-special_bound); i++) {
                System.out.print("*");
                for (int j = 0; j < (x_pos + int_height - i - 1) - bound*(int_height-94+x_pos)*(1-special_bound); j++)
                    System.out.print(" ");
                if (x_out_bound) {
                    for (int j = 0; j < i+1; j++) {
                        System.out.print(char_fill);

                    }
                    if(special_bound == 1){
                        for (int j = 0; j < Math.min(i,94-x_pos-int_height); j++){
                            System.out.print(char_fill);
                        }
                    }
                }

                if (!x_out_bound) {
                    for (int j = 0; j < (2 * i + 1); j++) {
                        System.out.print(char_fill);
                    }
                }
                for (int j = (x_pos + int_height + i + 1); j < 95; j++)
                    System.out.print(" ");
                System.out.println("*");
            }


            for (int i = y_pos + int_height + 1; i < 31; i++) {
                draw_board();
            }

        }

    }

    public void draw_down(boolean x_out_bound, boolean y_out_bound, boolean if_hour_glass){
        /**draw method, consider several situations: 1. all the graph within border
         * 2. less than half in border
         * 3.more than half in border
         * 4.consider x and y two dimensions
         **/
        boolean is_special = ((95-2*int_height) < x_pos && x_pos < (94 - int_height));
        int real_height = int_height-Math.abs(y_pos + int_height - 30);
        if(y_out_bound){

            for (int i = 0; i < y_pos; i++)
                draw_board();
            for (int i = 0; i < real_height; i++){
                System.out.print("*");
                for (int j = 0; j < Math.min(x_pos + i,94); j++){
                    System.out.print(" ");
                }
                if(x_out_bound) {
                    for (int j = 0; j < Math.min((2 * (int_height - i - 1) + 1),94-i-x_pos); j++) {
                        System.out.print(char_fill);

                    }
                }
                if(!x_out_bound){
                    for (int j = 0; j < (2 * (int_height - i - 1) + 1); j++) {
                        System.out.print(char_fill);
                    }
                }
                for (int j = (x_pos+2*int_height-i); j < 95; j++)
                    System.out.print(" ");
                System.out.println("*");
            }
            if(!if_hour_glass) {
                for (int i = y_pos + int_height + 1; i < 31; i++) {
                    draw_board();
                }
            }

        }
        if(!y_out_bound){
            int bound = x_out_bound ? 1 : 0;
            int special_bound = ((95-2*int_height) < x_pos && x_pos < (94 - int_height)) ? 1 : 0;
            int partial = ((x_pos < 94 - int_height) && (x_pos > 95 - 2*int_height)) ? 1 : 0;
            for (int i = 0; i < y_pos; i++)
                draw_board();
            for (int i = 0; i < int_height - bound*(int_height-94+x_pos)*(1-special_bound); i++) {
                System.out.print("*");
                for (int j = 0; j < x_pos + i; j++)
                    System.out.print(" ");
                if (x_out_bound) {
                    for (int j = 0; j < Math.min((2 * (int_height - i - 1) + 1),94-i-x_pos); j++) {
                        System.out.print(char_fill);
                    }
                    if(special_bound == 1){
                        for (int j = 0; j < Math.max(0,(95+i-x_pos-2*int_height)); j++) {
                            System.out.print(" ");
                        }
                    }
                }

                if (!x_out_bound) {
                    for (int j = 0; j < (2 * (int_height - i - 1) + 1); j++) {
                        System.out.print(char_fill);
                    }
                    for (int k = (x_pos+2*int_height-i); k < 95; k++)
                        System.out.print(" ");
                }
                System.out.println("*");
            }
            if(!if_hour_glass) {
                for (int i = y_pos + int_height + 1 - bound * (int_height - 94 + x_pos)*(1-special_bound); i < 31; i++) {
                    draw_board();
                }
            }
            if(if_hour_glass && is_special && partial == 0){
                for (int i = 0; i < int_height - real_height; i++) {
                    draw_board();
                }
            }
        }
    }

    public void double_method(){
        this.int_height = int_height*2;
    }

    public void half(){
        this.int_height = int_height/2;
    }



    public void draw_head(){
        for(int i = 0; i < 96; i++)
            System.out.print("*");
        System.out.println();
    }


    public void draw_board(){
        System.out.print("*");
        for (int i = 0; i < 94; i++){
            System.out.print(" ");
        }
        System.out.println("*");
    }


    public Double getArea(){
        return (2*int_height-1)*int_height*1/2.0;
    }

}
