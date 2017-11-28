/**
 * Anon
 * Assignment #7 shape.java CSc 210, Spring 2017
 * implementation of Interaction program
 */
public abstract class shape {
    public String name;
    public int x_pos;
    public int y_pos;
    public int int_height;
    public static char char_fill;
    public int ratio;
    public shape(String name, int int_height, char char_fill, int x_pos, int y_pos){
        this.name = name;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.int_height = int_height;
        this.char_fill = char_fill;
    }

    public abstract void draw();
    public abstract void dump();
    public abstract void double_method();
    public abstract void half();
}
