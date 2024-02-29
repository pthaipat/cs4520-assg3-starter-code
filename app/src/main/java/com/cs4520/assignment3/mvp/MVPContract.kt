package com.cs4520.assignment3.mvp

interface MVPContract {
    interface View {
        fun displayResult(result: Double)
        fun displayToast(message: String)
        fun inputToPresenter(firstNum: Double, secondNum: Double, operation: String)
        fun clearInput()
    }

    interface Presenter {
        fun executeOperation(firstNum: Double, secondNum: Double, operation: String)
        fun setView(view: View)
    }

    interface Model {
        fun calculateResult(firstNum: Double, secondNum: Double, operation: String): Double
    }
}