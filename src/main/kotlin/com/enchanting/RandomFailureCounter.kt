package com.enchanting

import kotlin.random.Random

class RandomFailureCounter {
    fun willFail(): Boolean {
        return Random.nextInt(0, 10) == 1
    }

}
