package fr.mappy.fizzbuzz.domain

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ResultCalculatorTest {

    @Test
    fun checkResultSize() {
        val result = ResultCalculator.calculateResult(2, 4, "fizz", "buzz", 10)
        Assert.assertEquals(result.size, 10)
    }

    @Test
    fun checkResult() {
        val result = ResultCalculator.calculateResult(3, 5, "fizz", "buzz", 15)

        Assert.assertEquals(result[0], "1")
        Assert.assertEquals(result[1], "2")
        Assert.assertEquals(result[2], "fizz")
        Assert.assertEquals(result[3], "4")
        Assert.assertEquals(result[4], "buzz")
        Assert.assertEquals(result[5], "fizz")
        Assert.assertEquals(result[6], "7")
        Assert.assertEquals(result[7], "8")
        Assert.assertEquals(result[8], "fizz")
        Assert.assertEquals(result[9], "buzz")
        Assert.assertEquals(result[10], "11")
        Assert.assertEquals(result[11], "fizz")
        Assert.assertEquals(result[12], "13")
        Assert.assertEquals(result[13], "14")
        Assert.assertEquals(result[14], "fizzbuzz")
    }

}