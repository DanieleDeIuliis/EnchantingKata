package com.enchanting

import com.enchanting.Enchantment.EMPTY

class Weapon(name : String, var enchantment: Enchantment = EMPTY){
    val name: String = name
        get() = "${enchantment.prefix} $field".trim()

    val magicDamage: String
        get() = enchantment.bonus

}
