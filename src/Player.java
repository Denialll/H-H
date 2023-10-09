import java.util.Random;

public class Player extends Creature {
    private int healingCount = 0;

    public Player(int attack, int defense, int health, int minDamage, int maxDamage) {
        super(attack, defense, health, minDamage, maxDamage);
    }

    @Override
    public void attack(Creature creature) {
        if(creature.isDead()){
            System.out.println("This creature is already dead");
            return;
        }
        if (creature instanceof Player) {
            System.out.println("Friendly fire!");
            return;
        }

        Random random = new Random();

        int attackModifier = getAttack() - creature.getDefense() + 1;
        if(attackModifier < 0){
            System.out.println("The monster's defense is too high");
            return;
        }

        boolean successAttack = false;

        for (int i = 0; i < attackModifier; i++) {
            int roll = random.nextInt(1, 7);
            if (roll == 5 || roll == 6) {
                successAttack = true;
                break;
            }
        }

        if (successAttack) {
            int damage = random.nextInt(minDamage, maxDamage + 1);
            System.out.println("The PLAYER successfully attacked the monster and damage on " + damage + " units.");
            creature.takeDamage(damage);
        } else {
            System.out.println("The PLAYER was unable to attack the monster.");
        }
    }

    public void heal() {
        if (health == 0){
            System.out.println("You can't heal yourself, because you dead.");
            return;
        }
        if (health == maxHealth) {
            System.out.println("Max health");
            return;
        }

        if (healingCount < 4) {
            int healingAmount = (int) (maxHealth * 0.3);

            health += healingAmount;
            if (health > maxHealth) {
                health = maxHealth;
            }
            healingCount++;

            System.out.println("The player was healed by " + healingAmount + " health units.");
        } else {
            System.out.println("The player has already used all the possibilities for healing.");
        }
    }
}