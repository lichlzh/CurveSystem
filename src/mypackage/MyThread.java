package mypackage;
//��ͼ�����߳�
public class MyThread extends Thread{
	private static int tim;
	public static void Clear()
	{tim=0;}
	@Override
	public void run() {
		tim=0;
		while(true){
			try {
				while(MainView.Control.suspend) {
					sleep(500);
				}
				tim+=MainView.Graph.TIME_INTERVAL;
				for(int i=0;i<SelectPanel.Selections;i++)
					if(MainView.Select.sel[i]) {
						double val=0;
						if(i%2==0)
							val=Math.sin((double)tim/400);
						else
							val=Math.cos((double)tim/400);
						if(i>1)
							val*=val;
						//i=0:sin i=1:cos i=2:sin^2 i=3:cos^2
						val=((val+1)*200);
						//val����[-1,1]���䣬val+1����[0,2]���䡪���������������X���Ϸ���
						MainView.Graph.q[i].add((int)val+20);
					}
				MainView.Graph.repaint();
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
