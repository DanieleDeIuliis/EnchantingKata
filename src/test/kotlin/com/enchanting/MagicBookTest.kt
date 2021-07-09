package com.enchanting

import com.enchanting.ElementalAttribute.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MagicBookTest {

    @Test
    fun `enchant a weapon with the magic book gives a fire attribute`() {
        val weapon = Weapon("Staff")
        val magicBook = MagicBook()

        magicBook.enchant(weapon)

        assertThat(weapon.elementalAttribute).isEqualTo(FIRE)
    }

    @Test
    fun `enchanting a weapon changes the name with a prefix`() {
        val weapon = Weapon("Staff")
        val magicBook = MagicBook()

        magicBook.enchant(weapon)

        assertThat(weapon.name).isEqualTo("Inferno Staff")
    }

    @Test
    fun `enchanting a weapon removes the old enchantment`() {
        val weapon = Weapon("Staff", ICE)
        val magicBook = MagicBook()

        magicBook.enchant(weapon)

        assertThat(weapon.elementalAttribute).isEqualTo(FIRE)
    }
}

