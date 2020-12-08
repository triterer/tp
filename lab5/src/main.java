import java.util.Random;
import java.util.Scanner;
public class main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("player name: ");
		String username = scanner.nextLine();

		System.out.println("enemy name: ");
		String enemyname = scanner.nextLine();
		
		user user1 = new user(username);
		enemy enemy1 = new enemy(enemyname);
		
		boolean game_not_ended = true;
		
		
		while(game_not_ended) {
			System.out.println("roll: ");
			int current_num = scanner.nextInt();
			if (user1.check_hit(current_num)) {
				enemy1.take_hit();
				enemy1.generate_num();
				enemy1.decrease_health();
			}
			else {
				enemy1.take_miss(current_num);
			}
			
			int enemy_num = enemy1.gen_num();
			if(enemy1.check_hit(enemy_num)) {
				user1.take_hit();
				user1.decrease_health();
				user1.generate_num();
			}
			else {
				user1.take_miss();
			}
			
			if (user1.check_dead()) {
				System.out.println("you dead");
				game_not_ended = false;
			}
			
			if (enemy1.check_dead()) {
				System.out.println("enemy dead");
				game_not_ended = false;
			}
			
		}
	}
}

