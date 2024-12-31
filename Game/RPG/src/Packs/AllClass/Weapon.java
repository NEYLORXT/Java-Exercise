package Packs.AllClass;

import Packs.InHerited.InheritedPlayer;
import Packs.InHerited.InheritedWeapon;

public class Weapon extends InheritedWeapon{
    Weapon(Player player){
        super(player);

    }

    Weapon(Player player, String name_weapon){
        super(player, name_weapon);
    }

    public void UpdateWeapon(){
        super.UpdateWeapon();
    }


}
