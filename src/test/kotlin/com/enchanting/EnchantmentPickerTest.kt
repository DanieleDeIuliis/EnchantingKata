package com.enchanting

import com.enchanting.Enchantment.*
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EnchantmentPickerTest {

    private val enchantmentResult: EnchantmentResult = mockk()
    private val enchantmentSelector: EnchantmentSelector = mockk()
    private val enchantmentPicker = EnchantmentPicker(enchantmentResult, enchantmentSelector)

    @Test
    fun `returns a successful enchantment`() {
        every { enchantmentSelector.select() } returns FIRE
        every { enchantmentResult.isSuccessful() } returns true

        val enchantment = enchantmentPicker.next()

        assertThat(enchantment).isNotEqualTo(FAILURE)
    }

    @Test
    fun `returns an empty enchantment when the enchant fails`() {
        every { enchantmentSelector.select() } returns FAILURE
        every { enchantmentResult.isSuccessful() } returns false

        val enchantment = enchantmentPicker.next()

        assertThat(enchantment).isEqualTo(FAILURE)
    }

    @Test
    fun `returns a successful ice enchantment`() {
        every { enchantmentSelector.select() } returns ICE
        every { enchantmentResult.isSuccessful() } returns true

        val enchantment = enchantmentPicker.next()

        assertThat(enchantment).isEqualTo(ICE)
    }

    @Test
    fun `could not return twice the same enchantment`() {
        every { enchantmentSelector.select()} returns ICE andThen ICE andThen FIRE
        every { enchantmentResult.isSuccessful() } returns true

        enchantmentPicker.next()
        val enchantment = enchantmentPicker.next()

        assertThat(enchantment).isEqualTo(FIRE)
    }
}