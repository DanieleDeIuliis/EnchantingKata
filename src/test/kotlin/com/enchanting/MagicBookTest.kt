package com.enchanting

import com.enchanting.ElementalAttribute.*
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MagicBookTest {

    private val spell: Spell = mockk()

    @Test
    fun `enchant a weapon with the magic book gives a fire attribute`() {
        val weapon = Weapon("Staff")
        every { spell.isSucceeded() } returns true
        val magicBook = MagicBook(spell)

        magicBook.enchant(weapon)

        assertThat(weapon.elementalAttribute).isEqualTo(FIRE)
    }

    @Test
    fun `enchanting a weapon changes the name with a prefix`() {
        val weapon = Weapon("Staff")
        every { spell.isSucceeded() } returns true
        val magicBook = MagicBook(spell)

        magicBook.enchant(weapon)

        assertThat(weapon.name).isEqualTo("Inferno Staff")
    }

    @Test
    fun `enchanting a weapon removes the old enchantment`() {
        val weapon = Weapon("Staff", ICE)
        every { spell.isSucceeded() } returns true
        val magicBook = MagicBook(spell)

        magicBook.enchant(weapon)

        assertThat(weapon.elementalAttribute).isEqualTo(FIRE)
    }

    @Test
    fun `when an enchantment fails, it removes the current one`() {
        val weapon = Weapon("Staff", ICE)
        every { spell.isSucceeded() } returns false

        MagicBook(spell).enchant(weapon)

        assertThat(weapon.elementalAttribute).isNull()
    }
}

