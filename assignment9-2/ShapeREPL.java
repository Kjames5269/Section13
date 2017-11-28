
import java.util.*;
public class ShapeREPL {

	private static Scanner input_;

	public static void main(String[] args) {
		HashMap<String, Shape> shapeHM=new HashMap<String, Shape>();
		input_ = new Scanner(System.in);
		Shape shapeUser;
		while(input_.hasNext()) {
			String command = input_.nextLine();
			//String[] info = new String [10];
			String [] info = command.split(" ");
			//format: DEFINEshape_nameSHAPE_TYPEparameters
			if (info[0].equals("DEFINE")) {
				if (info[2].equals("RECTANGLE")) {
					shapeUser = new Rectangle(Arrays.copyOfRange(info,3, info.length));
				}
				else if (info[2].equals("TRIANGLE")) {
					shapeUser = new Triangle(Arrays.copyOfRange(info,3, info.length));
				}
				else if (info[2].equals("PARALLELOGRAM")) {
					shapeUser = new Parallelogram(Arrays.copyOfRange(info,3, info.length));
				}
				else if (info[2].equals("HOURGLASS")) {
					shapeUser = new  Hourglass(Arrays.copyOfRange(info,3, info.length));
				}else {
					System.out.println("Invalid command.");
					continue;
				}
				shapeHM.put(info[1], shapeUser);
			}
		    //get shape set up shape
			else if (info[0].equals("DRAW")) {
				shapeHM.get(info[1]).draw();
			}
			else if (info[0].equals("DOUBLE")) {
				shapeHM.get(info[1]).doubleIt();
			}
			else if (info[0].equals("HALF")) {
				shapeHM.get(info[1]).half();
			}
			
			else if(info[0].equals("DUMP")) {
				String nameAr = info[1];
				System.out.println(shapeHM.get(info[1]).dumpChar(nameAr));
			}
			else {
				System.out.println("Invalid command.");
			}
		}
	}
}
