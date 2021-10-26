import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Demo4 implements Callable{
	
	int num;
	public Demo4(int num) {
		this.num = num;
	}
	
	
	@Override
	public Object call() throws Exception {
		System.out.println(Thread.currentThread().getName()+"is finding sum of first"+num+"numbers");
		int sum = 0;
		for(int i = 0; i<= num;i++) {
			sum = sum +i;
		}
		return sum;
	}

	
}

public class CollableDemo {

	public static void main(String[] args) {
			
		Demo4[] d = {
			
				new Demo4(10),
				new Demo4(20),
				new Demo4(30),
				new Demo4(40),
				new Demo4(50),
				new Demo4(60),
				
		};
		ExecutorService es = Executors.newFixedThreadPool(2);
		for(Demo4 job : jobs) {
			Future f = es.submit(job);
			
			try {
				System.out.println(f.get());
			}catch(Exception e ) {
				e.printStackTrace();
			}
			
		}
		es.shutdown();
}
}
