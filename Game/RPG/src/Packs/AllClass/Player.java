package Packs.AllClass;

import Packs.InHerited.InheritedPlayer;

public class Player extends InheritedPlayer {
    public Player(){
        super();
        Weapon = new Weapon(this);
    }
    public Player(String name){
        super(name);
        Weapon = new Weapon(this, "GUN");
    }

    public String GetName(){
        return super.GetName();
    }

    public void Attack(InheritedPlayer player) {
        super.Attack(player);
    }

    public void SetName(String new_name){
        super.SetName(new_name);
    }

    public boolean GetIsDead(){
        return super.GetIsDead();
    }

    public void SetIsDead(boolean new_isDead){
        super.SetIsDead(new_isDead);
    }

    public void DrinkPotion(){
        super.DrinkPotion();
    }

    public void State(){
        super.State();
    }

    public void UpdateWeapon(){
        super.UpdateWeapon();
    }

    public void printName(){
        super.printName();
    }

    public void printVie(){
        super.printVie();
    }

    public void printWeapon(){
        super.printWeapon();
    }




}
