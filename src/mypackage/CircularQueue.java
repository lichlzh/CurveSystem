package mypackage;
//循环队列存储点的Y坐标
public class CircularQueue {
	final static public int MAXN=50;
	private int head,tail;
	int[] queue;
	CircularQueue(){
		queue=new int[MAXN+1];
		head=tail=0;
	}
	public void Clear(){
		head=tail=0;
	}
	public int size(){
		return (tail-head+MAXN+1)%(MAXN+1);
	}
	public void add(int x) {
		queue[tail++]=x;
		if(tail>MAXN)
			tail-=MAXN+1;
		if(head==tail)
			head++;
		if(head>MAXN)
			head-=MAXN+1;
		
	}
	public int elemAt(int id){
		try{
			id=(id+head)%(MAXN+1);
		}catch (ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}
		return queue[id];
	}
}
