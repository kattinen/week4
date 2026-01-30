// Cave.java 
// Kati Liukkonen
// Viikon 4 harjoitustehtävä: pienen pelin luokka luola / Cave
// Visual Studio Code
// Versio 1.0
// No license

package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Cave implements Serializable {
    private String name;
    private ArrayList<Monster> monsterList;
    private String file;

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

    public void chooseMonster () {
        if (monsterList.size() == 0) {
            System.out.println("Luola on tyhjä.");
        }
        else {
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

    public void saveMonsterList(String saveFile) {
        this.file = saveFile;
        try {
            ObjectOutputStream monsterWriter = new ObjectOutputStream(new FileOutputStream(file));
            monsterWriter.writeObject(monsterList);
            monsterWriter.close();
            System.out.println("Peli tallennettiin tiedostoon " + file + ".");
        }
        catch (IOException e) {
            System.out.println("Pelin tallentaminen ei onnistunut.");
            e.printStackTrace();
        }
    }

    public void loadMonsterList(String savedFile) {
        this.file = savedFile;
        try {
            ObjectInputStream monsterReader = new ObjectInputStream(new FileInputStream(file));
            monsterList = (ArrayList<Monster>) monsterReader.readObject();
            monsterReader.close();
            System.out.println("Peli ladattu tiedostosta " + file + ". Tervetuloa takaisin, PELAAJA.");           
            }
        catch (FileNotFoundException e) {
            System.out.println("Pelin lataaminen ei onnistunut.");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Pelin lataaminen ei onnistunut.");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Pelin lataaminen ei onnistunut.");
            e.printStackTrace();
        }

    } 
 
}
