package com.enchanting

import com.enchanting.ElementalAttribute.*
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SpellTest {

    private val randomFailureCounter: RandomFailureCounter = mockk()

    @Test
    fun `get a random elemental attribute different from the current one`() {
        val weapon = Weapon("Hammer", FIRE)
        every { randomFailureCounter.willFail() } returns false
        val spell = Spell(randomFailureCounter)

        val newElementalAttribute = spell.castOn(weapon)

        assertThat(newElementalAttribute).isNotEqualTo(FIRE)
    }

    @Test
    fun `when the spell fails, returns null`() {
        val weapon = Weapon("Hammer", FIRE)
        every { randomFailureCounter.willFail() } returns true
        val spell = Spell(randomFailureCounter)

        val newElementalAttribute = spell.castOn(weapon)

        assertThat(newElementalAttribute).isNull()
    }
}