import java.util.Random;

public class enemy extends player{
	Random rand = new Random();
	
	enemy(String name){
		super(name);
	}
	
	public int gen_num() {
		return rand.nextInt(10)+1;
	}
	
	void take_hit() {
		System.out.println("Enemy, "+this.name+", take hit. HP left: "+(this.health-10));
	}
	
	void take_miss(int num) {
		if (num >this.target)
			System.out.println("you missed, take lower");
		else
			System.out.println("you missed, take higher");
	}
}