package com.enchanting

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EnchantmentPickerTest {

    private val enchantmentResult: EnchantmentResult = mockk()
    private val enchantmentPicker = EnchantmentPicker(enchantmentResult)

    @Test
    fun `returns a successful enchantment`() {
        every { enchantmentResult.isSuccessful() } returns true

        val enchantment = enchantmentPicker.next()

        assertThat(enchantment).isNotEqualTo(Enchantment("", ""))
    }

    @Test
    fun `returns an empty enchantment when the enchant fails`() {
        every { enchantmentResult.isSuccessful() } returns false

        val enchantment = enchantmentPicker.next()

        assertThat(enchantment).isEqualTo(Enchantment("", ""))
    }
}