package com.enchanting

class EnchantmentPicker(private val enchantmentResult: EnchantmentResult) {
    fun next(): Enchantment {
        return if(enchantmentResult.isSuccessful()) {
            Enchantment("+5 Fire damage","Inferno")
        } else {
            Enchantment("","")
        }
    }

}