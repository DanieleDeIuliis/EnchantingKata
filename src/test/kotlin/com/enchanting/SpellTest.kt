package com.enchanting

import com.enchanting.ElementalAttribute.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SpellTest {

    @Test
    fun `get a random elemental attribute different from the current one`() {
        val weapon = Weapon("Hammer", FIRE)
        val spell = Spell()

        val newElementalAttribute = spell.castOn(weapon)

        assertThat(newElementalAttribute).isNotEqualTo(FIRE)
    }
}