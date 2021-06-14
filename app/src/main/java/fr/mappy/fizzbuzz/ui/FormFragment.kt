package fr.mappy.fizzbuzz.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import fr.mappy.fizzbuzz.R
import fr.mappy.fizzbuzz.data.FormError
import fr.mappy.fizzbuzz.databinding.FragmentFormBinding
import fr.mappy.fizzbuzz.presentation.FormViewModel
import fr.mappy.fizzbuzz.utils.toInt


class FormFragment : Fragment(R.layout.fragment_form) {

    private lateinit var binding: FragmentFormBinding
    private val viewModel: FormViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFormBinding.bind(view)

        addViewListeners()

    }

    private fun addViewListeners() {
        binding.validateButton.setOnClickListener {
            validateClick()
        }

        binding.statisticButton.setOnClickListener {
            findNavController().navigate(FormFragmentDirections.actionFormFragmentToStatisticFragment())
        }
    }

    private fun validateClick() {
        val errorIfExists = viewModel.returnErrorIfExists(
            binding.firstIntInput.text?.toInt(),
            binding.secondIntInput.text?.toInt(),
            binding.firstStringInput.text?.toString(),
            binding.secondStringInput.text?.toString(),
            binding.limitIntInput.text?.toInt()
        )

        if (errorIfExists != null) {
            Toast.makeText(
                requireContext(),
                getMessageError(errorIfExists),
                Toast.LENGTH_SHORT
            ).show()
        } else {
            findNavController().navigate(
                FormFragmentDirections.actionFormFragmentToResultFragment(
                    binding.firstIntInput.text.toInt()!!,
                    binding.secondIntInput.text.toInt()!!,
                    binding.firstStringInput.text.toString(),
                    binding.secondStringInput.text.toString(),
                    binding.limitIntInput.text.toInt()!!
                )
            )
        }
    }

    private fun getMessageError(error: FormError): String {
        return when (error) {
            FormError.EMPTY_FIELD -> getString(R.string.error_message_fields_should_not_be_empty)
            FormError.INPUT_INT_LOWER_OR_EQUALS_ZERO -> getString(R.string.error_int_zero)
            FormError.INPUT_INT_EQUALS -> getString(R.string.error_int_equals)
            FormError.INPUT_STRING_EQUALS -> getString(R.string.error_string_equals)
            FormError.INPUT_LIMIT_LOWER_OR_EQUALS_ZERO -> getString(R.string.error_limit_zero)
        }
    }
}