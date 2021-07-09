package com.enchanting

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MagicBookTest {

    @Test
    fun `enchant a weapon with the magic book gives a fire attribute`() {
        val weapon = Weapon()
        val magicBook = MagicBook()

        magicBook.enchant(weapon = weapon)

        assertThat(weapon.elementalAttribute).isEqualTo(ElementalAttribute.FIRE)
    }
}

