import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class Main {
	//Car with variables
	public Car car;

	//Main panel
	public GraphPanel panel;

	public Main(){
		//Set car
		car = new Car();
                
		//Set panels
		panel = new GraphPanel(car);

		//Set up GUI frame
                setUpFrame();

		moveCar();
        }

	public void moveCar(){
		//Number of points in each square
		double pDiv = 5;

		//Set graph points
		for (int x = 0; x < (pDiv/Constants.SPACE)*panel.getWidth(); x++){
			car.passTime();
			panel.points.add(new MyPoint(x/pDiv, car.s));
		}

		//Paint results
		panel.repaint();
	}

        public void setUpFrame(){
                JFrame f = new JFrame("Hills");
                f.setIconImage(new ImageIcon("images/icon_image.png").getImage());
                f.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
                
		f.setLayout(new GridLayout(1, 1));
		f.add(panel);

	        f.setLocationRelativeTo(null);
                f.setResizable(false);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
        }	
}
