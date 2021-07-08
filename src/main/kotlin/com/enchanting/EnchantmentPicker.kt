package com.enchanting

import com.enchanting.Enchantment.FAILURE
import com.enchanting.Enchantment.FIRE

class EnchantmentPicker(private val enchantmentResult: EnchantmentResult) {
    fun next(): Enchantment {
        return if(enchantmentResult.isSuccessful()) {
            FIRE
        } else {
            FAILURE
        }
    }

}