package com.enchanting

import com.enchanting.Enchantment.FAILURE

class Weapon(name : String, var enchantment: Enchantment = FAILURE){
    val name: String = name
        get() = "${enchantment.prefix} $field".trim()

    val magicDamage: String
        get() = enchantment.bonus

}
