package com.enchanting

class Spell {
    fun castOn(weapon: Weapon): ElementalAttribute? {
        return ElementalAttribute.values().filter { it != weapon.elementalAttribute }.random()
    }

}
