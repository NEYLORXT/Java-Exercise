package Packs.InHerited;

import Packs.AllClass.StaticFunctions;
import Packs.InHerited.InheritedWeapon;

import java.util.Random;

public abstract class InheritedPlayer {
    protected InheritedPlayer(){
    InheritedWeapon weapon = null;
    name = "Player";
    vie = 100.0f;
    isDead = false;
    }

    protected InheritedPlayer(String new_name){
        InheritedWeapon weapon = null;
        name = new_name;
        vie = 100.0f;
        isDead = false;
    }

    protected void Attack(InheritedPlayer player) {
        lastEnemy = player;

        StaticFunctions.LineFeed();

        if (Weapon == null) {
            player.receiveDamage(5.0f);

            System.out.printf("""
                %s met %.2f de degats a %s
                """, name, 5.0f , player.GetName() );
        }
        else{
            player.receiveDamage(this.Weapon.getDegats());

            System.out.printf("""
                %s met %.2f de degats a %s
                """, name, Weapon.getDegats(), player.GetName() );
        }

        StaticFunctions.LineFeed();

        State();
        player.State();

    }

    protected void receiveDamage(float damage) {
        vie -= damage;

        if (vie <= 0) {
            vie = 0;
            SetIsDead(true); // Active directement la méthode pour marquer mort
        }
    }

    protected void SetIsDead(boolean newIsDeadValue) {
        isDead = newIsDeadValue;
    }

    protected boolean GetIsDead(){
        return isDead;
    }

    protected String GetName(){
         return name;
    }

    protected void SetName(String new_name){
         name = new_name;
    }

    protected float GetVie(){
        return vie;
    }

    protected void SetVie(float new_vie){
        vie = new_vie;
    }

    protected void AddVie(float add_vie){
        vie += add_vie;

        if (vie >= 100.0f) {
            vie = 100.0f;
        }

        StaticFunctions.LineFeed();

        System.out.printf("""
                %s boit une potion de %.2f de vie
                """, name, add_vie);

        StaticFunctions.LineFeed();

        State();

        if (lastEnemy != null){
            lastEnemy.State();
        }


    }

    protected void DrinkPotion(){
        Random random = new Random();
        float randomValue = ( 10.0f + random.nextFloat(21.0f) );

        AddVie( (float)(randomValue) );
    }


    //Affiche l etat du joueur
    protected void State(){
         //SAUT DE LIGNE
        StaticFunctions.LineFeed();

        System.out.printf("""
                Name : %s
                Vie : %.2f
                Is Dead : %b
                Weapon = %s
                Weapon damage = %.2f
               """, name, vie, isDead, Weapon.getName(), Weapon.getDegats() );

        StaticFunctions.LineFeed();
    }

    //met a jour l arme
    protected void UpdateWeapon(){
        Weapon.UpdateWeapon();

        //Affiche l etat du joueur
        State();
        lastEnemy.State();
    }

    protected void printName(){
         System.out.println(name);
    }
    protected void printVie(){
         System.out.println(vie);
    }

    //Verifie s il a l arme
    protected void printWeapon(){
        if (Weapon != null){
            System.out.println("Good");
        }
        else {
            System.out.println("Bad");
        }
    }



    protected InheritedWeapon Weapon;
    protected InheritedPlayer lastEnemy;
    protected String name;
    protected float vie;
    protected boolean isDead;
}
