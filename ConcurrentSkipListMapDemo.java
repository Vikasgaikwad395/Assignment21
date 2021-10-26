import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo extends Thread {
		static ConcurrentSkipListMap<Integer, String> ck = new ConcurrentSkipListMap<>();
	
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Child Thread going to add Element.");
					}
		System.out.println("Child thread updating Map");
		ck.put(105,"Sham");
		
		
	}

	public static void main(String[] args) throws InterruptedException {
			
		ck.put(101, "Sham");
		ck.put(104, "Kabir");
		ck.put(102, "Tara");
		ck.put(103, "Dani");
		
		
		ConcurrentSkipListMapDemo c = new ConcurrentSkipListMapDemo();
		c.start();
		
		Set<Integer> s = ck.keySet();
		Iterator<Integer> itr = s.iterator();
		while(itr.hasNext()) {
			Integer i = itr.next();
			System.out.println("Main thread Iterating and current Entry key is:  "+i+"....."+ck.get(i));
			Thread.sleep(6000);
		}
		System.out.println(ck);

	}

}
