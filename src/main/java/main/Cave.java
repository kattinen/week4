// Cave.java 
// Kati Liukkonen
// Viikon 4 harjoitustehtävä: pienen pelin luokka luola / Cave
// Visual Studio Code
// Versio 1.0
// No license

package main;

import java.util.ArrayList;

public class Cave {
    private String name;
    private ArrayList<Monster> monsterList;

    public Cave (Player player) {
        //this.name = player;
        this.monsterList = new ArrayList<>();
    }

    public void addMonster (Monster monster) {
        monsterList.add(monster);
    }

    public void listMonsters () {
        if (monsterList.size() == 0) {
            System.out.println("Luola on tyhjä.");
        }
        else {
            System.out.println("Luolan hirviöt:");
            int i = 0;
            for(Monster monster : monsterList) {
                i++;
                monster.printInfo(i);
            }
        }
    }

    public Monster getMonster (int number) {
        return monsterList.get(number - 1);    
    }

    public void removeMonster(Monster monster) {
        monsterList.remove(monster);
    }

    
}
