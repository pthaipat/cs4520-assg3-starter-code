package com.cs4520.assignment3.mvp

class MVPModel : MVPContract.Model {
    override fun calculateResult(firstNum: Double, secondNum: Double, operation: String): Double {
        return when (operation) {
            "+" -> (firstNum + secondNum)
            "-" -> (firstNum - secondNum)
            "*" -> (firstNum * secondNum)
            "/" -> (firstNum / secondNum)
            else -> throw IllegalArgumentException("Invalid operation")
        }
    }
}