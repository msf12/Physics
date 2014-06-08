
public class Projectile 
{

	static double GRAVITY = 9.806; 
	
	public static void main (String[] args)
	{
	
		PhysicsObject pro = new PhysicsObject();
		
		double[] vel = new double[]{10,10,10};
		double[] acc = new double[]{-GRAVITY,0,0};
		pro.setVel(vel);
		
		System.out.println("Vel "+ vel[0] +" Pos "+ pro.getPos()[0]);
		
		while(pro.getPos()[0] > -0.000001)
		{
			pro.timeStepAcc(0.0001, acc);
			System.out.println("Vel "+ vel[0] +" Pos "+ pro.getPos()[0]);
		}
		
	}
}
