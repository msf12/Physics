
public class Projectile 
{

	static double GRAVITY = 9.806; 
	
	public static void main (String[] args)
	{
	
		PhysicsObject pro = new PhysicsObject();
		
		double[] vel = new double[]{-1,0,0};
		double[] acc = new double[]{-GRAVITY,0,0};
		pro.setVel(vel);
		pro.setPos(new double[]{10,0,0});
		
		System.out.println("Vel "+ pro.getVel()[0] +" Pos "+ pro.getPos()[0]);
		
		while(pro.getPos()[0] > 0)
		{
			pro.timeStep(0.1);
			System.out.println("Vel "+ pro.getVel()[0] +" Pos "+ pro.getPos()[0]);
		}
		
	}
}
