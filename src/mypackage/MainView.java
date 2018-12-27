package mypackage;
//界面布局
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class MainView {
	private JFrame frame;
	static GraphPanel Graph;
	static LocationPanel Location;
	static SelectPanel Select;
	static ControlPanel Control;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MainView() throws InterruptedException {
		frame = new JFrame("曲线系统");
		frame.setBounds(200, 150, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Graph=new GraphPanel();
		frame.getContentPane().add(Graph,BorderLayout.CENTER);
		
		Location=new LocationPanel();
		Location.setPreferredSize(new Dimension(100,100));
		frame.getContentPane().add(Location, BorderLayout.EAST);
		
		Select=new SelectPanel();
		Select.setPreferredSize(new Dimension(100,100));
		frame.getContentPane().add(Select, BorderLayout.WEST);
		
		Control=new ControlPanel();
		Control.setPreferredSize(new Dimension(100,100));
		frame.getContentPane().add(Control, BorderLayout.SOUTH);
		
	}
}
