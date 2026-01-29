// Player.java 
// Kati Liukkonen
// Viikon 4 harjoitustehtävä: pienen pelin luokka pelaaja / Player
// Visual Studio Code
// Versio 1.0
// No license

package main;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public int attack(Monster monster) {
        int damage = 10;
        int remainingHealth = monster.takeDamage(damage);
        String monsterName = monster.getType();
        System.out.println(name + " hyökkää " + monsterName + " hirviöön!");
        System.out.println("Hirviöllä on " + remainingHealth + " elämää jäljellä.");
        return remainingHealth;
    } 
 

}
