package com.enchanting

class Spell(private val randomFailureCounter: RandomFailureCounter = RandomFailureCounter()) {
    fun castOn(weapon: Weapon): ElementalAttribute? {
        if(randomFailureCounter.willFail()) {
            return null
        }
        return ElementalAttribute.values().filter { it != weapon.elementalAttribute }.random()
    }

}
