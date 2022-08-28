import java.util.ArrayList;

public class Hills {
	//Physics values
        public double t;
        public double v;
        public double s;
        public double a;

        //PID values
        public double kP;
        public double kI;
        public double kD;

        //Error variables
        public double lastError;
        public double totalError;

        //Target to reach
        public double target;

	public ArrayList<MyPoint> points;

	public Hills(){
		//Default physics values
                t = 0.1;
                v = 0.0;
                s = 0.0;
                a = 0.0;

                //Default PID values
                kP = 1.0;
                kI = 0.02;
                kD = 0.25;
	}

	/** 
	 * @param pDiv the number of points in each square
	 * @param numPoints the number of points generated 
	 */
	public void generateHills(int pDiv, int numPoints){
                for (int x = 0; x < numPoints; x++){
                        passTime();
                        points.add(new MyPoint(x/pDiv, s));
                }
	}

	//Pass time t
        public void passTime(){
                //Update position s
                s += (v * t) + (1/2) * a * (t*t);

                //Update speed v
                v = v + a * t;

                //Update acceleration using PID
                a = getAccelerationPID();
        }

        //Get new acceleration using PID
        public double getAccelerationPID(){
                double error = target - s;
                double errorRate = (error - lastError) / t;

                if(Math.abs(error) < 1){
                        totalError += error * t;
                }

                double output = (kP * error) + (kI * totalError) + (kD * errorRate);
                lastError = error;

                return output;
        }
}
