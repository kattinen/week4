// App.java 
// Kati Liukkonen
// Viikon 4 harjoitustehtävä: pieni peli, jossa on luokat pelaaja, hirviö ja luola
// Visual Studio Code
// Versio 1.0
// No license



package main;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {

        Scanner sc = new Scanner(System.in);

        Player player = null;
        Cave cave = null;

        System.out.println("Syötä pelaajan nimi: ");
        String playerName = sc.nextLine();
        player = new Player(playerName);
        cave = new Cave(player);

        boolean exit = false; 
        while (!exit) {
            System.out.println("1) Lisää luolaan hirviö");
            System.out.println("2) Listaa hirviöt");
            System.out.println("3) Hyökkää hirviöön");
            System.out.println("4) Tallenna peli");
            System.out.println("5) Lataa peli");
            System.out.println("0) Lopeta peli");

            if(sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);
            
                switch(i) {
                    case 1:
                        System.out.println("Anna hirviön tyyppi: ");
                        String type = sc.nextLine();
                        System.out.println("Anna hirviön elämän määrä numerona: ");
                        int health = Integer.parseInt(sc.nextLine());
                        Monster monster = new Monster(type, health);
                        cave.addMonster(monster);
                        break;
                    case 2:
                        cave.listMonsters();
                        break;
                    case 3:
                        System.out.println("Valitse hirviö, johon hyökätä: ");
                        cave.listMonsters();
                        int number = Integer.parseInt(sc.nextLine());
                        Monster attackMonster = cave.getMonster(number);
                        int remainingHealth = player.attack(attackMonster);
                        if (remainingHealth == 0) {
                            cave.removeMonster(attackMonster);
                        }
                        break;
                    case 4:
                        // Tallenna peli
                        break;
                    case 5:
                        // Lataa peli
                        break;
                    case 0:
                        System.out.println("Peli päättyy. Kiitos pelaamisesta!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Virheellinen valinta, yritä uudelleen.");
                }
            }

        }

        // Kun käsittelet pelaajaa App.java:ssa, viittaa siihen luolaolion kautta,
        // esimerkiksi cave.player.attack(monster))

        // Peli pitää myös pystyä tallentamaan ja ladata, 
        // joka onnistuu serialisoimalla tarvittavat luokat ja tallentamalla Cave luokan olio.

        sc.close();
    }
}
