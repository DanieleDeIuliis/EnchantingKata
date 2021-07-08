package com.enchanting

class Weapon(name : String, var enchantment: Enchantment = Enchantment("", "")){
    val name: String = name
        get() = "${enchantment.prefix} $field".trim()

    val magicDamage: String
        get() = enchantment.bonus

    fun magicDamage(): String {
        return enchantment.bonus
    }

}
