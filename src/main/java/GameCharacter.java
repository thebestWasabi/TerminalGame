public class GameCharacter {
    private String name;
    private int maximumHealthPoint;
    private int healthPoint;
    private int damage;
    private boolean block;

    public GameCharacter(String name, int maximumHealthPoint, int damage) {
        this.name = name;
        this.maximumHealthPoint = maximumHealthPoint;
        this.healthPoint = maximumHealthPoint;
        this.damage = damage;
        this.block = false;
    }

    public void attack(GameCharacter target) {
        int criticalDamageIgnoringBlock = damage;

        if (target.block) {
            if (Math.random() <= 0.5) {
                System.out.printf("%s полностью заблокировал атаку", target.name);
            } else {
                criticalDamageIgnoringBlock *= 1.5;
                target.healthPoint -= criticalDamageIgnoringBlock;
                System.out.printf("Пока %s стоит в блоке %s атакует и наносит увеличиный урон в %d ед " +
                                "по незащищенной области\nУ %s осталось %d ед здоровья",
                        target.name, this.name, criticalDamageIgnoringBlock, target.name, target.healthPoint);
            }
            return;
        }
        target.healthPoint -= damage;
        System.out.printf("%s атакует и наносит персонажу '%s' %d ед урона.\nУ персонажа '%s' осталось %d ед здоровья.",
                name, target.name, damage, target.name, target.healthPoint);
    }

    public void blockAction() {
        block = true;
        System.out.printf("%s защищается", this.name);
    }

    public void healing() {

    }

    public void blockReset() {
        block = false;
    }

    public String getName() {
        return name;
    }

    public int getMaximumHealthPoint() {
        return maximumHealthPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getDamage() {
        return damage;
    }

    public boolean isBlock() {
        return block;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaximumHealthPoint(int maximumHealthPoint) {
        this.maximumHealthPoint = maximumHealthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }
}
