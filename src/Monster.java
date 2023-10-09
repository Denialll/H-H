import java.util.Random;

public class Monster extends Creature {

    public Monster(int attack, int defense, int health, int minDamage, int maxDamage) {
        super(attack, defense, health, minDamage, maxDamage);
    }

    @Override
    public void attack(Creature creature) {
        if(creature.isDead()){
            System.out.println("This creature is already dead");
            return;
        }
        if (creature instanceof Monster) {
            System.out.println("Friendly fire!");
            return;
        }

        Random random = new Random();

        int attackModifier = getAttack() - creature.getDefense() + 1;
        if(attackModifier < 0){
            System.out.println("The player's defense is too high");
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
            System.out.println("The MONSTER successfully attacked the player and damage on " + damage + " units.");
            creature.takeDamage(damage);
        } else {
            System.out.println("The MONSTER was unable to attack the player.");
        }
    }
}