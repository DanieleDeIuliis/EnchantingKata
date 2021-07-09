package com.enchanting

import com.enchanting.Enchantment.EMPTY
import com.enchanting.Enchantment.FAILURE

class EnchantmentPicker(private val enchantmentResult: EnchantmentResult, private val selector: EnchantmentSelector) {
    var lastEnchantment: Enchantment = EMPTY

    fun next(): Enchantment {
        return if(enchantmentResult.isSuccessful()) {
            lastEnchantment = selector.next()
            return lastEnchantment
        } else FAILURE
    }

    private fun EnchantmentSelector.next(): Enchantment {
        val new = select()
        if(new != lastEnchantment) {
            return new
        }
        return next()
    }

}