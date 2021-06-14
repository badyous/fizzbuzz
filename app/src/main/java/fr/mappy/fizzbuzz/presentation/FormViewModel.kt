package fr.mappy.fizzbuzz.presentation

import androidx.lifecycle.ViewModel
import fr.mappy.fizzbuzz.data.FormError
import fr.mappy.fizzbuzz.domain.FormControllerHelper

class FormViewModel : ViewModel() {

    fun returnErrorIfExists(
        input1Int: Int?,
        input2Int: Int?,
        input1Str: String?,
        input2Str: String?,
        limit: Int?
    ): FormError? {
        return FormControllerHelper.generateErrorIfExists(
            input1Int,
            input2Int,
            input1Str,
            input2Str,
            limit
        )
    }
}