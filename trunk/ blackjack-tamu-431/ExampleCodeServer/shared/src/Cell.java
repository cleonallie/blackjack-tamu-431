/**
 * $Id: Cell.java 26 2009-11-07 02:24:04Z seongyupyoo $
 */

/**
 * @author dan
 *
 */
public class Cell<T> {
	private T content;
	private boolean full = false;

	public Cell() {}
	
	public synchronized T get() {
		while(!full) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		full = false;
		notifyAll();
		return content;
	}
	
	public synchronized void set(T value) {
		while(full) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		full = true;
		content = value;
		notifyAll();
	}
	
	public static void main(String [] args) {
		
		Cell<String> c = new Cell<String>();
		
		Thread t = new Thread(new TestThread(c));
		t.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		c.set("World");
	}
}

/**
 * @author Yoo
 *
 */
class TestThread implements Runnable {
	
	Cell<String> c;
	
	public TestThread(Cell<String> c) {
		this.c = c;
	}
	
	public void run() {
		System.out.println("Hello");
		System.out.println(c.get());
	}
}