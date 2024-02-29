package com.cs4520.assignment3.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.cs4520.assignment3.databinding.MvpLayoutBinding

class MVPFragment : Fragment(), MVPContract.View {
    private var _binding: MvpLayoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: MVPPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = MvpLayoutBinding.inflate(inflater, container, false)
        val view = binding.root
        presenter = MVPPresenter(this, MVPModel())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.addButton.setOnClickListener {
            try {
                presenter.executeOperation(binding.inputNumber1.text.toString().toDouble(), binding.inputNumber2.text.toString().toDouble(), "+")
            } catch (e: Exception) {
                displayToast("Invalid operation")
            }
            clearInput()
        }
        binding.subtractButton.setOnClickListener {
            try {
                presenter.executeOperation(binding.inputNumber1.text.toString().toDouble(), binding.inputNumber2.text.toString().toDouble(), "-")
            } catch (e: Exception) {
                displayToast("Invalid operation")
            }
            clearInput()
        }
        binding.multiplyButton.setOnClickListener {
            try {
                presenter.executeOperation(binding.inputNumber1.text.toString().toDouble(), binding.inputNumber2.text.toString().toDouble(), "*")
            } catch (e: Exception) {
                displayToast("Invalid operation")
            }
            clearInput()
        }
        binding.divideButton.setOnClickListener {
            try {
                // make sure that dividing by zero will clear the input and display toast
                if (binding.inputNumber2.text.toString().toDouble() == 0.0) {
                    displayToast("Cannot divide by zero!")
                }
                presenter.executeOperation(binding.inputNumber1.text.toString().toDouble(), binding.inputNumber2.text.toString().toDouble(), "/")
            } catch (e: Exception) {
                displayToast("Invalid operation")
            }
            clearInput()
        }
    }

    override fun displayResult(result: Double) {
        binding.resultTextView.text = result.toString()
    }

    override fun displayToast(message: String) {
        Toast.makeText(this.activity, message,
            Toast.LENGTH_SHORT).show();
    }

    override fun inputToPresenter(firstNum: Double, secondNum: Double, operation: String) {
        try {
            displayToast("Input to presenter")
            presenter.executeOperation(firstNum, secondNum, operation)
        } catch (e: Exception) {
            displayToast("Invalid operation")
        }
    }

    override fun clearInput() {
        // to make input numbers blank
        binding.inputNumber1.text.clear()
        binding.inputNumber2.text.clear()
    }
}