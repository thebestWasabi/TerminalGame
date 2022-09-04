package basic_classes;

import battle_characters.Fighter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GameCharacter implements Fighter {

    private String name;
    private int maxHealthPoint;
    private int healthPoint;
    private int strength;
    private int dexterity;
    private int attackPower;
    private int defence;

    private boolean block;

    private int xp;
    private int maxXP;
    private int gold;


    protected GameCharacter(String name, int maxHealthPoint, int strength, int dexterity, int attackPower, int xp, int gold) {
        this.name = name;
        this.maxHealthPoint = maxHealthPoint;
        this.healthPoint = maxHealthPoint;
        this.strength = strength;
        this.dexterity = dexterity;
        this.attackPower = attackPower;
        this.xp = xp;
        this.maxXP = 500;
        this.gold = gold;
        this.block = false;
    }


    @Override
    public void attack(GameCharacter target) {
        int damage = attackPower + strength;

        if (target.block) {
            shieldBlock(target);
        } else {
            target.healthPoint -= damage;
            System.out.printf("""
                    \n%s атакует и наносит персонажу '%s' %d ед урона
                    У персонажа '%s' осталось %d / %d ед здоровья
                     """, this.name, target.name, damage, target.name, target.healthPoint, target.maxHealthPoint);
        }
    }


    public void shieldBlock(GameCharacter target) {
        int criticalDamageIgnoringBlock = attackPower + strength;

        if (Math.random() <= 0.75) {
            System.out.printf("\n%s атакует, но %s полностью блокирует атаку\n", this.name, target.name);
        } else {
            target.healthPoint -= criticalDamageIgnoringBlock * 1.5;
            System.out.printf("""
                    \nПока %s стоит в блоке %s атакует и наносит увеличиный урон в %d ед (x1.5) по незащищенной области
                    У персонажа %s осталось %d / %d ед здоровья
                    """, target.name, this.name, criticalDamageIgnoringBlock, target.name, target.healthPoint, target.maxHealthPoint);
        }
    }


    public void blockAction() {
        block = true;
        int blockHP = 5;
        healthPoint += blockHP;

        if (this.healthPoint > this.maxHealthPoint) {
            this.healthPoint = this.maxHealthPoint;
        }
        System.out.printf("""
                \n%s встает в защитную стойку и готовится...
                Здоровье +%d ед (%d / %d)
                """, this.name, blockHP, this.healthPoint, this.maxHealthPoint);
    }


    public void blockReset() {
        block = false;
    }


    public void healing() {
        int potion = 15;
        this.healthPoint = this.healthPoint + potion;

        if (this.healthPoint > this.maxHealthPoint) {
            this.healthPoint = this.maxHealthPoint;
        }
        System.out.printf("\n%s пьет зелье здоровья\nЗдоровье +%d ед (%d / %d) \n",
                this.name, potion, this.healthPoint, this.maxHealthPoint);
    }


    @Override
    public String toString() {
        return "Характеристики: " +
                "Здоровье = " + healthPoint + " / " + maxHealthPoint + "; " +
                "Опыт = " + xp + " / " + maxXP + "; " +
                "Золото = " + gold;
    }
}