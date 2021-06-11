package fr.mappy.fizzbuzz.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import fr.mappy.fizzbuzz.R
import fr.mappy.fizzbuzz.presentation.FormViewModel


class FormFragment : Fragment(R.layout.fragment_form) {

    private val viewModel by activityViewModels<FormViewModel>()

}