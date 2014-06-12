public class PhysicsObject 
{
	private static int DIM =3;

	//Maintaining an XYZ convetion for listing of coordinates
	private double[] velocity = new double[DIM];

	private double[] position = new double[DIM];

	private double mass;

	//Create small, Massless, motionless

	public PhysicsObject ()
	{
		for(int i=0;i<DIM;i++)
		{
			velocity[i]=0;
			position[i]=0;
		}
		mass=0;
	}
	
	public double[] sphToCartCoodinates (double mag , double theta, double phi)
	{
		double[] vel = new double [DIM];
		
		vel[0] = mag * Math.sin(phi)*Math.cos(theta);
		vel[1] = mag * Math.sin(phi)*Math.sin(theta);
		vel[3] = mag * Math.cos(phi);
		
		return vel;
	}
	public double[] timeStep (double time)
	{

		for(int i=0; i < DIM; i++)
		{
			position[i]= position[i] + velocity[i]*time;
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
			position[i]= position[i] + velocity[i]*time;
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

	//Theta is the angle between x and y axis,
	//Phi is the angle between the z axis and the x-y plane
	
	public void setVelAngle (double magnitude, double theta, double phi)
	{
		velocity = this.sphToCartCoodinates(magnitude, theta, phi);
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
