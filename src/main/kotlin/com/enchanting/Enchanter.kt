package com.enchanting

class Enchanter(private val enchantmentPicker: EnchantmentPicker) {
    fun enchant(weapon: Weapon) {
        val enchantment = enchantmentPicker.next()
        weapon.enchantmentBonus = enchantment.bonus
        weapon.name = "${enchantment.prefix} ${weapon.name}"
    }

}
