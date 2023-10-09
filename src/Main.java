
public class Main {
    public static void main(String[] args) {
        Player player = new Player(15, 10, 50, 2, 10);
        Monster monster = new Monster(30, 8, 80, 5, 10);

        player.attack(monster);
        monster.attack(player);
        player.heal();
    }
}