
public class PhysicsObject 
{
	private static int DIM =3;
	
	private double[] velocity = new double[DIM];
	
	private double[] position = new double[DIM];
	
	private double mass;
	
	//Create small, Massless, motionless
	
	public PhysicsObject ()
	{
		for(int i=0; i< DIM;i++)
		{
			velocity[i]=0;
			position[i]=0;
		}
		
		mass=0;
	}
	
	//Mass but no velocity
	public PhysicsObject (double massi)
	{
		mass= massi;
	}
	
	public PhysicsObject (double[] vel, double m)
	{
		mass= m;
		velocity = vel;
	}
	
	public PhysicsObject (double[] vel, double[] pos, double m)
	{
		mass= m;
		velocity = vel;
		position = pos;
	}
	
	public double[] timeStep (double time)
	{
		
		for(int i=0; i < DIM; i++)
		{
			position[i]= velocity[i]*time;
		}
		return position;
	}
	
	public double[] timeStepAcc (double time, double[] acc)
	{
		for(int i =0; i <DIM; i++)
		{
			velocity[i]= velocity[i] + acc[i]*time;
		}
		for(int i=0; i < DIM; i++)
		{
			position[i]= velocity[i]*time;
		}
		return position;
	}
	
	public double[] getVel ()
	{
		return velocity;
	}
	
	public double[] getPos()
	{
		return position;
	}
	
	public double getMass()
	{
		return mass;
	}
	
	public void setVel (double[] newVel)
	{
		velocity = newVel;
	}

	public void setPos (double[] newPos)
	{
		position= newPos;
	}
	
	public void setMass(double newMass)
	{
		mass= newMass;
	}
}
