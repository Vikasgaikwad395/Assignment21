import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

class Employee implements Runnable{
	
	String name;
	
	Employee(String name){
	this.name = name;
		}
	
	public void run() {
		System.out.println(name+"....Job started by thread"+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name+"..........Job started by thread"+Thread.currentThread().getName());
	}
}
public class Test {

	public static void main(String args[]) {
	
		 Employee[] jobs = {
				 new Employee("Ramu"),
				 new Employee("Sham"),
				 new Employee("Aryan"),
				 new Employee("Umesh"),
				 new Employee("Yash"),
				 new Employee("Rohit"),
		 };
		 ExecutorService es = Executors.newFixedThreadPool(2);
		 for(Employee job:jobs) {
			es.submit(job);
		 }
		 	es.shutdown();
	}

}
