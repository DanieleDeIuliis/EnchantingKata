package com.enchanting

class Weapon(name: String, var elementalAttribute: ElementalAttribute? = null) {
    var name = name
        get() = "${elementalAttribute?.prefix} $field".trim()
}
