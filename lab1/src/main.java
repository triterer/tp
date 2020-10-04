
import java.util.Random;
public class main {
	static thr1 thr_1;
	static thr2 thr_2;
	public static void main(String[] args) {
		Random ran_gen = new Random();
		int rand_num= gen_num(ran_gen);
		
		thr_1 = new thr1();
		thr_2 = new thr2();
		thr_1.start();
		thr_2.start();
		while(true) {
			thr_1.change_rand(rand_num);
			thr_2.change_rand(rand_num);
			rand_num= gen_num(ran_gen);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
		}
	}
	
	private static int gen_num(Random ran_gen) {
		return ran_gen.nextInt()%100;
	}
}


class thr1 extends Thread{
	private int rand_num;
	public void change_rand(int num) {
		this.rand_num = num;
	}
	@Override
	public void run() {
		//change_rand(num);
		
		while(true) {
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {}
			if (rand_num%2 == 0)
				System.out.println("num: "+rand_num+" square: "+Math.pow(rand_num, 2));
		}
	}
}

class thr2 extends Thread{
	private int rand_num;
	public void change_rand(int num) {
		this.rand_num = num;
	}
	@Override
	public void run() {
		//change_rand(num);
		while(true) {
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {}
			if (rand_num%2 != 0)
				System.out.println("num: "+rand_num+" cube: "+Math.pow(rand_num, 3));
		}
	}
}