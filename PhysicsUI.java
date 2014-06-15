//User info: position and velocity in xyz or position in xyz and velocity in magnitude, angle, angle
import java.util.Scanner;
import java.util.ArrayList;

public class PhysicsUI
{
	public static void main(String[] args) {
		boolean addObjects = true;
		Scanner sc = new Scanner(System.in);
		int DIM = 3; //this exists for potential in the future to do 2D
		ArrayList<PhysicsObject> objects = new ArrayList<PhysicsObject>();
		do {
			System.out.println("Would you like to add a new object? [y/N]");
			addObjects = sc.nextLine().trim().equalsIgnoreCase("y");
			if(addObjects) {
				PhysicsObject newObject = new PhysicsObject();
				String[] in;
				//does this object have mass?
				System.out.println("Would you like to set the object's mass? [y/N]");
				if(sc.nextLine().equalsIgnoreCase("y")) {
					System.out.println("What is the object's mass?");
					newObject.setMass(sc.nextDouble());
				}
				//does it have velocity?
				System.out.println("Would you like to set the object's velocity? [y/N]");
				if(sc.nextLine().equalsIgnoreCase("y")) {
					//how will velocity be added?
					System.out.println("What form would you like to add velocity in?\n[1] (x,y,z)\n[2] (magnitude,theta,phi)");
					if(Integer.parseInt(sc.nextLine()) == 1) {
						double[] velocity = new double[DIM];
						do {
							System.out.println("What is the object's velocity in the form (x,y,z)?");
							in = sc.nextLine().replaceAll("[^0-9,.]","").split(",");
						} while(in.length != DIM);
						for(int i = 0; i < DIM; i++) {
							velocity[i] = Double.parseDouble(in[i]);
							// System.out.println(velocity[i]);
						}
						newObject.setVel(velocity);
					}
					else if(Integer.parseInt(sc.nextLine()) == 2) {
						double[] velocity = new double[DIM];
						do {
							System.out.println("What is the object's velocity in the form (magnitude,theta,phi)?");
							in = sc.nextLine().replaceAll("[^0-9,.]","").split(",");
						} while(in.length != DIM);
						for(int i = 0; i < DIM; i++) {
							velocity[i] = Double.parseDouble(in[i]);
							// System.out.println(velocity[i]);
						}
						newObject.setVelAngle(velocity[0],velocity[1],velocity[2]);
					}
				}
				//does it have a specific position?
				System.out.println("Would you like to set the object's position? [y/N]");
				if(sc.nextLine().equalsIgnoreCase("y")) {
					double[] position = new double[DIM];
					do {
						System.out.println("What is the object's position in the form (x,y,z)?");
						in = sc.nextLine().replaceAll("[^0-9,.]","").split(",");
					} while(in.length != DIM);
					for(int i = 0; i < DIM; i++) {
						position[i] = Double.parseDouble(in[i]);
						// System.out.println(position[i]);
					}
					newObject.setPos(position);
				}
				objects.add(newObject);
			}
		} while(addObjects);

	}
}