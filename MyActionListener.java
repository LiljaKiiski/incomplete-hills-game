import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class MyActionListener implements ActionListener{
	public Main main;
	private Timer timer;

    	public MyActionListener(Main main, int interval){
		this.main = main;
		timer = new Timer(interval, this);
	}

	public void start(){
		timer.start();
	}

    	@Override
    	public void actionPerformed(ActionEvent e) { 
  		main.board.move();
		main.panel.repaint();
    	}
}
