package fr.mappy.fizzbuzz.domain

class ResultCalculator {

    fun calculateResult(
        inputInt1: Int,
        inputInt2: Int,
        inputStr1: String,
        inputStr2: String,
        limit: Int
    ): List<String> {
        val int1Int2 = inputInt1.times(inputInt2)
        val calculatedList = mutableListOf<String>()
        for (i in 1..limit) {
            when {
                i % int1Int2 == 0 -> {
                    calculatedList.add(inputStr1 + inputStr2)
                }
                i % inputInt1 == 0 -> {
                    calculatedList.add(inputStr1)
                }
                i % inputInt2 == 0 -> {
                    calculatedList.add(inputStr2)
                }
                else -> {
                    calculatedList.add(i.toString())
                }
            }
        }
        return calculatedList
    }
}