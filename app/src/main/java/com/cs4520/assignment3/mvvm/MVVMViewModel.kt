package com.cs4520.assignment3.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

public class MVVMViewModel: ViewModel() {
    // MutableLiveData representing the result -->
    // binding.resultTextView.text = result.toString() in the view
    private val _result = MutableLiveData<String>()
    val result: LiveData<String>
        get() = _result

    private var model: MVVMModel = MVVMModel()

    // controls the operation by calling the model's logic and then updating the mutable live data
    // to be received by view
    fun executeOperation(firstNum: Double, secondNum: Double, operation: String) {
       val answer = model.calculateResult(firstNum, secondNum, operation)
        if (secondNum == 0.0 && operation == "/") {
            _result.value = "Undefined"
            return
        }
        _result.value = answer.toString()
    }

}