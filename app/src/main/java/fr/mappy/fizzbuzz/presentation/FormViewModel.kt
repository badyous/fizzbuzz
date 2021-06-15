package fr.mappy.fizzbuzz.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.mappy.fizzbuzz.data.FormError
import fr.mappy.fizzbuzz.domain.form.FormControllerHelper
import fr.mappy.fizzbuzz.domain.form.FormRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(private val formRepository: FormRepository) : ViewModel() {

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

    fun saveFormHit(
        input1Int: Int,
        input2Int: Int,
        input1Str: String,
        input2Str: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            formRepository.saveHitForForm(input1Int, input2Int, input1Str, input2Str)
        }
    }
}