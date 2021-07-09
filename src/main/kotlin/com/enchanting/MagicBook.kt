package com.enchanting

import com.enchanting.ElementalAttribute.*

class MagicBook(private val spell: Spell) {

    fun enchant(weapon: Weapon) {
        if(spell.isSucceeded()) {
            weapon.elementalAttribute = FIRE
            return
        }

        weapon.elementalAttribute = null
    }

}
