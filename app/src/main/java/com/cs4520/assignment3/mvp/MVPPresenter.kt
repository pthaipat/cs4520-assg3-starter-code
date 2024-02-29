package com.cs4520.assignment3.mvp

class MVPPresenter(
    private var view: MVPContract.View,
    private val model: MVPContract.Model) : MVPContract.Presenter {
    override fun executeOperation(firstNum: Double, secondNum: Double, operation: String) {
        val result = model.calculateResult(firstNum, secondNum, operation)
        view.displayResult(result)
    }

    override fun setView(view: MVPContract.View) {
        this.view = view
    }
}