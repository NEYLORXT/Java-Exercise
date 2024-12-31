import Packs.AllClass.Player;
import Packs.AllClass.StaticFunctions;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //PLAYER NAME
        Scanner sc_users_name = new Scanner(System.in);
        System.out.println("Enter your Name");
        String player_name = sc_users_name.nextLine();

        if (player_name.length() <= 1){
            player_name = "Player";
        }

        Player Player = new Player(player_name);
        Player IA = new Player("IA");


        //Etat du joueur
        Player.State();

        IA.State();


        while ( !Player.GetIsDead() && !IA.GetIsDead() ){
            Scanner sc_users_response = new Scanner(System.in);

            System.out.println("Enter your Choice");
            System.out.println("""
                    1- Attack
                    2- drink a potion
                    3- Weapon Update""");
            byte choice = sc_users_response.nextByte();

            switch (choice){
                case 1 :
                    Player.Attack(IA);
                    break;

                case 2 :
                    Player.DrinkPotion();
                    break;

                case 3 :
                    StaticFunctions.LineFeed();
                    Player.UpdateWeapon();
                    StaticFunctions.LineFeed();
                    break;

                default:
                    StaticFunctions.LineFeed();
                    System.out.println("INCORRECT RESPONSE");
                    StaticFunctions.LineFeed();
            }

        }

        if (Player.GetIsDead()){
            System.out.printf("""
                    %s vous a battu
                    """, IA.GetName());
        }
        else {
            System.out.printf("""
                    %s a battu %s
                    """, Player.GetName(), IA.GetName());
        }

        Player.State();
        IA.State();

    }
}