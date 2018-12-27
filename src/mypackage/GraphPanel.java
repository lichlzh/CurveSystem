package mypackage;
//ͼ�λ���
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class GraphPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	//������ʹ�õ���ɫ����
	final public static Color color_data[]= {Color.RED,Color.ORANGE,Color.DARK_GRAY,Color.GREEN};
	
	private final int FRAME_X = 50;
	private final int FRAME_Y = 50;
	public final int FRAME_WIDTH = 600;// ��
	public final int FRAME_HEIGHT = 400;// ��
 
	// ԭ������
	private final int Origin_X = FRAME_X + 50;
	private final int Origin_Y = FRAME_Y + FRAME_HEIGHT - 30;
 
	// X,Y���յ�����
	private final int XAxis_X = FRAME_X + FRAME_WIDTH - 30;
	private final int XAxis_Y = Origin_Y;
	private final int YAxis_X = Origin_X;
	private final int YAxis_Y = FRAME_Y + 30;
 
	// X���ϵ�ʱ��ֶ�ֵ��1�ֶ�=40���أ�
	public final int TIME_INTERVAL = 50;
	// Y����ֵ
	public final int PRESS_INTERVAL = 30;
	public CircularQueue[] q;
	public GraphPanel(){
		q=new CircularQueue[SelectPanel.Selections];
		for(int i=0;i<SelectPanel.Selections;i++)
			q[i]=new CircularQueue();
	}
	public void Clear(){
		for(int i=0;i<SelectPanel.Selections;i++)
			q[i].Clear();
	}
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2D=(Graphics2D)g;
		g.setColor(Color.BLACK);
		super.paintComponent(g);
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int w=500;
		int xDelta=w/CircularQueue.MAXN;
		int[] length=new int[SelectPanel.Selections];
		for(int i=0;i<SelectPanel.Selections;i++)
			if(MainView.Select.sel[i]) {
				length[i]=q[i].size();
				if(length[i]>0) {
					int x=xDelta*(length[i]-1);
					double y=(double)(XAxis_Y-q[i].elemAt(length[i]-1))/(XAxis_Y-FRAME_Y)*600;
					//������ֵ�任Ϊ�����ϵ�����
					MainView.Location.ChangeText(i,x,(int)y);
				}
			}
		for(int j=0;j<SelectPanel.Selections;j++)
			if(MainView.Select.sel[j]) {
				g2D.setColor(color_data[j]);
				for (int i=0;i<length[j]-1; i++) 
					g2D.drawLine(xDelta * i+100, q[j].elemAt(i),xDelta * (i + 1)+100, q[j].elemAt(i + 1));
				//������ȡ�ܶ����ֱ�߻�ֱΪ��
			}
		g2D.setColor(Color.BLUE);
		g2D.setStroke(new BasicStroke(Float.parseFloat("2.0F")));
		// X���Լ������ͷ
		g.drawLine(Origin_X, Origin_Y, XAxis_X, XAxis_Y);
		g.drawLine(XAxis_X, XAxis_Y, XAxis_X - 5, XAxis_Y - 5);
		g.drawLine(XAxis_X, XAxis_Y, XAxis_X - 5, XAxis_Y + 5);
		// Y���Լ������ͷ
		g.drawLine(Origin_X, Origin_Y, YAxis_X, YAxis_Y);
		g.drawLine(YAxis_X, YAxis_Y, YAxis_X - 5, YAxis_Y + 5);
		g.drawLine(YAxis_X, YAxis_Y, YAxis_X + 5, YAxis_Y + 5);
		// ��X���ϵ�ʱ��̶ȣ���������ԭ����ÿ��TIME_INTERVAL(ʱ��ֶ�)���ػ�һʱ��㣬��X���յ�ֹ��
		g.setColor(Color.BLUE);
		g2D.setStroke(new BasicStroke(Float.parseFloat("1.0f")));
		// X��̶����α仯���
		for (int i = Origin_X, j = 0; i < XAxis_X; i += TIME_INTERVAL, j += TIME_INTERVAL) 
			g.drawString(" " + j, i - 10, Origin_Y + 20);
		g.drawString("X", XAxis_X + 5, XAxis_Y + 5);
		// ��Y���Ͽ̶ȣ�������ԭ����ÿ��10���ػ�һֵ����Y���յ�ֹ��
		for (int i = Origin_Y, j = 0; i > YAxis_Y; i -= PRESS_INTERVAL, j += TIME_INTERVAL) 
			g.drawString(j + " ", Origin_X - 30, i + 3);
		g.drawString("Y", YAxis_X - 5, YAxis_Y - 5);// �̶�С��ͷֵ
		g.setColor(Color.BLACK);
		// ��������
		// �����ڲ�����
		for (int i = Origin_Y; i > YAxis_Y; i -= PRESS_INTERVAL) 
			g.drawLine(Origin_X, i, Origin_X + 10 * TIME_INTERVAL, i);
		// �����ڲ�����
		for (int i = Origin_X; i < XAxis_X; i += TIME_INTERVAL) 
			g.drawLine(i, Origin_Y, i, Origin_Y - 11 * PRESS_INTERVAL);
	}
}
