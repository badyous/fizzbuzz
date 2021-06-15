package fr.mappy.fizzbuzz.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.mappy.fizzbuzz.domain.ResultCalculator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResultViewModel : ViewModel() {


    private val resultList = MutableLiveData<List<String>>(listOf())
    val calculatedResultList: LiveData<List<String>> get() = resultList

    fun calculateResult(
        inputInt1: Int,
        inputInt2: Int,
        inputStr1: String,
        inputStr2: String,
        limit: Int
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            resultList.postValue(
                ResultCalculator.calculateResult(
                    inputInt1,
                    inputInt2,
                    inputStr1,
                    inputStr2,
                    limit
                )
            )
        }
    }
}