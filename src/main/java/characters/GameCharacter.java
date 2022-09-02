package characters;

import characters.battle_characters.Fighter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GameCharacter implements Fighter {

    private String name;
    private int maximumHealthPoint;
    private int healthPoint;
    private int strength;
    private int dexterity;
    private int attackPower;


    private boolean block;

    private int xp;
    private int gold;


    protected GameCharacter(String name, int maximumHealthPoint, int strength, int dexterity, int attackPower, int gold) {
        this.name = name;
        this.maximumHealthPoint = maximumHealthPoint;
        this.healthPoint = maximumHealthPoint;
        this.strength = strength;
        this.dexterity = dexterity;
        this.gold = gold;
        this.attackPower = attackPower;
        this.block = false;
    }

    @Override
    public void attack(GameCharacter target) {
        int damage = attackPower + strength;
        int criticalDamageIgnoringBlock = damage * 2;

        if (target.block) {

            if (Math.random() <= 0.75) {
                System.out.printf("%s атакует, но %s полностью блокирует атаку\n", this.name, target.name);

            } else {
                target.healthPoint -= criticalDamageIgnoringBlock;

                System.out.printf("""
                        Пока %s стоит в блоке %s атакует и наносит увеличиный урон в %d ед по незащищенной области
                        У %s осталось %d / %d ед здоровья
                        """, target.name, this.name, criticalDamageIgnoringBlock, target.name, target.healthPoint, target.maximumHealthPoint);
            }
            return;
        }

        target.healthPoint -= damage;

        System.out.printf("""
                %s атакует и наносит персонажу '%s' %d ед урона.
                У персонажа '%s' осталось %d / %d ед здоровья.
                """, this.name, target.name, damage, target.name, target.healthPoint, target.maximumHealthPoint);
    }

    @Override
    public void blockAction() {
        block = true;
        healthPoint += 7;

        if (this.healthPoint > this.maximumHealthPoint) {
            this.healthPoint = this.maximumHealthPoint;
        }

        System.out.printf("""
                %s встает в защитную стойку и готовится...
                Здоровье +7 ед (%d / %d)
                """, this.name, this.healthPoint, this.maximumHealthPoint);
    }

    public void blockReset() {
        block = false;
    }

    @Override
    public void healing() {
        int potion = 30;
        this.healthPoint = this.healthPoint + potion;

        if (this.healthPoint > this.maximumHealthPoint) {
            this.healthPoint = this.maximumHealthPoint;
        }

        System.out.printf("%s пьет зелье здоровья\nЗдоровье +%d ед (%d / %d)\n",
                this.name, potion, this.healthPoint, this.maximumHealthPoint);
    }
}