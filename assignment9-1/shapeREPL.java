

import java.util.*;
public class shapeREPL{
    static String[] def = new String[99999];


    static String[] rec_words = new String[0];
    static String[] para_words = new String[0];
    static String[] tri_words = new String[0];
    static String[] hour_words = new String[0];
    static int is_double = 1;
    static double is_half = 1;
    public static void main(String args[]) {
        HashMap<String, shape> str_shape = new HashMap<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            parseLine(in.nextLine(),str_shape);

        }
    }

    public static void parseLine(String line, HashMap<String,shape> str_shape) {

        if (line.toLowerCase().compareTo("") == 0) {
            System.exit(0);
        } else if (non_opr(line)) {
            System.out.println("Invalid command.");
        } else {
            if (line.substring(0, 6).toLowerCase().compareTo("define") == 0) {
                String[] words = line.split("\\s+");
                String kind = words[2];
                if (kind.equals("RECTANGLE") || kind.equals("PARALLELOGRAM")) {
                    int int_width = Integer.parseInt(words[3]);
                    int int_height = Integer.parseInt(words[4]);
                    char char_fill = words[5].charAt(1);
                    int x_pos = Integer.parseInt(words[6]);
                    int y_pos = Integer.parseInt(words[7]);
                    String name = words[1];
                    if (kind.equals("RECTANGLE")) {
                        rectangle rec = new rectangle(name, int_width, int_height, char_fill, x_pos, y_pos);
                        str_shape.put(name, rec);
                    } else {
                        parallelogram para = new parallelogram(name, int_width, int_height, char_fill, x_pos, y_pos);
                        str_shape.put(name, para);
                    }
                }
                else if (kind.equals("TRIANGLE")) {
                    int int_height = Integer.parseInt(words[3]);
                    String dir = words[4];
                    char char_fill = words[5].charAt(1);
                    int x_pos = Integer.parseInt(words[6]);
                    int y_pos = Integer.parseInt(words[7]);
                    String name = words[1];
                    triangle tri = new triangle(name, int_height, dir, char_fill, x_pos, y_pos);
                    str_shape.put(name, tri);
                } else {
                    int int_height = Integer.parseInt(words[3]);
                    char char_fill = words[4].charAt(1);
                    int x_pos = Integer.parseInt(words[5]);
                    int y_pos = Integer.parseInt(words[6]);
                    String name = words[1];
                    hourglass hour = new hourglass(name, int_height, char_fill, x_pos, y_pos);
                    str_shape.put(name, hour);
                }
            } else if (line.substring(0, 4).toLowerCase().compareTo("draw") == 0) {
                String[] words = line.split("\\s+");
                for (String key : str_shape.keySet()){
                    if (key.equals(words[1])) {
                        str_shape.get(key).draw();
                    }

                }

            } else if (line.substring(0, 4).toLowerCase().compareTo("dump") == 0) {
                String[] words = line.split("\\s+");
                for (String key : str_shape.keySet()){
                    if (key.equals(words[1])) {
                        str_shape.get(key).dump();
                    }

                }
            } else if (line.substring(0, 6).toLowerCase().compareTo("double") == 0) {
                String[] words = line.split("\\s+");
                for (String key : str_shape.keySet()){
                    if (key.equals(words[1])) {
                        str_shape.get(key).double_method();
                    }

                }
            } else if (line.substring(0, 4).toLowerCase().compareTo("half") == 0) {
                String[] words = line.split("\\s+");
                for (String key : str_shape.keySet()){
                    if (key.equals(words[1])) {
                        str_shape.get(key).half();
                    }

                }
            }
        }
    }


    public static int to_int(double db){
        if(db-(int)Math.floor(db) == 0.5)
            return (int)Math.floor(db);
        else
            return (int)Math.floor(db);
    }



    public static boolean non_opr(String line) {
        int cnt = 0;
        String[] words = line.split("\\s+");
        String operation = words[0];
        String[] valid_opr = {"DUMP","DRAW","DOUBLE","HALF","DEFINE"};
        for(String opr: valid_opr){
            if(!operation.equals(opr))
                cnt++;
        }
        if (cnt==5)
            return true;
        else
            return false;

    }


}





