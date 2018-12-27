package mypackage;
//实时坐标显示
import java.awt.FlowLayout;
import java.awt.TextField;
import javax.swing.JPanel;

public class LocationPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	TextField[] text;
	public LocationPanel(){
		text=new TextField[SelectPanel.Selections];
		for(int i=0;i<SelectPanel.Selections;i++) {
			text[i]=new TextField(" 未开始 ");
			text[i].setColumns(10);
			text[i].setForeground(GraphPanel.color_data[i]);
			add(text[i]);
		}
		setLayout(new FlowLayout(FlowLayout.CENTER,60,65));
	}
	//文本框修改接口
	public void ChangeText(int id,int x,int y) {
		text[id].setText("( "+x+","+y+" )");
	}
	//文本框清空接口
	public void Clear() {
		for(int i=0;i<SelectPanel.Selections;i++)
			text[i].setText(" 未开始 ");
	}
}
