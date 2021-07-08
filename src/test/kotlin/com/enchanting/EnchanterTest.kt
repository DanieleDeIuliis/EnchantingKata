package com.enchanting

import com.enchanting.Enchantment.*
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class EnchanterTest {

    private lateinit var enchanter: Enchanter
    private lateinit var weapon: Weapon
    private var enchantedWeapon: Weapon = Weapon("Hammer of God", FIRE)
    private val enchantmentPicker: EnchantmentPicker = mockk()

    @BeforeEach
    fun setUp() {
        enchanter = Enchanter(enchantmentPicker)
        weapon = Weapon("Hammer of God")
    }

    @Test
    fun `enchanting a weapon, it gets a fire enchantment`() {
        every { enchantmentPicker.next() } returns FIRE

        enchanter.enchant(weapon)

        assertThat(weapon.magicDamage).isEqualTo("+5 Fire damage")
        assertThat(weapon.name).isEqualTo("Inferno Hammer of God")
    }

    @Test
    fun `enchanting a weapon, it gets an icy enchantment`() {
        every { enchantmentPicker.next() } returns ICE

        enchanter.enchant(weapon)

        assertThat(weapon.magicDamage).isEqualTo("+5 Ice damage")
        assertThat(weapon.name).isEqualTo("Icy Hammer of God")
    }

    @Test
    fun `when an enchantment fails, it removes magic attributes`() {
        every { enchantmentPicker.next() } returns FAILURE

        enchanter.enchant(enchantedWeapon)

        assertThat(enchantedWeapon.magicDamage).isEqualTo("")
        assertThat(enchantedWeapon.name).isEqualTo("Hammer of God")
    }

}