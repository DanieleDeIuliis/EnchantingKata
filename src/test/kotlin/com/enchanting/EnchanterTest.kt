package com.enchanting

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class EnchanterTest {

    private lateinit var enchanter: Enchanter
    private lateinit var weapon: Weapon
    private val enchantmentPicker: EnchantmentPicker = mockk()

    @BeforeEach
    fun setUp() {
        enchanter = Enchanter(enchantmentPicker)
        weapon = Weapon("Hammer of God")
    }

    @Test
    fun `enchanting a weapon, it gets a fire enchantment`() {
        every { enchantmentPicker.next() } returns Enchantment(bonus = "+5 Fire damage", prefix = "Inferno")

        enchanter.enchant(weapon)

        assertThat(weapon.enchantmentBonus).isEqualTo("+5 Fire damage")
        assertThat(weapon.name).isEqualTo("Inferno Hammer of God")
    }

    @Test
    fun `enchanting a weapon, it gets an icy enchantment`() {
        every { enchantmentPicker.next() } returns Enchantment(bonus = "+5 Ice damage", prefix = "Icy")

        enchanter.enchant(weapon)

        assertThat(weapon.enchantmentBonus).isEqualTo("+5 Ice damage")
        assertThat(weapon.name).isEqualTo("Icy Hammer of God")
    }
}