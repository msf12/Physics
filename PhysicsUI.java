//User info: position and velocity in xyz or position in xyz and velocity in magnitude, angle, angle
import java.util.Scanner;
import java.util.ArrayList;

public class PhysicsUI
{
	public static void main(String[] args) {
		boolean addObjects = true;
		Scanner sc = new Scanner(System.in);
		int DIM = 3; //this exists for potential in the future to do 2D
		double[] position = new double[DIM];
		ArrayList<PhysicsObject> objects = new ArrayList<PhysicsObject>();
		do {
			System.out.println("Would you like to add a new object? [y/N]");
			addObjects = sc.nextLine().trim().equalsIgnoreCase("y");
			if(addObjects) {
				String[] in;
				//does this object have mass?
				
				//does it have velocity?
					//how will velocity be added?

				//does it have a specific position?
				do {
					System.out.println("What is the object's position in the form (x,y,z)?");
					in = sc.nextLine().replaceAll("[^0-9,.]","").split(",");
				} while(in.length != DIM);
				for(int i = 0; i < DIM; i++) {
					position[i] = Double.parseDouble(in[i]);
					System.out.println(position[i]);
				}
				objects.add(new PhysicsObject(position));
			}
		} while(addObjects);

	}
}