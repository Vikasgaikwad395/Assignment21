import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable{

	int num;
	void MyCollable(int num){
		this.num = num;
	}
	
	public Object call() throws Exception{
		
	System.out.println(Thread.currentThread().getName()+ "is finding sum of first"+num+"numbers");	
	int sum = 0;
	for(int i = 1; i <= num;i++) {
		sum= sum+i;
	}
	return sum;
	
	}
	
}

public class Test2 {

	public static void main(String args[]) {
	
		MyCallable[] jobs = {
			new MyCallable(10),
				new MyCallable(20),
				new MyCallable(30),
				new MyCallable(40),
				new MyCallable(50)
				
					
			};
		ExecutorService es = Executors.newFixedThreadPool(2);
		for(MyCallable job : jobs) {
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
