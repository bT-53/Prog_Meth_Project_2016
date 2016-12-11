package Logic;

import java.util.List;

public class ThreadsManager implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<Thread> threads;
		for (Thread t: ThreadsHolder.instance.getThreads()) {
			if (!t.isAlive()) {
				
			}
		}
	}
}
