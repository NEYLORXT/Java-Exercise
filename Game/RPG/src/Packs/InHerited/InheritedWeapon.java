package Packs.InHerited;

import Packs.AllClass.StaticFunctions;

import java.util.Random;

public abstract class InheritedWeapon {
    protected InheritedWeapon(InheritedPlayer player){
        this.name = "Gun";
        this.degats = 10.0f;
        this.player = player;
    }

    protected InheritedWeapon(InheritedPlayer player, String name_weapon){
        name = name_weapon;
        degats = 10.0f;
        this.player = player;
    }

    protected String getName(){
        return name;
    }

    protected void setName(String new_name){
        name = new_name;
    }

    protected float getDegats(){
        return degats;
    }

    protected void SetDegats(float newDegats){
        degats = newDegats;
    }

    protected void UpdateWeapon(){
        float old_damage = degats;

        Random random = new Random();
        float new_damage = ( 5 + random.nextFloat(11) );
        degats += new_damage ;

        StaticFunctions.LineFeed();

        System.out.printf("""
                %s a levelup son arme de [ %.2f ] : %.2f -> %.2f
               """, player.name, (degats - old_damage) , old_damage, degats);
        StaticFunctions.LineFeed();

    }


    protected InheritedPlayer player;
    protected String name;
    protected float degats;
}
