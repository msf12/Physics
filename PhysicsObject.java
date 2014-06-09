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
		this(0);
	}

	//Mass but no velocity
	public PhysicsObject (double m)
	{
		for(int i=0; i< DIM;i++)
		{
			velocity[i]=0;
			position[i]=0;
		}

		mass= m;
	}

	public PhysicsObject (double[] vel, double m)
	{
		for(int i=0; i< DIM;i++)
		{
			position[i]=0;
		}

		mass= m;
		velocity = vel;
	}

	public PhysicsObject (double[] vel, double[] pos, double m)
	{
		mass= m;
		velocity = vel;
		position = pos;
	}

	//Theta is the angle between x and y axis,
	//Phi is the angle between the z axis and the x-y plane
	
	public PhysicsObject (double[] pos, double magnitude, double theta, double phi, double m)
	{
		mass = m;
		position = pos ;
		velocity = this.sphToCartCoodinates(magnitude, theta, phi);
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

	public void setPos (double[] newPos)
	{
		position= newPos;
	}

	public void setMass(double newMass)
	{
		mass= newMass;
	}
}
