public class user extends player{
	user(String name){
		super(name);
	}
	
	void take_hit() {
		System.out.println("enemy hit you, "+this.name+", you have left "+(this.health-10)+"health");
	}
	
	void take_miss() {
		System.out.println("enemy missed");
	}
}