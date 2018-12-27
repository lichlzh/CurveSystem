package mypackage;
//控制按钮布局与监听
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	final static public int Controls=3;
	String str[]= {"开始","暂停","清空"};
	private JButton[] button;
	private Thread Draw;
	public boolean suspend;//线程是否暂停
	private class ClickListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent Event) {
			String ClickKey=Event.getActionCommand();
			if(ClickKey.equals(str[0])){
				suspend=false;
			}
			else if(ClickKey.equals(str[1])){
				suspend=true;
			}
			else{//ClickKey.equals(str[2])
				suspend=true;
				MainView.Graph.Clear();
				MainView.Graph.repaint();//清空已画的曲线
				MainView.Location.Clear();//坐标显示还原
				MyThread.Clear();//线程时间轴还原
			}
		}
	}
	public ControlPanel() throws InterruptedException{
		button=new JButton[Controls];
		setLayout(new FlowLayout(FlowLayout.CENTER,60,10));
		ActionListener Listener=new ClickListener();
		for(int i=0;i<Controls;i++) {
			button[i]=new JButton(str[i]);
			button[i].addActionListener(Listener);
			add(button[i]);
		}
		Draw=new Thread(new MyThread());
		suspend=true;
		Draw.start();
	}
}
