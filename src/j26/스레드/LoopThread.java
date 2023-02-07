package j26.스레드;

public class LoopThread extends Thread {
	
	private String threadName;
	
	public LoopThread(String threadName) {
		this.threadName = threadName;
	}
	
	
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			System.out.println(threadName + ": " + i);
			try {
				Thread.sleep(1000); 	//sleep(1000) = 1초 자는 걸 뜻한다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
