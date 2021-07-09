package com.enchanting


class MagicBook(private val spell: Spell) {

    fun enchant(weapon: Weapon) {
        weapon.elementalAttribute = spell.castOn(weapon)
    }

}
