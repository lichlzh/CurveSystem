package mypackage;
//ʵʱ������ʾ
import java.awt.FlowLayout;
import java.awt.TextField;
import javax.swing.JPanel;

public class LocationPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	TextField[] text;
	public LocationPanel(){
		text=new TextField[SelectPanel.Selections];
		for(int i=0;i<SelectPanel.Selections;i++) {
			text[i]=new TextField(" δ��ʼ ");
			text[i].setColumns(10);
			text[i].setForeground(GraphPanel.color_data[i]);
			add(text[i]);
		}
		setLayout(new FlowLayout(FlowLayout.CENTER,60,65));
	}
	//�ı����޸Ľӿ�
	public void ChangeText(int id,int x,int y) {
		text[id].setText("( "+x+","+y+" )");
	}
	//�ı�����սӿ�
	public void Clear() {
		for(int i=0;i<SelectPanel.Selections;i++)
			text[i].setText(" δ��ʼ ");
	}
}
