package mypackage;
//曲线选择按钮布局与监听
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SelectPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	public boolean change(boolean x){
		if(x==true)return false;
		return true;
	}
	
	final static public int Selections=4;
	String str[]= {"sin (x)","cos (x)","sin^2(x)","cos^2(x)"};
	JButton[] button;
	boolean[] sel;
	
	private class ClickListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent Event) {
			String ClickKey=Event.getActionCommand();
			for(int i=0;i<4;i++)
				if(ClickKey.equals(str[i])) {
					sel[i]=change(sel[i]);
					MainView.Graph.q[i].Clear();
					if(sel[i]==true)
						button[i].setBackground(Color.WHITE);
					else
						button[i].setBackground(Color.BLACK);
				}
		}
	}
	
	public SelectPanel() {
		sel=new boolean[Selections];
		button=new JButton[Selections];
		for(int i=0;i<Selections;i++)
			sel[i]=false;
		setLayout(new FlowLayout(FlowLayout.CENTER,10,60));
		ActionListener Listener=new ClickListener(); 
		for(int i=0;i<Selections;i++) {
			button[i]=new JButton(str[i]);
			button[i].addActionListener(Listener);
			button[i].setForeground(GraphPanel.color_data[i]);
			button[i].setBackground(Color.BLACK);
			add(button[i]);
		}
	}
}
