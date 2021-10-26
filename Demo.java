import java.util.Iterator;
import java.util.concurrent.ConcurrentSkipListSet;

public class Demo  extends Thread{

	
		static ConcurrentSkipListSet<String> m = new ConcurrentSkipListSet<>();
		
		public void run() {
		 
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Child Thread adding a element in Set");			
				}
			
			System.out.println("Child Thread updating List");
			m.add("Java");
			}
		public static void main(String[] args) throws Exception {
			
			m.add("Python");
			m.add("Ruby");
			m.add("C");
			m.add("C++");
			
			
			Demo d = new Demo();
			d.start();
			
			Iterator<String> itr = m.iterator();
			while(itr.hasNext()) {
				String s = itr.next();
				System.out.println("Main thread iterating list and current object is:  "+s);
				Thread.sleep(4000);
				
			}
			System.out.println(m);
	}

}
