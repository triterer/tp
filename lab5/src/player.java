import java.util.Random;

public class player{
	protected int health;
	protected int target;
	protected String name;
	Random rand = new Random();
	
	player(String name){
		this.health = 100;
		this.name = name;
		this.target = rand.nextInt(10)+1;
	}
	
	public void generate_num() {
		this.target = rand.nextInt(10)+1;
	}
	
	public boolean check_hit(int num) {
		if (num == this.target)
			return true;
		return false;
	}
	
	public boolean check_dead() {
		if (this.health<=0)
			return true;
		return false;
	}
	
	public void decrease_health() {
		this.health = this.health - 10;
	}
}