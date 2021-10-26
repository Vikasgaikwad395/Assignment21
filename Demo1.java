import java.util.concurrent.locks.ReentrantLock;

		
		class Table{
			static ReentrantLock l = new ReentrantLock();
			
			void printTable(int x) {
				l.lock();
				for(int i= 1; i <= 10; i++) {
					 System.out.println(x * i);
					 
					 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println(e);
						
					}
				}
				l.unlock();
			}
		}
		
		class My extends Thread{
			Table t;
			
			My(Table t){
				this.t = t;
			}
			public void run() {
				t.printTable(6);
				
			}
		}

		class My1 extends Thread {
			Table t;
			My1(Table t) {
				this.t = t;
			}
			public void run() {
				t.printTable(9);
				
			}
		}


public class Demo1 {
		
	public static void main(String[] args) {
		
		Table t = new Table();
		My t1 = new My(t);
		My1 t2 = new My1(t);
		t1.start();
		t2.start();
		
		
	}

}
