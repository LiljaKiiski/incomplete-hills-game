import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class Main {
	public Hills hills;
	public GraphPanel panel;

	public Main(){
		hills = new Hills();
		panel = new GraphPanel(hills);
		setUpFrame();

		double pDiv = 16;
		//double numPoints = (pDiv/Constants.SPACE)*panel.getWidth();
		double numPoints = panel.getWidth();

		hills.generateHills(pDiv, numPoints);

		panel.repaint();
        }

        public void setUpFrame(){
                JFrame f = new JFrame("Hills");
                f.setIconImage(new ImageIcon("images/icon_image.png").getImage());
                f.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
                
		f.setLayout(new GridLayout(1, 1));
		//panel.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
		f.add(panel);

	        f.setLocationRelativeTo(null);
                f.setResizable(false);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
        }	
}
