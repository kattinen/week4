// Monster.java 
// Kati Liukkonen
// Viikon 4 harjoitustehtävä: pienen pelin luokka hirviö / Monster
// Visual Studio Code
// Versio 1.0
// No license


package main;

public class Monster {
    private String type;
    private int health;

    public Monster(String type, int health) {
        this.type = type;
        this.health = health;
    }

    public void printInfo(int number) {
        System.out.println(number + ": " + type + " / " + health + "HP");
    }

    public int takeDamage(int dmg) {
        this.health = this.health - dmg;
        if (this.health < 0) {
            this.health = 0;
        }
        return this.health;
    }

    public String getType() {
        return this.type;
    }

}
