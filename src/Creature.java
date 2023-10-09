public abstract class Creature {
    int attack;
    int defense;
    int health;
    int maxHealth;
    int minDamage;
    int maxDamage;
    boolean isDead = false;

    protected Creature(int attack, int defense, int maxHealth, int minDamage, int maxDamage) {
        if(attack > 30 || attack < 1) throw new RuntimeException("Attack parameter exceeds range (1-30)");
        else this.attack = attack;
        if(defense > 30 || defense < 1) throw new RuntimeException("Defense parameter exceeds range (1-30)");
        else this.defense = defense;
        if(maxHealth < 1) throw new RuntimeException("Health parameter is less then 1");
        else {
            this.health = maxHealth;
            this.maxHealth = maxHealth;
        }
        if(minDamage < 0 || maxDamage < minDamage) throw new RuntimeException("The min or max damage are incorrectly");
        else{
            this.minDamage = minDamage;
            this.maxDamage = maxDamage;
        }
    }

    protected abstract void attack(Creature creature);

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            isDead = true;
            health = 0;
            System.out.println("The creature died!");
        }
    }

    protected int getAttack() { return attack; }

    protected void setAttack(int attack) {
        this.attack = attack;
    }

    protected int getDefense() {
        return defense;
    }

    protected void setDefense(int defense) {
        this.defense = defense;
    }

    protected int getHealth() {
        return health;
    }

    protected int getMaxHealth() {
        return maxHealth;
    }

    protected void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    protected void setHealth(int health) {
        this.health = health;
    }
}