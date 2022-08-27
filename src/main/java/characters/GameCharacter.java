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
    private int xp;
    private int gold;
    private int damage;
    private boolean block;

    public GameCharacter(String name, int maximumHealthPoint, int strength, int dexterity, int damage, int gold) {
        this.name = name;
        this.maximumHealthPoint = maximumHealthPoint;
        this.healthPoint = maximumHealthPoint;
        this.strength = strength;
        this.dexterity = dexterity;
        this.gold = gold;
        this.damage = damage;
        this.block = false;
    }

    @Override
    public void attack(GameCharacter target) {
        int criticalDamageIgnoringBlock = damage;

        if (target.block) {

            if (Math.random() <= 0.5) {

                System.out.printf(
                        "%s атакует, но %s полностью блокирует атаку",
                        this.name,
                        target.name
                );

            } else {
                criticalDamageIgnoringBlock *= 1.5;
                target.healthPoint -= criticalDamageIgnoringBlock;

                System.out.printf(
                        "Пока %s стоит в блоке %s атакует и наносит увеличиный урон в %d ед " +
                                "по незащищенной области\nУ %s осталось %d / %d ед здоровья",
                        target.name,
                        this.name,
                        criticalDamageIgnoringBlock,
                        target.name,
                        target.healthPoint,
                        target.maximumHealthPoint
                );
            }
            return;
        }

        target.healthPoint -= damage + strength;

        System.out.printf(
                "%s атакует и наносит персонажу '%s' %d ед урона.\nУ персонажа '%s' осталось %d / %d ед здоровья.",
                this.name,
                target.name,
                this.damage,
                target.name,
                target.healthPoint,
                target.maximumHealthPoint);
    }

    @Override
    public void blockAction() {
        healthPoint++;
        block = true;
        System.out.printf(
                "%s встает в защитную стойку и готовится...",
                this.name
        );
    }

    public void blockReset() {
        block = false;
    }

    @Override
    public void healing() {

    }
}